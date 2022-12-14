package List;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bord.DAOBord;
import more.DTOPage;

@WebServlet("/ControllWishList.do")
public class ControllWishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAOBord db=new DAOBord();
			DTOPage dto=new DTOPage();
			
			HttpSession session=request.getSession();
			String user_id=(String)session.getAttribute("user_id");
			String user_pw=(String)session.getAttribute("user_pw");
			
			dto.setSkey(request.getParameter("skey"));
			dto.setSval(request.getParameter("sval"));
			
			if(dto.getSkey()=="" || dto.getSkey()==null) {
				dto.setSkey("title"); 
				dto.setSval("");
			}
			
			dto.setPnum(request.getParameter("linum"));
			if(dto.getPnum()==null || dto.getPnum()=="") {
				dto.setPnum("1");
			}
			dto.setpNum(Integer.parseInt(dto.getPnum()));
			
			if(dto.getpNum()==1) {
				dto.setStart((dto.getpNum()*10)-9);
				dto.setEnd((dto.getpNum()*10)-5);
			}else {
				dto.setStart(((dto.getpNum()*10)-9)-5);
				dto.setEnd(dto.getStart()+4);
			}
			
			
			if(db.ListCount(dto,user_id,user_pw)%5==0) {
				dto.setPagecount(db.ListCount(dto,user_id,user_pw)/5);
			}else {
				dto.setPagecount((db.ListCount(dto,user_id,user_pw)/5)+1);
			}
			
			dto.setTemp((dto.getpNum()%10)-1);
			dto.setPagestart(dto.getpNum()-dto.getTemp());
			dto.setPageend((dto.getPagestart()*10));
			
			if(dto.getPageend()>dto.getPagecount()) {
				dto.setPageend(dto.getPagecount());
			}
			
			ArrayList<DTOWishList> list = db.WishListSelectAll(dto,user_id,user_pw);
			
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("WishList.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
