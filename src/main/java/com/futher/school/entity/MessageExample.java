package com.futher.school.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMeIdIsNull() {
            addCriterion("me_id is null");
            return (Criteria) this;
        }

        public Criteria andMeIdIsNotNull() {
            addCriterion("me_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeIdEqualTo(Integer value) {
            addCriterion("me_id =", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdNotEqualTo(Integer value) {
            addCriterion("me_id <>", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdGreaterThan(Integer value) {
            addCriterion("me_id >", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("me_id >=", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdLessThan(Integer value) {
            addCriterion("me_id <", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdLessThanOrEqualTo(Integer value) {
            addCriterion("me_id <=", value, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdIn(List<Integer> values) {
            addCriterion("me_id in", values, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdNotIn(List<Integer> values) {
            addCriterion("me_id not in", values, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdBetween(Integer value1, Integer value2) {
            addCriterion("me_id between", value1, value2, "meId");
            return (Criteria) this;
        }

        public Criteria andMeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("me_id not between", value1, value2, "meId");
            return (Criteria) this;
        }

        public Criteria andMeTitleIsNull() {
            addCriterion("me_title is null");
            return (Criteria) this;
        }

        public Criteria andMeTitleIsNotNull() {
            addCriterion("me_title is not null");
            return (Criteria) this;
        }

        public Criteria andMeTitleEqualTo(String value) {
            addCriterion("me_title =", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleNotEqualTo(String value) {
            addCriterion("me_title <>", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleGreaterThan(String value) {
            addCriterion("me_title >", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("me_title >=", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleLessThan(String value) {
            addCriterion("me_title <", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleLessThanOrEqualTo(String value) {
            addCriterion("me_title <=", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleLike(String value) {
            addCriterion("me_title like", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleNotLike(String value) {
            addCriterion("me_title not like", value, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleIn(List<String> values) {
            addCriterion("me_title in", values, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleNotIn(List<String> values) {
            addCriterion("me_title not in", values, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleBetween(String value1, String value2) {
            addCriterion("me_title between", value1, value2, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeTitleNotBetween(String value1, String value2) {
            addCriterion("me_title not between", value1, value2, "meTitle");
            return (Criteria) this;
        }

        public Criteria andMeContentIsNull() {
            addCriterion("me_content is null");
            return (Criteria) this;
        }

        public Criteria andMeContentIsNotNull() {
            addCriterion("me_content is not null");
            return (Criteria) this;
        }

        public Criteria andMeContentEqualTo(String value) {
            addCriterion("me_content =", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentNotEqualTo(String value) {
            addCriterion("me_content <>", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentGreaterThan(String value) {
            addCriterion("me_content >", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentGreaterThanOrEqualTo(String value) {
            addCriterion("me_content >=", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentLessThan(String value) {
            addCriterion("me_content <", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentLessThanOrEqualTo(String value) {
            addCriterion("me_content <=", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentLike(String value) {
            addCriterion("me_content like", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentNotLike(String value) {
            addCriterion("me_content not like", value, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentIn(List<String> values) {
            addCriterion("me_content in", values, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentNotIn(List<String> values) {
            addCriterion("me_content not in", values, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentBetween(String value1, String value2) {
            addCriterion("me_content between", value1, value2, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeContentNotBetween(String value1, String value2) {
            addCriterion("me_content not between", value1, value2, "meContent");
            return (Criteria) this;
        }

        public Criteria andMeImageIsNull() {
            addCriterion("me_image is null");
            return (Criteria) this;
        }

        public Criteria andMeImageIsNotNull() {
            addCriterion("me_image is not null");
            return (Criteria) this;
        }

        public Criteria andMeImageEqualTo(String value) {
            addCriterion("me_image =", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageNotEqualTo(String value) {
            addCriterion("me_image <>", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageGreaterThan(String value) {
            addCriterion("me_image >", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageGreaterThanOrEqualTo(String value) {
            addCriterion("me_image >=", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageLessThan(String value) {
            addCriterion("me_image <", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageLessThanOrEqualTo(String value) {
            addCriterion("me_image <=", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageLike(String value) {
            addCriterion("me_image like", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageNotLike(String value) {
            addCriterion("me_image not like", value, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageIn(List<String> values) {
            addCriterion("me_image in", values, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageNotIn(List<String> values) {
            addCriterion("me_image not in", values, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageBetween(String value1, String value2) {
            addCriterion("me_image between", value1, value2, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeImageNotBetween(String value1, String value2) {
            addCriterion("me_image not between", value1, value2, "meImage");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousIsNull() {
            addCriterion("me_anonymous is null");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousIsNotNull() {
            addCriterion("me_anonymous is not null");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousEqualTo(String value) {
            addCriterion("me_anonymous =", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousNotEqualTo(String value) {
            addCriterion("me_anonymous <>", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousGreaterThan(String value) {
            addCriterion("me_anonymous >", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousGreaterThanOrEqualTo(String value) {
            addCriterion("me_anonymous >=", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousLessThan(String value) {
            addCriterion("me_anonymous <", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousLessThanOrEqualTo(String value) {
            addCriterion("me_anonymous <=", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousLike(String value) {
            addCriterion("me_anonymous like", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousNotLike(String value) {
            addCriterion("me_anonymous not like", value, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousIn(List<String> values) {
            addCriterion("me_anonymous in", values, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousNotIn(List<String> values) {
            addCriterion("me_anonymous not in", values, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousBetween(String value1, String value2) {
            addCriterion("me_anonymous between", value1, value2, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeAnonymousNotBetween(String value1, String value2) {
            addCriterion("me_anonymous not between", value1, value2, "meAnonymous");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateIsNull() {
            addCriterion("me_releaseDate is null");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateIsNotNull() {
            addCriterion("me_releaseDate is not null");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateEqualTo(Date value) {
            addCriterion("me_releaseDate =", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateNotEqualTo(Date value) {
            addCriterion("me_releaseDate <>", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateGreaterThan(Date value) {
            addCriterion("me_releaseDate >", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateGreaterThanOrEqualTo(Date value) {
            addCriterion("me_releaseDate >=", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateLessThan(Date value) {
            addCriterion("me_releaseDate <", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateLessThanOrEqualTo(Date value) {
            addCriterion("me_releaseDate <=", value, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateIn(List<Date> values) {
            addCriterion("me_releaseDate in", values, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateNotIn(List<Date> values) {
            addCriterion("me_releaseDate not in", values, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateBetween(Date value1, Date value2) {
            addCriterion("me_releaseDate between", value1, value2, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeReleasedateNotBetween(Date value1, Date value2) {
            addCriterion("me_releaseDate not between", value1, value2, "meReleasedate");
            return (Criteria) this;
        }

        public Criteria andMeStatusIsNull() {
            addCriterion("me_status is null");
            return (Criteria) this;
        }

        public Criteria andMeStatusIsNotNull() {
            addCriterion("me_status is not null");
            return (Criteria) this;
        }

        public Criteria andMeStatusEqualTo(String value) {
            addCriterion("me_status =", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotEqualTo(String value) {
            addCriterion("me_status <>", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusGreaterThan(String value) {
            addCriterion("me_status >", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("me_status >=", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLessThan(String value) {
            addCriterion("me_status <", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLessThanOrEqualTo(String value) {
            addCriterion("me_status <=", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusLike(String value) {
            addCriterion("me_status like", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotLike(String value) {
            addCriterion("me_status not like", value, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusIn(List<String> values) {
            addCriterion("me_status in", values, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotIn(List<String> values) {
            addCriterion("me_status not in", values, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusBetween(String value1, String value2) {
            addCriterion("me_status between", value1, value2, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeStatusNotBetween(String value1, String value2) {
            addCriterion("me_status not between", value1, value2, "meStatus");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentIsNull() {
            addCriterion("me_replyContent is null");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentIsNotNull() {
            addCriterion("me_replyContent is not null");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentEqualTo(String value) {
            addCriterion("me_replyContent =", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentNotEqualTo(String value) {
            addCriterion("me_replyContent <>", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentGreaterThan(String value) {
            addCriterion("me_replyContent >", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentGreaterThanOrEqualTo(String value) {
            addCriterion("me_replyContent >=", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentLessThan(String value) {
            addCriterion("me_replyContent <", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentLessThanOrEqualTo(String value) {
            addCriterion("me_replyContent <=", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentLike(String value) {
            addCriterion("me_replyContent like", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentNotLike(String value) {
            addCriterion("me_replyContent not like", value, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentIn(List<String> values) {
            addCriterion("me_replyContent in", values, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentNotIn(List<String> values) {
            addCriterion("me_replyContent not in", values, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentBetween(String value1, String value2) {
            addCriterion("me_replyContent between", value1, value2, "meReplycontent");
            return (Criteria) this;
        }

        public Criteria andMeReplycontentNotBetween(String value1, String value2) {
            addCriterion("me_replyContent not between", value1, value2, "meReplycontent");
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