package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

class NetFrame extends JFrame {
	
	private JPanel headPanel;
	private JPanel optionPanel;
	private JPanel option1Panel;
	private JRadioButton server;
	private JRadioButton client;
	private JCheckBox echo;
	private JCheckBox rcv;
	
	private JPanel option2Panel;
	private JRadioButton tcp;
	private JRadioButton udp;
	
	private JPanel startStopPanel;
	private JButton start;
	private JButton stop;
	
	private JPanel bodyPanel;
	private JPanel tailPanel;
	
	
	public NetFrame() {
		initFrame();
		createOutterPanel();
		makeHeadPanel();
		
		setVisible(true);
	}
	
	public void makeHeadPanel() {
		optionPanel=new JPanel();
		optionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		headPanel.add(optionPanel,BorderLayout.CENTER);
		
		Border border1=BorderFactory.createTitledBorder("Option1");
		option1Panel=new JPanel();
		option1Panel.setBorder(border1);
		server=new JRadioButton("Server");
		client=new JRadioButton("Client");
		echo=new JCheckBox("Echo");
		rcv=new JCheckBox("Rcv");
		
		ButtonGroup serverClient=new ButtonGroup();
		serverClient.add(server);
		serverClient.add(client);
		
		option1Panel.add(server);
		option1Panel.add(echo);
		
		option1Panel.add(client);
		option1Panel.add(rcv);
		
		Border border2=BorderFactory.createTitledBorder("Option2");
		option2Panel=new JPanel();
		option2Panel.setBorder(border2);
		
		tcp=new JRadioButton("TCP");
		udp=new JRadioButton("UDP");
		
		ButtonGroup protocol=new ButtonGroup();
		protocol.add(tcp);
		protocol.add(udp);
		
		option2Panel.add(tcp);
		option2Panel.add(udp);
		
		
		optionPanel.add(option1Panel);
		optionPanel.add(option2Panel);
		
		Border border3=BorderFactory.createTitledBorder("Start/Stop");
		start=new JButton("Start");
		stop=new JButton("Stop");
		
		startStopPanel=new JPanel();
		startStopPanel.setBorder(border3);
		startStopPanel.setLayout(new FlowLayout());
		startStopPanel.add(start);
		startStopPanel.add(stop);
		
		headPanel.add(startStopPanel,BorderLayout.EAST);
		
	}
	
	public void createOutterPanel() {
		headPanel=new JPanel();
		headPanel.setLayout(new BorderLayout());
		headPanel.setBackground(Color.RED);
		add(headPanel,BorderLayout.NORTH);
		
		bodyPanel=new JPanel();
		bodyPanel.setBackground(Color.GREEN);
		add(bodyPanel,BorderLayout.CENTER);
		
		tailPanel=new JPanel();
		tailPanel.setBackground(Color.YELLOW);
		add(tailPanel,BorderLayout.SOUTH);
		
	}
	
	public void initFrame() {
		setTitle("Network Simulator");
		setSize(700,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	
}


public class Test {
	public static void main(String[] args) {
		NetFrame frame=new NetFrame();
	}
}
