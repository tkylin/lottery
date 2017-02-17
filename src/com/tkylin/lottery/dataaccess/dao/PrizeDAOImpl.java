package com.tkylin.lottery.dataaccess.dao;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;
import com.tkylin.lottery.dataaccess.entity.Prize;
import com.tkylin.lottery.dataaccess.entity.PrizeExample;
import java.util.List;

public class PrizeDAOImpl extends SqlMapDaoTemplate implements PrizeDAO {

    public PrizeDAOImpl(DaoManager daoManager) {
        super(daoManager);
    }

    public int countByExample(PrizeExample example) {
        Integer count = (Integer)  queryForObject("prize.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    public int deleteByExample(PrizeExample example) {
        int rows = delete("prize.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer id) {
        Prize key = new Prize();
        key.setId(id);
        int rows = delete("prize.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    public Integer insert(Prize record) {
        Object newKey = insert("prize.ibatorgenerated_insert", record);
        return (Integer) newKey;
    }

    public List selectByExample(PrizeExample example) {
        List list = queryForList("prize.ibatorgenerated_selectByExample", example);
        return list;
    }

    public Prize selectByPrimaryKey(Integer id) {
        Prize key = new Prize();
        key.setId(id);
        Prize record = (Prize) queryForObject("prize.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    public int updateByExampleSelective(Prize record, PrizeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("prize.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Prize record, PrizeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = update("prize.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(Prize record) {
        int rows = update("prize.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(Prize record) {
        int rows = update("prize.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    private static class UpdateByExampleParms extends PrizeExample {
        private Object record;

        public UpdateByExampleParms(Object record, PrizeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}