package filein;

import java.io.*;

public class FileInput {
    public static void main(String[] args) {
        //FileInputStream fis = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            File file = new File("data\\test.txt");

            //fis = new FileInputStream(file); // byte(숫자) 단위로 처리
            fr = new FileReader(file);// 글자 단위로 읽어옴
            br = new BufferedReader(fr);

            int i = 0; // 읽어올 데이터(byte 단위)를 저장하는 변수
                       // read 가 숫자형만 받기에 int 사용
            /*
            // FileInputStream 사용
            // read() : byte 단위로 데이터를 읽어오는 메소드
            // 읽어온 내용이 없으면 -1 반환
            while((i = fis.read()) != -1){
                //System.out.println(i); // 숫자로 출력됨
                System.out.write(i); // 숫자를 문자로 변환 (file 관련해서만 사용)
            }
            */

            /*
            // FileReader 사용
            while ((i = fr.read()) != -1){
                System.out.print((char) i); // char 로 형변환 해주기!
            }
             */

            // BufferedReader 사용
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //fis.close();
                br.close(); // 제거는 설치한 역순으로!
                fr.close();
            } catch (IOException e) {} // 비워둬도 무방
        }
    }
}
