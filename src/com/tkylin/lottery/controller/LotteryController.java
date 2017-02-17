package com.tkylin.lottery.controller;

import com.google.gson.JsonSyntaxException;
import com.jfinal.kit.PropKit;
import com.tkylin.lottery.constant.LotteryConstant;
import com.tkylin.lottery.dataaccess.DAOManager;
import com.tkylin.lottery.dataaccess.dao.custom.LotteryCustomDAO;
import com.tkylin.lottery.dataaccess.entity.User;
import com.tkylin.lottery.dto.LotteryDto;
import com.tkylin.lottery.dto.PrizeDto;
import com.tkylin.lottery.dto.ResponseDto;
import com.tkylin.lottery.service.LotteryService;
import com.tkylin.lottery.util.LotteryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/3 15:10
 */
public class LotteryController extends BaseController {
    static Map<Long, Long> lockMap = new HashMap<Long, Long>();


    //初始化
    public void index() {
    }

    public void lotteryNumber() {
        ResponseDto resp = new ResponseDto();
        resp.setCode(-500);
        resp.setDesc("服务器异常!");
        resp.setLotteryCount(0);
        resp.setStatus(200);
        try {
            //Jedis jedis = Redis.use("lottery").getJedis();
            Long userId = getParaToLong("userId");
            if (userId == null || userId < 10000) {
                resp.setDesc("参数错误!");
                resp.setCode(-200);
                renderJson(resp);
                return;
            }
            if (lockMap.containsKey(userId)) {
                LOGGER.info(">>>>操作太频繁,请稍后!");
                resp.setDesc("操作太频繁,请稍后!");
                resp.setCode(-100);
                renderJson(resp);
                return;
            } else {
                lockMap.put(userId, System.currentTimeMillis());
            }
            User user = LotteryService.selectUserByKey(userId);

            long endTime = System.currentTimeMillis();
            Date startDate = getStartDate();
            long startTime = startDate.getTime();
            int lotteryCount = 0, usableRoomCardNum = 0;
            if (user != null && user.getLastUpdateTime() != null) {
                if (user.getLastUpdateTime().compareTo(startDate) >= 0) {//已经抽过奖
                    startTime = user.getLastUpdateTime().getTime();
                } else {//第一次抽检初始化用户数据
                    user.setCount(0);
                    user.setLastUpdateTime(startDate);
                    user.setLotteryCount(0);
                    user.setRoomCardNum(0);
                    user.setUsableRoomCardNum(0);
                    user.setUserId(userId);
                    LotteryService.updateUserByKey(user);
                }
                lotteryCount = user.getCount();
                usableRoomCardNum = user.getUsableRoomCardNum() == null ? 0 : user.getUsableRoomCardNum();
            }

            String result = LotteryUtil.checkLotteryNumber(userId, startTime, endTime);
            LotteryDto lotteryDto = GSON.fromJson(result, LotteryDto.class);
            if (lotteryDto != null && lotteryDto.getRet() == 0) {
                //计算剩余抽奖次数
                int cardNum = lotteryDto.getData().getRoomcard();
                usableRoomCardNum += Math.abs(cardNum);
                int count = LotteryUtil.countChange(usableRoomCardNum);//转换成抽奖次数
                int modRoomCardNum = LotteryUtil.modChange(usableRoomCardNum);//剩下不够转换抽奖次数的房卡
                lotteryCount += count;//累加到总数上去
                Date lastUpdateTime = new Date(endTime);
                //验证成功写入用户数据表
                if (user == null) {
                    lotteryCount += PropKit.getInt(LotteryUtil.DEFAULT_CHANGE, 0);//第一次加上赠送值
                    user = new User();
                    user.setUserId(userId);
                    user.setCreateTime(new Date());
                    user.setLastUpdateTime(lastUpdateTime);
                    user.setLotteryCount(0);
                    user.setRoomCardNum(-usableRoomCardNum);
                    user.setUsableRoomCardNum(modRoomCardNum);
                    user.setCount(lotteryCount);
                    LotteryService.addUser(user);
                } else {
                    User update = new User();
                    update.setUserId(userId);
                    update.setLastUpdateTime(lastUpdateTime);
                    update.setCount(count);
                    update.setRoomCardNum(cardNum);
                    update.setUsableRoomCardNum(modRoomCardNum);
                    LotteryCustomDAO customDAO = DAOManager.getDAO(LotteryCustomDAO.class);
                    customDAO.updateUserByPrimaryKey(update);
                }
                resp.setCode(0);
                resp.setDesc("");
                resp.setLotteryCount(lotteryCount);
                resp.setStatus(200);
            }
            lockMap.remove(userId);
        } catch (JsonSyntaxException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        renderJson(resp);
    }

    public void lottery() {
        Long userId = getParaToLong("userId", 0L);
        String ip = getRequest().getRemoteAddr();

        ResponseDto resp = new ResponseDto();
        resp.setCode(0);
        resp.setDesc("");
        resp.setStatus(200);

        User user = LotteryService.selectUserByKey(userId);

        if (user == null) {
            resp.setCode(-300);
            resp.setDesc("参数错误!");
            renderJson(resp);
            return;
        }

        if (user.getCount() < 1) {
            resp.setCode(-301);
            resp.setDesc("抽奖机会已经用完!");
            renderJson(resp);
            return;
        }

        PrizeDto prize = LotteryService.lottery(userId, ip);
        if (prize.getType() == LotteryConstant.PrizeType.HOUSE_CARD) {
            LotteryUtil.addRoomCard(userId, prize.getRewardNum());
            resp.setDesc("恭喜中奖!奖品已经发放到您的账号上,请登录应用查看!谢谢您的参与!");
        } else if (prize.getType() != LotteryConstant.PrizeType.NO_PRIZE) {
            resp.setDesc("恭喜中奖!请联系客服确认相关奖项,领取奖品!");
        }

        resp.setPrize(prize);

        renderJson(resp);
    }

    public Date getStartDate() {
        Date startDate = new Date();
        int type = PropKit.getInt(LotteryUtil.OPEN_TYPE, 0);
        if (type == 1) {//指定一周里面的某天
            startDate = LotteryUtil.parseDate(LotteryUtil.formatDate(startDate));
        } else if (type == 2) {//指定时间范围
            String begin = PropKit.get(LotteryUtil.OPEN_BEGIN_DATE, LotteryUtil.formatDate(startDate));
            startDate = LotteryUtil.parseDate(begin);
        }
        return startDate;
    }


}
