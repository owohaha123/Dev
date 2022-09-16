public class GenericsTest {
    public static void main(String[] args) {
        Box b1 = new Box();
        b1.setItem("abc");
        Box b2 = new Box();
        b2.setItem(100);
        System.out.println(b1.getItem());

        // 저장된 데이터의 맞는 형태로 변경하여 사용
        // 형변환 연산자가 필요 (잘못된 형변환 시 예외사항 발생)
        String rb1 = (String)b1.getItem(); // String 형태로 형변환
        int rb2 = (int)b1.getItem();  // int 형태로 형변환

        // 제네릭스 박스 사용
        Box2<String> gb1 = new Box2<>();
        Box2<Integer> gb2 = new Box2<>();
        gb1.setItem("xyz");
        gb2.setItem(200);

        String rgb1 = gb1.getItem();
        int rgb2 = gb2.getItem();
    }
} // main class end

class Box {
    private Object item;
    public void setItem(Object item){
        this.item = item;
    }
    public Object getItem(){
        return item;
    }
} // Box end


class Box2<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
