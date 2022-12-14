package application;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class UDPChatting {
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress address;
	private int yourPort;
	
	private ObservableList<XYChart.Data<String, Float>> lists1 = FXCollections.observableArrayList();
	private ObservableList<XYChart.Data<String, Float>> lists2 = FXCollections.observableArrayList();
	private ObservableList<XYChart.Data<String, Float>> lists3 = FXCollections.observableArrayList();
	private ObservableList<XYChart.Data<String, Float>> lists4 = FXCollections.observableArrayList();
	
	class Sensor {
		int id;
		int seq;
		float temperature;
		float humidity;
	}
	
	private DataBase db;
	private Sensor sensor;
	
	
	public UDPChatting(int myPort,int yourPort,String address,DataBase db) {
		try {
			this.yourPort = yourPort;
			this.db = db;
			
			sensor = new Sensor();
			socket = new DatagramSocket(myPort);
			
			this.address = InetAddress.getByName(address);
		}catch(IOException e) {
			System.out.println("UDPServer socket Error"+e.getMessage());
		}
	}
	
	public void send(String text) {
		try {
			byte sendBuffer[] = text.getBytes(); 
			packet = new DatagramPacket(sendBuffer,sendBuffer.length,address,yourPort);
			socket.send(packet);
		}catch(Exception e) {
			System.out.println("send Error "+e.getMessage());
		}
	}
	
	public void receive(TextArea text) {
		while(true) {
			try {
				byte receiveBuffer[] = new byte[1024];
				packet = new DatagramPacket(receiveBuffer,receiveBuffer.length);
				socket.receive(packet);
				//String line = new String(receiveBuffer);
				
				text.appendText(new String(receiveBuffer)+"\n");
			}catch(Exception e) {
				break;
			}
		}
	}
	
	public void insertDB(String sql) {
		try {
			db.getStmt().executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("insert db error");
		}
	}
	
	public void selectDB(String sql,int id) {
		ResultSet rs = null;
		
		try {
			rs = db.getStmt().executeQuery(sql);
			
			if(rs.next()) {
				switch(id) {
				case 1:
					lists1.add(new XYChart.Data<String, Float>(String.valueOf(id),  rs.getFloat("temperature")));
					break;
				case 2:
					lists2.add(new XYChart.Data<String, Float>(String.valueOf(id),  rs.getFloat("temperature")));
					break;
				case 3:
					lists3.add(new XYChart.Data<String, Float>(String.valueOf(id),  rs.getFloat("temperature")));
					break;
				case 4:
					lists4.add(new XYChart.Data<String, Float>(String.valueOf(id),  rs.getFloat("temperature")));
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.println("select db error");
		}
		
	}
	
	public void testReceive(TableView<UserData> tableView) {		
		while(true) {
			try {
				byte receiveBuffer[] = new byte[1024];
				packet = new DatagramPacket(receiveBuffer,receiveBuffer.length);
				socket.receive(packet);
				converterByte(receiveBuffer);
				Platform.runLater(()->{
					int next = tableView.getItems().size() + 1;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					tableView.getItems().add(new UserData(next , sensor.id, sensor.seq, sensor.temperature, sensor.humidity, sdf.format(new Date())));
					String sql = String.format("insert into sensor_table ( id, seq, temperature, humidity, time ) value ( %d, %d, %.1f, %.1f, now() )", sensor.id,sensor.seq,sensor.temperature,sensor.humidity);
					insertDB(sql);
					for(int i=1; i<=4; i++) {
						sql = "select *from sensor_table where id = '"+i+"' order by idx desc limit 1";
						selectDB(sql, i);
					}
					
				});
				
			}catch(Exception e) {
				System.out.println("receive error "+e.getMessage());
				try {
					db.getConn().close();
				}catch(Exception e1) {}
				break;
			}
		}
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
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

	public DatagramSocket getSocket() {
		return socket;
	}

	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}

}
