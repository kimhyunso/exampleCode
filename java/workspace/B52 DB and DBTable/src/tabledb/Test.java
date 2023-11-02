package tabledb;

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
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

class MyFrame extends JFrame implements ActionListener{
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel tablePanel;
	
	private JPanel debugPanel;
	private JTextField debug;
	
	private JPanel inputPanel;
	private JTextField id;
	private JTextField name;
	private JSpinner age;
	private JButton okBtn;
	private JScrollPane tableScroll;

	
	//DB
	private String url="jdbc:mysql://localhost/itbank2?characterEncoding=utf8";
	private String user="itbank2";
	private String pass="itbank2pass";
	private Connection con;
	private Statement stm;
	
	private int count;
	private int idx;
	
	
	public MyFrame() {
		makeFrame();
		makeDebugPanel();
		makeConnect();
		
		makeTablePanel();
		makeInputPanel();
		
		setVisible(true);
	}
	
	public void makeConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			debug.setText("DB Connect OK");
			stm=con.createStatement();
		}catch(Exception e) {
			debug.setText("Error : "+e.getMessage());
		}
	}
	
	public void makeDebugPanel() {
		debugPanel=new JPanel();
		debug=new JTextField(40);
		//JScrollPane scroll = new JScrollPane(debug);
		debug.setEnabled(false);
		debug.setText("중요 정보를 표시합니다 . ");
		debugPanel.add(debug);
		add(debugPanel,BorderLayout.NORTH);
	}
	
	public void makeTablePanel() {
		
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
		
		//DB 가져오기
		try {
			String id;
			String name;
			int age;
			Timestamp time;
			
			String sql="select *from second_table order by idx asc";
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
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int column=table.getSelectedColumn();
				
				debug.setText(table.getValueAt(row, column).toString());
			}
		});
		
		tableScroll = new JScrollPane(table);
		tablePanel.add(tableScroll);
		
		add(tablePanel,BorderLayout.CENTER);
	
	}
	
	public void makeInputPanel() {
		
		inputPanel=new JPanel();
		JLabel idLabel=new JLabel("ID");
		JLabel nameLabel=new JLabel("Name");
		JLabel ageLabel=new JLabel("Age");
		
		SpinnerModel smAge=new SpinnerNumberModel(20, 1 , 100 ,1); 
		age = new JSpinner(smAge);
		
		id=new JTextField(10);
		name=new JTextField(10);
		okBtn=new JButton("등록");
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
	
	public void makeFrame() {
		setTitle("Table");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void insertData() {
		String id=this.id.getText();
		String name=this.name.getText();
		int age=(int)this.age.getValue();
		Timestamp time;
		String sql="";
		
		
		sql=String.format("insert into second_table (id,name,age,time) values('%s','%s','%d',now())", id,name,age);
		try {
			int result=stm.executeUpdate(sql);
			
			sql = "select * from second_table order by idx desc limit 1";
			
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				idx=rs.getInt("idx");
				id=rs.getString("id");
				name=rs.getString("name");
				age=rs.getInt("age");
				time=rs.getTimestamp("time");
				Object data[]= {++count,id,name,age,time};
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
			//DB넣는다
			insertData();
		}
	}
	
}




public class Test {
	
	public static void main(String[] args) {
		MyFrame frame=new MyFrame();
	}

}
