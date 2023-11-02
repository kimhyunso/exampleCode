package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {
	
	public static MultipartRequest uploadFile(HttpServletRequest req, String saveDirectory, int maxPostSize) {
		try {
			
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static void download(HttpServletRequest req, HttpServletResponse resp, 
			String directory, String sfileName, String ofileName) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		
		try {
			File file = new File(sDirectory,sfileName);
			InputStream in = new FileInputStream(file);
			
			String client = req.getHeader("User-Agent");
			if(client.indexOf("WOW64") == 1) {
				ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
			}else {
				ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
			}
			
			resp.reset();
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename=\""+ofileName +"\"");
			resp.setHeader("Content-Length", ""+file.length());
			
			
			OutputStream out = resp.getOutputStream();
			
			byte b[] = new byte[(int)file.length()];
			int readBuffer = 0;
			while((readBuffer = in.read(b)) > 0) {
				out.write(b,0,readBuffer);
			}
			
			in.close();
			out.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void deleteFile(HttpServletRequest req, String directory, String fileName) {
		String sDirectory = req.getServletContext().getRealPath(directory);
		File file = new File(sDirectory + File.separator + fileName);
		if(file.exists()) {
			file.delete();
		}
	}

}
