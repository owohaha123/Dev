package datetime;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        // Calendar 인스턴스 생성
        // Calendar 는 추상 메소드. new 가 아닌 getInstance 사용하여 인스턴스 생성
        Calendar cal = Calendar.getInstance();
        //System.out.println(cal);

        // 연, 월, 일 구하기
        int year = cal.get(Calendar.YEAR);
        // month 는 0~11까지 나옴(배열). 따라서 +1 해줘야 함
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        System.out.println(year + "년 " + month + "월 " + day + "일");

        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        System.out.println(hour + "시 " + minute + "분 " + second + "초");

        // 달의 마지막 날 구하기
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
        System.out.println("이번 달의 마지막 날 : " + lastDayOfMonth);

        // 날짜 지정
        Calendar cal2 = Calendar.getInstance();
        // 연, 월, 일 지정
        cal2.set(Calendar.YEAR, 2022);
        cal2.set(Calendar.MONTH, 7); // 실제 월 -1 값 입력
        cal2.set(Calendar.DATE, 1); // 보통 기본은 1일로 설정
        System.out.println(cal2);

        // 시작일의 요일(1: 일 7: 토)
        int startDay = cal2.get(Calendar.DAY_OF_WEEK);
        System.out.println(startDay);
        int lastDay = cal2.getActualMaximum(Calendar.DATE);
        System.out.println(lastDay);
    }
}
