package simulator;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TCPClient {
	
	private int port;
	private NetFrame frame;
	
	private FileRandom fileRandom;
	private Socket socket;
	private String ip;
	
	public TCPClient(NetFrame frame,FileRandom fileRandom) {
		this.frame = frame;
		this.fileRandom = fileRandom;
		
		try {
			ip = frame.getIpInput().getText();
			port = Integer.parseInt(frame.getPortInput().getText());
			socket = new Socket(ip, port);
			socket.setSoTimeout(5000);
			
			frame.getPortInput().setEnabled(false);
			frame.getIpInput().setEnabled(false);
			
			socket.close();
			System.out.println("TCPClient sucess");
		}catch(Exception e) {
			System.out.println("TCPClient failed");
			JOptionPane.showMessageDialog(frame, "Error! " + e.getMessage(),"Error Message!",JOptionPane.ERROR_MESSAGE);
			frame.initEnabled();
		}
	}
	
	public void send(String line) {
		try {
			socket = new Socket(ip, port);
			socket.setSoTimeout(1000);
			
			if(line == null || line.equals("")) {
				return;
			}
			
			String splitLine[] = line.split("\n");
			String buffer = "";
			
			for(int i=0; i<splitLine.length; i++) {
				buffer += splitLine[i];
			}
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			int count = (int)frame.getCountSpinner().getValue();
			int sleep = (int)frame.getSleepSpinner().getValue();
			
			if(frame.getRcv().isSelected()) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						receive(in);
					}
				});
				thread.start();
			}
			
			for(int i=0; i<count; i++) {
				
				if(socket.isClosed()) {
					out.close();
					break;
				}
					
				if(frame.getRandom().isSelected()) {
					String showText = fileRandom.checkedRandom((int)(Math.random()*7)).toString();
					frame.getDisplay().setText(showText);
					buffer = showText; 
				}
					
				out.println(buffer);
				int next = frame.getTable().getRowCount()+1;
				Object data[] = {next,"Up",socket.getInetAddress().getHostAddress(),socket.getPort(),buffer};
				frame.getTableModel().addRow(data);
				tableScroll();
							
				Thread.sleep(sleep);
			}
			
			
		}catch(Exception e) {
			System.out.println("TCPClient send 실패 "+e.getMessage());
			frame.initEnabled();
		}
		
	}
	
	
	public void tableScroll() {
		int bottomRow = frame.getTable().getRowCount();
		Rectangle rect = frame.getTable().getCellRect(bottomRow,0,true);
		frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
	}
	
	public void receive(BufferedReader in) {
		String line = null;
		try {
			
			while((line = in.readLine()) != null) {
				int next = frame.getTable().getRowCount()+1;
				Object data[] = {next,"Down",socket.getInetAddress().getHostAddress(),socket.getPort(),line};
				frame.getTableModel().addRow(data);
				tableScroll();
			}
			
		} catch (Exception e) {
			System.out.println("TCPClient receive 실패 "+e.getMessage());
			try {
				if(in != null)in.close();
			}catch(Exception e1) {}
		}
	}
	

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	

}
