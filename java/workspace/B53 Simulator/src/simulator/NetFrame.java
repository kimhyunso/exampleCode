package simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

class NetFrame extends JFrame implements ActionListener, StatusRole{

	private final int firstPort=11111;
	
	private JPanel headPanel;
	private JPanel optionPanel;
	private JPanel option1Panel;
	private JRadioButton server;
	private JRadioButton client;
	private JCheckBox echo;
	private JCheckBox rcv;
	private JLabel port;
	
	private JPanel addressPanel;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextField debugInput;
	
	private JPanel option2Panel;
	private JRadioButton tcp;
	private JRadioButton udp;
	
	private JPanel startStopPanel;
	private JButton start;
	private JButton stop;
	
	private JPanel bodyPanel;
	private JScrollPane tableScroll;
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> topColumn;
	private JButton[] btn=new JButton[7];
	private JTextArea display;
	
	private JPanel tailPanel;
	private JSpinner sleepSpinner;
	private JSpinner countSpinner;
	private JButton send;
	private JCheckBox random;
	
	private int role = NOROLE;
	private UDPServer udpServer;
	private UDPClient udpClient;
	
	private TCPServer tcpServer;
	private TCPClient tcpClient;
	
	private FileChooser fileChooser;
	private FileRandom fileRandom;
	
	public NetFrame() {
		initFrame();
		makeHeadPanel();
		makeBodyPanel();
		makeTailPanel();
		
		setVisible(true);
	}
	
	public void makeBodyPanel() {
		tablePanel();
		buttonPanel();
		textAreaPanel();
	}
	
	public void tablePanel() {
		bodyPanel=new JPanel();
		bodyPanel.setLayout(new BorderLayout());
		
		topColumn=new Vector<String>();
		topColumn.addElement("No");
		topColumn.addElement("Up/Down");
		topColumn.addElement("IP");
		topColumn.addElement("Port");
		topColumn.addElement("Msg");
		
		tableModel=new DefaultTableModel(topColumn,0);
		table=new JTable(tableModel);
		tableScroll =new JScrollPane(table);
		
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(550,400));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(3);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int column=table.getSelectedColumn();
				
				display.setText(table.getValueAt(row, column).toString());
			}
		});
		
		bodyPanel.add(tableScroll,BorderLayout.CENTER);
		add(bodyPanel,BorderLayout.CENTER);
	}
	
	public void buttonPanel() {
		Border border=BorderFactory.createTitledBorder("Test Message");
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(btn.length,0));
		panel.setBorder(border);
		
		for(int i=0; i<btn.length; i++) {
			btn[i]=new JButton("Test Msg "+Integer.toString((i+1)));
			btn[i].addActionListener(this);
			panel.add(btn[i]);
		}
		btn[btn.length-2].setVisible(false);
		btn[btn.length-1].setText("Save File");
		
		bodyPanel.add(panel,BorderLayout.EAST);
	}
	
	public void textAreaPanel() {
		Border border=BorderFactory.createTitledBorder("User Defained Message");
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(border);
		display=new JTextArea(30,30);
		JScrollPane scroll = new JScrollPane(display);
		
		panel.add(scroll,BorderLayout.CENTER);
		
		bodyPanel.add(panel,BorderLayout.SOUTH);
	}
	
	public void makeTailPanel() {
		tailPanel=new JPanel();
		Border border=BorderFactory.createTitledBorder("Simulation Option");
		tailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tailPanel.setBorder(border);
		
		SpinnerModel sleepModel=new SpinnerNumberModel(543, 1 , 10000 ,1); 
		sleepSpinner=new JSpinner(sleepModel);
		SpinnerModel countModel=new SpinnerNumberModel(10, 1 , 10000 ,1); 
		countSpinner=new JSpinner(countModel);
		send=new JButton("Send");
		random=new JCheckBox("By Random");
		
		JLabel sleep=new JLabel("Sleep(msec)");
		JLabel count=new JLabel("Count");
		
		tailPanel.add(sleep);
		tailPanel.add(sleepSpinner);
		
		tailPanel.add(count);
		tailPanel.add(countSpinner);
		
		send.addActionListener(this);
		tailPanel.add(random);
		tailPanel.add(send);
		
		initEnabled();
		
		fileChooser = new FileChooser(this);
		fileRandom = new FileRandom();
		
		add(tailPanel,BorderLayout.SOUTH);
	}
	
	public void initEnabled() {
		start.setEnabled(true);
		stop.setEnabled(false);
		debugInput.setEnabled(false);
		send.setEnabled(false);
		display.setEnabled(false);
		sleepSpinner.setEnabled(false);
		countSpinner.setEnabled(false);
		random.setEnabled(false);
		
		server.setEnabled(true);
		echo.setEnabled(true);
		client.setEnabled(true);
		rcv.setEnabled(true);
		ipInput.setEnabled(true);
		portInput.setEnabled(true);
		
		portInput.setText(Integer.toString(firstPort));
		tcp.setEnabled(true);
		udp.setEnabled(true);
		display.setText("");
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
		
		start.addActionListener(this);
		stop.addActionListener(this);
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
		JLabel ip=new JLabel("IP");
		port=new JLabel("Port");
		JLabel debug=new JLabel("Debug");
		ipInput=new JTextField(15);
		portInput=new JTextField(10);
		debugInput=new JTextField(20);
		addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addressPanel.add(ip);
		addressPanel.add(ipInput);
		addressPanel.add(port);
		addressPanel.add(portInput);
		addressPanel.add(debug);
		addressPanel.add(debugInput);
		
		ipInput.setText("127.0.0.1");
		debugInput.setText("Debug....");
		
		debugInput.setEnabled(false);
		
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
		
		udp.setSelected(true);
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
		server.setSelected(true);
		
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
	
	public void determinRole()
	{
		// 버튼들을 검사하고...
		if(server.isSelected()) {
			enabled(false);
		}else if(client.isSelected()) {
			enabled(true);
		}
		
		if(client.isSelected() && tcp.isSelected()) {
			role = TCPCLIENT;
		}else if(client.isSelected() && udp.isSelected()) {
			role = UDPCLIENT;
		}else if(server.isSelected() && tcp.isSelected()) {
			role = TCPSERVER;
		}else if(server.isSelected() && udp.isSelected()) {
			role = UDPSERVER;
		}
		
	}
	
	public void startUDPServer()
	{
		//System.out.println("start UDP Server");
		this.debugInput.setText("start UDP Server");
		udpServer=new UDPServer(this);
	}
	
	public void startUDPClient()
	{
		//System.out.println("start UDP Client");
		this.debugInput.setText("start UDP Client");
		udpClient = new UDPClient(this,fileRandom);
	}
	
	
	public void printRole()
	{
		if(role == TCPSERVER)
			this.debugInput.setText("ROLE : TCP SERVER");
		else if(role == TCPCLIENT)
			this.debugInput.setText("ROLE : TCP CLIENT");
		else if(role == UDPSERVER)
			this.debugInput.setText("ROLE : UDP SERVER");
		else if(role == UDPCLIENT)
			this.debugInput.setText("ROLE : UDP CLIENT");
		else if(role == NOROLE)
			this.debugInput.setText("ROLE : NO ROLE");
		else
			this.debugInput.setText("ROLE : UNKNOWN ROLE");
	}
	
	public void startTCPServer() {
		tcpServer = new TCPServer(this);
	}
	
	public void startTCPClient() {
		tcpClient = new TCPClient(this,fileRandom);
	}
	
	public void start()
	{
		// 내 역할 결정
		determinRole();
		
		if(role == UDPSERVER)
			startUDPServer();
		else if(role == UDPCLIENT)
			startUDPClient();
		else if(role == TCPSERVER)
			startTCPServer();
		else if(role == TCPCLIENT)
			startTCPClient();
		
		printRole();
	}
	
	public void stop()
	{
		role = NOROLE;
		
		if(udpServer != null) {
			if(udpServer.getSocket() != null) {
				udpServer.getSocket().close();
				udpServer = null;
			}
		}
		
		if(udpClient != null) {
			if(udpClient.getSocket() != null) {
				udpClient.getSocket().close();
				udpClient = null;
			}
		}
		
		if(tcpServer != null) {
			try {
				if(tcpServer.getServerSocket()!=null) tcpServer.getServerSocket().close();
				if(tcpServer.getClientSocket()!=null) tcpServer.getClientSocket().close();
				tcpServer = null;
			} catch (IOException e) {}
		}
		
		if(tcpClient != null) {
			try {
				if(tcpClient.getSocket() != null) tcpClient.getSocket().close();
				tcpClient = null;
			}catch(Exception e) {}
		}
		
		printRole();
	}
	
	public void enabled(boolean enable) {
		start.setEnabled(false);
		stop.setEnabled(true);
		
		debugInput.setEnabled(false);
		sleepSpinner.setEnabled(enable);
		countSpinner.setEnabled(enable);
		send.setEnabled(enable);
		random.setEnabled(enable);
		display.setEnabled(enable);
		
		ipInput.setEnabled(enable);
		portInput.setEnabled(enable);
		
		server.setEnabled(false);
		client.setEnabled(false);
		echo.setEnabled(false);
		rcv.setEnabled(false);
		
		tcp.setEnabled(false);
		udp.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(random.isSelected() && e.getSource() == send ) {
			display.setText(fileRandom.checkedRandom((int)(Math.random()*7) + 1).toString());
		}
		
		String line = display.getText();
		
		if(e.getSource()==start) {
			start();
		}
		
		if(e.getSource()==stop) {
			initEnabled();
			stop();
		}
				
		if(e.getSource()==send) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(udpClient != null) udpClient.send(line.getBytes());
					else if(tcpClient != null) tcpClient.send(line);
				}
			};
			thread.start();			
		}
		
		
		if(e.getSource()==btn[0]) {
			fileChooser.open();
		}
		
		if(e.getSource()==btn[btn.length-1]) {
			fileChooser.save();
		}
		
		if(e.getSource() == btn[btn.length-3]) {
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
		}
	}
	
	
	public JScrollPane getTableScroll() {
		return tableScroll;
	}


	public void setTableScroll(JScrollPane tableScroll) {
		this.tableScroll = tableScroll;
	}

	public JLabel getPort() {
		return port;
	}


	public void setPort(JLabel port) {
		this.port = port;
	}


	public JCheckBox getRandom() {
		return random;
	}

	public void setRandom(JCheckBox random) {
		this.random = random;
	}

	public JCheckBox getRcv() {
		return rcv;
	}

	public void setRcv(JCheckBox rcv) {
		this.rcv = rcv;
	}

	public JSpinner getSleepSpinner() {
		return sleepSpinner;
	}

	public void setSleepSpinner(JSpinner sleepSpinner) {
		this.sleepSpinner = sleepSpinner;
	}

	public JSpinner getCountSpinner() {
		return countSpinner;
	}

	public void setCountSpinner(JSpinner countSpinner) {
		this.countSpinner = countSpinner;
	}

	public JTextArea getDisplay() {
		return display;
	}

	public void setDisplay(JTextArea display) {
		this.display = display;
	}

	public JTextField getIpInput() {
		return ipInput;
	}

	public void setIpInput(JTextField ipInput) {
		this.ipInput = ipInput;
	}

	public JTextField getPortInput() {
		return portInput;
	}

	public void setPortInput(JTextField portInput) {
		this.portInput = portInput;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JCheckBox getEcho() {
		return echo;
	}

	public void setEcho(JCheckBox echo) {
		this.echo = echo;
	}

}

