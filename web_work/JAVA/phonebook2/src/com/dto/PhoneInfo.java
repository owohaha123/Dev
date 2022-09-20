package com.dto;

public class PhoneInfo {
    private int no;
    private String name;
    private String phone;
    private String birth;
    private int age;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String str = "번호 : " + no + "\n"
                    + "이름 : " + name + "\n"
                    + "연락처 : " + phone + "\n"
                    + "생일 : " + birth + "\n"
                    + "나이 : " + age;
        return str;
    }
}
