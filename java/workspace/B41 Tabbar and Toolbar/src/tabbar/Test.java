package tabbar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Tab Menu");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//tab = createTabbedPane();
		this.add(createTabbedPane(), BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	

	public JTabbedPane createTabbedPane()
	{
		JTabbedPane pane = new JTabbedPane();
		
		pane.addTab("Tab 1", new JLabel("Tab Menu 1"));
		pane.addTab("Tab 2", new JLabel(new ImageIcon("image/google.png")));
		pane.addTab("Tab 3", new MyPanel());
		
		pane.addTab("Tab 4", new JLabel("Tab Menu 4"));
		pane.addTab("Tab 5", new JLabel("Tab Menu 5"));
		pane.addTab("Tab 6", new JLabel("Tab Menu 6"));
		pane.addTab("Tab 7", new JLabel("Tab Menu 7"));
		pane.addTab("Tab 8", new JLabel("Tab Menu 8"));
		pane.addTab("Tab 9", new JLabel("Tab Menu 9"));
		pane.addTab("Tab 10", new JLabel("Tab Menu 10"));
		
		return pane;
	}
	
}

class MyPanel extends JPanel implements ActionListener{
	
	private JTextArea display;
	private JTextField input;
	
	public MyPanel() {
		setLayout(new FlowLayout());
		display = new JTextArea(15,40);
		input = new JTextField(40);
		input.addActionListener(this);
		
		add(display);
		add(input);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			display.append(input.getText()+"\n");
			input.selectAll();
		}
	}
}



public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}

}
