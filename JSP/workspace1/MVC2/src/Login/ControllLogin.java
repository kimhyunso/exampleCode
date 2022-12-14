package Login;

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

@WebServlet("/ControllLogin.do")
public class ControllLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		session.setAttribute("nickname", null);
		session.setAttribute("delable", null);
		
		out.print("<script>setTimeout(function(){location.href='Start.jsp'},1000);</script>");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession();
			DAOBord db=new DAOBord();
			DTOLogin dto=new DTOLogin();
			PrintWriter out=response.getWriter();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			dto.setUser_id(id);
			dto.setUser_pw(pw);
			
			if(db.LoginSelect(dto)) {
				session.setAttribute("user_id", dto.getUser_id());
				session.setAttribute("user_pw", dto.getUser_pw());
				session.setAttribute("nickname", dto.getNickname());
				session.setAttribute("delable", dto.getDelable());
				response.sendRedirect("Start.jsp");
				
			}else {
				session.setAttribute("user_id", null);
				session.setAttribute("user_pw", null);
				session.setAttribute("nickname", null);
				session.setAttribute("delable", null);
				out.print("<script>alert('아이디 or 비밀번호를 확인하세요!'); location.href='Login.jsp'</script>");
				out.flush();
			}

		}catch(Exception e) {
			
		}
	}
	

}
