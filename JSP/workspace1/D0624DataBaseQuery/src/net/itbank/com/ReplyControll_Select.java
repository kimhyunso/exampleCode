package net.itbank.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReplyControll_Select.do")
public class ReplyControll_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int sabun=(int)request.getAttribute("sabun");
			DBConnecter db=new DBConnecter();
			DTOReplyGuest rdg=new DTOReplyGuest();
			rdg.setSabun(sabun);
			
			ArrayList<DTOReplyGuest> list= db.ReplySelectAll(sabun);
			DTOGuest dto=db.Select(sabun);
			
			
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("guestDetailShow.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
