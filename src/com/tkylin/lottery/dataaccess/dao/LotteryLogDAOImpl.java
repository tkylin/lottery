package com.tkylin.lottery.dataaccess.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.tkylin.lottery.dataaccess.entity.LotteryLog;
import com.tkylin.lottery.dataaccess.entity.LotteryLogExample;
import java.util.List;

public class LotteryLogDAOImpl extends SqlMapDaoTemplate implements LotteryLogDAO {

    public LotteryLogDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public int countByExample(LotteryLogExample example) {
        Integer count = (Integer)  queryForObject("lottery_log.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(LotteryLogExample example) {
        int rows = delete("lottery_log.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        LotteryLog key = new LotteryLog();
        key.setId(id);
        int rows = delete("lottery_log.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Long insert(LotteryLog record) {
        Object newKey = insert("lottery_log.ibatorgenerated_insert", record);
        return (Long) newKey;
    }

    public List selectByExample(LotteryLogExample example) {
        List list = queryForList("lottery_log.ibatorgenerated_selectByExample", example);
        return list;
    }

    public LotteryLog selectByPrimaryKey(Long id) {
        LotteryLog key = new LotteryLog();
        key.setId(id);
        LotteryLog record = (LotteryLog) queryForObject("lottery_log.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(LotteryLog record, LotteryLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("lottery_log.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(LotteryLog record, LotteryLogExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("lottery_log.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(LotteryLog record) {
        int rows = update("lottery_log.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(LotteryLog record) {
        int rows = update("lottery_log.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends LotteryLogExample {
        private Object record;

        public UpdateByExampleParms(Object record, LotteryLogExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}