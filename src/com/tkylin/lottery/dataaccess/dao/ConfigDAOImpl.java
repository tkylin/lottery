package com.tkylin.lottery.dataaccess.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.tkylin.lottery.dataaccess.entity.Config;
import com.tkylin.lottery.dataaccess.entity.ConfigExample;
import java.util.List;

public class ConfigDAOImpl extends SqlMapDaoTemplate implements ConfigDAO {

    public ConfigDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public int countByExample(ConfigExample example) {
        Integer count = (Integer)  queryForObject("config.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(ConfigExample example) {
        int rows = delete("config.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        Config key = new Config();
        key.setId(id);
        int rows = delete("config.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Integer insert(Config record) {
        Object newKey = insert("config.ibatorgenerated_insert", record);
        return (Integer) newKey;
    }

    public List selectByExample(ConfigExample example) {
        List list = queryForList("config.ibatorgenerated_selectByExample", example);
        return list;
    }

    public Config selectByPrimaryKey(Integer id) {
        Config key = new Config();
        key.setId(id);
        Config record = (Config) queryForObject("config.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(Config record, ConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("config.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Config record, ConfigExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("config.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(Config record) {
        int rows = update("config.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(Config record) {
        int rows = update("config.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends ConfigExample {
        private Object record;

        public UpdateByExampleParms(Object record, ConfigExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}