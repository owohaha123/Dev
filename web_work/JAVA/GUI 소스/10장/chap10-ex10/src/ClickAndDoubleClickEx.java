import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClickAndDoubleClickEx extends JFrame {
	public ClickAndDoubleClickEx() {
		setTitle("Click and DoubleClick 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener()); // Mouse 리스너 달기
		setSize(300,200);
		setVisible(true);
	}
	
	// MouseAdapter를 상속받아 Mouse 리스너 구현
	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) { // 더블클릭의 경우
				// [0,255] 사이의 랜덤한 r,g,b 정수 값 얻기 
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				Component c = (Component)e.getSource(); // 마우스가 클릭된 컴포넌트를 알아낸다.
				c.setBackground(new Color(r,b,g)); // 컴포넌트의 배경을 r,g,b 색으로 칠한다.
			}
		}
	}
	
	public static void main(String [] args) {
		new ClickAndDoubleClickEx();
	}
}