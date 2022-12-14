package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadAction")
public class FileDownloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		ServletContext  application = this.getServletContext();
	
		String fileName = request.getParameter("file");
		String directory = this.getServletContext().getRealPath("/storage");
		File file = new File(directory + "/" + fileName);

		String mimeType = getServletContext().getMimeType(file.toString());
		if (mimeType == null) {response.setContentType("application/octet-stream");}
		
		String downloadName = null;
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {
			downloadName = new String(fileName.getBytes("UTF-8"), "8859_1");
		}else {
			downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}

		/////////////////////////////////////////////////////////
		/*
		 ServletContext  application = this.getServletContext();
		 String path=application.getRealPath("./storage");
	   String data=request.getParameter("fname");
	   File file = new File( path, data); 
	   response.setHeader("Content-Disposition","attachment;filename="+data);
	   try{
	  	 InputStream is=new FileInputStream(file);
	  	 OutputStream os=response.getOutputStream();
	  	 
	  	 byte[ ] bt=new byte[(int)file.length()];
	  	 is.read(bt,0,bt.length);
	  	 os.write(bt);//기록저장
	  	 
	  	 is.close(); os.close(); //반드시 필요
	  */
		/////////////////////////////////////////////////////////
		
		response.setHeader("Content-Disposition", "attachment;fileName=" + downloadName + "\";");
		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStrem = response.getOutputStream();

		byte b[] = new byte[1024];
		int data = 0;
		while ((data = fileInputStream.read(b, 0, b.length)) != -1) {
			servletOutputStrem.write(b, 0, data);
		}

		servletOutputStrem.flush();
		servletOutputStrem.close();
		fileInputStream.close();
	}

}//class END
