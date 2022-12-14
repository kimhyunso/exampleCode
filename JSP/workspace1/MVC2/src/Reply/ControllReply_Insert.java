package Reply;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bord.DAOBord;

@WebServlet("/ControllReply_Insert.do")
public class ControllReply_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			int num=Integer.parseInt(request.getParameter("num"));
			HttpSession session=request.getSession();
			
			DAOBord db=new DAOBord();
			DTOReply dto=new DTOReply();
			
			dto.setUser_id((String)session.getAttribute("user_id"));
			dto.setUser_pw((String)session.getAttribute("user_pw"));
			dto.setNickname((String)session.getAttribute("nickname"));
			dto.setNum(num);
			dto.setContent(request.getParameter("content"));
			
			db.ReplyInsert(dto);
			RequestDispatcher rd=request.getRequestDispatcher("ControllBordDetail.do?num="+num+"&renum=");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
