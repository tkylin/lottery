package com.tkylin.lottery.dataaccess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeExample {
    protected String orderByClause;

    protected List oredCriteria;

    protected String limitClause;

    public PrizeExample() {
        oredCriteria = new ArrayList();
    }

    protected PrizeExample(PrizeExample example) {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return this;
        }

        public Criteria andNameIn(List values) {
            addCriterion("name in", values, "name");
            return this;
        }

        public Criteria andNameNotIn(List values) {
            addCriterion("name not in", values, "name");
            return this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return this;
        }

        public Criteria andProbabilityIsNull() {
            addCriterion("probability is null");
            return this;
        }

        public Criteria andProbabilityIsNotNull() {
            addCriterion("probability is not null");
            return this;
        }

        public Criteria andProbabilityEqualTo(Integer value) {
            addCriterion("probability =", value, "probability");
            return this;
        }

        public Criteria andProbabilityNotEqualTo(Integer value) {
            addCriterion("probability <>", value, "probability");
            return this;
        }

        public Criteria andProbabilityGreaterThan(Integer value) {
            addCriterion("probability >", value, "probability");
            return this;
        }

        public Criteria andProbabilityGreaterThanOrEqualTo(Integer value) {
            addCriterion("probability >=", value, "probability");
            return this;
        }

        public Criteria andProbabilityLessThan(Integer value) {
            addCriterion("probability <", value, "probability");
            return this;
        }

        public Criteria andProbabilityLessThanOrEqualTo(Integer value) {
            addCriterion("probability <=", value, "probability");
            return this;
        }

        public Criteria andProbabilityIn(List values) {
            addCriterion("probability in", values, "probability");
            return this;
        }

        public Criteria andProbabilityNotIn(List values) {
            addCriterion("probability not in", values, "probability");
            return this;
        }

        public Criteria andProbabilityBetween(Integer value1, Integer value2) {
            addCriterion("probability between", value1, value2, "probability");
            return this;
        }

        public Criteria andProbabilityNotBetween(Integer value1, Integer value2) {
            addCriterion("probability not between", value1, value2, "probability");
            return this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return this;
        }

        public Criteria andNumberIn(List values) {
            addCriterion("number in", values, "number");
            return this;
        }

        public Criteria andNumberNotIn(List values) {
            addCriterion("number not in", values, "number");
            return this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return this;
        }

        public Criteria andIconIn(List values) {
            addCriterion("icon in", values, "icon");
            return this;
        }

        public Criteria andIconNotIn(List values) {
            addCriterion("icon not in", values, "icon");
            return this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return this;
        }

        public Criteria andSortIn(List values) {
            addCriterion("sort in", values, "sort");
            return this;
        }

        public Criteria andSortNotIn(List values) {
            addCriterion("sort not in", values, "sort");
            return this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return this;
        }

        public Criteria andStatusIn(List values) {
            addCriterion("status in", values, "status");
            return this;
        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("status not in", values, "status");
            return this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return this;
        }

        public Criteria andIndexNoIsNull() {
            addCriterion("index_no is null");
            return this;
        }

        public Criteria andIndexNoIsNotNull() {
            addCriterion("index_no is not null");
            return this;
        }

        public Criteria andIndexNoEqualTo(Integer value) {
            addCriterion("index_no =", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoNotEqualTo(Integer value) {
            addCriterion("index_no <>", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoGreaterThan(Integer value) {
            addCriterion("index_no >", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("index_no >=", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoLessThan(Integer value) {
            addCriterion("index_no <", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoLessThanOrEqualTo(Integer value) {
            addCriterion("index_no <=", value, "indexNo");
            return this;
        }

        public Criteria andIndexNoIn(List values) {
            addCriterion("index_no in", values, "indexNo");
            return this;
        }

        public Criteria andIndexNoNotIn(List values) {
            addCriterion("index_no not in", values, "indexNo");
            return this;
        }

        public Criteria andIndexNoBetween(Integer value1, Integer value2) {
            addCriterion("index_no between", value1, value2, "indexNo");
            return this;
        }

        public Criteria andIndexNoNotBetween(Integer value1, Integer value2) {
            addCriterion("index_no not between", value1, value2, "indexNo");
            return this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return this;
        }

        public Criteria andTypeIn(List values) {
            addCriterion("type in", values, "type");
            return this;
        }

        public Criteria andTypeNotIn(List values) {
            addCriterion("type not in", values, "type");
            return this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return this;
        }

        public Criteria andRewardNumIsNull() {
            addCriterion("reward_num is null");
            return this;
        }

        public Criteria andRewardNumIsNotNull() {
            addCriterion("reward_num is not null");
            return this;
        }

        public Criteria andRewardNumEqualTo(Integer value) {
            addCriterion("reward_num =", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumNotEqualTo(Integer value) {
            addCriterion("reward_num <>", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumGreaterThan(Integer value) {
            addCriterion("reward_num >", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_num >=", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumLessThan(Integer value) {
            addCriterion("reward_num <", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumLessThanOrEqualTo(Integer value) {
            addCriterion("reward_num <=", value, "rewardNum");
            return this;
        }

        public Criteria andRewardNumIn(List values) {
            addCriterion("reward_num in", values, "rewardNum");
            return this;
        }

        public Criteria andRewardNumNotIn(List values) {
            addCriterion("reward_num not in", values, "rewardNum");
            return this;
        }

        public Criteria andRewardNumBetween(Integer value1, Integer value2) {
            addCriterion("reward_num between", value1, value2, "rewardNum");
            return this;
        }

        public Criteria andRewardNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_num not between", value1, value2, "rewardNum");
            return this;
        }
    }
}