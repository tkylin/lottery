package com.tkylin.lottery.dataaccess.dao;

import com.tkylin.lottery.dataaccess.entity.User;
import com.tkylin.lottery.dataaccess.entity.UserExample;
import java.util.List;

public interface UserDAO {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    void insert(User record);

    List selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}