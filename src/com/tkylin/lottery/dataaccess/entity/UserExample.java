package com.tkylin.lottery.dataaccess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExample {
    protected String orderByClause;

    protected List oredCriteria;

    protected String limitClause;

    public UserExample() {
        oredCriteria = new ArrayList();
    }

    protected UserExample(UserExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.limitClause = example.limitClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public List getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
    }

    public void setLimitClause(String limitClause) {
        this.limitClause = limitClause;
    }

    public String getLimitClause() {
        return limitClause;
    }

    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return this;
        }

        public Criteria andUserIdIn(List values) {
            addCriterion("user_id in", values, "userId");
            return this;
        }

        public Criteria andUserIdNotIn(List values) {
            addCriterion("user_id not in", values, "userId");
            return this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return this;
        }

        public Criteria andRoomCardNumIsNull() {
            addCriterion("room_card_num is null");
            return this;
        }

        public Criteria andRoomCardNumIsNotNull() {
            addCriterion("room_card_num is not null");
            return this;
        }

        public Criteria andRoomCardNumEqualTo(Integer value) {
            addCriterion("room_card_num =", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumNotEqualTo(Integer value) {
            addCriterion("room_card_num <>", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumGreaterThan(Integer value) {
            addCriterion("room_card_num >", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_card_num >=", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumLessThan(Integer value) {
            addCriterion("room_card_num <", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumLessThanOrEqualTo(Integer value) {
            addCriterion("room_card_num <=", value, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumIn(List values) {
            addCriterion("room_card_num in", values, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumNotIn(List values) {
            addCriterion("room_card_num not in", values, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumBetween(Integer value1, Integer value2) {
            addCriterion("room_card_num between", value1, value2, "roomCardNum");
            return this;
        }

        public Criteria andRoomCardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("room_card_num not between", value1, value2, "roomCardNum");
            return this;
        }

        public Criteria andLotteryCountIsNull() {
            addCriterion("lottery_count is null");
            return this;
        }

        public Criteria andLotteryCountIsNotNull() {
            addCriterion("lottery_count is not null");
            return this;
        }

        public Criteria andLotteryCountEqualTo(Integer value) {
            addCriterion("lottery_count =", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountNotEqualTo(Integer value) {
            addCriterion("lottery_count <>", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountGreaterThan(Integer value) {
            addCriterion("lottery_count >", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_count >=", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountLessThan(Integer value) {
            addCriterion("lottery_count <", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_count <=", value, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountIn(List values) {
            addCriterion("lottery_count in", values, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountNotIn(List values) {
            addCriterion("lottery_count not in", values, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountBetween(Integer value1, Integer value2) {
            addCriterion("lottery_count between", value1, value2, "lotteryCount");
            return this;
        }

        public Criteria andLotteryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_count not between", value1, value2, "lotteryCount");
            return this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return this;
        }

        public Criteria andCountIn(List values) {
            addCriterion("count in", values, "count");
            return this;
        }

        public Criteria andCountNotIn(List values) {
            addCriterion("count not in", values, "count");
            return this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeIn(List values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeNotIn(List values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("create_time in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("create_time not in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return this;
        }

        public Criteria andUsableRoomCardNumIsNull() {
            addCriterion("usable_room_card_num is null");
            return this;
        }

        public Criteria andUsableRoomCardNumIsNotNull() {
            addCriterion("usable_room_card_num is not null");
            return this;
        }

        public Criteria andUsableRoomCardNumEqualTo(Integer value) {
            addCriterion("usable_room_card_num =", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumNotEqualTo(Integer value) {
            addCriterion("usable_room_card_num <>", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumGreaterThan(Integer value) {
            addCriterion("usable_room_card_num >", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("usable_room_card_num >=", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumLessThan(Integer value) {
            addCriterion("usable_room_card_num <", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumLessThanOrEqualTo(Integer value) {
            addCriterion("usable_room_card_num <=", value, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumIn(List values) {
            addCriterion("usable_room_card_num in", values, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumNotIn(List values) {
            addCriterion("usable_room_card_num not in", values, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumBetween(Integer value1, Integer value2) {
            addCriterion("usable_room_card_num between", value1, value2, "usableRoomCardNum");
            return this;
        }

        public Criteria andUsableRoomCardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("usable_room_card_num not between", value1, value2, "usableRoomCardNum");
            return this;
        }
    }
}