package model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.board.MVCMemberDAO;
import model2.board.MVCMemberDTO;
import utils.JSFunction;

@WebServlet("/mvc2/member.do")
public class MemberController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/mvc2/Member.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCMemberDTO dto = new MVCMemberDTO();
		MVCMemberDAO dao = new MVCMemberDAO();
		
		dto = dao.selectOne(req.getParameter("id"), req.getParameter("pass"));
		dao.close();
		
		if(dto.getId() == null || dto.getPass() == null) {
			dto = dao.selectOne(req.getParameter("id"), req.getParameter("pass"));
			JSFunction.alertLocation("아이디 또는 비밀번호를 잘못입력하셨습니다.", "../mvc2/member.do", resp);
		}else {
			req.getSession().setAttribute("id", dto.getId());
			req.getSession().setAttribute("pass", dto.getPass());
			req.getSession().setAttribute("nick", dto.getNick());
			JSFunction.alertLocation("로그인에 성공했습니다.", "../mvc2/list.do", resp);
		}
		
	}
	
}
