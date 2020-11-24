package com.kgc.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class HarvestAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HarvestAddressExample() {
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

        public Criteria andAddIdIsNull() {
            addCriterion("add_id is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("add_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(Integer value) {
            addCriterion("add_id =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(Integer value) {
            addCriterion("add_id <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(Integer value) {
            addCriterion("add_id >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_id >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(Integer value) {
            addCriterion("add_id <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(Integer value) {
            addCriterion("add_id <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<Integer> values) {
            addCriterion("add_id in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<Integer> values) {
            addCriterion("add_id not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(Integer value1, Integer value2) {
            addCriterion("add_id between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("add_id not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNull() {
            addCriterion("add_name is null");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNotNull() {
            addCriterion("add_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddNameEqualTo(String value) {
            addCriterion("add_name =", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotEqualTo(String value) {
            addCriterion("add_name <>", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThan(String value) {
            addCriterion("add_name >", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_name >=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThan(String value) {
            addCriterion("add_name <", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThanOrEqualTo(String value) {
            addCriterion("add_name <=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLike(String value) {
            addCriterion("add_name like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotLike(String value) {
            addCriterion("add_name not like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameIn(List<String> values) {
            addCriterion("add_name in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotIn(List<String> values) {
            addCriterion("add_name not in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameBetween(String value1, String value2) {
            addCriterion("add_name between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotBetween(String value1, String value2) {
            addCriterion("add_name not between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andAddGenderIsNull() {
            addCriterion("add_gender is null");
            return (Criteria) this;
        }

        public Criteria andAddGenderIsNotNull() {
            addCriterion("add_gender is not null");
            return (Criteria) this;
        }

        public Criteria andAddGenderEqualTo(String value) {
            addCriterion("add_gender =", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderNotEqualTo(String value) {
            addCriterion("add_gender <>", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderGreaterThan(String value) {
            addCriterion("add_gender >", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderGreaterThanOrEqualTo(String value) {
            addCriterion("add_gender >=", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderLessThan(String value) {
            addCriterion("add_gender <", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderLessThanOrEqualTo(String value) {
            addCriterion("add_gender <=", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderLike(String value) {
            addCriterion("add_gender like", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderNotLike(String value) {
            addCriterion("add_gender not like", value, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderIn(List<String> values) {
            addCriterion("add_gender in", values, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderNotIn(List<String> values) {
            addCriterion("add_gender not in", values, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderBetween(String value1, String value2) {
            addCriterion("add_gender between", value1, value2, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddGenderNotBetween(String value1, String value2) {
            addCriterion("add_gender not between", value1, value2, "addGender");
            return (Criteria) this;
        }

        public Criteria andAddAddressIsNull() {
            addCriterion("add_address is null");
            return (Criteria) this;
        }

        public Criteria andAddAddressIsNotNull() {
            addCriterion("add_address is not null");
            return (Criteria) this;
        }

        public Criteria andAddAddressEqualTo(String value) {
            addCriterion("add_address =", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressNotEqualTo(String value) {
            addCriterion("add_address <>", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressGreaterThan(String value) {
            addCriterion("add_address >", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressGreaterThanOrEqualTo(String value) {
            addCriterion("add_address >=", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressLessThan(String value) {
            addCriterion("add_address <", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressLessThanOrEqualTo(String value) {
            addCriterion("add_address <=", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressLike(String value) {
            addCriterion("add_address like", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressNotLike(String value) {
            addCriterion("add_address not like", value, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressIn(List<String> values) {
            addCriterion("add_address in", values, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressNotIn(List<String> values) {
            addCriterion("add_address not in", values, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressBetween(String value1, String value2) {
            addCriterion("add_address between", value1, value2, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddAddressNotBetween(String value1, String value2) {
            addCriterion("add_address not between", value1, value2, "addAddress");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeIsNull() {
            addCriterion("add_Postcode is null");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeIsNotNull() {
            addCriterion("add_Postcode is not null");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeEqualTo(String value) {
            addCriterion("add_Postcode =", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeNotEqualTo(String value) {
            addCriterion("add_Postcode <>", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeGreaterThan(String value) {
            addCriterion("add_Postcode >", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("add_Postcode >=", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeLessThan(String value) {
            addCriterion("add_Postcode <", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeLessThanOrEqualTo(String value) {
            addCriterion("add_Postcode <=", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeLike(String value) {
            addCriterion("add_Postcode like", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeNotLike(String value) {
            addCriterion("add_Postcode not like", value, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeIn(List<String> values) {
            addCriterion("add_Postcode in", values, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeNotIn(List<String> values) {
            addCriterion("add_Postcode not in", values, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeBetween(String value1, String value2) {
            addCriterion("add_Postcode between", value1, value2, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPostcodeNotBetween(String value1, String value2) {
            addCriterion("add_Postcode not between", value1, value2, "addPostcode");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIsNull() {
            addCriterion("add_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIsNotNull() {
            addCriterion("add_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneEqualTo(String value) {
            addCriterion("add_phone =", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotEqualTo(String value) {
            addCriterion("add_phone <>", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneGreaterThan(String value) {
            addCriterion("add_phone >", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("add_phone >=", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLessThan(String value) {
            addCriterion("add_phone <", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLessThanOrEqualTo(String value) {
            addCriterion("add_phone <=", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLike(String value) {
            addCriterion("add_phone like", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotLike(String value) {
            addCriterion("add_phone not like", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIn(List<String> values) {
            addCriterion("add_phone in", values, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotIn(List<String> values) {
            addCriterion("add_phone not in", values, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneBetween(String value1, String value2) {
            addCriterion("add_phone between", value1, value2, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotBetween(String value1, String value2) {
            addCriterion("add_phone not between", value1, value2, "addPhone");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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