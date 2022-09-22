import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerAllEx extends JFrame {
	private JLabel la = new JLabel("No Mouse Event"); // 메시지 출력 레이블 컴포넌트
	
	public MouseListenerAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener	listener = new MyMouseListener(); // 리스너 객체 생성
		c.addMouseListener(listener); 		// MouseListener 리스너 등록
		c.addMouseMotionListener(listener); // MouseMotionListener 리스너 등록
		
		c.add(la);
		setSize(300,200);
		setVisible(true);
	}
	
	// Mouse 리스너와 MouseMotion 리스너를 모두 가진 리스너 작성
	class MyMouseListener implements MouseListener, MouseMotionListener {
		// MouseListener의 5개 메소드 구현
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed ("+e.getX()+","+e.getY()+")"); // 마우스가 눌러진 위치 (x,y) 점을 출력
		}
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased("+e.getX()+","+e.getY()+")"); // 마우스가 떼어진 위치 (x,y) 점을 출력
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)e.getSource(); // 마우스가 올라간 컴포넌트를 알아낸다.
			c.setBackground(Color.CYAN);
		}
		public void mouseExited(MouseEvent e) {
			Component c = (Component)e.getSource(); // 마우스가 내려간 컴포넌트를 알아낸다.
			c.setBackground(Color.YELLOW);
		}
		
		// MouseMotionListener의 2개 메소드 구현
		public void mouseDragged(MouseEvent e) { // 마우스가 드래깅되는 동안 계속 호출
			la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
		}
		public void mouseMoved(MouseEvent e) { // 마우스가 움직이는 동안 계속 호출
			la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
		}
	}
	
	public static void main(String [] args) {
		new MouseListenerAllEx();
	}
}