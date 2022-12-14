package net.itbank.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet{
	PrintWriter pw;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");	
		pw=resp.getWriter();
		HttpSession session=req.getSession();
		String id=req.getParameter("userid");
		String pwd=req.getParameter("userpwd");
		
		if(session.isNew()||(session.getAttribute("id")==null||session.getAttribute("userpwd")==null)) {
			session.setAttribute("id",id);
			session.setAttribute("pwd",pwd);
			String str="<script language='javascript'>";
			pw.print("Login Loding...");
			str +="setTimeout(function(){"
					+ "},3000)";
			back();
		}else {
			session.invalidate();
			back();
			return;
		}
		
		pw.close();
	
	}
	
	public void back() {
		String str = "<script language='javascript'>";
		//str += "self.close();"; 
		str += "history.back();"; 
		str += "</script>";
		pw.print(str);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
