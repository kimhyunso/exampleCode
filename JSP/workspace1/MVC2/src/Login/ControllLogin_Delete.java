package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bord.DAOBord;

@WebServlet("/ControllLogin_Delete.do")
public class ControllLogin_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			DAOBord db=new DAOBord();
			String id=request.getParameter("id");
			
			
			if(db.LoginSelect(id)!=0) {
				DTOLogin dto =db.LoginSelectDTO(id);
				
				if(dto.getDelable()!=1) {
					db.LoginDelete(dto.getUser_id());
					db.MemberDelete(dto.getUser_id());
					
					out.print("<script>alert('탈퇴되었습니다.'); setTimeout(function(){location.href='Start.jsp'},1000)</script>");
					out.flush();
				}else {
					out.print("<script>alert('관리자입니다.'); location.href='Start.jsp'</script>");
					out.flush();
				}
				
			}else {
				out.print("<script>alert('없는 아이디 입니다.'); location.href='Member.jsp'</script>");
				out.flush();
			}
			
			
		}catch(Exception e) {
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
