package net.itbank.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListControll.do")
public class ListControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		try {
			DBConnecter db=new DBConnecter();
			DTOPage pdto=new DTOPage();
			
			pdto.setSkey(request.getParameter("keyfield"));
			pdto.setSval(request.getParameter("keyword"));
			if(pdto.getSkey()==null || pdto.getSval()==null) {
				pdto.setSkey("title");
				pdto.setSval("");
			}
			
			
			
			pdto.setGnum(request.getParameter("Gidx"));
			if(pdto.getGnum()==null)pdto.setGnum("1");
			pdto.setgNum(Integer.parseInt(pdto.getGnum()));
			
			pdto.setTotal(db.Count(pdto));
			pdto.setStart((pdto.getgNum()*10)-9);
			pdto.setEnd((pdto.getgNum()*10));
			
			if(pdto.getTotal()%10==0) {
				pdto.setPagecount(pdto.getTotal()/10);
			}else {
				pdto.setPagecount((pdto.getTotal()/10)+1);
			}
			
			
			pdto.setTemp((pdto.getgNum()-1)%10);
			pdto.setPagestart(pdto.getgNum()-pdto.getTemp());
			pdto.setPageend(pdto.getPagestart()+9);
			
			if(pdto.getPageend()>pdto.getPagecount()) {
				pdto.setPageend(pdto.getPagecount());
			}
			
			ArrayList<DTOGuest> list=db.AllSelect(pdto);
			
			request.setAttribute("count", db.Count(pdto));
			request.setAttribute("list", list);
			request.setAttribute("pdto",pdto);
			
			RequestDispatcher rd=request.getRequestDispatcher("guestList.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
