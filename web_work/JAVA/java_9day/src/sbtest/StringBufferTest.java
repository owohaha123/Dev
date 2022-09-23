package sbtest;

public class StringBufferTest {
    public static void main(String[] args) {
        // 기본 생성법 (16칸의 공간을 형성)
        StringBuffer sb1 = new StringBuffer();
        //System.out.println(sb1.capacity()); // 16

        // 원하는 크기로 생성
        StringBuffer sb2 = new StringBuffer(100);
        //System.out.println(sb2.capacity()); // 100

        sb1.append("abcdefghijklnmopqrstuvwxyz"); //26글자
        //System.out.println(sb1.capacity()); // 34? (26+8...?)왜...?

        // capacity : 전체 공간이 얼마인지
        // length : 사용하고 있는 공간
        StringBuffer sb3 = new StringBuffer("abcd");
        //System.out.println(sb3.capacity()); // 20 (4+16)
        //System.out.println(sb3.length()); // 4

        StringBuffer sb4 = sb1.delete(2,6);
        //System.out.println(sb4); // c~f 까지 삭제

        sb4.insert(5,"와");
        //System.out.println(sb4); // abghi와jklnmopqrstuvwxyz
        sb4.replace(6,10,"오~~~~");
        //System.out.println(sb4); // abghi와오~~~~mopqrstuvwxyz

        sb1.reverse();
        System.out.println(sb1); // zyxwvutsrqpom~~~~오와ihgba

        // 최종적으로 문자열로 변환
        String s = sb1.toString();
    }
}
