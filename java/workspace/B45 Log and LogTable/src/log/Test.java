package log;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

class MyFrame extends JFrame implements ActionListener{
	
	private JPanel tablePanel;
	private JTable table;
	private DefaultTableModel tableModel;
	private Vector<String> columnData;
	
	private JPanel displayPanel;
	private JTextArea display;
	
	private JPanel inputPanel;
	private JTextArea input;
	//private JTextField input;
	private JButton okBtn;
	
	
	public MyFrame() {
		setTitle("Log");
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanel();
		
		setVisible(true);
	}
	public void createPanel() {
		tablePanel=new JPanel();
		createTable();
		
		displayPanel=new JPanel();
		display=new JTextArea(10,40);
		JScrollPane scroll1=new JScrollPane(display);
		displayPanel.add(scroll1);
		
		inputPanel=new JPanel();
		
		input = new JTextArea(10,30);
		input.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					int next = table.getRowCount()+1;
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Object[] data= {next,input.getText(),sdf.format(new Date())};
					tableModel.addRow(data);
					input.setText("");
				}
				
			}
			
		});
		
		JScrollPane scroll2=new JScrollPane(input);
		okBtn=new JButton("OK");
		okBtn.addActionListener(this);
		
		inputPanel.add(scroll2);
		inputPanel.add(okBtn);
		
		add(tablePanel,BorderLayout.NORTH);
		add(displayPanel,BorderLayout.CENTER);
		add(inputPanel,BorderLayout.SOUTH);
	}
	
	public void createTable() {
		columnData=new Vector<String>();
		columnData.addElement("No");
		columnData.addElement("Message");
		columnData.addElement("Time");
		
		tableModel=new DefaultTableModel(columnData,0);
		table=new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(450,300));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					int row=table.getSelectedRow();
					int col=table.getSelectedColumn();
					display.append(table.getValueAt(row, col)+"\n");
				}
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		JScrollPane scroll = new JScrollPane(table);
		
		tablePanel.add(scroll);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==okBtn) {
			int next = table.getRowCount()+1;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Object[] data= {next,input.getText(),sdf.format(new Date())};
			tableModel.addRow(data);
			input.setText("");
			input.requestFocus();
		}
		
		
		
	}
	
}


public class Test {

	public static void main(String arg[]) {
		new MyFrame();
	}

}
