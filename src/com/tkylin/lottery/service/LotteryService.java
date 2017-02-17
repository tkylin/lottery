package com.tkylin.lottery.service;

import com.tkylin.lottery.constant.LotteryConstant;
import com.tkylin.lottery.dataaccess.DAOManager;
import com.tkylin.lottery.dataaccess.dao.LotteryLogDAO;
import com.tkylin.lottery.dataaccess.dao.PrizeDAO;
import com.tkylin.lottery.dataaccess.dao.UserDAO;
import com.tkylin.lottery.dataaccess.dao.custom.LotteryCustomDAO;
import com.tkylin.lottery.dataaccess.entity.LotteryLog;
import com.tkylin.lottery.dataaccess.entity.Prize;
import com.tkylin.lottery.dataaccess.entity.PrizeExample;
import com.tkylin.lottery.dataaccess.entity.User;
import com.tkylin.lottery.dto.PrizeDto;

import java.util.*;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 10:45
 */
public class LotteryService {

    public static User selectUserByKey(Long userId) {
        if (userId == null || userId < 1) {
            return null;
        }
        UserDAO dao = DAOManager.getDAO(UserDAO.class);
        return dao.selectByPrimaryKey(userId);
    }

    public static void addUser(User user) {
        UserDAO dao = DAOManager.getDAO(UserDAO.class);
        dao.insert(user);
    }

    public static boolean updateUserByKey(User user) {
        UserDAO dao = DAOManager.getDAO(UserDAO.class);
        int ret = dao.updateByPrimaryKeySelective(user);
        return ret > 0;
    }

    public static Long addLotteryLog(LotteryLog log) {
        LotteryLogDAO dao = DAOManager.getDAO(LotteryLogDAO.class);
        return dao.insert(log);
    }

    public static PrizeDto checkExpiry(Long uniqueCode) {
        LotteryLogDAO dao = DAOManager.getDAO(LotteryLogDAO.class);
        LotteryLog log = dao.selectByPrimaryKey(uniqueCode);
        PrizeDto prizeDto = null;
        if (log != null) {
            prizeDto = new PrizeDto();
            prizeDto.setCreateTime(log.getCreateTime());
            prizeDto.setUid(log.getUid());
            PrizeDAO prizeDAO = DAOManager.getDAO(PrizeDAO.class);
            Prize prize = prizeDAO.selectByPrimaryKey(log.getPrize());
            if (prize != null) {
                prizeDto.setIcon(prize.getIcon());
                prizeDto.setIndexNo(prize.getIndexNo());
                prizeDto.setName(prize.getName());
                prizeDto.setRewardNum(prize.getRewardNum());
                prizeDto.setStatus(log.getStatus());
                prizeDto.setType(prize.getType());
                prizeDto.setUniqueCode(log.getId());
            }
        }
        return prizeDto;
    }

    public static void expiry(Long uniqueCode) {
        if(uniqueCode<1){
            return;
        }
        LotteryLogDAO dao = DAOManager.getDAO(LotteryLogDAO.class);
        LotteryLog log = new LotteryLog();
        log.setId(uniqueCode);
        log.setStatus(2);
        log.setUpdateTime(new Date());
        dao.updateByPrimaryKeySelective(log);
    }

    public static List<Prize> prizeList() {
        PrizeDAO dao = DAOManager.getDAO(PrizeDAO.class);
        PrizeExample exa = new PrizeExample();
        exa.createCriteria().andStatusEqualTo(LotteryConstant.Status.ENABLE);
        return dao.selectByExample(exa);
    }

    public static PrizeDto lottery(long userId, String ip) {
        //开始随机抽奖
        List<Prize> list = prizeList();
        if (list == null || list.size() == 0) {
            return null;
        }
        LotteryCustomDAO customDAO = DAOManager.getDAO(LotteryCustomDAO.class);
        //扣除抽奖次数
        User userUpdate = new User();
        userUpdate.setUserId(userId);
        userUpdate.setCount(-1);
        userUpdate.setLotteryCount(1);
        customDAO.updateUserByPrimaryKey(userUpdate);

        Map<Integer, Prize> map = new HashMap<Integer, Prize>();
        int total = 0; //概率总数
        int len = list.size();    //奖品类型总数，即有多少种奖品
        for (Prize prize : list) {
            map.put(prize.getIndexNo(), prize);
            total += prize.getProbability();
        }
        int index = 0;    //奖品编号
        int random = new Random().nextInt(total);

        if (random < 1) {    //概率按随机算法，奖品编号越后，就是随机值越小
            index = len;
        } else {
            int temp = 0;
            for (int i = 1; i < len + 1; i++) {
                temp += map.get(i).getProbability();
                if (random > (total - temp)) {
                    index = i;
                    break;
                }
            }
        }
        Prize prize = map.get(index);
        if (prize.getType() != LotteryConstant.PrizeType.NO_PRIZE) {
            Prize update = new Prize();
            update.setId(prize.getId());
            update.setNumber(-1);

            //判断奖品编号是否已经被中完

            int result = customDAO.updatePrizeByPrimaryKey(update);

            if (result < 1) {//已没货直接返回未中奖
                for (Prize o : map.values()) {
                    if (o.getType() == LotteryConstant.PrizeType.NO_PRIZE) {
                        prize = o;
                        break;
                    }
                }
            }
        }

        //写抽奖日志
        LotteryLog log = new LotteryLog();
        log.setCreateTime(new Date());
        log.setPrize(prize.getId());
        log.setPrizeName(prize.getName());
        log.setUid(userId);
        log.setIp(ip);
        log.setStatus(1);

        Long logId = addLotteryLog(log);
        PrizeDto prizeDto = new PrizeDto();
        prizeDto.setIcon(prize.getIcon());
        prizeDto.setIndexNo(prize.getIndexNo());
        prizeDto.setName(prize.getName());
        prizeDto.setType(prize.getType());
        prizeDto.setUniqueCode(logId);
        prizeDto.setRewardNum(prize.getRewardNum());
        prizeDto.setCreateTime(log.getCreateTime());
        prizeDto.setUid(userId);

        return prizeDto;
    }
}
