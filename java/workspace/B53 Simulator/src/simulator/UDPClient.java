package simulator;

import java.awt.Rectangle;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class UDPClient{
	
	private NetFrame frame;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress address;
	private int myPort;
	private int yourPort;
	private FileRandom fileRandom;
	
	private boolean isFlag = true;
	
	public UDPClient(NetFrame frame,FileRandom fileRandom) {
		this.frame = frame;
		this.fileRandom = fileRandom;
		
		try {
			address = InetAddress.getByName(frame.getIpInput().getText());
			myPort = Integer.parseInt(frame.getPortInput().getText());
			socket = new DatagramSocket(myPort);
			
			System.out.println("UDPClient sussced");
		}catch (Exception e) {
			System.out.println("UDPClient failed"+e.getMessage());
			JOptionPane.showMessageDialog(frame, "Error! " + e.getMessage(),"Error Message!",JOptionPane.ERROR_MESSAGE);
			frame.initEnabled();
		}
	}
	
	
	public void send(byte[] lineBuffer) {
		byte [] sendBuffer;
		try {
			
			if(lineBuffer.length <= 0) {
				return;
			}
			
			yourPort = Integer.parseInt(frame.getPortInput().getText());
			
			sendBuffer = lineBuffer;
			
			packet = new DatagramPacket(sendBuffer,sendBuffer.length,address,yourPort);
			
			int count = (int) frame.getCountSpinner().getValue();
			int sleep = (int) frame.getSleepSpinner().getValue();
			
			if(frame.getRcv().isSelected()) {
				
				Thread thread = new Thread(new Runnable() {
					@Override
					public synchronized void run() {
						// TODO Auto-generated method stub
						receive();
					}
				});
				
				thread.start();
			}
			
			for(int i=0; i<count; i++) {
				
				if(frame.getRandom().isSelected()) {
					String showText = fileRandom.checkedRandom((int)(Math.random()*7)).toString();
					frame.getDisplay().setText(showText);
					sendBuffer = showText.getBytes(); 
					packet = new DatagramPacket(sendBuffer,sendBuffer.length,address,yourPort);
				}
				
				int next = frame.getTable().getRowCount()+1;
				Object data[] = {next,"Up",packet.getAddress().getHostAddress(),packet.getPort(),new String(sendBuffer)};
				frame.getTableModel().addRow(data);
				
				socket.send(packet);
				
				int bottomRow = frame.getTable().getRowCount()-1;
				Rectangle rect =frame.getTable().getCellRect(bottomRow,0,true);
				frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
				
				Thread.sleep(sleep);
			}
			
			//역순
			//frame.getTableModel().moveRow(frame.getTableModel().getRowCount()-1,frame.getTableModel().getRowCount()-1,0);
			
		}catch(Exception e) {
			System.out.println("UDPClient send 실패 : "+e.getMessage());
		}
		
	}
	
	public void receive() {
		while(true) {
			try {
				
				byte receiveBuffer[]=new byte[1024];
				DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
				socket.receive(packet);
				int next = frame.getTable().getRowCount()+1;
				Object data[] = {next,"Down",packet.getAddress().getHostAddress(),packet.getPort(),new String(receiveBuffer).trim()};
				frame.getTableModel().addRow(data);
				
			}catch(Exception e) {
				System.out.println("UDPClient receive 실패 : "+e.getMessage());
				break;
			}
		}
		
	}
	
	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}


	public DatagramSocket getSocket() {
		return socket;
	}


	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}
	
}
