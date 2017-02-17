package com.tkylin.lottery.dataaccess.dao;

import com.tkylin.lottery.dataaccess.entity.LotteryLog;
import com.tkylin.lottery.dataaccess.entity.LotteryLogExample;
import java.util.List;

public interface LotteryLogDAO {
    int countByExample(LotteryLogExample example);

    int deleteByExample(LotteryLogExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(LotteryLog record);

    List selectByExample(LotteryLogExample example);

    LotteryLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(LotteryLog record, LotteryLogExample example);

    int updateByExample(LotteryLog record, LotteryLogExample example);

    int updateByPrimaryKeySelective(LotteryLog record);

    int updateByPrimaryKey(LotteryLog record);
}