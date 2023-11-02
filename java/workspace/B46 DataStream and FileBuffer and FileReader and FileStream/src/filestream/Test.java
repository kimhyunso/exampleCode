package filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			out=new FileOutputStream("data.txt",false);
			
			for(int i=1; i<=30; i++) {
				out.write(i);
			}
			
			out.flush();
			
			in=new FileInputStream("data.txt");
			int c;
			
			while( (c=in.read()) != -1 ) {
				System.out.println(c);
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				if(in != null)
					in.close();
				if(out != null)
					out.close();
			} catch (IOException e) {
				
			}
		}
		
	}
}
