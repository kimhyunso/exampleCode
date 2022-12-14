package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/downloadImage.do")
public class DownloadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		HttpSession session = request.getSession(); // 서블릿에서 세션생성
		ServletContext  application = this.getServletContext(); // 서블릿에서 application 
		String fileName = request.getParameter("file");
		//String path = application.getRealPath("/storage");
		String path = this.getServletContext().getRealPath("/storage");
		File file = new File(path+"/"+fileName);
		
		String mimeType = getServletContext().getMimeType(file.toString());
		if(mimeType ==null) {response.setContentType("application/octet-stream");}
		
		String downloadName = null;
		if(request.getHeader("user-agent").indexOf("MSIE")==-1) {
			downloadName = new String(fileName.getBytes("UTF-8"), "8859_1");
		}else {
			downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}
		
		response.setHeader("Content-Disposition", "attachment;fileName="+downloadName+"\";");
		
		FileInputStream is = new FileInputStream(file);
		ServletOutputStream os = response.getOutputStream();
		
		byte b[] = new byte[1024];
		int data =0;
		while((data= is.read(b, 0, b.length)) != -1) {
			os.write(b, 0, data);
		}
		
		os.flush();
		os.close();
		is.close();
		
	}
	
}//class END
