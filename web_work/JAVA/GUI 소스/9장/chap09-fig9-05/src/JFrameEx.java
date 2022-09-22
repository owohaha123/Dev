/*
 * 스윙 프레임의 구성을 보이기 위한 예
 */

import javax.swing.*;
import java.awt.*;

public class JFrameEx extends JFrame{
	public JFrameEx() {
		setTitle("프레임 구성");
		
		// 메뉴 생성
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu searchMenu = new JMenu("Search");
		JMenu windowMenu = new JMenu("Window");
		
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(searchMenu);
		mb.add(windowMenu);
		setJMenuBar(mb);

		// contentPane
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color(186, 143, 45));
		this.add(new JButton("add"));
		this.add(new JButton("sub"));
		this.add(new JButton("mul"));
		this.add(new JButton("div"));
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameEx();

	}
}
