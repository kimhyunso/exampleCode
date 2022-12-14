package Reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bord.DAOBord;

@WebServlet("/ControllReply_Update.do")
public class ControllReply_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAOBord db=new DAOBord();
			DTOReply dto=new DTOReply();
			int num = Integer.parseInt(request.getParameter("num"));
			dto.setContent(request.getParameter("content"));
			dto.setKind(Integer.parseInt(request.getParameter("kind")));
			db.ReplyUpdate(dto);
			
			response.sendRedirect("ControllBordDetail.do?num="+num+"&renum=");
		}catch(Exception e) {
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
