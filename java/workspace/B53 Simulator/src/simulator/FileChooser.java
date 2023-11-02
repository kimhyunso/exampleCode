package simulator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	
	private JFileChooser fc;
	private NetFrame frame;
	
	
	public FileChooser(NetFrame frame) {
		this.frame = frame;
		fc = new JFileChooser();
	}
	
	public void open() {
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Text","txt");
		fc.setFileFilter(filter);
		
		int result = fc.showOpenDialog(frame);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			// 확인 버튼 클릭했을 때만, 파일을 가져온다.
			String path = fc.getSelectedFile().getPath();
			System.out.println(path);
			
			FileReader in = null;
			BufferedReader br = null;
			
			//String fileContents;
			frame.getDisplay().setText("");
			String line = null;
			
			try {
				in = new FileReader(path);
				br = new BufferedReader(in);
				
				while( (line = br.readLine()) != null)
				{
					frame.getDisplay().append(line + "\n");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				frame.getDisplay().append("File Open Error "+e2.getMessage()+"\n");
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
	
	public void save() {
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Text","txt");
		fc.setFileFilter(filter);
		
		int result = fc.showSaveDialog(frame);
		
		if(result == JFileChooser.APPROVE_OPTION)
		{
			FileWriter out = null;
			BufferedWriter bw = null;
			String fileContents = frame.getDisplay().getText();
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

	public JFileChooser getFc() {
		return fc;
	}

	public void setFc(JFileChooser fc) {
		this.fc = fc;
	}
	
	
}
