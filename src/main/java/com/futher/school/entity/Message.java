package com.futher.school.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements  Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer meId;

    private String meTitle;

    private String meContent;

    private String meImage;

    private String meAnonymous;

    private Date meReleasedate;

    private String meStatus;

    private String meReplycontent;
    
    
    public Message() {
    	
	}

	public Message(Integer meId, String meTitle, String meContent, String meImage, String meAnonymous,
			Date meReleasedate, String meStatus, String meReplycontent) {
		this.meId = meId;
		this.meTitle = meTitle;
		this.meContent = meContent;
		this.meImage = meImage;
		this.meAnonymous = meAnonymous;
		this.meReleasedate = meReleasedate;
		this.meStatus = meStatus;
		this.meReplycontent = meReplycontent;
	}

	public Integer getMeId() {
        return meId;
    }

    public void setMeId(Integer meId) {
        this.meId = meId;
    }

    public String getMeTitle() {
        return meTitle;
    }

    public void setMeTitle(String meTitle) {
        this.meTitle = meTitle;
    }

    public String getMeContent() {
        return meContent;
    }

    public void setMeContent(String meContent) {
        this.meContent = meContent;
    }

    public String getMeImage() {
        return meImage;
    }

    public void setMeImage(String meImage) {
        this.meImage = meImage;
    }

    public String getMeAnonymous() {
        return meAnonymous;
    }

    public void setMeAnonymous(String meAnonymous) {
        this.meAnonymous = meAnonymous;
    }

    public Date getMeReleasedate() {
        return meReleasedate;
    }

    public void setMeReleasedate(Date meReleasedate) {
        this.meReleasedate = meReleasedate;
    }

    public String getMeStatus() {
        return meStatus;
    }

    public void setMeStatus(String meStatus) {
        this.meStatus = meStatus;
    }

    public String getMeReplycontent() {
        return meReplycontent;
    }

    public void setMeReplycontent(String meReplycontent) {
        this.meReplycontent = meReplycontent;
    }

	@Override
	public String toString() {
		return "Message [meId=" + meId + ", meTitle=" + meTitle + ", meContent=" + meContent + ", meImage=" + meImage
				+ ", meAnonymous=" + meAnonymous + ", meReleasedate=" + meReleasedate + ", meStatus=" + meStatus
				+ ", meReplycontent=" + meReplycontent + "]";
	}
    
}