package com.dto;

public class PhoneComInfo extends PhoneInfo {
    private String company; // 회사명
    private String dept; // 부서명
    private String level; // 직급

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\n"
                    + "회사명 : " + company + "\n"
                    + "부서명 : " + dept + "\n"
                    + "직급 : " + level;
        return str;
    }
}
