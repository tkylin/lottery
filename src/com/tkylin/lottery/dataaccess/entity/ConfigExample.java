package com.tkylin.lottery.dataaccess.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigExample {
    protected String orderByClause;

    protected List oredCriteria;

    protected String limitClause;

    public ConfigExample() {
        oredCriteria = new ArrayList();
    }

    protected ConfigExample(ConfigExample example) {
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

        public Criteria andCardToChangeIsNull() {
            addCriterion("card_to_change is null");
            return this;
        }

        public Criteria andCardToChangeIsNotNull() {
            addCriterion("card_to_change is not null");
            return this;
        }

        public Criteria andCardToChangeEqualTo(Integer value) {
            addCriterion("card_to_change =", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeNotEqualTo(Integer value) {
            addCriterion("card_to_change <>", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeGreaterThan(Integer value) {
            addCriterion("card_to_change >", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_to_change >=", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeLessThan(Integer value) {
            addCriterion("card_to_change <", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeLessThanOrEqualTo(Integer value) {
            addCriterion("card_to_change <=", value, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeIn(List values) {
            addCriterion("card_to_change in", values, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeNotIn(List values) {
            addCriterion("card_to_change not in", values, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeBetween(Integer value1, Integer value2) {
            addCriterion("card_to_change between", value1, value2, "cardToChange");
            return this;
        }

        public Criteria andCardToChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("card_to_change not between", value1, value2, "cardToChange");
            return this;
        }

        public Criteria andRangeIsNull() {
            addCriterion("range is null");
            return this;
        }

        public Criteria andRangeIsNotNull() {
            addCriterion("range is not null");
            return this;
        }

        public Criteria andRangeEqualTo(Integer value) {
            addCriterion("range =", value, "range");
            return this;
        }

        public Criteria andRangeNotEqualTo(Integer value) {
            addCriterion("range <>", value, "range");
            return this;
        }

        public Criteria andRangeGreaterThan(Integer value) {
            addCriterion("range >", value, "range");
            return this;
        }

        public Criteria andRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("range >=", value, "range");
            return this;
        }

        public Criteria andRangeLessThan(Integer value) {
            addCriterion("range <", value, "range");
            return this;
        }

        public Criteria andRangeLessThanOrEqualTo(Integer value) {
            addCriterion("range <=", value, "range");
            return this;
        }

        public Criteria andRangeIn(List values) {
            addCriterion("range in", values, "range");
            return this;
        }

        public Criteria andRangeNotIn(List values) {
            addCriterion("range not in", values, "range");
            return this;
        }

        public Criteria andRangeBetween(Integer value1, Integer value2) {
            addCriterion("range between", value1, value2, "range");
            return this;
        }

        public Criteria andRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("range not between", value1, value2, "range");
            return this;
        }

        public Criteria andLotteryServerIsNull() {
            addCriterion("lottery_server is null");
            return this;
        }

        public Criteria andLotteryServerIsNotNull() {
            addCriterion("lottery_server is not null");
            return this;
        }

        public Criteria andLotteryServerEqualTo(String value) {
            addCriterion("lottery_server =", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerNotEqualTo(String value) {
            addCriterion("lottery_server <>", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerGreaterThan(String value) {
            addCriterion("lottery_server >", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_server >=", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerLessThan(String value) {
            addCriterion("lottery_server <", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerLessThanOrEqualTo(String value) {
            addCriterion("lottery_server <=", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerLike(String value) {
            addCriterion("lottery_server like", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerNotLike(String value) {
            addCriterion("lottery_server not like", value, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerIn(List values) {
            addCriterion("lottery_server in", values, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerNotIn(List values) {
            addCriterion("lottery_server not in", values, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerBetween(String value1, String value2) {
            addCriterion("lottery_server between", value1, value2, "lotteryServer");
            return this;
        }

        public Criteria andLotteryServerNotBetween(String value1, String value2) {
            addCriterion("lottery_server not between", value1, value2, "lotteryServer");
            return this;
        }

        public Criteria andDefaultChangeIsNull() {
            addCriterion("default_change is null");
            return this;
        }

        public Criteria andDefaultChangeIsNotNull() {
            addCriterion("default_change is not null");
            return this;
        }

        public Criteria andDefaultChangeEqualTo(Integer value) {
            addCriterion("default_change =", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeNotEqualTo(Integer value) {
            addCriterion("default_change <>", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeGreaterThan(Integer value) {
            addCriterion("default_change >", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_change >=", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeLessThan(Integer value) {
            addCriterion("default_change <", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeLessThanOrEqualTo(Integer value) {
            addCriterion("default_change <=", value, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeIn(List values) {
            addCriterion("default_change in", values, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeNotIn(List values) {
            addCriterion("default_change not in", values, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeBetween(Integer value1, Integer value2) {
            addCriterion("default_change between", value1, value2, "defaultChange");
            return this;
        }

        public Criteria andDefaultChangeNotBetween(Integer value1, Integer value2) {
            addCriterion("default_change not between", value1, value2, "defaultChange");
            return this;
        }

        public Criteria andDefItem1IsNull() {
            addCriterion("def_item1 is null");
            return this;
        }

        public Criteria andDefItem1IsNotNull() {
            addCriterion("def_item1 is not null");
            return this;
        }

        public Criteria andDefItem1EqualTo(String value) {
            addCriterion("def_item1 =", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1NotEqualTo(String value) {
            addCriterion("def_item1 <>", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1GreaterThan(String value) {
            addCriterion("def_item1 >", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1GreaterThanOrEqualTo(String value) {
            addCriterion("def_item1 >=", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1LessThan(String value) {
            addCriterion("def_item1 <", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1LessThanOrEqualTo(String value) {
            addCriterion("def_item1 <=", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1Like(String value) {
            addCriterion("def_item1 like", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1NotLike(String value) {
            addCriterion("def_item1 not like", value, "defItem1");
            return this;
        }

        public Criteria andDefItem1In(List values) {
            addCriterion("def_item1 in", values, "defItem1");
            return this;
        }

        public Criteria andDefItem1NotIn(List values) {
            addCriterion("def_item1 not in", values, "defItem1");
            return this;
        }

        public Criteria andDefItem1Between(String value1, String value2) {
            addCriterion("def_item1 between", value1, value2, "defItem1");
            return this;
        }

        public Criteria andDefItem1NotBetween(String value1, String value2) {
            addCriterion("def_item1 not between", value1, value2, "defItem1");
            return this;
        }

        public Criteria andDefItem2IsNull() {
            addCriterion("def_item2 is null");
            return this;
        }

        public Criteria andDefItem2IsNotNull() {
            addCriterion("def_item2 is not null");
            return this;
        }

        public Criteria andDefItem2EqualTo(String value) {
            addCriterion("def_item2 =", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2NotEqualTo(String value) {
            addCriterion("def_item2 <>", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2GreaterThan(String value) {
            addCriterion("def_item2 >", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2GreaterThanOrEqualTo(String value) {
            addCriterion("def_item2 >=", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2LessThan(String value) {
            addCriterion("def_item2 <", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2LessThanOrEqualTo(String value) {
            addCriterion("def_item2 <=", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2Like(String value) {
            addCriterion("def_item2 like", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2NotLike(String value) {
            addCriterion("def_item2 not like", value, "defItem2");
            return this;
        }

        public Criteria andDefItem2In(List values) {
            addCriterion("def_item2 in", values, "defItem2");
            return this;
        }

        public Criteria andDefItem2NotIn(List values) {
            addCriterion("def_item2 not in", values, "defItem2");
            return this;
        }

        public Criteria andDefItem2Between(String value1, String value2) {
            addCriterion("def_item2 between", value1, value2, "defItem2");
            return this;
        }

        public Criteria andDefItem2NotBetween(String value1, String value2) {
            addCriterion("def_item2 not between", value1, value2, "defItem2");
            return this;
        }

        public Criteria andDefItem3IsNull() {
            addCriterion("def_item3 is null");
            return this;
        }

        public Criteria andDefItem3IsNotNull() {
            addCriterion("def_item3 is not null");
            return this;
        }

        public Criteria andDefItem3EqualTo(String value) {
            addCriterion("def_item3 =", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3NotEqualTo(String value) {
            addCriterion("def_item3 <>", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3GreaterThan(String value) {
            addCriterion("def_item3 >", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3GreaterThanOrEqualTo(String value) {
            addCriterion("def_item3 >=", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3LessThan(String value) {
            addCriterion("def_item3 <", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3LessThanOrEqualTo(String value) {
            addCriterion("def_item3 <=", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3Like(String value) {
            addCriterion("def_item3 like", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3NotLike(String value) {
            addCriterion("def_item3 not like", value, "defItem3");
            return this;
        }

        public Criteria andDefItem3In(List values) {
            addCriterion("def_item3 in", values, "defItem3");
            return this;
        }

        public Criteria andDefItem3NotIn(List values) {
            addCriterion("def_item3 not in", values, "defItem3");
            return this;
        }

        public Criteria andDefItem3Between(String value1, String value2) {
            addCriterion("def_item3 between", value1, value2, "defItem3");
            return this;
        }

        public Criteria andDefItem3NotBetween(String value1, String value2) {
            addCriterion("def_item3 not between", value1, value2, "defItem3");
            return this;
        }

        public Criteria andDefItem4IsNull() {
            addCriterion("def_item4 is null");
            return this;
        }

        public Criteria andDefItem4IsNotNull() {
            addCriterion("def_item4 is not null");
            return this;
        }

        public Criteria andDefItem4EqualTo(Integer value) {
            addCriterion("def_item4 =", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4NotEqualTo(Integer value) {
            addCriterion("def_item4 <>", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4GreaterThan(Integer value) {
            addCriterion("def_item4 >", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4GreaterThanOrEqualTo(Integer value) {
            addCriterion("def_item4 >=", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4LessThan(Integer value) {
            addCriterion("def_item4 <", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4LessThanOrEqualTo(Integer value) {
            addCriterion("def_item4 <=", value, "defItem4");
            return this;
        }

        public Criteria andDefItem4In(List values) {
            addCriterion("def_item4 in", values, "defItem4");
            return this;
        }

        public Criteria andDefItem4NotIn(List values) {
            addCriterion("def_item4 not in", values, "defItem4");
            return this;
        }

        public Criteria andDefItem4Between(Integer value1, Integer value2) {
            addCriterion("def_item4 between", value1, value2, "defItem4");
            return this;
        }

        public Criteria andDefItem4NotBetween(Integer value1, Integer value2) {
            addCriterion("def_item4 not between", value1, value2, "defItem4");
            return this;
        }

        public Criteria andDefItem5IsNull() {
            addCriterion("def_item5 is null");
            return this;
        }

        public Criteria andDefItem5IsNotNull() {
            addCriterion("def_item5 is not null");
            return this;
        }

        public Criteria andDefItem5EqualTo(Integer value) {
            addCriterion("def_item5 =", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5NotEqualTo(Integer value) {
            addCriterion("def_item5 <>", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5GreaterThan(Integer value) {
            addCriterion("def_item5 >", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5GreaterThanOrEqualTo(Integer value) {
            addCriterion("def_item5 >=", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5LessThan(Integer value) {
            addCriterion("def_item5 <", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5LessThanOrEqualTo(Integer value) {
            addCriterion("def_item5 <=", value, "defItem5");
            return this;
        }

        public Criteria andDefItem5In(List values) {
            addCriterion("def_item5 in", values, "defItem5");
            return this;
        }

        public Criteria andDefItem5NotIn(List values) {
            addCriterion("def_item5 not in", values, "defItem5");
            return this;
        }

        public Criteria andDefItem5Between(Integer value1, Integer value2) {
            addCriterion("def_item5 between", value1, value2, "defItem5");
            return this;
        }

        public Criteria andDefItem5NotBetween(Integer value1, Integer value2) {
            addCriterion("def_item5 not between", value1, value2, "defItem5");
            return this;
        }

        public Criteria andDefItem6IsNull() {
            addCriterion("def_item6 is null");
            return this;
        }

        public Criteria andDefItem6IsNotNull() {
            addCriterion("def_item6 is not null");
            return this;
        }

        public Criteria andDefItem6EqualTo(Integer value) {
            addCriterion("def_item6 =", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6NotEqualTo(Integer value) {
            addCriterion("def_item6 <>", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6GreaterThan(Integer value) {
            addCriterion("def_item6 >", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6GreaterThanOrEqualTo(Integer value) {
            addCriterion("def_item6 >=", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6LessThan(Integer value) {
            addCriterion("def_item6 <", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6LessThanOrEqualTo(Integer value) {
            addCriterion("def_item6 <=", value, "defItem6");
            return this;
        }

        public Criteria andDefItem6In(List values) {
            addCriterion("def_item6 in", values, "defItem6");
            return this;
        }

        public Criteria andDefItem6NotIn(List values) {
            addCriterion("def_item6 not in", values, "defItem6");
            return this;
        }

        public Criteria andDefItem6Between(Integer value1, Integer value2) {
            addCriterion("def_item6 between", value1, value2, "defItem6");
            return this;
        }

        public Criteria andDefItem6NotBetween(Integer value1, Integer value2) {
            addCriterion("def_item6 not between", value1, value2, "defItem6");
            return this;
        }
    }
}