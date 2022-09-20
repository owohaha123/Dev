package com.dto;

public class PhoneSchInfo extends PhoneInfo{
    private String sname; // 학교명
    private String major; // 전공
    private int year; // 학년

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\n"
                    + "학교 : " + sname + "\n"
                    + "전공 : " + major + "\n"
                    + "학년 : " + year;
        return str;
    }
}
