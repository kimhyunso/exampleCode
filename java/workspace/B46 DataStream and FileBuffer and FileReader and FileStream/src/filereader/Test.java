package filereader;

import java.io.FileReader;
import java.io.FileWriter;

public class Test {
	
	public static void main(String[] args) {
		FileReader in = null;
		FileWriter out = null;
		
		String msg ="ABCD°¡³ª´Ù¶óùÛâª¡Ú¡Ú¨Î¢Ý¢ß";
		try {
			
			out = new FileWriter("data1.txt",false);
			out.write(msg);
			out.flush();
			
			in = new FileReader("data1.txt");
			int c;
			while((c=in.read()) != -1) {
				System.out.print((char)c);
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(in!=null)in.close();
				if(out!=null)out.close();
			}catch(Exception e) {}
		}
		
		
	}

}
