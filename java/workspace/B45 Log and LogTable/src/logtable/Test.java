package logtable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

class MyFrame extends JFrame implements ActionListener{
	
	private JPanel tablePanel;
	private JTable table;
	private DefaultTableModel tableModel;
	
	
	private JPanel displayPanel;
	private JTextArea display;
	
	private JPanel inputPanel;
	private JTextArea input;
	private JButton ok;
	
	public MyFrame() {
		makeFrame();
		
		makeTablePanel();
		makeDisplayPanel();
		makeInputPanel();
		
		setVisible(true);
	}
	
	public void makeFrame() {
		setTitle("Log Table");
		setSize(500,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void makeTablePanel() {
		tablePanel=new JPanel();
		Vector<String> userColumn=new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("Message");
		userColumn.addElement("Time");
		
		tableModel=new DefaultTableModel(userColumn,0);
		table =new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(450,350));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		//size setting
		JScrollPane scroll=new JScrollPane(table);
		tablePanel.add(scroll);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				display.setText(table.getValueAt(row, col).toString());
			}
		});
		
		
		add(tablePanel,BorderLayout.NORTH);
	}
	
	public void makeDisplayPanel() {
		displayPanel=new JPanel();
		display=new JTextArea(10,40);
		displayPanel.add(display);
		
		add(displayPanel,BorderLayout.CENTER);
	}
	
	public void makeInputPanel() {
		inputPanel=new JPanel();
		
		input = new JTextArea(5,30);
		ok=new JButton("OK");
		JScrollPane scroll = new  JScrollPane(input);
		ok.addActionListener(this);
		
		inputPanel.add(scroll);
		inputPanel.add(ok);
		
		add(inputPanel,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			int next=table.getRowCount() + 1;
			String msg=input.getText();
			Date date=new Date();
			
			Object data[]= {next,msg,date};
			tableModel.addRow(data);
		}
		
	}
	
}

public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}

}
