package filetest;

import java.io.File;
import java.io.IOException;

public class FileInfoEx {
    public static void main(String[] args) {
        // 1. 파일 정보 확인하기
        // 파일 객체 생성 및 이름 지정 (메모리)
        File f = new File("test.txt");

        try {
            boolean b = f.createNewFile(); // 파일 생성 메소드 (하드디스크)
            if(b == true){
                System.out.println("파일 생성 성공");
            }else {
                System.out.println("이미 파일이 존재함");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // 파일 존재 여부 및 파일/폴더 구분
        System.out.println("파일인가? " + f.isFile());
        // 마지막 수정 시간
        // 시간과 관련하여 산출된 밀리초의 값은 1970년 1월 1일부터 시작
        System.out.println("수정시간 : " + f.lastModified());

        // 파일의 설정 정보 확인
        System.out.println("읽기 가능 : " + f.canRead());
        System.out.println("쓰기 가능 : " + f.canWrite());
        System.out.println("실행 가능 : " + f.canExecute());
        System.out.println("숨김 파일? : " + f.isHidden());
        // 파일 존재 여부 확인
        System.out.println("존재하는가? " + f.exists());
        // 파일 크기 확인
        System.out.println("파일의 크기 : " + f.length());

        // 파일 경로
        // 상대 경로 정보
        System.out.println("상대 경로 : " + f.getPath());
        // 절대 경로 정보
        System.out.println("절대 경로 : " + f.getAbsolutePath());

        /*
        // 파일 이름 변경
        File f2 = new File("test2.txt");
        boolean rb = f.renameTo(f2);
        if(rb == true){
            System.out.println("변경 성공");
        }else{
            System.out.println("변경 실패");
        }

        // 파일 이동
        // renameTo : 파일명 변경, 파일 이동의 경우 사용
        File f3 = new File("target\\test2.txt");
        boolean rb2 = f2.renameTo(f3);
        if(rb2 == true){
            System.out.println("이동 성공");
        }else{
            System.out.println("이동 실패");
        }
        // 복사(ctrl + c) : 원본 유지
        // 이동(ctrl + x) : 원본 삭제
        // int a = 10; int b = a;
         */

        // 파일 삭제
        if(f.exists()){
            f.delete();
        }
    }
}
