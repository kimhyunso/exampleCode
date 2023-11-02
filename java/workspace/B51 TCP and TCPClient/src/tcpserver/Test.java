package tcpserver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyFrame extends JFrame implements ActionListener{

	private JPanel displayPanel;
	private JTextArea display;
	private JPanel inputPanel;
	private TextField input;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	public MyFrame() {
		
		makeFrame();
		makeDisplay();
		makeInput();
		
		Thread thread;
		thread = new Thread(new Runnable() {
			public void run() {
				tcpServer();
			}
		});
		
		thread.start();
		
		setVisible(true);
	}
	
	public void tcpServer() {
		
		//ServerSocket serverSocket=null;
		display.append("Start TCP Server\n");
		int port = 11112;
		
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setReuseAddress(true);
			
			display.append("Create TCP Socket : "+port+"\n");
			
		}catch(Exception e) {
			display.append("Cannot open Port # "+port+"\n");
			//System.exit(1);
		}
		
		//Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
			display.append("Accept OK");
			display.append("Client Info : "+clientSocket.getRemoteSocketAddress().toString()+":"+clientSocket.getPort()+"\n");
			
		}catch(Exception e) {
			display.append("Fail to Accept");
		}
		
		// Accept OK ...communication !!
		try {
			PrintWriter out =new PrintWriter(clientSocket.getOutputStream(),true);
			display.append("OK Create PrintWriter\n");
			
			BufferedReader in =new BufferedReader(
						new InputStreamReader(
								clientSocket.getInputStream()
						)
					);
			display.append("OK Create BufferedReader\n");
			String inputLine , outputLine;
			
					
			while((inputLine = in.readLine()) != null ) {
				display.append("<< "+inputLine+"\n");
				//Echo
				outputLine = inputLine;
				out.println(outputLine);
				display.append(">> "+outputLine+"\n");
				
				/*if(inputLine.equals("quit")) {
					if(out!=null)out.close();
					if(in!=null)in.close();
					if(serverSocket!=null)serverSocket.close();
					if(clientSocket!=null)clientSocket.close();
					break;
				}*/
				
			}
			
		}catch(Exception e) {
			
		}finally {
			//if(out!=null)out.close();
			//if(in!=null)in.close();
			try {
				if(serverSocket!=null)serverSocket.close();
				if(clientSocket!=null)clientSocket.close();
			}catch(Exception e1) {}
		}
		
	}
	
	public void makeFrame() {
		setTitle("TCP Server");
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