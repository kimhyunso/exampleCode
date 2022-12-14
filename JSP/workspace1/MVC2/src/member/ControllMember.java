package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bord.DAOBord;

@WebServlet("/ControllMember.do")
public class ControllMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out=response.getWriter();
			
			DTOMember dto=new DTOMember();
			DAOBord db=new DAOBord();
			
			String id=request.getParameter("id");
			String pw=request.getParameter("pw");
			String nick=request.getParameter("nick");
			String email=request.getParameter("email");
			StringBuffer location=new StringBuffer(); 
			
			location.append(request.getParameter("roadAddrPart1"));
			location.append(request.getParameter("addrDetail"));
			
			String job=request.getParameter("job");
			
			dto.setUser_id(id);
			dto.setUser_pw(pw);
			dto.setNickname(nick);
			dto.setEmail(email);
			dto.setLocation(location);
			dto.setJob(job);
			
			if(db.MemberSelect(dto.getUser_id())==0) {
				db.MemberInsert(dto);
				db.LoginInsert(dto);
				out.print("<script>alert('회원가입 완료!'); location.href='Login.jsp'</script>");
				out.flush();
			}else {
				String who = db.MemberSelectW(dto);
				out.print("<script>alert('"+who+"가(이) 있습니다.'); setTimeout(function(){location.href='Member.jsp'},1000);</script>");
				out.flush();
			}
			
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
