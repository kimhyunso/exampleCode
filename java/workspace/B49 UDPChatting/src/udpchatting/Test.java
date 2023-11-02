package udpchatting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Chatting{
	
	//Variable for Network
	private DatagramSocket socket;
	private DatagramPacket packet; //수신할 데이터
	private InetAddress address;
	
	private int myPort=10005;
	private int yourPort=11111;
	
	private JPanel displayPanel;
	private JTextArea display;
	private JPanel inputPanel;
	private TextField input;
	
	public Chatting() {
		
		new MyFrame();
		
		/* set socket */
		try {
			
			//address : 상대방 address
			address = InetAddress.getByName("192.168.0.8");
			socket = new DatagramSocket(myPort,address);
		}catch(Exception e) {
			display.append("Error : "+e.getMessage());
		}
	}
	
	
	public void receive() {
		while(true) {
			try {
				byte[] rcvBuffer=new byte[1024];
				packet = new DatagramPacket(rcvBuffer , rcvBuffer.length);
				socket.receive(packet);
				
				// << 1.2.3.4:1000
				// Hello
				display.append("<< "+packet.getAddress().getHostAddress()+":"+packet.getPort()+"\n");
				display.append(new String(rcvBuffer)+"\n");
				
			}catch(Exception e) {
				
			}
		}
	}
	
	class MyFrame extends JFrame implements ActionListener{

		public MyFrame() {
			makeFrame();
			makeDisplay();
			makeInput();
			
			setVisible(true);
		}
		
		public void makeDisplay() {
			Font font=new Font("Dialog",Font.BOLD,20);
			displayPanel=new JPanel();
			display=new JTextArea(11,27);
			
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
		
		public void makeFrame() {
			setTitle("UDP Chatting : "+myPort);
			setSize(500,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==input) {
				//send
				
				byte [] sendBuffer=input.getText().getBytes();
				// 전송할 패킷을 만들기
				DatagramPacket sendPacket;
				sendPacket=new DatagramPacket(sendBuffer,sendBuffer.length,address,yourPort);
				
				try {
					socket.send(sendPacket);
				}catch(Exception e1) {
					display.append("Error (send) :"+e1.getMessage()+"\n");
				}
				//>> 1.2.3.4:80
				//Hello World
				
				display.append(">> "+address.getHostAddress()+":"+yourPort+"\n");
				display.append(input.getText()+"\n");
				input.selectAll();
			}
		}
	}
}



public class Test {
	
	public static void main(String[] args) {
		Chatting chat = new Chatting();
		chat.receive();
	}
	
}
