package com.futher.school.entity;

public class MessageWithBLOBs extends Message {
    private String meContent;

    private String meReplycontent;

    public String getMeContent() {
        return meContent;
    }

    public void setMeContent(String meContent) {
        this.meContent = meContent == null ? null : meContent.trim();
    }

    public String getMeReplycontent() {
        return meReplycontent;
    }

    public void setMeReplycontent(String meReplycontent) {
        this.meReplycontent = meReplycontent == null ? null : meReplycontent.trim();
    }
}