package com.tkylin.lottery.dataaccess.dao.custom;

import com.tkylin.lottery.dataaccess.entity.Prize;
import com.tkylin.lottery.dataaccess.entity.User;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2016/11/9 11:40
 */
public interface LotteryCustomDAO {
    int updateUserByPrimaryKey(User record);

    int updatePrizeByPrimaryKey(Prize record);
}
