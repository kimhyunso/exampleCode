package tcpclient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyFrame extends JFrame implements ActionListener{

	private JPanel displayPanel;
	private JTextArea display;
	private JPanel inputPanel;
	private TextField input;
	
	private PrintWriter out =null;
	private Socket toSocket = null;
	private BufferedReader in = null;
	private int port=11112;
	
	public MyFrame() {
		
		makeFrame();
		makeDisplay();
		makeInput();
		
		setVisible(true);
		
		tcpClient();
	}
	
	public void tcpReceiver() {
		String fromServer =null;
		
		while(true) {
			try {
				fromServer = in.readLine();
				display.append("<< "+fromServer+"\n");
				
				if(fromServer.equals("quit")) {
					break;
				}
				
			}catch(Exception e) {
				
			}
		}
		
		closeClient();
	}
	
	public void closeClient() {
		try {
			if(in!=null)in.close();
			if(out!=null)out.close();
			if(toSocket!=null)toSocket.close();
		}catch(Exception e) {
			
		}
	}
	
	public void tcpClient() {
		display.append("TCP Client Start");
		
		try {
			toSocket=new Socket("127.0.0.1",port);
			
			out = new PrintWriter(toSocket.getOutputStream(),true); //true : auto flush
			
			in = new BufferedReader(
					new InputStreamReader(
						toSocket.getInputStream()
					)
				);
			
		} catch(UnknownHostException e) {
			display.append("Unknown Host Exception\n");
			
		} catch(Exception e) {
			display.append("Connect Error "+e.getMessage()+"\n");
		}
		
		display.append("OK Connect\n");
	}
	
	public void makeFrame() {
		setTitle("TCP Client");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	
	public void makeDisplay() {
		Font font=new Font("Dialog",Font.BOLD,20);
		display=new JTextArea(11,27);
		displayPanel=new JPanel();
		JScrollPane scroll =new JScrollPane(display);
		
		display.setFont(font);
		displayPanel.setLayout(new FlowLayout());
		displayPanel.add(scroll);
		
		add(displayPanel,BorderLayout.CENTER);
	}
	
	public void makeInput() {
		Font font=new Font("Dialog",Font.BOLD,20);
		inputPanel=new JPanel();
		input=new TextField(40);
		input.setFont(font);
		input.addActionListener(this);
		inputPanel.setLayout(new FlowLayout());
		inputPanel.add(input);
		
		add(inputPanel,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			
			if(!toSocket.isClosed()) {
				out.println(input.getText());
				display.append(">> "+input.getText()+"\n");
				input.selectAll();
			}
		}
	}

}

public class Test {
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
		frame.tcpReceiver();
	}
}