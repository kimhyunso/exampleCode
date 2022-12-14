package List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bord.DAOBord;

@WebServlet("/ControllList_Delete.do")
public class ControllList_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAOBord db=new DAOBord();
			HttpSession session=request.getSession();
			DTOList dto=new DTOList();
			dto.setKind(Integer.parseInt(request.getParameter("kind")));
			dto.setUser_id((String)session.getAttribute("user_id"));
			dto.setUser_pw((String)session.getAttribute("user_pw"));
			db.ListDelete(dto);
			response.sendRedirect("ControllList.do");
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
