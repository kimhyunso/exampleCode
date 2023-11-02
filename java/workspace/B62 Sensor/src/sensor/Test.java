package sensor;

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
	
	private int myPort=10001;
	private int yourPort=10002;
	
	private JPanel displayPanel;
	private JTextArea display;
	private JPanel inputPanel;
	private TextField input;
	
	class Sensor{
		int id;
		int seq;
		float temperature;
		float humidity;
	}
	
	public Chatting() {
		
		new MyFrame();
		
		/* set socket */
		try {
			
			//address : 상대방 address
			address = InetAddress.getByName("192.168.0.8");
			socket = new DatagramSocket(myPort);
		}catch(Exception e) {
			display.append("Error : "+e.getMessage());
		}
	}
	
	
	public void receive() {
		Sensor sensor = new Sensor();
		
		while(true) {
			try {
				byte[] rcvBuffer=new byte[1024];
				packet = new DatagramPacket(rcvBuffer , rcvBuffer.length);
				socket.receive(packet);
				// << 1.2.3.4:1000
				// Hello
				display.append("<< "+packet.getAddress().getHostAddress()+":"+packet.getPort()+"\n");
				//display.append(new String(rcvBuffer)+"\n");
				byte[] temp;
				temp = new byte[4];
				
				System.arraycopy(rcvBuffer, 0, temp, 0, 4);
				sensor.id = byteToInt(temp);
				sensor.id = swap(sensor.id);
				display.append("id = "+ sensor.id+"\n");
				
				System.arraycopy(rcvBuffer, 4, temp, 0, 4);
				sensor.seq = byteToInt(temp);
				sensor.seq = swap(sensor.seq);
				display.append("seq = "+ sensor.seq+"\n");
				
				System.arraycopy(rcvBuffer, 8, temp, 0, 4);
				sensor.temperature = byteToFloat(temp);
				sensor.temperature = swap(sensor.temperature);
				display.append("temperature = "+ sensor.temperature+"\n");
				
				System.arraycopy(rcvBuffer, 12, temp, 0, 4);
				sensor.humidity = byteToFloat(temp);
				sensor.humidity = swap(sensor.humidity);
				display.append("humidity = "+ sensor.humidity+"\n");
				
			}catch(Exception e) {
				
			}
		}
	}
	
	public int byteToInt(byte[] arr)
	{
		return (arr[0] & 0xff)<<24 | (arr[1] & 0xff)<<16 |(arr[2] & 0xff)<<8 | (arr[3] & 0xff);
	} 

	public float byteToFloat(byte[] bytes){
		int intBits = 
			bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
		return Float.intBitsToFloat(intBits);  

	}
	public short swap(short x) {
		return (short)((x << 8) | ((x >> 8) & 0xff));
	}

	public char swap(char x) {
		return (char)((x << 8) | ((x >> 8) & 0xff));
	}

	public int swap(int x) {
		return (int)((swap((short)x) << 16) | (swap((short)(x >> 16)) & 0xffff));
	}

	public long swap(long x) {
		return (long)(((long)swap((int)(x)) << 32) | ((long)swap((int)(x >> 32)) & 0xffffffffL));
	}

	public float swap(float x) {
		return Float.intBitsToFloat(swap(Float.floatToRawIntBits(x)));
	}

	public double swap(double x) {
		return Double.longBitsToDouble(swap(Double.doubleToRawLongBits(x)));
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
