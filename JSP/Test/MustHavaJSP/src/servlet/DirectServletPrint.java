package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/13/DirectServletPrint.do")
public class DirectServletPrint extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title></title></head>");
		pw.println("<body>");
		pw.println("<h2>서블릿에서 직접 출력합니다.</h2>");
		pw.println("<p>jsp로 포워드 하지 않습니다.</p>");
		pw.println("</body>");
		pw.println("<html>");
		pw.println("</html>");
		pw.close();
	}

}
