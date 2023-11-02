package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

class MyFrame extends JFrame implements ActionListener{
	private JPanel displayPanel;
	private JTextField input;
	private JButton okBtn;
	private JLabel result;
	private JRadioButton small , midium , large;
	private JCheckBox reading,ridding,sleeping,fishing;
	
	public MyFrame(){
		initFrame();
		createPanel();
		
		textControl();
		radioControl();
		checkControl();
		
		JButton imgBtn = new JButton(new ImageIcon("images/google.png"));
		displayPanel.add(imgBtn);
		
		
		setVisible(true);
	}
	
	public void checkControl() {
		JPanel panel=new JPanel();
		Border border=BorderFactory.createTitledBorder("취미 선택(중복)");
		panel.setBorder(border);
		reading=new JCheckBox("독서");
		ridding=new JCheckBox("타기");
		sleeping=new JCheckBox("잠자기");
		fishing=new JCheckBox("낚시");
		
		/*ButtonGroup size=new ButtonGroup();
		size.add(reading);
		size.add(ridding);
		size.add(sleeping);
		size.add(fishing);*/
		
		sleeping.setSelected(true);
		
		panel.add(reading);
		panel.add(ridding);
		panel.add(sleeping);
		panel.add(fishing);
		
		displayPanel.add(panel);
		
	}
	
	public void radioControl() {
		small=new JRadioButton("Small Size");
		midium=new JRadioButton("Midium Size");
		large=new JRadioButton("Large Size");
		JPanel sizePanel=new JPanel();
		Border border=BorderFactory.createTitledBorder("사이즈 선택");
		sizePanel.setBorder(border);
		//displayPanel.add(new JLabel("어떤 크기의 제품을 선택하시겠습니까 ? "));
		ButtonGroup size=new ButtonGroup();
		size.add(small);
		size.add(midium);
		size.add(large);
		
		sizePanel.add(small);
		sizePanel.add(midium);
		sizePanel.add(large);
		midium.setSelected(true);
		
		displayPanel.add(sizePanel);
		
	}
	
	public void textControl() {
		input = new JTextField(10);
		displayPanel.add(new JLabel("제곱 구할 값"));
		displayPanel.add(input);
		okBtn=new JButton("OK");
		okBtn.addActionListener(this);
		displayPanel.add(okBtn);
		result=new JLabel("");
		displayPanel.add(result);
	}
	
	public void createPanel() {
		displayPanel=new JPanel();
		displayPanel.setLayout(new FlowLayout());
		add(displayPanel);
	}
	
	public void initFrame() {
		setTitle("GUI");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okBtn) {
			int value = Integer.parseInt(input.getText());
			value*=value;
			result.setText(Integer.toString(value));
			
			if(large.isSelected()) {
				System.out.println("Large 선택");
			}else if(midium.isSelected()) {
				System.out.println("Midium");
			}else {
				System.out.println("small");
			}
			
			if(reading.isSelected()) {
				System.out.println("독서 선택");
			}else {
				System.out.println("독서 X");
			}
			
		}
		
	}
	
}


public class Test {
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
