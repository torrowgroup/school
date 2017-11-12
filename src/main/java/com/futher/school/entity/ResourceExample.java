package com.futher.school.entity;

import java.util.ArrayList;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andReIdIsNull() {
            addCriterion("re_id is null");
            return (Criteria) this;
        }

        public Criteria andReIdIsNotNull() {
            addCriterion("re_id is not null");
            return (Criteria) this;
        }

        public Criteria andReIdEqualTo(Integer value) {
            addCriterion("re_id =", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotEqualTo(Integer value) {
            addCriterion("re_id <>", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThan(Integer value) {
            addCriterion("re_id >", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_id >=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThan(Integer value) {
            addCriterion("re_id <", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThanOrEqualTo(Integer value) {
            addCriterion("re_id <=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdIn(List<Integer> values) {
            addCriterion("re_id in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotIn(List<Integer> values) {
            addCriterion("re_id not in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdBetween(Integer value1, Integer value2) {
            addCriterion("re_id between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotBetween(Integer value1, Integer value2) {
            addCriterion("re_id not between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReTypepidIsNull() {
            addCriterion("re_typepid is null");
            return (Criteria) this;
        }

        public Criteria andReTypepidIsNotNull() {
            addCriterion("re_typepid is not null");
            return (Criteria) this;
        }

        public Criteria andReTypepidEqualTo(Integer value) {
            addCriterion("re_typepid =", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidNotEqualTo(Integer value) {
            addCriterion("re_typepid <>", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidGreaterThan(Integer value) {
            addCriterion("re_typepid >", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_typepid >=", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidLessThan(Integer value) {
            addCriterion("re_typepid <", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidLessThanOrEqualTo(Integer value) {
            addCriterion("re_typepid <=", value, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidIn(List<Integer> values) {
            addCriterion("re_typepid in", values, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidNotIn(List<Integer> values) {
            addCriterion("re_typepid not in", values, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidBetween(Integer value1, Integer value2) {
            addCriterion("re_typepid between", value1, value2, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypepidNotBetween(Integer value1, Integer value2) {
            addCriterion("re_typepid not between", value1, value2, "reTypepid");
            return (Criteria) this;
        }

        public Criteria andReTypeidIsNull() {
            addCriterion("re_typeId is null");
            return (Criteria) this;
        }

        public Criteria andReTypeidIsNotNull() {
            addCriterion("re_typeId is not null");
            return (Criteria) this;
        }

        public Criteria andReTypeidEqualTo(Integer value) {
            addCriterion("re_typeId =", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidNotEqualTo(Integer value) {
            addCriterion("re_typeId <>", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidGreaterThan(Integer value) {
            addCriterion("re_typeId >", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_typeId >=", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidLessThan(Integer value) {
            addCriterion("re_typeId <", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("re_typeId <=", value, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidIn(List<Integer> values) {
            addCriterion("re_typeId in", values, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidNotIn(List<Integer> values) {
            addCriterion("re_typeId not in", values, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidBetween(Integer value1, Integer value2) {
            addCriterion("re_typeId between", value1, value2, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("re_typeId not between", value1, value2, "reTypeid");
            return (Criteria) this;
        }

        public Criteria andReTypenameIsNull() {
            addCriterion("re_typeName is null");
            return (Criteria) this;
        }

        public Criteria andReTypenameIsNotNull() {
            addCriterion("re_typeName is not null");
            return (Criteria) this;
        }

        public Criteria andReTypenameEqualTo(String value) {
            addCriterion("re_typeName =", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameNotEqualTo(String value) {
            addCriterion("re_typeName <>", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameGreaterThan(String value) {
            addCriterion("re_typeName >", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("re_typeName >=", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameLessThan(String value) {
            addCriterion("re_typeName <", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameLessThanOrEqualTo(String value) {
            addCriterion("re_typeName <=", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameLike(String value) {
            addCriterion("re_typeName like", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameNotLike(String value) {
            addCriterion("re_typeName not like", value, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameIn(List<String> values) {
            addCriterion("re_typeName in", values, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameNotIn(List<String> values) {
            addCriterion("re_typeName not in", values, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameBetween(String value1, String value2) {
            addCriterion("re_typeName between", value1, value2, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTypenameNotBetween(String value1, String value2) {
            addCriterion("re_typeName not between", value1, value2, "reTypename");
            return (Criteria) this;
        }

        public Criteria andReTitleIsNull() {
            addCriterion("re_title is null");
            return (Criteria) this;
        }

        public Criteria andReTitleIsNotNull() {
            addCriterion("re_title is not null");
            return (Criteria) this;
        }

        public Criteria andReTitleEqualTo(String value) {
            addCriterion("re_title =", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleNotEqualTo(String value) {
            addCriterion("re_title <>", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleGreaterThan(String value) {
            addCriterion("re_title >", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleGreaterThanOrEqualTo(String value) {
            addCriterion("re_title >=", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleLessThan(String value) {
            addCriterion("re_title <", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleLessThanOrEqualTo(String value) {
            addCriterion("re_title <=", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleLike(String value) {
            addCriterion("re_title like", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleNotLike(String value) {
            addCriterion("re_title not like", value, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleIn(List<String> values) {
            addCriterion("re_title in", values, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleNotIn(List<String> values) {
            addCriterion("re_title not in", values, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleBetween(String value1, String value2) {
            addCriterion("re_title between", value1, value2, "reTitle");
            return (Criteria) this;
        }

        public Criteria andReTitleNotBetween(String value1, String value2) {
            addCriterion("re_title not between", value1, value2, "reTitle");
            return (Criteria) this;
        }

        public Criteria andRePublisherIsNull() {
            addCriterion("re_publisher is null");
            return (Criteria) this;
        }

        public Criteria andRePublisherIsNotNull() {
            addCriterion("re_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andRePublisherEqualTo(String value) {
            addCriterion("re_publisher =", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherNotEqualTo(String value) {
            addCriterion("re_publisher <>", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherGreaterThan(String value) {
            addCriterion("re_publisher >", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherGreaterThanOrEqualTo(String value) {
            addCriterion("re_publisher >=", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherLessThan(String value) {
            addCriterion("re_publisher <", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherLessThanOrEqualTo(String value) {
            addCriterion("re_publisher <=", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherLike(String value) {
            addCriterion("re_publisher like", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherNotLike(String value) {
            addCriterion("re_publisher not like", value, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherIn(List<String> values) {
            addCriterion("re_publisher in", values, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherNotIn(List<String> values) {
            addCriterion("re_publisher not in", values, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherBetween(String value1, String value2) {
            addCriterion("re_publisher between", value1, value2, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andRePublisherNotBetween(String value1, String value2) {
            addCriterion("re_publisher not between", value1, value2, "rePublisher");
            return (Criteria) this;
        }

        public Criteria andReReleasedateIsNull() {
            addCriterion("re_releaseDate is null");
            return (Criteria) this;
        }

        public Criteria andReReleasedateIsNotNull() {
            addCriterion("re_releaseDate is not null");
            return (Criteria) this;
        }

        public Criteria andReReleasedateEqualTo(String value) {
            addCriterion("re_releaseDate =", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateNotEqualTo(String value) {
            addCriterion("re_releaseDate <>", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateGreaterThan(String value) {
            addCriterion("re_releaseDate >", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateGreaterThanOrEqualTo(String value) {
            addCriterion("re_releaseDate >=", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateLessThan(String value) {
            addCriterion("re_releaseDate <", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateLessThanOrEqualTo(String value) {
            addCriterion("re_releaseDate <=", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateLike(String value) {
            addCriterion("re_releaseDate like", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateNotLike(String value) {
            addCriterion("re_releaseDate not like", value, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateIn(List<String> values) {
            addCriterion("re_releaseDate in", values, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateNotIn(List<String> values) {
            addCriterion("re_releaseDate not in", values, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateBetween(String value1, String value2) {
            addCriterion("re_releaseDate between", value1, value2, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReReleasedateNotBetween(String value1, String value2) {
            addCriterion("re_releaseDate not between", value1, value2, "reReleasedate");
            return (Criteria) this;
        }

        public Criteria andReSpareIsNull() {
            addCriterion("re_spare is null");
            return (Criteria) this;
        }

        public Criteria andReSpareIsNotNull() {
            addCriterion("re_spare is not null");
            return (Criteria) this;
        }

        public Criteria andReSpareEqualTo(String value) {
            addCriterion("re_spare =", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareNotEqualTo(String value) {
            addCriterion("re_spare <>", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareGreaterThan(String value) {
            addCriterion("re_spare >", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareGreaterThanOrEqualTo(String value) {
            addCriterion("re_spare >=", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareLessThan(String value) {
            addCriterion("re_spare <", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareLessThanOrEqualTo(String value) {
            addCriterion("re_spare <=", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareLike(String value) {
            addCriterion("re_spare like", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareNotLike(String value) {
            addCriterion("re_spare not like", value, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareIn(List<String> values) {
            addCriterion("re_spare in", values, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareNotIn(List<String> values) {
            addCriterion("re_spare not in", values, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareBetween(String value1, String value2) {
            addCriterion("re_spare between", value1, value2, "reSpare");
            return (Criteria) this;
        }

        public Criteria andReSpareNotBetween(String value1, String value2) {
            addCriterion("re_spare not between", value1, value2, "reSpare");
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