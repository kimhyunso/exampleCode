package net.itbank.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReplyControll_Insert.do")
public class ReplyControll_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int sabun=Integer.parseInt(request.getParameter("sabun"));
			DBConnecter db=new DBConnecter();
			DTOReplyGuest dto=new DTOReplyGuest();
			dto.setSabun(sabun);
			dto.setWriter(request.getParameter("writer"));
			dto.setContent(request.getParameter("content"));
			db.ReplyInsert(dto);
			
			request.setAttribute("sabun", sabun);
			RequestDispatcher rd=request.getRequestDispatcher("ReplyControll_Select.do");
			rd.forward(request, response);
			
		}catch(Exception e) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
