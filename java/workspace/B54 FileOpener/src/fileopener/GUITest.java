package fileopener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

class MyFrame extends JFrame implements ActionListener
{
	private JPanel displayPanel;
	private JPanel buttonPanel;
	
	private JTextArea display;
	private JTextField input;
	private JButton open;
	private JButton save;
	
	private JFileChooser fc;
	
	public MyFrame()
	{
		this.setTitle("My GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programmming Here
		this.setLayout(new BorderLayout());
		
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		fc = new JFileChooser();
		
		displayPanel.setLayout(new FlowLayout());
		display = new JTextArea(11, 30);
		Font displayFont = new Font("Serif", Font.BOLD, 20);
		display.setFont(displayFont);
		//display.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(display);
		displayPanel.add(scroll);
	
		buttonPanel.setLayout(new FlowLayout());
		open = new JButton("Open");
		save = new JButton("Save");
		
		Font buttonFont = new Font("Serif", Font.BOLD, 20);
		open.setFont(buttonFont);
		save.setFont(buttonFont);
		
		open.addActionListener(this);
		save.addActionListener(this);
		
		buttonPanel.add(open);
		buttonPanel.add(save);
		
		this.add(displayPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == open)
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "txt");
			int result;
			fc.setFileFilter(filter);
			
			result = fc.showOpenDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				// 확인 버튼 클릭했을 때만, 파일을 가져온다.
				String path = fc.getSelectedFile().getPath();
				System.out.println(path);
				
				FileReader in = null;
				BufferedReader br = null;
				
				//String fileContents;
				display.setText("");
				String line = null;
				
				try {
					in = new FileReader(path);
					br = new BufferedReader(in);
					
					while( (line = br.readLine()) != null)
					{
						display.append(line + "\n");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					display.append("File Open Error \n");
				} finally
				{
					try {
						if(in != null)
							in.close();
						if(br != null)
							br.close();
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
			
		}
		
		if(e.getSource() == save)
		{
			int result;
			result = fc.showSaveDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				FileWriter out = null;
				BufferedWriter bw = null;
				String fileContents = display.getText();
				String path = fc.getSelectedFile().getPath();
				System.out.println("Save file : " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n");
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();
						bw.flush();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						if(out != null)
							out.close();
						if(bw != null)
							bw.close();
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	
	
}

public class GUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}

}
