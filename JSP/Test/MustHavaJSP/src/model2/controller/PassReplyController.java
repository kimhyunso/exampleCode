package model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.board.MVCReplyDAO;
import model2.board.MVCReplyDTO;
import utils.JSFunction;

@WebServlet("/mvc2/passReply.do")
public class PassReplyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		String ridx = req.getParameter("ridx");
		
		MVCReplyDAO dao = new MVCReplyDAO();
		
		if(mode.equals("0")) {
			req.getRequestDispatcher("/mvc2/ReplyEdit.jsp").forward(req, resp);
		}else if(mode.equals("1")) {
			int result = dao.delete(idx,ridx);
			dao.close();
			if(result == 1) {
				JSFunction.alertLocation("삭제되었습니다.", "../mvc2/view.do?idx="+idx, resp);
			}else {
				JSFunction.alertLocation("삭제 실패하였습니다.", "../mvc2/view.do?idx="+idx, resp);
			}
		}
	}
	
}
