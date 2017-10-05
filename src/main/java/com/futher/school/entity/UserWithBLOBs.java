package com.futher.school.entity;

public class UserWithBLOBs extends User {
    private String usIntroduce;

    private String usTeachingresults;

    public String getUsIntroduce() {
        return usIntroduce;
    }

    public void setUsIntroduce(String usIntroduce) {
        this.usIntroduce = usIntroduce == null ? null : usIntroduce.trim();
    }

    public String getUsTeachingresults() {
        return usTeachingresults;
    }

    public void setUsTeachingresults(String usTeachingresults) {
        this.usTeachingresults = usTeachingresults == null ? null : usTeachingresults.trim();
    }
}