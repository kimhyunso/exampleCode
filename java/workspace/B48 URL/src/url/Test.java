package url;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyFrame extends JFrame implements ActionListener{

	private JPanel displayPanel;
	private JTextArea display;
	private JPanel inputPanel;
	private TextField input;
	
	public MyFrame() {
		setTitle("URL Info");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font=new Font("Dialog",Font.BOLD,20);
		displayPanel=new JPanel();
		inputPanel=new JPanel();
		display=new JTextArea(11,27);
		input=new TextField(30);
		JScrollPane scroll =new JScrollPane(display);
		
		display.setFont(font);
		displayPanel.setLayout(new FlowLayout());
		displayPanel.add(scroll);
		
		input.setFont(font);
		input.addActionListener(this);
		inputPanel.setLayout(new FlowLayout());
		inputPanel.add(input);
		
		
		add(displayPanel,BorderLayout.CENTER);
		add(inputPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			display.append(input.getText()+"\n");
			
			try {
				URL url = new URL(input.getText());
				display.append("Protocol : "+url.getProtocol()+"\n");
				display.append("Host : "+url.getHost()+"\n");
				display.append("Port : "+url.getPort()+"\n");
				display.append("Path : "+url.getPath()+"\n");
				display.append("Query : "+url.getQuery()+"\n\n\n");
				
				BufferedReader in = new BufferedReader(
							new InputStreamReader(url.openStream())
						);
				
				String line;
				String lineCount = "";
				int count=0;
				
				while( (line=in.readLine()) !=null) {
					lineCount = String.format("%04d : ", ++count);
					display.append(lineCount+line+"\n");
				}
				
				if(in!=null)in.close();
				
			}catch(Exception e1) {
				
			}
			
			
			input.selectAll();
		}
	}

}

public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}