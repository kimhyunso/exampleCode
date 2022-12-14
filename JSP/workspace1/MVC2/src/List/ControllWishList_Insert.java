package List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bord.DAOBord;

@WebServlet("/ControllWishList_Insert.do")
public class ControllWishList_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAOBord db=new DAOBord();
				
			DTOWishList dto=(DTOWishList)request.getAttribute("wdto");
			db.WishListInsert(dto);
			response.sendRedirect("ControllWishList.do?linum=&skey=&sval=");
		}catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
