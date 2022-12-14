package net.itbank.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateControll.do")
public class UpdateControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			DBConnecter db=new DBConnecter();
			DTOGuest dto=new DTOGuest();
			dto.setSabun(Integer.parseInt(request.getParameter("sabun")));
			dto.setName(request.getParameter("name"));
			dto.setTitle(request.getParameter("title"));
			dto.setPay(Integer.parseInt(request.getParameter("pay")));
			
			db.Update(dto);
			response.sendRedirect("Index.jsp");
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
