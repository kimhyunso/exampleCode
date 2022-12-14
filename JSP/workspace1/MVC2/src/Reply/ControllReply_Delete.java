package Reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bord.DAOBord;
import Login.DTOLogin;

@WebServlet("/ControllReply_Delete.do")
public class ControllReply_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			
			int num=Integer.parseInt(request.getParameter("num"));
			
			DAOBord db=new DAOBord();
			DTOReply dto=new DTOReply();
			
			dto.setKind(Integer.parseInt(request.getParameter("kind")));
			db.ReplyDelete(dto);
			
			RequestDispatcher rd=request.getRequestDispatcher("ControllBordDetail.do?num="+num+"&renum=");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
