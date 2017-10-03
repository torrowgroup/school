package com.futher.school.entity;

import java.io.Serializable;

public class Type implements  Serializable{

	private static final long serialVersionUID = 1L;

	private Integer tyId;

    private Integer tyPid;

    private String tyCategoryname;

    private String tySpare;

    
    public Type() {

    }

	public Type( Integer tyPid, String tyCategoryname, String tySpare) {
		this.tyPid = tyPid;
		this.tyCategoryname = tyCategoryname;
		this.tySpare = tySpare;
	}

	public Integer getTyId() {
        return tyId;
    }

    public void setTyId(Integer tyId) {
        this.tyId = tyId;
    }

    public Integer getTyPid() {
        return tyPid;
    }

    public void setTyPid(Integer tyPid) {
        this.tyPid = tyPid;
    }

    public String getTyCategoryname() {
        return tyCategoryname;
    }

    public void setTyCategoryname(String tyCategoryname) {
        this.tyCategoryname = tyCategoryname;
    }

    public String getTySpare() {
        return tySpare;
    }

    public void setTySpare(String tySpare) {
        this.tySpare = tySpare;
    }

	@Override
	public String toString() {
		return "Type [tyId=" + tyId + ", tyPid=" + tyPid + ", tyCategoryname=" + tyCategoryname + ", tySpare=" + tySpare
				+ "]";
	}
    
}