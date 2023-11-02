package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

public class FileRandom {
	private Vector<File> file;
	private String path[] = {"./file/random1.txt",
							 "./file/random2.txt",
							 "./file/random3.txt",
							 "./file/random4.txt",
							 "./file/random5.txt",
							 "./file/random6.txt",
							 "./file/random7.txt"};
	private BufferedReader in = null;
	private StringBuffer appendLine;
	
	public FileRandom() {
		file = new Vector<File>();
		createFiles();
	}
	
	public void createFiles() {
		for(int i=0; i<path.length; i++) {
			file.add(new File(path[i]));
		}
	}
	
	public StringBuffer checkedRandom(int random) {
		appendLine = new StringBuffer();
		
		if(random >= 7) {
			random = 6;
		}
		
		try {
			in = new BufferedReader(new FileReader(file.get(random)));
			String line;
			
			while((line = in.readLine()) != null) {
				appendLine.append(line);
			}
			
		}catch(Exception e) {
			System.out.println("file ¿À·ù"+e.getMessage());
		}finally {
			try {
				if(in != null) in.close();
			}catch(Exception e) {
				System.out.println("file close error");
			}
			
		}
		
		return appendLine;
	}
	
	public StringBuffer getAppendLine() {
		return appendLine;
	}

	public void setAppendLine(StringBuffer appendLine) {
		this.appendLine = appendLine;
	}

}