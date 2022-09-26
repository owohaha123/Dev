package com.dto;

public class DiaryInfo {
    private String theme;
    private String tdate ;// 날짜
    private String mood;
    private String Content;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return  "날짜 : " + tdate + '\n' +
                "주제 : " + theme + '\n' +
                "기분 : " + mood + '\n' +
                "내용 : " + Content ;
    }

    public DiaryInfo(){}
    public DiaryInfo(String tdate, String theme, String mood, String Content){
        this.tdate = tdate;
        this.theme = theme;
        this.mood = mood;
        this.Content = Content;
    }

}// class end
