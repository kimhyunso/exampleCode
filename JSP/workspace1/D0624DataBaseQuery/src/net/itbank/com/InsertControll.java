package net.itbank.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertControll.do")
public class InsertControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DBConnecter db=new DBConnecter();
			DTOGuest dto=new DTOGuest();
			dto.setSabun(Integer.parseInt(request.getParameter("sabun")));
			dto.setName(request.getParameter("name"));
			dto.setTitle(request.getParameter("title"));
			dto.setPay(Integer.parseInt(request.getParameter("pay")));
			db.Insert(dto);
			
			response.sendRedirect("ListControll.do");
		}catch (Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
