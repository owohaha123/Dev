public class StringEx {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        char[] ch = {'h','e','l','l','o'};
        String str3 = new String(ch);

        // StringBuffer
        StringBuffer sb = new StringBuffer();
        sb.append("apc");
        sb.append("def");
        String str4 = new String(sb);
        String str5 = sb.toString();

        // 3) charAt() : 지정된 위치의 문자 가져오기
        char c = str1.charAt(0);
        System.out.println(str1 + " : " + c); // hello 의 ()번째 문자

        // 6) split(구분자) : 문자열에서 사용된 구분자(쉼표 콜론 공백 바 등)를 [] 안에 넣어줌
        String str6 = "dog,cat:chicken-pig";
        //String str6 = "dog cat chicken pig";
        String strs[] = str6.split("[,: -]");
        for(String s : strs){
            System.out.println(s);
        }
        System.out.println(strs.length); // 4
        System.out.println(str6); // dog,cat:chicken-pig

        // 7) replace / replaceAll
        String str7 = "aaaa1bbaabb4ccacc8";
        String str8 = str7.replace("aa","AA");
        System.out.println(str7); // aaaa1bbaabb4ccacc8
        System.out.println(str8); // AAAA1bbAAbb4ccacc8
        String str9 = str7.replaceAll("aa","ZZ");
        System.out.println(str9); // ZZZZ1bbZZbb4ccacc8
        String str10 = str7.replaceAll("[0-9]"," ");
        System.out.println(str10); // aaaa bbaabb ccacc

        // 9) substring
        String str11 = str7.substring(0, 10);
        System.out.println(str7); // aaaa1bbaabb4ccacc8
        System.out.println(str11); // aaaa1bbaab
    }

}
