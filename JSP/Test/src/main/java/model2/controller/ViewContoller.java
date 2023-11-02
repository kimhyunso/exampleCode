package model2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.board.MVCBoardDAO;
import model2.board.MVCBoardDTO;
import model2.board.MVCMemberDAO;
import model2.board.MVCMemberDTO;
import model2.board.MVCReplyDAO;
import model2.board.MVCReplyDTO;

@WebServlet("/mvc2/view.do")
public class ViewContoller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCMemberDAO mdao = new MVCMemberDAO();
		MVCReplyDAO rdao = new MVCReplyDAO();
		
		String id = req.getSession().getAttribute("id").toString();
		String pass = req.getSession().getAttribute("pass").toString();
		String idx = req.getParameter("idx");
		
		dao.updateVisitCount(idx);
		MVCBoardDTO dto = dao.selectView(idx);
		MVCMemberDTO mdto = mdao.selectOne(id, pass);
		List<MVCReplyDTO> replyLists = rdao.selectAll(idx);
		
		
		dto.setContent(dto.getContent().replaceAll(">", "&gl;"));
		dto.setContent(dto.getContent().replaceAll("<", "&lt;"));
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		
		
		
		dto.setTitle(dto.getTitle().replaceAll(">", "&gl;"));
		dto.setTitle(dto.getTitle().replaceAll("<", "&lt;"));
		
		req.setAttribute("dto", dto);
		req.setAttribute("mdto", mdto);
		req.setAttribute("replyLists", replyLists);
		
		dao.close();
		mdao.close();
		rdao.close();
		req.getRequestDispatcher("/mvc2/View.jsp").forward(req, resp);
	}
	
	

}
