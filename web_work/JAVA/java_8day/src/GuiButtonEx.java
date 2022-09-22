import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiButtonEx extends JFrame {
    // 기본적인 화면 구성에 대한 설정을 생성자로 처리
    public GuiButtonEx(){
        // 제목표시줄에 타이틀 출력
        setTitle("GUI 예제");
        // 종료 버튼 클릭 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 화면 요소를 담는 Container 생성
        Container c = getContentPane();
        // 화면 요소를 배치하는 레이아웃 설정
        c.setLayout(new FlowLayout());

        // Container 에 버튼 추가
        JButton btn1 = new JButton("Action");
        c.add(btn1);

        MyActionListener mal = new MyActionListener();
        btn1.addActionListener(mal); //버튼에 리스너 붙이기

        JButton btn2 = new JButton("Action2");
        c.add(btn2);

        InnerActionListener ial = new InnerActionListener();
        btn2.addActionListener(ial);

        JButton btn3 = new JButton("Action3");
        c.add(btn3);
        btn3.addActionListener(new ActionListener() {
            // 익명 클래스(전용 기능 제공 객체)
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action3")){
                    b.setText("액션3");
                }else{
                    b.setText("Action3");
                }
                setTitle(b.getText());
            }
        });

        // 화면 크기 설정
        setSize(350,150);
        // 화면에 출력
        setVisible(true);
    }

    class InnerActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GuiButtonEx.this.setTitle("바뀐 제목!");
        }
    }

    public static void main(String[] args) {
        new GuiButtonEx();
    }
}

// 버튼 이벤트 처리용 객체
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action")){
            b.setText("액션");
        }else{
            b.setText("Action");
        }
    }
}