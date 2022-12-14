package List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ControllWho.do")
public class ControllWho extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String button=null;
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String user_id = (String)session.getAttribute("user_id");
		String user_pw = (String)session.getAttribute("user_pw");
		String nick=(String)session.getAttribute("nickname");
		
		if(user_id==null && user_pw==null) {
			out.print("<script>alert('로그인을 해주세요!'); location.href='Login.jsp';</script>");
			out.flush();
		}else {
			RequestDispatcher rd=null;
			DTOList dto=new DTOList();
			DTOWishList wdto=new DTOWishList();
			button = request.getParameter("button");
			int num = Integer.parseInt(request.getParameter("num"));
			String favorite = request.getParameter("favorite");
			int count=Integer.parseInt(request.getParameter("count"));
			
			dto.setNum(num);
			dto.setOption(favorite);
			dto.setCount(count);
			dto.setUser_id(user_id);
			dto.setUser_pw(user_pw);
			dto.setNick(nick);
			
			wdto.setNum(num);
			wdto.setOp(favorite);
			wdto.setCount(count);
			wdto.setUser_id(user_id);
			wdto.setUser_pw(user_pw);
			wdto.setNick(nick);
			
			switch (button) {
			case "구매하기":
				response.sendRedirect("ControllBuy.do?num="+num);
				break;
			case "장바구니":
				request.setAttribute("boxdto", dto);
				if(rd==null) {
					rd=request.getRequestDispatcher("ControllList_Insert.do");
					rd.forward(request, response);
				}
				break;
			case "위시리스트":
				request.setAttribute("wdto", wdto);
				if(rd==null) {
					rd=request.getRequestDispatcher("ControllWishList_Insert.do");
					rd.forward(request, response);
				}
				break;
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
