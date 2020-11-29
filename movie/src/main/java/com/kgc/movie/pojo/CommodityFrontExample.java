package com.kgc.movie.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommodityFrontExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityFrontExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
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
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEnterIdIsNull() {
            addCriterion("enter_Id is null");
            return (Criteria) this;
        }

        public Criteria andEnterIdIsNotNull() {
            addCriterion("enter_Id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterIdEqualTo(Integer value) {
            addCriterion("enter_Id =", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotEqualTo(Integer value) {
            addCriterion("enter_Id <>", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThan(Integer value) {
            addCriterion("enter_Id >", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_Id >=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThan(Integer value) {
            addCriterion("enter_Id <", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThanOrEqualTo(Integer value) {
            addCriterion("enter_Id <=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdIn(List<Integer> values) {
            addCriterion("enter_Id in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotIn(List<Integer> values) {
            addCriterion("enter_Id not in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdBetween(Integer value1, Integer value2) {
            addCriterion("enter_Id between", value1, value2, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_Id not between", value1, value2, "enterId");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNull() {
            addCriterion("commodity_name is null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIsNotNull() {
            addCriterion("commodity_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityNameEqualTo(String value) {
            addCriterion("commodity_name =", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotEqualTo(String value) {
            addCriterion("commodity_name <>", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThan(String value) {
            addCriterion("commodity_name >", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_name >=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThan(String value) {
            addCriterion("commodity_name <", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLessThanOrEqualTo(String value) {
            addCriterion("commodity_name <=", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameLike(String value) {
            addCriterion("commodity_name like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotLike(String value) {
            addCriterion("commodity_name not like", value, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameIn(List<String> values) {
            addCriterion("commodity_name in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotIn(List<String> values) {
            addCriterion("commodity_name not in", values, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameBetween(String value1, String value2) {
            addCriterion("commodity_name between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityNameNotBetween(String value1, String value2) {
            addCriterion("commodity_name not between", value1, value2, "commodityName");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIsNull() {
            addCriterion("commodity_date is null");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIsNotNull() {
            addCriterion("commodity_date is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityDateEqualTo(Date value) {
            addCriterionForJDBCDate("commodity_date =", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("commodity_date <>", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateGreaterThan(Date value) {
            addCriterionForJDBCDate("commodity_date >", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("commodity_date >=", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateLessThan(Date value) {
            addCriterionForJDBCDate("commodity_date <", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("commodity_date <=", value, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateIn(List<Date> values) {
            addCriterionForJDBCDate("commodity_date in", values, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("commodity_date not in", values, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("commodity_date between", value1, value2, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("commodity_date not between", value1, value2, "commodityDate");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceIsNull() {
            addCriterion("commodity_totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceIsNotNull() {
            addCriterion("commodity_totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceEqualTo(Float value) {
            addCriterion("commodity_totalPrice =", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceNotEqualTo(Float value) {
            addCriterion("commodity_totalPrice <>", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceGreaterThan(Float value) {
            addCriterion("commodity_totalPrice >", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("commodity_totalPrice >=", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceLessThan(Float value) {
            addCriterion("commodity_totalPrice <", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceLessThanOrEqualTo(Float value) {
            addCriterion("commodity_totalPrice <=", value, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceIn(List<Float> values) {
            addCriterion("commodity_totalPrice in", values, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceNotIn(List<Float> values) {
            addCriterion("commodity_totalPrice not in", values, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceBetween(Float value1, Float value2) {
            addCriterion("commodity_totalPrice between", value1, value2, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andCommodityTotalpriceNotBetween(Float value1, Float value2) {
            addCriterion("commodity_totalPrice not between", value1, value2, "commodityTotalprice");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}