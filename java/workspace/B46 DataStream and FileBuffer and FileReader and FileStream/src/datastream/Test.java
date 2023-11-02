package datastream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) {
		
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			out = new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("data.txt",false)
						)
					);
			
			for(int i=1; i<=100; i++) {
				out.write(i);
			}
			
			out.writeUTF("ABCD °¡³ª´Ù¶ó £ÀùÓ¡Ù¡Ø¢¾ âª");
			out.flush();
			
			in = new DataInputStream(
					new BufferedInputStream(
						new FileInputStream("data.txt")
						)
					);
			
			int c;
			for(int i=1; i<=100; i++) {
				System.out.println(in.read());
			}
			System.out.println(in.readUTF());
			
			
			
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(in != null)in.close();
				if(out != null)out.close();
			}catch(Exception e1) {}
		}
		
		
	}
}
