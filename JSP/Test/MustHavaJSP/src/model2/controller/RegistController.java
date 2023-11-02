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

@WebServlet("/mvc2/regist.do")
public class RegistController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/mvc2/Regist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCMemberDTO dto = new MVCMemberDTO();
		MVCMemberDAO dao = new MVCMemberDAO();
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String nick = req.getParameter("nick");
		
		dto.setId(id);
		dto.setPass(pass);
		dto.setNick(nick);
		
		int result = dao.insert(dto);
		
		dao.close();
		
		if(result == 1) {
			JSFunction.alertLocation("중복된 아이디 입니다.", "../mvc2/regist.do", resp);
		}else {
			JSFunction.alertLocation("회원가입되었습니다.", "../mvc2/member.do", resp);
		}
	}
	

}
