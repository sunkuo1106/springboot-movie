package com.kgc.movie.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieTicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieTicketExample() {
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

        public Criteria andMovieIdIsNull() {
            addCriterion("movie_id is null");
            return (Criteria) this;
        }

        public Criteria andMovieIdIsNotNull() {
            addCriterion("movie_id is not null");
            return (Criteria) this;
        }

        public Criteria andMovieIdEqualTo(Integer value) {
            addCriterion("movie_id =", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdNotEqualTo(Integer value) {
            addCriterion("movie_id <>", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdGreaterThan(Integer value) {
            addCriterion("movie_id >", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_id >=", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdLessThan(Integer value) {
            addCriterion("movie_id <", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdLessThanOrEqualTo(Integer value) {
            addCriterion("movie_id <=", value, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdIn(List<Integer> values) {
            addCriterion("movie_id in", values, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdNotIn(List<Integer> values) {
            addCriterion("movie_id not in", values, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdBetween(Integer value1, Integer value2) {
            addCriterion("movie_id between", value1, value2, "movieId");
            return (Criteria) this;
        }

        public Criteria andMovieIdNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_id not between", value1, value2, "movieId");
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

        public Criteria andMovieYingchengidIsNull() {
            addCriterion("movie_yingchengid is null");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidIsNotNull() {
            addCriterion("movie_yingchengid is not null");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidEqualTo(Integer value) {
            addCriterion("movie_yingchengid =", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidNotEqualTo(Integer value) {
            addCriterion("movie_yingchengid <>", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidGreaterThan(Integer value) {
            addCriterion("movie_yingchengid >", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_yingchengid >=", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidLessThan(Integer value) {
            addCriterion("movie_yingchengid <", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidLessThanOrEqualTo(Integer value) {
            addCriterion("movie_yingchengid <=", value, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidIn(List<Integer> values) {
            addCriterion("movie_yingchengid in", values, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidNotIn(List<Integer> values) {
            addCriterion("movie_yingchengid not in", values, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidBetween(Integer value1, Integer value2) {
            addCriterion("movie_yingchengid between", value1, value2, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieYingchengidNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_yingchengid not between", value1, value2, "movieYingchengid");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNull() {
            addCriterion("movie_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNotNull() {
            addCriterion("movie_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieNameEqualTo(String value) {
            addCriterion("movie_name =", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotEqualTo(String value) {
            addCriterion("movie_name <>", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThan(String value) {
            addCriterion("movie_name >", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_name >=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThan(String value) {
            addCriterion("movie_name <", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThanOrEqualTo(String value) {
            addCriterion("movie_name <=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLike(String value) {
            addCriterion("movie_name like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotLike(String value) {
            addCriterion("movie_name not like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameIn(List<String> values) {
            addCriterion("movie_name in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotIn(List<String> values) {
            addCriterion("movie_name not in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameBetween(String value1, String value2) {
            addCriterion("movie_name between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotBetween(String value1, String value2) {
            addCriterion("movie_name not between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieDateIsNull() {
            addCriterion("movie_date is null");
            return (Criteria) this;
        }

        public Criteria andMovieDateIsNotNull() {
            addCriterion("movie_date is not null");
            return (Criteria) this;
        }

        public Criteria andMovieDateEqualTo(Date value) {
            addCriterion("movie_date =", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateNotEqualTo(Date value) {
            addCriterion("movie_date <>", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateGreaterThan(Date value) {
            addCriterion("movie_date >", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateGreaterThanOrEqualTo(Date value) {
            addCriterion("movie_date >=", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateLessThan(Date value) {
            addCriterion("movie_date <", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateLessThanOrEqualTo(Date value) {
            addCriterion("movie_date <=", value, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateIn(List<Date> values) {
            addCriterion("movie_date in", values, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateNotIn(List<Date> values) {
            addCriterion("movie_date not in", values, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateBetween(Date value1, Date value2) {
            addCriterion("movie_date between", value1, value2, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieDateNotBetween(Date value1, Date value2) {
            addCriterion("movie_date not between", value1, value2, "movieDate");
            return (Criteria) this;
        }

        public Criteria andMovieRoomIsNull() {
            addCriterion("movie_room is null");
            return (Criteria) this;
        }

        public Criteria andMovieRoomIsNotNull() {
            addCriterion("movie_room is not null");
            return (Criteria) this;
        }

        public Criteria andMovieRoomEqualTo(String value) {
            addCriterion("movie_room =", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomNotEqualTo(String value) {
            addCriterion("movie_room <>", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomGreaterThan(String value) {
            addCriterion("movie_room >", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomGreaterThanOrEqualTo(String value) {
            addCriterion("movie_room >=", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomLessThan(String value) {
            addCriterion("movie_room <", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomLessThanOrEqualTo(String value) {
            addCriterion("movie_room <=", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomLike(String value) {
            addCriterion("movie_room like", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomNotLike(String value) {
            addCriterion("movie_room not like", value, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomIn(List<String> values) {
            addCriterion("movie_room in", values, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomNotIn(List<String> values) {
            addCriterion("movie_room not in", values, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomBetween(String value1, String value2) {
            addCriterion("movie_room between", value1, value2, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMovieRoomNotBetween(String value1, String value2) {
            addCriterion("movie_room not between", value1, value2, "movieRoom");
            return (Criteria) this;
        }

        public Criteria andMoviePriceIsNull() {
            addCriterion("movie_price is null");
            return (Criteria) this;
        }

        public Criteria andMoviePriceIsNotNull() {
            addCriterion("movie_price is not null");
            return (Criteria) this;
        }

        public Criteria andMoviePriceEqualTo(Float value) {
            addCriterion("movie_price =", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceNotEqualTo(Float value) {
            addCriterion("movie_price <>", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceGreaterThan(Float value) {
            addCriterion("movie_price >", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("movie_price >=", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceLessThan(Float value) {
            addCriterion("movie_price <", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceLessThanOrEqualTo(Float value) {
            addCriterion("movie_price <=", value, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceIn(List<Float> values) {
            addCriterion("movie_price in", values, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceNotIn(List<Float> values) {
            addCriterion("movie_price not in", values, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceBetween(Float value1, Float value2) {
            addCriterion("movie_price between", value1, value2, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMoviePriceNotBetween(Float value1, Float value2) {
            addCriterion("movie_price not between", value1, value2, "moviePrice");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherIsNull() {
            addCriterion("movie_whether is null");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherIsNotNull() {
            addCriterion("movie_whether is not null");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherEqualTo(String value) {
            addCriterion("movie_whether =", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherNotEqualTo(String value) {
            addCriterion("movie_whether <>", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherGreaterThan(String value) {
            addCriterion("movie_whether >", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherGreaterThanOrEqualTo(String value) {
            addCriterion("movie_whether >=", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherLessThan(String value) {
            addCriterion("movie_whether <", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherLessThanOrEqualTo(String value) {
            addCriterion("movie_whether <=", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherLike(String value) {
            addCriterion("movie_whether like", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherNotLike(String value) {
            addCriterion("movie_whether not like", value, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherIn(List<String> values) {
            addCriterion("movie_whether in", values, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherNotIn(List<String> values) {
            addCriterion("movie_whether not in", values, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherBetween(String value1, String value2) {
            addCriterion("movie_whether between", value1, value2, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieWhetherNotBetween(String value1, String value2) {
            addCriterion("movie_whether not between", value1, value2, "movieWhether");
            return (Criteria) this;
        }

        public Criteria andMovieSeatIsNull() {
            addCriterion("movie_seat is null");
            return (Criteria) this;
        }

        public Criteria andMovieSeatIsNotNull() {
            addCriterion("movie_seat is not null");
            return (Criteria) this;
        }

        public Criteria andMovieSeatEqualTo(String value) {
            addCriterion("movie_seat =", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatNotEqualTo(String value) {
            addCriterion("movie_seat <>", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatGreaterThan(String value) {
            addCriterion("movie_seat >", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatGreaterThanOrEqualTo(String value) {
            addCriterion("movie_seat >=", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatLessThan(String value) {
            addCriterion("movie_seat <", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatLessThanOrEqualTo(String value) {
            addCriterion("movie_seat <=", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatLike(String value) {
            addCriterion("movie_seat like", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatNotLike(String value) {
            addCriterion("movie_seat not like", value, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatIn(List<String> values) {
            addCriterion("movie_seat in", values, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatNotIn(List<String> values) {
            addCriterion("movie_seat not in", values, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatBetween(String value1, String value2) {
            addCriterion("movie_seat between", value1, value2, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andMovieSeatNotBetween(String value1, String value2) {
            addCriterion("movie_seat not between", value1, value2, "movieSeat");
            return (Criteria) this;
        }

        public Criteria andEnterIdIsNull() {
            addCriterion("enter_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterIdIsNotNull() {
            addCriterion("enter_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterIdEqualTo(Integer value) {
            addCriterion("enter_id =", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotEqualTo(Integer value) {
            addCriterion("enter_id <>", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThan(Integer value) {
            addCriterion("enter_id >", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_id >=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThan(Integer value) {
            addCriterion("enter_id <", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdLessThanOrEqualTo(Integer value) {
            addCriterion("enter_id <=", value, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdIn(List<Integer> values) {
            addCriterion("enter_id in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotIn(List<Integer> values) {
            addCriterion("enter_id not in", values, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdBetween(Integer value1, Integer value2) {
            addCriterion("enter_id between", value1, value2, "enterId");
            return (Criteria) this;
        }

        public Criteria andEnterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_id not between", value1, value2, "enterId");
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