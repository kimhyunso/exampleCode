package toolbar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("ToolBar");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createToolBar();
		
		setVisible(true);
	}
	
	public void createToolBar() {
		JToolBar toolbar = new JToolBar("Tool Bar Menu Test");
		toolbar.setBackground(Color.LIGHT_GRAY);
		toolbar.add(new JButton("New"));
		toolbar.add(new JButton(new ImageIcon("images/save.png")));
		toolbar.addSeparator();
		toolbar.add(new JLabel("추가 툴바 기능"));
		
		JComboBox<String> combo = new JComboBox<>();
		combo.addItem("Java");
		combo.addItem("C++");
		combo.addItem("Python");
		
		toolbar.add(combo);
		
		add(toolbar,BorderLayout.NORTH);
		
	}
	
}



public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
