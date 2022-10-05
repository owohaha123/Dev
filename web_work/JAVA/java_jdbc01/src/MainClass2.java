import dao.DataDao2;
import dto.MemberDto;

import java.util.Scanner;

public class MainClass2 {
    public static void main(String[] args) {
        DataDao2 dd2 = new DataDao2();
        MemberDto md = new MemberDto();
        Scanner scan = new Scanner(System.in);

        System.out.println("회원 가입");
        System.out.println("----------");
        System.out.print("ID : ");
        md.setM_id(scan.nextLine());
        System.out.print("PWD : ");
        md.setM_pwd(scan.nextLine());
        System.out.print("NAME : ");
        md.setM_name(scan.nextLine());
        System.out.print("AGE : ");
        md.setM_age(scan.nextInt());
        scan.nextLine(); // 숫자 받으면 한 번씩 써주기
        System.out.print("JOB : ");
        md.setM_job(scan.nextLine());

        // dao 의 insert 메소드로 DB 에 저장
        dd2.insertMember(md);
    }
}
