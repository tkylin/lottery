package com.tkylin.lottery.dataaccess.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.tkylin.lottery.dataaccess.entity.User;
import com.tkylin.lottery.dataaccess.entity.UserExample;
import java.util.List;

public class UserDAOImpl extends SqlMapDaoTemplate implements UserDAO {

    public UserDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public int countByExample(UserExample example) {
        Integer count = (Integer)  queryForObject("user.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(UserExample example) {
        int rows = delete("user.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long userId) {
        User key = new User();
        key.setUserId(userId);
        int rows = delete("user.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public void insert(User record) {
        insert("user.ibatorgenerated_insert", record);
    }

    public List selectByExample(UserExample example) {
        List list = queryForList("user.ibatorgenerated_selectByExample", example);
        return list;
    }

    public User selectByPrimaryKey(Long userId) {
        User key = new User();
        key.setUserId(userId);
        User record = (User) queryForObject("user.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(User record, UserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("user.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(User record, UserExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("user.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(User record) {
        int rows = update("user.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(User record) {
        int rows = update("user.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends UserExample {
        private Object record;

        public UpdateByExampleParms(Object record, UserExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}