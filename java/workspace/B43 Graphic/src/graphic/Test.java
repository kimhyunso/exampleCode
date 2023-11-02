package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyComponent extends JComponent{
	
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		Font font=new Font("Ravie",Font.BOLD,30);
		g.setFont(font);
		/*
		g.drawString("Hellow Graphic",100,200);
		g.drawRect(50, 100, 300, 100);
		g.fillRect(100, 100, 100, 100);
		
		g.setColor(Color.BLUE);
		g.drawLine(0, 400, 500, 0);
		
		g.drawOval(100,100,200,200);
		g.setColor(new Color(0x0,0x0,0xFF,0xAA));
		
		g.fillOval(100, 100, 200, 200);
		
		g.setColor(new Color(0,255,0));
		g.drawArc(200, 200, 300, 300, 0, 150);
		
		g.fillArc(200,200,300,300,0,130);
		
		g.fillRoundRect(200, 100, 200, 100, 50	, 30);
		*/
		/*g.fillOval(90,30,300,300);
		
		g.setColor(Color.RED);
		
		g.drawArc(120, 90, 90, 90, 0, 360/2);
		
		g.drawArc(270, 90, 90, 90, 0, 360/2);
		
		g.drawArc(130, 100, 200, 200, 0, -360/2);
		*/
		
		/*g.setColor(Color.BLACK);
		
		g.drawLine(0, 400, 500, 0);
		g.drawLine(500, 430, 0, 0);
		
		g.drawLine(0, 430, 500, 0);
		g.drawLine(500, 430, 0, 0);
		
		g.drawLine(0, 460, 500, 0);
		g.drawLine(500, 460, 0, 0);
		
		g.drawLine(0, 490, 500, 0);
		g.drawLine(500, 490, 0, 0);
		
		g.drawLine(0, 520, 500, 0);
		g.drawLine(500, 520, 0, 0);*/
		
		
		/*int y1=50;
		int y2=450;
		int x1,x2;
		int step = 50;
		for(x1=50; x1<500; x1+=step) {
			for(x2=450; x2>0; x2-=step) {
				g.drawLine(x1,y1,x2,y2);
				g.drawLine(y1,x1,y2,x2);
			}
		}*/
		
	}
	
}


class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Java Graphics");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new MyComponent());
		
		setVisible(true);
	}
	
}


public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
