package com.controller;

import com.dto.DiaryInfo;
import com.view.InOutClass;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DiaryController {
    // 입출력 장치 객체
    private InOutClass io = new InOutClass();
    // 다이어리 저장 공간
    ArrayList<DiaryInfo> diary = new ArrayList<>();

    // 전체 제어 메소드
    public void run(){
        // 메뉴 번호 저장 변수
        int menu = -1;
        // 타이틀 출력
        io.twoPrint("⭐⭐My Diary⭐⭐");
        io.twoPrint("~~~~~~~~~~~~~~~~~~");

        while (true){
            // 메뉴 출력
            menuShow();

            menu = io.inNum("입력 > ");

            if(menu == 0){
                io.twoPrint("일기장 종료");
                break;
            }
            // 메뉴 번호에 따라 기능 처리
            switch (menu){
                case 1: // 입력 메소드 실행
                    inputData();
                    break;
                case 2: // 출력 메소드 실행
                    outputData();
                    break;
                case 3: // 수정 메소드 실행
                    updateData();
                    break;
                case 4: // 삭제 메소드 실행
                    deleteData();
                    break;
                default:
                    io.twoPrint("0~4번까지 입력하세요");
            }
        }// while end
    }// run end



    // 메뉴 출력 메소드
    private void menuShow(){
        io.twoPrint("1. 일기 쓰기");
        io.twoPrint("2. 일기 읽기");
        io.twoPrint("3. 일기 수정");
        io.twoPrint("4. 일기 삭제");
        io.twoPrint("0. 종료");
    }
    public String toDay() {
        // 파일명: 날짜 지정 기초 작업 (today)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();
        String today = sdf.format(time);

        Date selDate = null;
        try {
            selDate = sdf.parse(today);
        } catch (ParseException e) {
        }

        Calendar cal = new GregorianCalendar(Locale.KOREA);
        cal.setTime(selDate);
        today = sdf.format(cal.getTime());
        return today;
    }


    // 1. 일기 쓰기
    private void inputData(){
        io.twoPrint("🎞 일기 쓰기 🎞");
        io.twoPrint("----------------");

        // 생성자를 사용할 경우 먼저 입력을 모두 받아둔다
        String tdate = io.inStr("날짜 : ");
        String theme = io.inStr("주제 : ");
        String mood = io.inStr("기분 : ");
        String Content = io.inStr("내용 : ");

        DiaryInfo dInfo = new DiaryInfo(tdate, theme, mood, Content);

        BufferedWriter bw =null;
        FileWriter fw = null;

        try{
            File folder = new File("Diary");

            if(!folder.isDirectory()){
                folder.mkdir();
            }

            // 파일 생성
            File file = new File("Diary\\" + toDay() + ".txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            // 작성한 내용
            String wtdate = tdate;
            String wtheme = theme;
            String wmood = mood;
            String wContent = Content;

            // 파일에 작성 내용 저장
            bw.write(wtdate + "\n" + wtheme + "\n" + wmood + "\n" + wContent);
            bw.flush();

            System.out.println("💌Diary 폴더에 저장 성공💌");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }

        // 일기 목록에 일기 추가
        diary.add(dInfo);
        io.twoPrint("⭐오늘의 일기 끝!⭐\n");
    }

    // 2. 일기 가져오기
    private void outputData(){
        io.twoPrint("🎞 내가 쓴 일기 🎞");
        io.twoPrint("-------------------");
        // 저장된 정보가 있는지 확인
        if(diary.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }

        String dataDir = "C:\\Dev\\web_work\\JAVA\\mydiary\\Diary";
        File dir = new File(dataDir);



        File files[] = dir.listFiles();
        for (File file : files) {
            //System.out.println("file : " + file.getName());// 파일명만
            System.out.println("file : " + file);
        }

        io.twoPrint("⭐일기 출력 끝!⭐\n");
    }


    // 3. 일기 수정
    private void updateData() {
        if(diary.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("✏ 일기 수정 ✏");
        io.twoPrint("----------------");

        // 수정할 데이터 검색
        String tdate = io.inStr("수정할 날짜 : ");
        int i;
        DiaryInfo d = null;
        for(i = 0; i<diary.size(); i++){
            d = diary.get(i);
            if(tdate.equals(d.getTdate())){
                io.twoPrint(d.toString());
                break; // for(루프)만 멈춤
            }// if end
        }// for end

        // 검색 결과가 없을 경우의 처리
        if(i == diary.size()){
            io.twoPrint("검색 결과가 없습니다.");
            return; // 메소드 종료
        }
        BufferedWriter bw2 =null;
        FileWriter fw2 = null;

        try {
            File file = new File("Diary\\" + tdate + ".txt");
            fw2 = new FileWriter(file);
            bw2 = new BufferedWriter(fw2);

            io.twoPrint("수정할 내용이 없으면 엔터를 누르시오");
            String theme = io.inStr("주제 : ");
            if (!theme.equals("")) {
                d.setTheme(theme);

            }
            String mood = io.inStr("기분 : ");
            if (!mood.equals("")) {
                d.setMood(mood);
            }
            String Content = io.inStr("내용 : ");
            if (!Content.equals("")) {
                d.setContent(Content);
            }
            // 작성한 내용
            String wtheme = theme;
            String wmood = mood;
            String wContent = Content;

            // 파일에 작성 내용 저장
            bw2.write( wtheme + "\n" + wmood + "\n" + wContent);
            bw2.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bw2.close();
                fw2.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
            io.twoPrint("⭐일기 수정 끝!⭐\n");
    } // updateData end

    // 4. 일기 삭제
    private void deleteData() {
        if (diary.size() == 0) {
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 일기 삭제 ---");
        io.twoPrint("----------------");

        String tdate = io.inStr("삭제할 날짜 : ");
        int i; // 일부러 바깥쪽에서 선언
        DiaryInfo d = null;
        for (i = 0; i < diary.size(); i++) {
            d = diary.get(i); //get: ArrayList 복사하여 에서 꺼내오는 메소드
            if (tdate.equals(d.getTdate())) {
                io.twoPrint(d.toString());
                break; // for(루프)만 멈춤
            }// if end
        }// for end

        // 검색 결과가 없을 경우의 처리
        if (i == diary.size()) {
            io.twoPrint("검색 결과가 없습니다.");
            return; // 메소드 종료
        }

        // 삭제할 일기 검색 성공
        String yn = io.inStr("❗삭제할까요?(y)");

        if (yn.equals("y")) { // 입력값이 "y"라면
            diary.remove(d); // i 를 넣어도 됨
            String path = "Diary";

            File folder = new File(path);

            if (folder.exists()) {
                File[] list = folder.listFiles();

                for (File f : list) {
                    f.delete();
                }
                io.twoPrint("⭕삭제 완료 \n");
                return;
            }
            // 입력값이 "y"가 아니라면
            io.twoPrint("❌삭제 취소 \n");
        }
    }
}
