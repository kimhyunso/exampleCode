package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSearchServlet.do")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String name = request.getParameter("search");
		getJSON(name);
	}//end

	public String getJSON(String name) {
		if(name==null)
			name="";
		StringBuffer result= new StringBuffer("");
		result.append("{\"result\":[");
		UserDAO userDAO = new UserDAO();
		ArrayList<UserDTO> userList = userDAO.search(name);
		for(int i=0; i<userList.size(); i++) {
			result.append("[{\"value\": \""+userList.get(i).getNo()+"\"},");
			result.append("{\"value\": \""+userList.get(i).getSabun()+"\"},");
			result.append("{\"value\": \""+userList.get(i).getName()+"\"},");
			result.append("{\"value\": \""+userList.get(i).getTitle()+"\"},");
			result.append("{\"value\": \""+userList.get(i).getWdate()+"\"}],");
		}
		result.append("]}");
		System.out.println(result.toString());
		return result.toString();
	}//end

}//class END
