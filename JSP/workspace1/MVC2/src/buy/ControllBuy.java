package buy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bord.DAOBord;
import Bord.DTOBord;

@WebServlet("/ControllBuy.do")
public class ControllBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String path=request.getSession().getServletContext().getRealPath("./storage");
			DAOBord db=new DAOBord();
			int num = Integer.parseInt(request.getParameter("num"));
			DTOBord dto= db.Select(num);
			String data=dto.getImg();
			File file=new File(path,data);
			response.setHeader("Content-Disposition", "attachment;filename="+data);
			InputStream in=new FileInputStream(file);
			OutputStream os=response.getOutputStream();
			byte[] bt=new byte[(int)file.length()];
			in.read(bt,0,bt.length);
			os.write(bt);
			
			in.close(); os.close();
			response.sendRedirect("start.jsp");
		}catch(Exception ex){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
