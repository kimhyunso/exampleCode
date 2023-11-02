package filecopy;

import java.io.FileReader;
import java.io.FileWriter;

public class Test {
	public static void main(String[] args) {
		//data/origin.txt
		//data/clone.txt
		
		FileReader in = null;
		FileWriter out = null;
		
		try {
			int c;
			in = new FileReader("data/origin.txt");
			out = new FileWriter("data/clone.txt");
			
			while((c=in.read()) != -1 ) {
				out.write(c);
				System.out.print((char)c);
			}
			
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(in!=null)in.close();
				if(out!=null)out.close();
			} catch (Exception e2) {
			}
		}
		
		
		
		
	}
}
