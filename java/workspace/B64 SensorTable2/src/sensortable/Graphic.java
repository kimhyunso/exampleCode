package sensortable;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.swing.JComponent;

public class Graphic extends JComponent{
	
	private int width;
	private int height;
	private int interval;
	
	private SensorFrame frame;
	
	private float temp1;
	private float temp2;
	private float temp3;
	private float temp4;
	
	private int gas[];
	private float tempArray[];
	private float humArray[];
	private Timestamp timeArray[];
	
	
	private boolean isDeadArray[];
	
	int xa = 0;
	int ya = 0;
	int xb = 400;
	int yb = 0;
	int xc = 0;
	int yc = 400;
	
	int xd = 400;
	int yd = 400;

	int lena = 0;
	int lenb = 0;
	int lenc = 0;
	int lend = 0;
	
	private Color [] color;
	private DataBase db;
	private ResultSet rs;
	
	
	public Graphic(SensorFrame frame,DataBase db,int width,int height,int interval) {

		this.frame = frame;
		this.db = db;
		this.width = width;
		this.height = height;
		this.interval = interval;
		
		tempArray = new float[4];
		humArray = new float[4];
		gas = new int[4];
		isDeadArray = new boolean[4];
		timeArray = new Timestamp[4];
		
		getData();
		
		color = new Color [31];
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(5000);
						getData();
						repaint();
					}catch(Exception e) {
						break;
					}
				}
			}
		});
		thread.start();
		
	}
	
	public void getData() {
		
		try {
				
			for(int i=1; i<=4; i++) {
				
				String sql = "select *from sensor_table where id = '"+ i +"' and time > date_sub(NOW(), INTERVAL 10 SECOND)  order by idx desc limit 1";
				rs = db.getStmt().executeQuery(sql);
				
				if(rs.next())
				{
					gas[i-1] = rs.getInt("gas");
					tempArray[i-1] = rs.getFloat("temperature");
					humArray[i-1] = rs.getFloat("humidity");
					timeArray[i-1] = rs.getTimestamp("time");
					isDeadArray[i-1] = false;
					
				}else
				{
					tempArray[i-1] = 0;
					isDeadArray[i-1] = true;
				}
			}
			
		}catch(Exception e) {
			
		}
	}
	
	
	public void changeSetting(int width,int height,int interval) {
		this.width = width;
		this.height = height;
		this.interval = interval;
	}
	
	public void setTemperature(float[] tempArray) {
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		getData();
		g.setColor(new Color(0xFF, 0x0,0x0));
		int gap = 0;
		int first = 200;
		
		for(int i=1; i<isDeadArray.length+1; i++) {
			g.drawString(String.valueOf(i), first+gap, 30);
			gap+=50;
		}
		
		first = 210;
		gap = 0;
		for(int i=0; i<isDeadArray.length; i++) {
			if(isDeadArray[i]) {
				g.setColor(new Color(0xFF, 0x0,0x0));
			}else {
				g.setColor(new Color(0x29, 0xFF,0x22));
			}
			
			g.fillRect(first+gap, 10, 30, 30);
			gap+=50;
		}
		
		g.setColor(new Color(0x0, 0x84,0xFF));
		
		
		for(int i=1; i<width; i = i+interval)
		{
			for(int j=1; j<height; j = j+interval)
			{
				double lena =(Math.sqrt( (i - xa)* (i-xa) + (j -ya) * (j-ya)));
				double lenb =(Math.sqrt( (i - xb)* (i-xb) + (j -yb) * (j-yb)));
				double lenc = (Math.sqrt( (i - xc)* (i-xc) + (j -yc) * (j-yc)));
				double lend = (Math.sqrt( (i - xd)* (i-xd) + (j -yd) * (j-yd)));

	
				int lenTotal = (int)(lena + lenb + lenc + lend);
				//alert('lenTotal = ' + lenTotal);
				
				lena = lenTotal / lena;
				lenb = lenTotal / lenb;
				lenc = lenTotal / lenc;
				lend = lenTotal / lend;

				//alert('lena = ' + lena);
				//alert('lenb = ' + lenb);
				double a1 =  ((double) lena / (double)(lena + lenb + lenc + lend)) * (int)tempArray[0];
				double a2 =  ((double)lenb / (double)(lena + lenb + lenc + lend)) * (int)tempArray[1];
				double a3 =  ((double)lenc / (double)(lena + lenb + lenc + lend)) * (int)tempArray[2];
				double a4 =  ((double)lend / (double)(lena + lenb + lenc + lend)) * (int)tempArray[3];
				
				int expected = (int)(a1 + a2 + a3 + a4);
				int testInt = (int)Math.floor(expected);
				
				if(i == 2 && j == 2)
				{
					System.out.println("value = " + ((i - xa)* (i-xa) + (j -ya) * (j-ya)));
					
					System.out.println("lenTotal = " + lenTotal);
					System.out.println("lena = " + lena);
					System.out.println("lenb = " + lenb);
					System.out.println("a1 = " + a1 + ", a2 = " + a2);
					System.out.println("expected = " + expected);
					System.out.println("Test int at 300, 300 = " + testInt);
					//alert('test Int = ' +testInt);
					
				}	
				if(testInt > 30) {
					testInt = 30;
				}
				
				switch(testInt)
				{
					case 10:
						color[10] = new Color(0,0,255);
						break;
					case 11:
						color[11] = new Color(18,18,255);
						break;
					case 12:
						color[12] = new Color(36,36,255);
						break;
					case 13:
						color[13] = new Color(54,54,255);
						break;
					case 14:
						color[14] = new Color(72,72,255);
						break;
					case 15:
						color[15] = new Color(90,90,255);
						break;
					case 16:
						color[16] = new Color(108,108,255);
						break;
					case 17:
						color[17] = new Color(126,126,255);
						break;
					case 18:
						color[18] = new Color(144,144,255);
						break;
					case 19:
						color[19] = new Color(162,162,255);
						break;
					case 20:
						color[20] = new Color(255,255,255);
						break;
					case 21:
						color[21] = new Color(255,162,162);
						break;
					case 22:
						color[22] = new Color(255,144,144);
						break;
					case 23:
						color[23] = new Color(255,126,126);
						break;
					case 24:
						color[24] = new Color(255,108,108);
						break;
					case 25:
						color[25] = new Color(255,90,90);
						break;
					case 26:
						color[26] = new Color(255,72,72);
						break;
					case 27:
						color[27] = new Color(255,54,54);
						break;
					case 28:
						color[28] = new Color(255,36,36);
						break;
					case 29:
						color[29] = new Color(255,18,18);
						break;
					case 30:
						color[30] = new Color(255,0,0);
						break;
					default:
						break;
				}
				
				g.setColor(color[testInt]);
				g.fillRect( (int)((600 - width)/2) + i,  (int)((500 - height)/2) + j, interval, interval);
			}
		}
		
		//g.fillRect(100, 100, frame.getWidth(), frame.getHeight());
		super.paint(g);
	}
	
	

}
