package simulator;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TCPServer{

	private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	
	private int port;
	private NetFrame frame;
	
	public TCPServer(NetFrame frame) {
		this.frame=frame;
		port = Integer.parseInt(frame.getPortInput().getText());
		
		try {
			serverSocket = new ServerSocket(port);
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					accept();
				}
			});
			thread.start();
			
			System.out.println("TCPServer sucess");
			
		}catch(Exception e) {
			System.out.println("TCPServer failed "+e.getMessage());
			JOptionPane.showMessageDialog(frame, "Error! " + e.getMessage(),"Error Message!",JOptionPane.ERROR_MESSAGE);
			frame.initEnabled();
		}
		
	}
	
	public void accept() {
		while(true) {
			try {
				clientSocket = serverSocket.accept();
				clientSocket.setSoTimeout(1000);
				
				Thread thread = new Thread() {
					public void run() {
						receive();
					}
				};
				
				thread.start();
				
			}catch(Exception e) {
				break;
			}
		}
	}
	
	public void receive() {
		try {
			String line;
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			
			while((line = in.readLine()) != null) {
				
				if(clientSocket.isClosed()) {
					in.close();
					out.close();
					break;
				}
				
				int next = frame.getTable().getRowCount() + 1;
				Object data[] = {next,"Down",clientSocket.getInetAddress().getHostAddress(),clientSocket.getPort(),line};
				frame.getTableModel().addRow(data);
				
				if(frame.getEcho().isSelected()) {
					out.println(line);
					next++;
					Object data1[] = {next,"Up",clientSocket.getInetAddress().getHostAddress(),clientSocket.getPort(),line};
					frame.getTableModel().addRow(data1);
				}
				
				tableScroll();
			}
				
		}catch(Exception e) {
			System.out.println("TCPServer receive ½ÇÆÐ : "+e.getMessage());
		}
	}
	
	
	
	public void tableScroll() {
		int bottomRow = frame.getTable().getRowCount();
		Rectangle rect = frame.getTable().getCellRect(bottomRow,0,true);
		frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
	}
	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

}
