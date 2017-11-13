package com.futher.school.entity;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsIdIsNull() {
            addCriterion("us_id is null");
            return (Criteria) this;
        }

        public Criteria andUsIdIsNotNull() {
            addCriterion("us_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdEqualTo(Integer value) {
            addCriterion("us_id =", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotEqualTo(Integer value) {
            addCriterion("us_id <>", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThan(Integer value) {
            addCriterion("us_id >", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_id >=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThan(Integer value) {
            addCriterion("us_id <", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThanOrEqualTo(Integer value) {
            addCriterion("us_id <=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdIn(List<Integer> values) {
            addCriterion("us_id in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotIn(List<Integer> values) {
            addCriterion("us_id not in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdBetween(Integer value1, Integer value2) {
            addCriterion("us_id between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("us_id not between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsEmailIsNull() {
            addCriterion("us_email is null");
            return (Criteria) this;
        }

        public Criteria andUsEmailIsNotNull() {
            addCriterion("us_email is not null");
            return (Criteria) this;
        }

        public Criteria andUsEmailEqualTo(String value) {
            addCriterion("us_email =", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailNotEqualTo(String value) {
            addCriterion("us_email <>", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailGreaterThan(String value) {
            addCriterion("us_email >", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailGreaterThanOrEqualTo(String value) {
            addCriterion("us_email >=", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailLessThan(String value) {
            addCriterion("us_email <", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailLessThanOrEqualTo(String value) {
            addCriterion("us_email <=", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailLike(String value) {
            addCriterion("us_email like", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailNotLike(String value) {
            addCriterion("us_email not like", value, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailIn(List<String> values) {
            addCriterion("us_email in", values, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailNotIn(List<String> values) {
            addCriterion("us_email not in", values, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailBetween(String value1, String value2) {
            addCriterion("us_email between", value1, value2, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsEmailNotBetween(String value1, String value2) {
            addCriterion("us_email not between", value1, value2, "usEmail");
            return (Criteria) this;
        }

        public Criteria andUsPasswordIsNull() {
            addCriterion("us_password is null");
            return (Criteria) this;
        }

        public Criteria andUsPasswordIsNotNull() {
            addCriterion("us_password is not null");
            return (Criteria) this;
        }

        public Criteria andUsPasswordEqualTo(String value) {
            addCriterion("us_password =", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordNotEqualTo(String value) {
            addCriterion("us_password <>", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordGreaterThan(String value) {
            addCriterion("us_password >", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("us_password >=", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordLessThan(String value) {
            addCriterion("us_password <", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordLessThanOrEqualTo(String value) {
            addCriterion("us_password <=", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordLike(String value) {
            addCriterion("us_password like", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordNotLike(String value) {
            addCriterion("us_password not like", value, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordIn(List<String> values) {
            addCriterion("us_password in", values, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordNotIn(List<String> values) {
            addCriterion("us_password not in", values, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordBetween(String value1, String value2) {
            addCriterion("us_password between", value1, value2, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsPasswordNotBetween(String value1, String value2) {
            addCriterion("us_password not between", value1, value2, "usPassword");
            return (Criteria) this;
        }

        public Criteria andUsNameIsNull() {
            addCriterion("us_name is null");
            return (Criteria) this;
        }

        public Criteria andUsNameIsNotNull() {
            addCriterion("us_name is not null");
            return (Criteria) this;
        }

        public Criteria andUsNameEqualTo(String value) {
            addCriterion("us_name =", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameNotEqualTo(String value) {
            addCriterion("us_name <>", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameGreaterThan(String value) {
            addCriterion("us_name >", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameGreaterThanOrEqualTo(String value) {
            addCriterion("us_name >=", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameLessThan(String value) {
            addCriterion("us_name <", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameLessThanOrEqualTo(String value) {
            addCriterion("us_name <=", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameLike(String value) {
            addCriterion("us_name like", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameNotLike(String value) {
            addCriterion("us_name not like", value, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameIn(List<String> values) {
            addCriterion("us_name in", values, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameNotIn(List<String> values) {
            addCriterion("us_name not in", values, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameBetween(String value1, String value2) {
            addCriterion("us_name between", value1, value2, "usName");
            return (Criteria) this;
        }

        public Criteria andUsNameNotBetween(String value1, String value2) {
            addCriterion("us_name not between", value1, value2, "usName");
            return (Criteria) this;
        }

        public Criteria andUsSexIsNull() {
            addCriterion("us_sex is null");
            return (Criteria) this;
        }

        public Criteria andUsSexIsNotNull() {
            addCriterion("us_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUsSexEqualTo(String value) {
            addCriterion("us_sex =", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexNotEqualTo(String value) {
            addCriterion("us_sex <>", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexGreaterThan(String value) {
            addCriterion("us_sex >", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexGreaterThanOrEqualTo(String value) {
            addCriterion("us_sex >=", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexLessThan(String value) {
            addCriterion("us_sex <", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexLessThanOrEqualTo(String value) {
            addCriterion("us_sex <=", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexLike(String value) {
            addCriterion("us_sex like", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexNotLike(String value) {
            addCriterion("us_sex not like", value, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexIn(List<String> values) {
            addCriterion("us_sex in", values, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexNotIn(List<String> values) {
            addCriterion("us_sex not in", values, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexBetween(String value1, String value2) {
            addCriterion("us_sex between", value1, value2, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsSexNotBetween(String value1, String value2) {
            addCriterion("us_sex not between", value1, value2, "usSex");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidIsNull() {
            addCriterion("us_identityId is null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidIsNotNull() {
            addCriterion("us_identityId is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidEqualTo(Integer value) {
            addCriterion("us_identityId =", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidNotEqualTo(Integer value) {
            addCriterion("us_identityId <>", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidGreaterThan(Integer value) {
            addCriterion("us_identityId >", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_identityId >=", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidLessThan(Integer value) {
            addCriterion("us_identityId <", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidLessThanOrEqualTo(Integer value) {
            addCriterion("us_identityId <=", value, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidIn(List<Integer> values) {
            addCriterion("us_identityId in", values, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidNotIn(List<Integer> values) {
            addCriterion("us_identityId not in", values, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidBetween(Integer value1, Integer value2) {
            addCriterion("us_identityId between", value1, value2, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentityidNotBetween(Integer value1, Integer value2) {
            addCriterion("us_identityId not between", value1, value2, "usIdentityid");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameIsNull() {
            addCriterion("us_identityName is null");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameIsNotNull() {
            addCriterion("us_identityName is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameEqualTo(String value) {
            addCriterion("us_identityName =", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameNotEqualTo(String value) {
            addCriterion("us_identityName <>", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameGreaterThan(String value) {
            addCriterion("us_identityName >", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameGreaterThanOrEqualTo(String value) {
            addCriterion("us_identityName >=", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameLessThan(String value) {
            addCriterion("us_identityName <", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameLessThanOrEqualTo(String value) {
            addCriterion("us_identityName <=", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameLike(String value) {
            addCriterion("us_identityName like", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameNotLike(String value) {
            addCriterion("us_identityName not like", value, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameIn(List<String> values) {
            addCriterion("us_identityName in", values, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameNotIn(List<String> values) {
            addCriterion("us_identityName not in", values, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameBetween(String value1, String value2) {
            addCriterion("us_identityName between", value1, value2, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsIdentitynameNotBetween(String value1, String value2) {
            addCriterion("us_identityName not between", value1, value2, "usIdentityname");
            return (Criteria) this;
        }

        public Criteria andUsTelIsNull() {
            addCriterion("us_tel is null");
            return (Criteria) this;
        }

        public Criteria andUsTelIsNotNull() {
            addCriterion("us_tel is not null");
            return (Criteria) this;
        }

        public Criteria andUsTelEqualTo(String value) {
            addCriterion("us_tel =", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelNotEqualTo(String value) {
            addCriterion("us_tel <>", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelGreaterThan(String value) {
            addCriterion("us_tel >", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelGreaterThanOrEqualTo(String value) {
            addCriterion("us_tel >=", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelLessThan(String value) {
            addCriterion("us_tel <", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelLessThanOrEqualTo(String value) {
            addCriterion("us_tel <=", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelLike(String value) {
            addCriterion("us_tel like", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelNotLike(String value) {
            addCriterion("us_tel not like", value, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelIn(List<String> values) {
            addCriterion("us_tel in", values, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelNotIn(List<String> values) {
            addCriterion("us_tel not in", values, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelBetween(String value1, String value2) {
            addCriterion("us_tel between", value1, value2, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsTelNotBetween(String value1, String value2) {
            addCriterion("us_tel not between", value1, value2, "usTel");
            return (Criteria) this;
        }

        public Criteria andUsImageIsNull() {
            addCriterion("us_image is null");
            return (Criteria) this;
        }

        public Criteria andUsImageIsNotNull() {
            addCriterion("us_image is not null");
            return (Criteria) this;
        }

        public Criteria andUsImageEqualTo(String value) {
            addCriterion("us_image =", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageNotEqualTo(String value) {
            addCriterion("us_image <>", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageGreaterThan(String value) {
            addCriterion("us_image >", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageGreaterThanOrEqualTo(String value) {
            addCriterion("us_image >=", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageLessThan(String value) {
            addCriterion("us_image <", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageLessThanOrEqualTo(String value) {
            addCriterion("us_image <=", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageLike(String value) {
            addCriterion("us_image like", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageNotLike(String value) {
            addCriterion("us_image not like", value, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageIn(List<String> values) {
            addCriterion("us_image in", values, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageNotIn(List<String> values) {
            addCriterion("us_image not in", values, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageBetween(String value1, String value2) {
            addCriterion("us_image between", value1, value2, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsImageNotBetween(String value1, String value2) {
            addCriterion("us_image not between", value1, value2, "usImage");
            return (Criteria) this;
        }

        public Criteria andUsSpareIsNull() {
            addCriterion("us_spare is null");
            return (Criteria) this;
        }

        public Criteria andUsSpareIsNotNull() {
            addCriterion("us_spare is not null");
            return (Criteria) this;
        }

        public Criteria andUsSpareEqualTo(String value) {
            addCriterion("us_spare =", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareNotEqualTo(String value) {
            addCriterion("us_spare <>", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareGreaterThan(String value) {
            addCriterion("us_spare >", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareGreaterThanOrEqualTo(String value) {
            addCriterion("us_spare >=", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareLessThan(String value) {
            addCriterion("us_spare <", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareLessThanOrEqualTo(String value) {
            addCriterion("us_spare <=", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareLike(String value) {
            addCriterion("us_spare like", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareNotLike(String value) {
            addCriterion("us_spare not like", value, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareIn(List<String> values) {
            addCriterion("us_spare in", values, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareNotIn(List<String> values) {
            addCriterion("us_spare not in", values, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareBetween(String value1, String value2) {
            addCriterion("us_spare between", value1, value2, "usSpare");
            return (Criteria) this;
        }

        public Criteria andUsSpareNotBetween(String value1, String value2) {
            addCriterion("us_spare not between", value1, value2, "usSpare");
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