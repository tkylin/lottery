package com.tkylin.lottery.dataaccess.dao;

import com.tkylin.lottery.dataaccess.entity.Config;
import com.tkylin.lottery.dataaccess.entity.ConfigExample;
import java.util.List;

public interface ConfigDAO {
    int countByExample(ConfigExample example);

    int deleteByExample(ConfigExample example);

    int deleteByPrimaryKey(Integer id);

    Integer insert(Config record);

    List selectByExample(ConfigExample example);

    Config selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Config record, ConfigExample example);

    int updateByExample(Config record, ConfigExample example);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
}