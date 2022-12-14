package Bord;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import more.DTOPage;

@WebServlet("/ControllBord.do")
public class ControllBord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			DAOBord db=new DAOBord();
			DTOPage dto=new DTOPage();
			
			dto.setSval(request.getParameter("sval"));
			if(dto.getSval()==null || dto.getSval()=="") {
				dto.setSval("");
			}
			
			dto.setPnum(request.getParameter("gnum"));
			if(dto.getPnum()=="" || dto.getPnum()==null) dto.setPnum("1");
			dto.setpNum(Integer.parseInt(dto.getPnum()));
			
			if(dto.getpNum()==1) {
				dto.setStart((dto.getpNum()*10)-9);
			}else {
				dto.setStart(((dto.getpNum()*10)-9)-dto.getpNum());
			}
			
			dto.setEnd((dto.getpNum()*10)-2);
			
			if(db.Count(dto)%8==0) {
				dto.setPagecount(db.Count(dto)/8);
			}else {
				dto.setPagecount((db.Count(dto)/8)+1);
			}
			
			dto.setTemp((dto.getpNum()%10)-1);
			dto.setPagestart(dto.getpNum()-dto.getTemp());
			dto.setPageend(dto.getPagestart()+9);
			
			if(dto.getPagecount()<dto.getPageend()) {
				dto.setPageend(dto.getPagecount());
			}
			
			ArrayList<DTOBord> list = db.SelectAll(dto);
			
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("Bord.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
