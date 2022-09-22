import javax.swing.*;
import java.awt.*;

public class GridLayoutSample extends JFrame {
	public GridLayoutSample() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4, 3, 5, 5);
		
		Container c = getContentPane();
		c.setLayout(grid);
		for(int i=1; i<=9; i++)
			c.add(new JButton(Integer.toString(i)));

		c.add(new JButton("*"));
		c.add(new JButton("0"));
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutSample();
	}
}
