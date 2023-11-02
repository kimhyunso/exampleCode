package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = ""
					+"<script>"
					+"  alert('"+msg+"');"
					+"  location.href='"+url+"';"
					+"</script>";
			
			out.println(script);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void alertLocation(String msg, String url, HttpServletResponse resp) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			
			String script = ""
					+"<script>"
					+"  alert('"+msg+"');"
					+"  location.href='"+url+"';"
					+"</script>";
			
			pw.println(script);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = ""
					+"<script>"
					+" alert('"+msg+"');"
					+" history.back();"
					+"</script>";
			out.println(script);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			
			String script = ""
					+"<script>"
					+" alert('"+msg+"');"
					+" history.back();"
					+"</script>";
			pw.println(script);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
			
			
}
