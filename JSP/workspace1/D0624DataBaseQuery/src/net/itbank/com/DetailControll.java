package net.itbank.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailControll.do")
public class DetailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int sabun=Integer.parseInt(request.getParameter("sabun"));
			DBConnecter db=new DBConnecter();
			DTOGuest dto = db.Select(sabun);
			
			db.point(dto.getSabun());
			
			ArrayList<DTOReplyGuest> list = db.ReplySelectAll(sabun);
			
			request.setAttribute("dto", dto);
			request.setAttribute("sabun",sabun);
			request.setAttribute("list", list);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("guestDetailShow.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
