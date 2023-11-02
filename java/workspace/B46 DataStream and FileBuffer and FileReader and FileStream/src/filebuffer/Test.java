package filebuffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	
	public static void main(String[] args) {
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			out=new BufferedOutputStream(
						new FileOutputStream("data.txt",false)
					);
			
			for(int i=1; i<=100; i++) {
				out.write(i);
			}
			
			out.flush();
			
			in = new BufferedInputStream(
						new FileInputStream("data.txt")
					);
			
			int c;
			
			while((c=in.read()) != -1) {
				System.out.println(c);
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(in != null)in.close();
				if(out != null)out.close();
			}catch(Exception e) {}
		}
		
	}
}
