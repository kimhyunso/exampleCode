package jtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

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
	
	private JTextField name;
	private JTextField id;
	private JTextField address;
	private JSpinner age;
	
	private Vector<String> userColumn;
	
	public MyFrame() {
		setTitle("Table");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel tablePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		
		userColumn=new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("ID");
		userColumn.addElement("Name");
		userColumn.addElement("Age");
		userColumn.addElement("Address");
		
		tableModel=new DefaultTableModel(userColumn,0);
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(450,300));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				System.out.println("row = "+row+","+"column = "+col);
				System.out.println(table.getValueAt(row,col).toString());
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		//Object[] data= {1,"test","테스터",12,"서울 동작구"};
		//tableModel.addRow(data);
		
		JScrollPane scroll = new JScrollPane(table);
		tablePanel.add(scroll);
		table.setAutoCreateRowSorter(true);
 		
		add(tablePanel,BorderLayout.CENTER);
		add(inputPanel,BorderLayout.SOUTH);
		
		id=new JTextField(5);
		name=new JTextField(5);
		//초기 값 , minum값 ,mixum값 , 올라가는 값
		SpinnerModel smAge=new SpinnerNumberModel(20, 1 , 100 ,1); 
		age = new JSpinner(smAge);
		address = new JTextField(5);
		
		inputPanel.add(new JLabel("ID"));
		inputPanel.add(id);
		
		inputPanel.add(new JLabel("Name"));
		inputPanel.add(name);
		
		inputPanel.add(new JLabel("Age"));
		inputPanel.add(age);
		
		inputPanel.add(new JLabel("Address"));
		inputPanel.add(address);
		address.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==address) {
			int next = table.getRowCount() + 1;
			Object[] data= {next,id.getText(),name.getText(),age.getValue(),address.getText()};
			tableModel.addRow(data);
			
			
			Date date = new Date();
			System.out.println("현재시간 = "+date);
		}
	}
}


public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
