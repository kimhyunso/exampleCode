package dbtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

class MyFrame extends JFrame implements ActionListener{
	
	private Connection con;
	private Statement stm;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	
	
	private JPanel debugPanel;
	private JTextArea head;
	
	private JPanel inputPanel;
	private JTextField id;
	private JTextField name;
	private JSpinner age;
	private JButton okBtn;
	private int count;
	private int idx;
	
	
	public MyFrame() {
		connectDB();
		init();
		createHead();
		createBody();
		createTail();
		
		setVisible(true);
	}
	
	public void createTail() {
		inputPanel=new JPanel();
		JLabel idLabel=new JLabel("ID");
		JLabel nameLabel=new JLabel("Name");
		JLabel ageLabel=new JLabel("Age");
		
		SpinnerModel smAge=new SpinnerNumberModel(20, 1 , 100 ,1); 
		age = new JSpinner(smAge);
		
		id=new JTextField(10);
		name=new JTextField(10);
		okBtn=new JButton("µî·Ï");
		name.addActionListener(this);
		
		okBtn.addActionListener(this);
		
		inputPanel.add(idLabel);
		inputPanel.add(id);
		inputPanel.add(nameLabel);
		inputPanel.add(name);
		inputPanel.add(ageLabel);
		inputPanel.add(age);
		inputPanel.add(okBtn);
		
		add(inputPanel,BorderLayout.SOUTH);
	}
	
	public void createHead() {
		debugPanel=new JPanel();
		head=new JTextArea(5,40);
		JScrollPane scroll = new JScrollPane(head);
		
		debugPanel.add(scroll);
		add(debugPanel,BorderLayout.NORTH);
	}
	
	
	public void createBody() {
		tablePanel=new JPanel();
		
		Vector<String> column=new Vector<String>();
		column.addElement("Idx");
		column.addElement("ID");
		column.addElement("Name");
		column.addElement("Age");
		column.addElement("Time");
		
		tableModel=new DefaultTableModel(column,0);
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(450,270));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int column=table.getSelectedColumn();
				
				head.setText(table.getValueAt(row, column).toString());
			}
		});
		
		JScrollPane scroll=new JScrollPane(table);
		tablePanel.add(scroll);
		
		getData();
		
		add(tablePanel,BorderLayout.CENTER);
	}
	
	public void getData() {
		try {
			String id;
			String name;
			int age;
			Timestamp time;
			
			String sql="select *from second_table";
			ResultSet result=stm.executeQuery(sql);
			
			
			while(result.next()) {
				++count;
				idx=result.getInt("idx");
				id=result.getString("id");
				name=result.getString("name");
				age=result.getInt("age");
				time=result.getTimestamp("time");
				Object data[]= {count,id,name,age,time};
				tableModel.addRow(data);
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public void init() {
		setTitle("Table");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void connectDB() {
		String url="jdbc:mysql://localhost/itbank2?characterEncoding=utf8";
		String user="itbank2";
		String pass="itbank2pass";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			System.out.println("DB Connection");
			stm=con.createStatement();
		}catch(Exception e) {
			System.out.println("DB Fail "+e.getMessage());
		}
		
	}
	
	public void insertData() {
		String id=this.id.getText();
		String name=this.name.getText();
		int age=(int)this.age.getValue();
		String sql="";
		
		sql=sql.format("insert into second_table (id,name,age,time) values('%s','%s','%d',now())", id,name,age);
		try {
			int result=stm.executeUpdate(sql);
			
			sql="select *from second_table order by idx asc";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				idx=rs.getInt("idx");
			}
			sql="select *from second_table where idx = "+idx;
			
			ResultSet srs = stm.executeQuery(sql);
			
			while(srs.next()) {
				Object data[]= {++count,srs.getString("id"),srs.getString("name"),srs.getInt("age"),srs.getTimestamp("time")};
				tableModel.addRow(data);
			}
		}catch(Exception e1) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==name) {
			insertData();
		}
		
		if(e.getSource()==okBtn) {
			insertData();
		}
	}
	
}




public class Test {
	
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
	}

}
