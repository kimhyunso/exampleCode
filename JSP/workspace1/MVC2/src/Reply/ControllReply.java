package Reply;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bord.DAOBord;
import Bord.DTOBord;
import more.DTOPage;

@WebServlet("/ControllReply.do")
public class ControllReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			int num = Integer.parseInt(request.getParameter("num"));
			DAOBord db=new DAOBord();
			
			DTOBord dto = db.Select(num);
			
			DTOPage redto=new DTOPage();
			
			redto.setPnum(request.getParameter("renum"));
			if(redto.getPnum()==null || redto.getPnum()=="") {
				redto.setPnum("1");
			}
			redto.setpNum(Integer.parseInt(redto.getPnum()));
			
			if(db.ReplyCount(num)%10==0) {
				redto.setPagecount(db.ReplyCount(num)/10);
			}else {
				redto.setPagecount((db.ReplyCount(num)/10)+1);
			}
			redto.setStart((redto.getpNum()*10)-9);
			redto.setEnd((redto.getStart()*10));
			
			redto.setTemp((redto.getpNum()%10)-1);
			redto.setPagestart(redto.getpNum()-redto.getTemp());
			redto.setPageend((redto.getPagestart()*10));
			if(redto.getPageend()>redto.getPagecount()) {
				redto.setPageend(redto.getPagecount());
			}
			
			ArrayList<DTOReply> list = db.ReplySelectAll(redto,num);
			DTOReply dtoreply = db.ReplySelect(Integer.parseInt(request.getParameter("kind")));
			
			int cnt=db.ReplyMCount(Integer.parseInt(request.getParameter("num")));
			
			
			request.setAttribute("dtoreply", dtoreply);
			request.setAttribute("cnt", cnt);
			request.setAttribute("redto", redto);
			request.setAttribute("list", list);
			request.setAttribute("num", Integer.parseInt(request.getParameter("num")));
			request.setAttribute("dto", dto);
			
			RequestDispatcher rd=request.getRequestDispatcher("ReplyUpdate.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
