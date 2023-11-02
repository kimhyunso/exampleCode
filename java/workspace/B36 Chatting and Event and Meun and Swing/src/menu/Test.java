package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class MyFrame extends JFrame implements ActionListener{
	
	private JMenuItem eventTestItem;
	
	public MyFrame() {
		setTitle("GUI");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb=new JMenuBar(); // 메뉴바 생성
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu=new JMenu("Source");
		
		//Menu Item
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Open File"));
		fileMenu.add(new JMenuItem("Close"));
		fileMenu.addSeparator();
		eventTestItem=new JMenuItem("Event Test",KeyEvent.VK_E);
		fileMenu.add(eventTestItem);
		eventTestItem.addActionListener(this);
		fileMenu.addSeparator();
		
		//Sub Menu
		JMenu submenu = new JMenu("서브메뉴");
		fileMenu.add(submenu);
		submenu.add(new JMenuItem("Sub Menu1"));
		submenu.add(new JMenuItem("Sub Menu2"));
		
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		
		setJMenuBar(mb);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==eventTestItem) {
			System.out.println("메뉴에 의한 이벤트 처리");
		}
		
	}
	
}

public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}