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

@WebServlet("/mvc2/replyUpdate.do")
public class ReplyUpdateController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idx = Integer.parseInt(req.getParameter("idx"));
		String ridx = req.getParameter("ridx");
		String content = req.getParameter("content");
		
		MVCReplyDTO dto = new MVCReplyDTO();
		MVCReplyDAO dao = new MVCReplyDAO();
		
		dto.setContent(content);
		dto.setRidx(ridx);
		dto.setRgroup(idx);
		
		int result = dao.update(dto);
		dao.close();
		
		if(result == 1) {
			JSFunction.alertLocation("수정했습니다.", "../mvc2/view.do?idx="+idx, resp);
		}else {
			JSFunction.alertLocation("수정에 실패했습니다.", "../mvc2/view.do?idx="+idx, resp);
		}
	}

}
