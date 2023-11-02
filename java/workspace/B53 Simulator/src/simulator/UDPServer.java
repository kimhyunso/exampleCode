package simulator;

import java.awt.Rectangle;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;


public class UDPServer{

	private NetFrame frame;
	private DatagramSocket socket;
	private DatagramPacket packet;
	
	private int myPort;
	private String host;
	private InetAddress address;
	
	public UDPServer(NetFrame frame)
	{
		this.frame = frame;
		
		try {
			host = frame.getIpInput().getText();
			myPort=Integer.parseInt(frame.getPortInput().getText());
			address = InetAddress.getByName(host);
			
			socket = new DatagramSocket(myPort,address);
			System.out.println("UDPServer sussece");
			
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					receive();
				}
			});
			thread.start();
			
		}catch(Exception e) {
			System.out.println("UDPServer failed"+e.getMessage());
			JOptionPane.showMessageDialog(frame, "Error! " + e.getMessage(),"Error Message!",JOptionPane.ERROR_MESSAGE);
			frame.initEnabled();
		}
		
	}
	
	public void receive() {
		while(true) {
			try {
				byte[] rcvBuffer=new byte[1024];
				packet = new DatagramPacket(rcvBuffer , rcvBuffer.length);
				socket.receive(packet);
				
				int next=frame.getTable().getRowCount()+1;
				
				Object data[]= {next,"Down",packet.getAddress().getHostAddress(),packet.getPort(),new String(rcvBuffer).trim()};
				frame.getTableModel().addRow(data);
				
				if(frame.getEcho().isSelected()) {
					send(packet);
					next++;
					Object data1[]= {next,"Up",packet.getAddress().getHostAddress(),packet.getPort(),new String(rcvBuffer).trim()};
					frame.getTableModel().addRow(data1);
				}
				
				//역순
				//frame.getTableModel().moveRow(frame.getTableModel().getRowCount()-1,frame.getTableModel().getRowCount()-1,0);
				
				tableScroll();
				
			}catch(Exception e) {
				System.out.println("UDPServer receive 실패 : "+e.getMessage());
				break;
			}
		}
	}
	
	public void tableScroll() {
		int bottomRow = frame.getTable().getRowCount()-1;
		Rectangle rect = frame.getTable().getCellRect(bottomRow,0,true);
		frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
	}
	
	public void send(DatagramPacket packet) {
		
		try {
			socket.send(packet);
		}catch(Exception e) {
			System.out.println("UDPServer send 실패 : "+e.getMessage());
		}
	}

	public DatagramSocket getSocket() {
		return socket;
	}

	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}
	
}





