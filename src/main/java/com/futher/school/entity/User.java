package com.futher.school.entity;

import java.io.Serializable;

public class User implements  Serializable{

	private static final long serialVersionUID = 1L;

	private Integer usId;

    private String usEmail;

    private String usPassword;

    private String usName;

    private String usSex;

    private String usIdentityid;

    private String usIdentityname;

    private String usTel;

    private String usImage;

    private String usIntroduce;

    private String usTeachingresults;

    private String usSpare;

    
    public User() {

    }

	public User( String usEmail, String usPassword, String usName, String usSex, String usIdentityid,
			String usIdentityname, String usTel, String usImage, String usIntroduce, String usTeachingresults,
			String usSpare) {
		this.usEmail = usEmail;
		this.usPassword = usPassword;
		this.usName = usName;
		this.usSex = usSex;
		this.usIdentityid = usIdentityid;
		this.usIdentityname = usIdentityname;
		this.usTel = usTel;
		this.usImage = usImage;
		this.usIntroduce = usIntroduce;
		this.usTeachingresults = usTeachingresults;
		this.usSpare = usSpare;
	}

	public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public String getUsSex() {
        return usSex;
    }

    public void setUsSex(String usSex) {
        this.usSex = usSex;
    }

    public String getUsIdentityid() {
        return usIdentityid;
    }

    public void setUsIdentityid(String usIdentityid) {
        this.usIdentityid = usIdentityid;
    }

    public String getUsIdentityname() {
        return usIdentityname;
    }

    public void setUsIdentityname(String usIdentityname) {
        this.usIdentityname = usIdentityname;
    }

    public String getUsTel() {
        return usTel;
    }

    public void setUsTel(String usTel) {
        this.usTel = usTel;
    }

    public String getUsImage() {
        return usImage;
    }

    public void setUsImage(String usImage) {
        this.usImage = usImage;
    }

    public String getUsIntroduce() {
        return usIntroduce;
    }

    public void setUsIntroduce(String usIntroduce) {
        this.usIntroduce = usIntroduce;
    }

    public String getUsTeachingresults() {
        return usTeachingresults;
    }

    public void setUsTeachingresults(String usTeachingresults) {
        this.usTeachingresults = usTeachingresults;
    }

    public String getUsSpare() {
        return usSpare;
    }

    public void setUsSpare(String usSpare) {
        this.usSpare = usSpare;
    }

	@Override
	public String toString() {
		return "User [usId=" + usId + ", usEmail=" + usEmail + ", usPassword=" + usPassword + ", usName=" + usName
				+ ", usSex=" + usSex + ", usIdentityid=" + usIdentityid + ", usIdentityname=" + usIdentityname
				+ ", usTel=" + usTel + ", usImage=" + usImage + ", usIntroduce=" + usIntroduce + ", usTeachingresults="
				+ usTeachingresults + ", usSpare=" + usSpare + "]";
	}
    
}