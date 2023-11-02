package sensortable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

class SensorFrame extends JFrame implements ActionListener{
	
	private JTabbedPane tab;
	
	private JPanel tablePanel;
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> userData;
	private JScrollPane tableScroll;
	
	private JTextField widthInput;
	private JTextField heightInput;
	private JSpinner intervalSpinner;
	private JPanel settingPanel;
	private JButton okBtn;
	
	private Graphic graphic;
	private DataBase db;
	private UDPServer udpServer;
	
	private int width=400;
	private int height=400;
	private int interval=1;
	
	public SensorFrame() {
		connectDB();
		createUDPServer();
		init();
		createJTabbedPane();
		setVisible(true);
	}
	
	public void createUDPServer() {
		udpServer = new UDPServer(this,db);
	}
	
	public void connectDB() {
		db = new  DataBase();
	}
	
	public void init() {
		setTitle("Sensor Table");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createJTabbedPane() {
		tab = new JTabbedPane();
		graphic = new Graphic(this,db,width,height,interval);
		tab.add("실시간",createJTable());
		tab.add("그래픽온도",graphic);
		tab.add("환경설정",createSetting());
		add(tab);
	}
	
	public JPanel createSetting() {
		settingPanel = new JPanel();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,0));
		
		JPanel widthPanel = new JPanel();
		JPanel heightPanel = new JPanel();
		
		JPanel bottomPanel = new JPanel();
		okBtn = new JButton("OK");
		okBtn.addActionListener(this);
		widthInput = new JTextField(20);
		heightInput = new JTextField(20);
		SpinnerModel intervalSpinnerModel = new SpinnerNumberModel(interval, 1 , 100 ,1);
		intervalSpinner = new JSpinner(intervalSpinnerModel);
		
		widthInput.setText(Integer.toString(width));
		heightInput.setText(Integer.toString(height));
		
		bottomPanel.add(new JLabel("간격"));
		bottomPanel.add(intervalSpinner);
		bottomPanel.add(okBtn);
		
		widthPanel.add(new JLabel("가로"));
		widthPanel.add(widthInput);
		
		heightPanel.add(new JLabel("세로"));
		heightPanel.add(heightInput);
		
		mainPanel.add(widthPanel);
		mainPanel.add(heightPanel);
		mainPanel.add(bottomPanel);
		
		settingPanel.add(mainPanel);
		
		return settingPanel;
	}
	
	public JScrollPane createJTable() {
		tablePanel = new JPanel();
		userData = new Vector<String>();
		userData.addElement("No");
		userData.addElement("ID");
		userData.addElement("Seq");
		userData.addElement("Gas");
		userData.addElement("Temp");
		userData.addElement("Hum");
		userData.addElement("Time");
		
		tableModel = new DefaultTableModel(userData,0);
		table = new JTable(tableModel);
		
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(300,500));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		tableScroll = new JScrollPane(table);
		
		return tableScroll;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==okBtn) {
			
			width = Integer.parseInt(widthInput.getText());
			height = Integer.parseInt(heightInput.getText());
			interval = (int)intervalSpinner.getValue();
			
			graphic.changeSetting(width, height, interval);
			graphic.getData();
		}
		
	}

	public JScrollPane getTableScroll() {
		return tableScroll;
	}

	public void setTableScroll(JScrollPane tableScroll) {
		this.tableScroll = tableScroll;
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
	
}

public class Test {
	public static void main(String[] args) {
		SensorFrame frame = new SensorFrame();
	}
}
