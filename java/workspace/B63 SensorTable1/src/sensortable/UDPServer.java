package sensortable;

import java.awt.Rectangle;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	
	private MyFrame frame;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private class Sensor{
		int id;
		int seq;
		float temperature;
		float humidity;
	}
	private Sensor sensor;
	private DataBase db;
	
	public UDPServer(MyFrame frame,DataBase db) {
		this.frame = frame;
		this.db = db;
		
		try {
			socket = new DatagramSocket(10001);
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					receive();
				}
			});
			
			thread.start();
		}catch(Exception e) {}
	}
	
	public void receive() {
		while(true) {
			sensor = new Sensor();
			
			byte[] receiveBuffer = new byte[1024];
			packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			
			try {
				socket.receive(packet);
			}catch(Exception e) {}
			
			castting(receiveBuffer);
			
			
			int next = frame.getTable().getRowCount() + 1;
			Object data[]= {next,sensor.id,sensor.seq,sensor.temperature,sensor.humidity};
			frame.getTableModel().addRow(data);
			
			String sql = String.format("insert into sensor_table (id,seq,temperature,humidity,time) values( %d, %d, %.1f, %.1f ,now())",sensor.id,sensor.seq,sensor.temperature,sensor.humidity);
			
			try {
				db.getStmt().executeUpdate(sql);
			}catch(Exception e) {
				System.out.println("¿À·ù");
			}
			
			int bottomRow = frame.getTable().getRowCount()-1;
			Rectangle rect = frame.getTable().getCellRect(bottomRow,0,true);
			frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
		}
	}
	
	public void castting(byte[] buffer) {
		byte[] temp = new byte[4];
		
		System.arraycopy(buffer, 0, temp, 0, 4);
		sensor.id = byteToInt(temp);
		sensor.id = swap(sensor.id);
		
		System.arraycopy(buffer, 4, temp, 0, 4);
		sensor.seq = byteToInt(temp);
		sensor.seq = swap(sensor.seq);
		
		System.arraycopy(buffer, 8, temp, 0, 4);
		sensor.temperature = byteToFloat(temp);
		sensor.temperature = swap(sensor.temperature);
		
		System.arraycopy(buffer, 12, temp, 0, 4);
		sensor.humidity = byteToFloat(temp);
		sensor.humidity = swap(sensor.humidity);
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
	
	
}
