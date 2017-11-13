package com.futher.school.entity;

import java.io.Serializable;
import java.util.Date;

public class Resource implements  Serializable{

	private static final long serialVersionUID = 1L;

	private Integer reId;//资源编号

	private Integer reTypepid;//fu类别编号
	
    private Integer reTypeid;//类别编号

    private String reTypename;//类别名称

    private String reTitle;//z标题(图片URl，链接名称，文件名等)

    private String reContent;//内容(富文本等)

    private String rePublisher;//发布人

    private String reReleasedate;//发布日期

    private String reSpare;//备用

    public Resource() {

    }

	public Resource(Integer reId, Integer reTypepid, Integer reTypeid, String reTypename, String reTitle,
			String reContent, String rePublisher, String reReleasedate, String reSpare) {
		super();
		this.reId = reId;
		this.reTypepid = reTypepid;
		this.reTypeid = reTypeid;
		this.reTypename = reTypename;
		this.reTitle = reTitle;
		this.reContent = reContent;
		this.rePublisher = rePublisher;
		this.reReleasedate = reReleasedate;
		this.reSpare = reSpare;
	}

	public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getReTypeid() {
        return reTypeid;
    }
    
    public Integer getReTypepid() {
		return reTypepid;
	}

	public void setReTypepid(Integer reTypepid) {
		this.reTypepid = reTypepid;
	}

	public void setReTypeid(Integer reTypeid) {
        this.reTypeid = reTypeid;
    }

    public String getReTypename() {
        return reTypename;
    }

    public void setReTypename(String reTypename) {
        this.reTypename = reTypename;
    }

    public String getReTitle() {
        return reTitle;
    }

    public void setReTitle(String reTitle) {
        this.reTitle = reTitle;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public String getRePublisher() {
        return rePublisher;
    }

    public void setRePublisher(String rePublisher) {
        this.rePublisher = rePublisher;
    }

    public String getReReleasedate() {
        return reReleasedate;
    }

    public void setReReleasedate(String date) {
        this.reReleasedate = date;
    }

    public String getReSpare() {
        return reSpare;
    }

    public void setReSpare(String reSpare) {
        this.reSpare = reSpare;
    }

	@Override
	public String toString() {
		return "Resource [reId=" + reId + ", reTypepid=" + reTypepid + ", reTypeid=" + reTypeid + ", reTypename="
				+ reTypename + ", reTitle=" + reTitle + ", reContent=" + reContent + ", rePublisher=" + rePublisher
				+ ", reReleasedate=" + reReleasedate + ", reSpare=" + reSpare + "]";
	}

}