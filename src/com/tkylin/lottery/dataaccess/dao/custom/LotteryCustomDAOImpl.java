package com.tkylin.lottery.dataaccess.dao.custom;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.tkylin.lottery.dataaccess.entity.Prize;
import com.tkylin.lottery.dataaccess.entity.User;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 11:40
 */
public class LotteryCustomDAOImpl extends SqlMapDaoTemplate implements LotteryCustomDAO {

    public LotteryCustomDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    @Override
    public int updateUserByPrimaryKey(User record) {
        return update("lottery_custom.update_user", record);
    }

    @Override
    public int updatePrizeByPrimaryKey(Prize record) {
        return update("lottery_custom.update_prize", record);
    }


}
