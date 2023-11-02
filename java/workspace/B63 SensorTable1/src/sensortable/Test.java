package sensortable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class MyFrame extends JFrame implements ActionListener{

	private JPanel bodyPanel;
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> userData;
	private JScrollPane tableScroll;
	private UDPServer udpServer;
	private DataBase db;
	
	public MyFrame() {
		connectDB();
		init();
		createBody();
		autoUDP();
		
		setVisible(true);
	}
	
	public void autoUDP() {
		udpServer = new UDPServer(this,db);
	}
	
	public void connectDB() {
		db = new DataBase();
	}
	
	public void createBody() {
		bodyPanel = new JPanel();
		userData = new Vector<String>();
		userData.addElement("No");
		userData.addElement("ID");
		userData.addElement("Seq");
		userData.addElement("Temp");
		userData.addElement("Hum");
		
		tableModel = new DefaultTableModel(userData, 0);
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(450,500));
		table.setFillsViewportHeight(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		
		tableScroll = new JScrollPane(table);
		bodyPanel.add(tableScroll);
		
		add(bodyPanel,BorderLayout.CENTER);
	}
	
	public void init() {
		setTitle("SensorTable");
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
		new MyFrame();
	}
}
