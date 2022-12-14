package model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.board.MVCReplyDAO;
import model2.board.MVCReplyDTO;

@WebServlet("/mvc2/replyWrite.do")
public class ReplyWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCReplyDAO dao = new MVCReplyDAO();
		MVCReplyDTO dto = new MVCReplyDTO();
		
		String id = req.getSession().getAttribute("id").toString();
		String nick =req.getSession().getAttribute("nick").toString();
		String content = req.getParameter("content");
		int idx = Integer.parseInt(req.getParameter("idx"));
		int cl = 0;
	
		
		if (req.getParameter("class") != null) {
			cl = Integer.parseInt(req.getParameter("cl"));
		}
		
		
		dto.setId(id);
		dto.setNick(nick);
		dto.setContent(content);
		dto.setRgroup(idx);
		dto.setCl(cl);
		
		
		dao.insert(dto);
		dao.close();
		
		
		req.getRequestDispatcher("../mvc2/view.do").forward(req, resp);;
		
	}
}
