package sensortable;

import java.awt.Rectangle;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class UDPServer {
	
	private DatagramSocket socket;
	private DatagramPacket packet;
	private SensorFrame frame;
	private DataBase db;
	private int port = 10001;
	
	private class Sensor{
		int id;
		int seq;
		int gas;
		float temperature;
		float humidity;
	}
	
	private Sensor sensor;
	
	public UDPServer(SensorFrame frame,DataBase db) {
		this.frame = frame;
		this.db = db;
		
		try {
			socket = new DatagramSocket(port);
		}catch(Exception e) {
			System.out.println("socket Error : "+e.getMessage());
		}
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				receive();
			}
			
		});
		thread.start();
		
	}
	
	public void receive() {
		sensor = new Sensor();
		
		try {
			while(true) {
				
				byte []receiveBuffer = new byte[1024];
				packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
				socket.receive(packet);
				
				converterByte(receiveBuffer);
				String sql = String.format("insert into sensor_table (id, seq, gas, temperature, humidity, time) values (%d, %d, %d, %.1f, %.1f, now())", sensor.id, sensor.seq, sensor.gas, sensor.temperature, sensor.humidity);
				
				db.getStmt().executeUpdate(sql);
					
				sql = "select * from sensor_table order by idx desc limit 1";
				ResultSet rs = db.getStmt().executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt("id");
					int seq = rs.getInt("seq");
					int gas = rs.getInt("gas");
					float temp = rs.getFloat("temperature");
					float hum = rs.getFloat("humidity");
					Timestamp time = rs.getTimestamp("time");
					
					int next = frame.getTable().getRowCount() + 1;
					Object data[] = {next , id ,seq, gas, temp ,hum ,time};
					frame.getTableModel().addRow(data);
				}
					
				int bottomRow = frame.getTable().getRowCount()-1;
				Rectangle rect = frame.getTable().getCellRect(bottomRow,0,true);
				frame.getTableScroll().getViewport().setViewPosition(rect.getLocation());
			}
			
		}catch(Exception e) {
			
			System.out.println("receive Error : "+e.getMessage());
			
			try {
				db.getStmt().close();
				db.getConn().close();
			}catch(Exception e1) {}
		}
		
	}
	
	public void converterByte(byte[] buffer) {
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
		
		System.arraycopy(buffer, 16, temp, 0, 4);
		sensor.gas = byteToInt(temp);
		sensor.gas = swap(sensor.gas);
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

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	

}
