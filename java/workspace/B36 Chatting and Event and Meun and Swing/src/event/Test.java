package event;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener, MouseListener, KeyListener{
	
	private JPanel colorPanel;
	private JButton redBtn;
	private JButton yellowBtn;
	private JButton greenBtn;
	private JButton randomBtn;
	private JTextArea display;
	private JTextField input;
	
	public MyFrame() {
		super("ColorPanelTest");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorPanel=new JPanel();
		colorPanel.setLayout(new FlowLayout());
		
		redBtn=new JButton("RED");
		yellowBtn=new JButton("YELLOW");
		greenBtn=new JButton("GREEN");
		randomBtn=new JButton("RANDOM");
	
		//이벤트 등록
		redBtn.addActionListener(this);
		yellowBtn.addActionListener(this);
		greenBtn.addActionListener(this);
		randomBtn.addActionListener(this);
		
		colorPanel.add(redBtn);
		colorPanel.add(yellowBtn);
		colorPanel.add(greenBtn);
		colorPanel.add(randomBtn);
		
		display=new JTextArea(10,30);
		input=new JTextField(30);
		JScrollPane scroll=new JScrollPane(display);
		
		
		
		input.addKeyListener(this);
		colorPanel.add(scroll);
		colorPanel.add(input);
		
		colorPanel.addMouseListener(this);
		
		add(colorPanel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==redBtn) {
			System.out.println("빨강버튼 클릭되었습니다.");
			colorPanel.setBackground(Color.RED);
			redBtn.setText("빨강");
			
		}else if(e.getSource()==yellowBtn){
			System.out.println("노랑버튼 클릭되었습니다.");
			colorPanel.setBackground(Color.YELLOW);
		}else if(e.getSource()==greenBtn) {
			System.out.println("녹색버튼 클릭되었습니다.");
			colorPanel.setBackground(Color.GREEN);
		}else{
			int r , g , b;
			
			r = (int)(Math.random()*256);
			g = (int)(Math.random()*256);
			b = (int)(Math.random()*256); 
			
			Color color = new Color(r, g , b);
			colorPanel.setBackground(color);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		String info = "mouseClicked : "+x+","+y+"# "+count;
		display.append(info+"\n");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		String info = "mousePressed : "+x+","+y+"# "+count;
		display.append(info+"\n");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		String info = "mouseReleased : "+x+","+y+"# "+count;
		display.append(info+"\n");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		String info = "mouseEntered : "+x+","+y+"# "+count;
		display.append(info+"\n");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		String info = "mouseExited : "+x+","+y+"# "+count;
		display.append(info+"\n");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// A (ctrl,Shift,Alt) = (true , false,false)
		char c = e.getKeyChar();
		String info="(Ctrl,Shift,Alt)=( "+e.isControlDown()+","+e.isShiftDown()+","+e.isAltDown()+" )";
		info = "Typed : "+c+info;
		display.append(info+"\n");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		String info="(Ctrl,Shift,Alt)=( "+e.isControlDown()+","+e.isShiftDown()+","+e.isAltDown()+" )";
		info = "Pressed : "+c+info;
		display.append(info+"\n");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		String info="(Ctrl,Shift,Alt)=( "+e.isControlDown()+","+e.isShiftDown()+","+e.isAltDown()+" )";
		info = "Released : "+c+info;
		display.append(info+"\n");
		
	}
	
}

public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
