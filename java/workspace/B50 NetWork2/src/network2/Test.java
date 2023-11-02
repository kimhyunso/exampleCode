package network2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class NetFrame extends JFrame {
	
	private JPanel headPanel;
	private JPanel optionPanel;
	private JPanel option1Panel;
	private JRadioButton server;
	private JRadioButton client;
	private JCheckBox echo;
	private JCheckBox rcv;
	
	private JPanel addressPanel;
	private JLabel ip;
	private JTextField ipInput;
	private JLabel port;
	private JTextField portInput;
	
	private JPanel option2Panel;
	private JRadioButton tcp;
	private JRadioButton udp;
	
	private JPanel startStopPanel;
	private JButton start;
	private JButton stop;
	
	private JPanel bodyPanel;
	private JPanel subBodyPanel;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> topColumn;
	
	private JPanel tailPanel;
	
	public NetFrame() {
		initFrame();
		makeHeadPanel();
		makeBodyPanel();
		makeTailPanel();
		
		setVisible(true);
	}
	
	
	
	
	public void makeBodyPanel() {
		initBodyPanel();
		
	}
	
	public void TablePanel() {
		
		topColumn=new Vector<String>();
		topColumn.addElement("No");
		topColumn.addElement("Up/Down");
		topColumn.addElement("IP");
		topColumn.addElement("Msg");
		tableModel=new DefaultTableModel(topColumn,0);
		
		
		
	}
	
	public void initBodyPanel() {
		subBodyPanel=new JPanel();
		subBodyPanel.setLayout(new BorderLayout());
		
		bodyPanel=new JPanel();
		bodyPanel.setBackground(Color.GREEN);
		
	}
	
	
	public void makeTailPanel() {
		tailPanel=new JPanel();
		tailPanel.setBackground(Color.YELLOW);
		add(tailPanel,BorderLayout.SOUTH);
	}
	
	
	public void makeHeadPanel() {
		initPanel();
		makeStartandStopPanel();
		makeOption1Panel();
		makeOption2Panel();
		makeAddressOptionPanel();
		
	}
	
	public void makeStartandStopPanel() {
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
	
	public void initPanel() {
		headPanel=new JPanel();
		headPanel.setLayout(new BorderLayout());
		headPanel.setBackground(Color.RED);
		add(headPanel,BorderLayout.NORTH);
		
		optionPanel=new JPanel();
		optionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}
	
	
	public void makeAddressOptionPanel() {
		addressPanel=new JPanel();
		ip=new JLabel("IP");
		port=new JLabel("Port");
		ipInput=new JTextField(20);
		portInput=new JTextField(10);
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addressPanel.add(ip);
		addressPanel.add(ipInput);
		addressPanel.add(port);
		addressPanel.add(portInput);
		
		ipInput.setText("IP");
		portInput.setText("Port");
		
		ipInput.setEditable(false);
		portInput.setEditable(false);
		
		headPanel.add(addressPanel,BorderLayout.SOUTH);
	}
	
	
	public void makeOption2Panel() {
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
		
		optionPanel.add(option2Panel);
		
		headPanel.add(optionPanel,BorderLayout.CENTER);
	}
	
	
	public void makeOption1Panel() {
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
		
		optionPanel.add(option1Panel);
		
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
