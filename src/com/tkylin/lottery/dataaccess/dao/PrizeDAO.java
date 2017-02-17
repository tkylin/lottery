package com.tkylin.lottery.dataaccess.dao;

import com.tkylin.lottery.dataaccess.entity.Prize;
import com.tkylin.lottery.dataaccess.entity.PrizeExample;
import java.util.List;

public interface PrizeDAO {
    int countByExample(PrizeExample example);

    int deleteByExample(PrizeExample example);

    int deleteByPrimaryKey(Integer id);

    Integer insert(Prize record);

    List selectByExample(PrizeExample example);

    Prize selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Prize record, PrizeExample example);

    int updateByExample(Prize record, PrizeExample example);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);
}