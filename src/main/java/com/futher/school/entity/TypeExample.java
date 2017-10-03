package com.futher.school.entity;

import java.util.ArrayList;
import java.util.List;

public class TypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypeExample() {
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

        public Criteria andTyIdIsNull() {
            addCriterion("ty_id is null");
            return (Criteria) this;
        }

        public Criteria andTyIdIsNotNull() {
            addCriterion("ty_id is not null");
            return (Criteria) this;
        }

        public Criteria andTyIdEqualTo(Integer value) {
            addCriterion("ty_id =", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotEqualTo(Integer value) {
            addCriterion("ty_id <>", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdGreaterThan(Integer value) {
            addCriterion("ty_id >", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ty_id >=", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdLessThan(Integer value) {
            addCriterion("ty_id <", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdLessThanOrEqualTo(Integer value) {
            addCriterion("ty_id <=", value, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdIn(List<Integer> values) {
            addCriterion("ty_id in", values, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotIn(List<Integer> values) {
            addCriterion("ty_id not in", values, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdBetween(Integer value1, Integer value2) {
            addCriterion("ty_id between", value1, value2, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ty_id not between", value1, value2, "tyId");
            return (Criteria) this;
        }

        public Criteria andTyPidIsNull() {
            addCriterion("ty_pid is null");
            return (Criteria) this;
        }

        public Criteria andTyPidIsNotNull() {
            addCriterion("ty_pid is not null");
            return (Criteria) this;
        }

        public Criteria andTyPidEqualTo(Integer value) {
            addCriterion("ty_pid =", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidNotEqualTo(Integer value) {
            addCriterion("ty_pid <>", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidGreaterThan(Integer value) {
            addCriterion("ty_pid >", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ty_pid >=", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidLessThan(Integer value) {
            addCriterion("ty_pid <", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidLessThanOrEqualTo(Integer value) {
            addCriterion("ty_pid <=", value, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidIn(List<Integer> values) {
            addCriterion("ty_pid in", values, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidNotIn(List<Integer> values) {
            addCriterion("ty_pid not in", values, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidBetween(Integer value1, Integer value2) {
            addCriterion("ty_pid between", value1, value2, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyPidNotBetween(Integer value1, Integer value2) {
            addCriterion("ty_pid not between", value1, value2, "tyPid");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameIsNull() {
            addCriterion("ty_categoryName is null");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameIsNotNull() {
            addCriterion("ty_categoryName is not null");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameEqualTo(String value) {
            addCriterion("ty_categoryName =", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameNotEqualTo(String value) {
            addCriterion("ty_categoryName <>", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameGreaterThan(String value) {
            addCriterion("ty_categoryName >", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameGreaterThanOrEqualTo(String value) {
            addCriterion("ty_categoryName >=", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameLessThan(String value) {
            addCriterion("ty_categoryName <", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameLessThanOrEqualTo(String value) {
            addCriterion("ty_categoryName <=", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameLike(String value) {
            addCriterion("ty_categoryName like", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameNotLike(String value) {
            addCriterion("ty_categoryName not like", value, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameIn(List<String> values) {
            addCriterion("ty_categoryName in", values, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameNotIn(List<String> values) {
            addCriterion("ty_categoryName not in", values, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameBetween(String value1, String value2) {
            addCriterion("ty_categoryName between", value1, value2, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTyCategorynameNotBetween(String value1, String value2) {
            addCriterion("ty_categoryName not between", value1, value2, "tyCategoryname");
            return (Criteria) this;
        }

        public Criteria andTySpareIsNull() {
            addCriterion("ty_spare is null");
            return (Criteria) this;
        }

        public Criteria andTySpareIsNotNull() {
            addCriterion("ty_spare is not null");
            return (Criteria) this;
        }

        public Criteria andTySpareEqualTo(String value) {
            addCriterion("ty_spare =", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareNotEqualTo(String value) {
            addCriterion("ty_spare <>", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareGreaterThan(String value) {
            addCriterion("ty_spare >", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareGreaterThanOrEqualTo(String value) {
            addCriterion("ty_spare >=", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareLessThan(String value) {
            addCriterion("ty_spare <", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareLessThanOrEqualTo(String value) {
            addCriterion("ty_spare <=", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareLike(String value) {
            addCriterion("ty_spare like", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareNotLike(String value) {
            addCriterion("ty_spare not like", value, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareIn(List<String> values) {
            addCriterion("ty_spare in", values, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareNotIn(List<String> values) {
            addCriterion("ty_spare not in", values, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareBetween(String value1, String value2) {
            addCriterion("ty_spare between", value1, value2, "tySpare");
            return (Criteria) this;
        }

        public Criteria andTySpareNotBetween(String value1, String value2) {
            addCriterion("ty_spare not between", value1, value2, "tySpare");
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