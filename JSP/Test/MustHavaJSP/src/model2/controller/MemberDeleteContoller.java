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

@WebServlet("/mvc2/memberDelete.do")
public class MemberDeleteContoller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MVCMemberDTO dto = new MVCMemberDTO();
		MVCMemberDAO dao = new MVCMemberDAO();
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		dto.setId(id);
		dto.setPass(pass);
		
		int result = dao.delete(dto);
		dao.close();
		
		if(result == 1) {
			JSFunction.alertLocation("회원 탈퇴되었습니다.", "../mvc2/list.do", resp);
		}else {
			JSFunction.alertLocation("회원 탈퇴에 실패했습니다.", "../mvc2/list.do", resp);
		}
	}
}
