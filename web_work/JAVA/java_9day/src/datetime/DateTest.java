package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // Date class : 현재 시간을 저장한 인스턴스
        Date today = new Date();
        System.out.println(today);

        // SimpleDateFormat : 원하는 형태로 날짜와 시간 형식을 지정
        // 초에서도 m 을 쓰기에 여기선 M을 사용 / E는 요일 / G : 서기
        SimpleDateFormat sdf1 = new SimpleDateFormat("G yyyy-MM-dd(E)");
        String daystr = sdf1.format(today); // 문자열 변환
        System.out.println(daystr);

        // kk or HH : 24시 기준 / a : 오전
        SimpleDateFormat sdf2 = new SimpleDateFormat("[a] hh:mm:ss");
        String timestr = sdf2.format(today);
        System.out.println(timestr);

        // F : 요일 / w : 주차(연 기준) / W : 주차(월 기준) / D : 일차(연 기준)
        SimpleDateFormat sdf3 = new SimpleDateFormat("F w W D");
        String str = sdf3.format(today);
        System.out.println(str);
    }
}
