package model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileupload.FileUtil;
import model2.board.MVCBoardDAO;
import model2.board.MVCBoardDTO;
import utils.JSFunction;


@WebServlet("/mvc2/pass.do")
public class PassController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mode = req.getParameter("mode");
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardDTO dto;
		
		
		if(mode.equals("edit")) {
			resp.sendRedirect("../mvc2/edit.do?idx="+idx+"&mode=delete");
		}else if(mode.equals("delete")) {
			int result = dao.deletePost(idx);
			dto = dao.selectView(idx);
			dao.close();
			
			
			if(result == 1) {
				String saveFileName = dto.getSfile();
				FileUtil.deleteFile(req, "/uploads", saveFileName);
			}
			JSFunction.alertLocation("삭제되었습니다.","../mvc2/list.do",resp);
		}
	}

}
