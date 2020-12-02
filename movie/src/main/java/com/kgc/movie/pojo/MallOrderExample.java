package com.kgc.movie.pojo;

import java.util.ArrayList;
import java.util.List;

public class MallOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallOrderExample() {
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

        public Criteria andMallOrderIdIsNull() {
            addCriterion("mall_order_id is null");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdIsNotNull() {
            addCriterion("mall_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdEqualTo(Integer value) {
            addCriterion("mall_order_id =", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdNotEqualTo(Integer value) {
            addCriterion("mall_order_id <>", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdGreaterThan(Integer value) {
            addCriterion("mall_order_id >", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_order_id >=", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdLessThan(Integer value) {
            addCriterion("mall_order_id <", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("mall_order_id <=", value, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdIn(List<Integer> values) {
            addCriterion("mall_order_id in", values, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdNotIn(List<Integer> values) {
            addCriterion("mall_order_id not in", values, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("mall_order_id between", value1, value2, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_order_id not between", value1, value2, "mallOrderId");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameIsNull() {
            addCriterion("mall_order_name is null");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameIsNotNull() {
            addCriterion("mall_order_name is not null");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameEqualTo(String value) {
            addCriterion("mall_order_name =", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameNotEqualTo(String value) {
            addCriterion("mall_order_name <>", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameGreaterThan(String value) {
            addCriterion("mall_order_name >", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("mall_order_name >=", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameLessThan(String value) {
            addCriterion("mall_order_name <", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameLessThanOrEqualTo(String value) {
            addCriterion("mall_order_name <=", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameLike(String value) {
            addCriterion("mall_order_name like", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameNotLike(String value) {
            addCriterion("mall_order_name not like", value, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameIn(List<String> values) {
            addCriterion("mall_order_name in", values, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameNotIn(List<String> values) {
            addCriterion("mall_order_name not in", values, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameBetween(String value1, String value2) {
            addCriterion("mall_order_name between", value1, value2, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderNameNotBetween(String value1, String value2) {
            addCriterion("mall_order_name not between", value1, value2, "mallOrderName");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceIsNull() {
            addCriterion("mall_order_price is null");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceIsNotNull() {
            addCriterion("mall_order_price is not null");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceEqualTo(Float value) {
            addCriterion("mall_order_price =", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceNotEqualTo(Float value) {
            addCriterion("mall_order_price <>", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceGreaterThan(Float value) {
            addCriterion("mall_order_price >", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("mall_order_price >=", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceLessThan(Float value) {
            addCriterion("mall_order_price <", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceLessThanOrEqualTo(Float value) {
            addCriterion("mall_order_price <=", value, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceIn(List<Float> values) {
            addCriterion("mall_order_price in", values, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceNotIn(List<Float> values) {
            addCriterion("mall_order_price not in", values, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceBetween(Float value1, Float value2) {
            addCriterion("mall_order_price between", value1, value2, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderPriceNotBetween(Float value1, Float value2) {
            addCriterion("mall_order_price not between", value1, value2, "mallOrderPrice");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsIsNull() {
            addCriterion("mall_order_nums is null");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsIsNotNull() {
            addCriterion("mall_order_nums is not null");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsEqualTo(Integer value) {
            addCriterion("mall_order_nums =", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsNotEqualTo(Integer value) {
            addCriterion("mall_order_nums <>", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsGreaterThan(Integer value) {
            addCriterion("mall_order_nums >", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("mall_order_nums >=", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsLessThan(Integer value) {
            addCriterion("mall_order_nums <", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsLessThanOrEqualTo(Integer value) {
            addCriterion("mall_order_nums <=", value, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsIn(List<Integer> values) {
            addCriterion("mall_order_nums in", values, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsNotIn(List<Integer> values) {
            addCriterion("mall_order_nums not in", values, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsBetween(Integer value1, Integer value2) {
            addCriterion("mall_order_nums between", value1, value2, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("mall_order_nums not between", value1, value2, "mallOrderNums");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureIsNull() {
            addCriterion("mall_order_picture is null");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureIsNotNull() {
            addCriterion("mall_order_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureEqualTo(String value) {
            addCriterion("mall_order_picture =", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureNotEqualTo(String value) {
            addCriterion("mall_order_picture <>", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureGreaterThan(String value) {
            addCriterion("mall_order_picture >", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureGreaterThanOrEqualTo(String value) {
            addCriterion("mall_order_picture >=", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureLessThan(String value) {
            addCriterion("mall_order_picture <", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureLessThanOrEqualTo(String value) {
            addCriterion("mall_order_picture <=", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureLike(String value) {
            addCriterion("mall_order_picture like", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureNotLike(String value) {
            addCriterion("mall_order_picture not like", value, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureIn(List<String> values) {
            addCriterion("mall_order_picture in", values, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureNotIn(List<String> values) {
            addCriterion("mall_order_picture not in", values, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureBetween(String value1, String value2) {
            addCriterion("mall_order_picture between", value1, value2, "mallOrderPicture");
            return (Criteria) this;
        }

        public Criteria andMallOrderPictureNotBetween(String value1, String value2) {
            addCriterion("mall_order_picture not between", value1, value2, "mallOrderPicture");
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