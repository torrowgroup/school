package com.futher.school.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer meId;// 留言编号

	private String meTitle;// 留言标题

	private String meContent;// 留言内容

	private String meImage;// 图片URl

	private String meAnonymous;// 是否匿名(匿名为是，不匿名随便填)

	private String meReleasedate;// 留言日期

	private String meStatus;// 状态(未回复，已回复(显示到前台页面))

	private String meReplycontent;// 回复内容

	private String meSpare;// 备用

	public Message() {

	}

	public Message(Integer meId, String meTitle, String meContent, String meImage, String meAnonymous,
			String meReleasedate, String meStatus, String meReplycontent, String meSpare) {
		super();
		this.meId = meId;
		this.meTitle = meTitle;
		this.meContent = meContent;
		this.meImage = meImage;
		this.meAnonymous = meAnonymous;
		this.meReleasedate = meReleasedate;
		this.meStatus = meStatus;
		this.meReplycontent = meReplycontent;
		this.meSpare = meSpare;
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

	public String getMeReleasedate() {
		return meReleasedate;
	}

	public void setMeReleasedate(String meReleasedate) {
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

	public String getMeSpare() {
		return meSpare;
	}

	public void setMeSpare(String meSpare) {
		this.meSpare = meSpare;
	}

	@Override
	public String toString() {
		return "Message [meId=" + meId + ", meTitle=" + meTitle + ", meContent=" + meContent + ", meImage=" + meImage
				+ ", meAnonymous=" + meAnonymous + ", meReleasedate=" + meReleasedate + ", meStatus=" + meStatus
				+ ", meReplycontent=" + meReplycontent + ", meSpare=" + meSpare + "]";
	}

}