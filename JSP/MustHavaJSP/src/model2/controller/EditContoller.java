package model2.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import model2.board.MVCBoardDAO;
import model2.board.MVCBoardDTO;
import utils.JSFunction;

@WebServlet("/mvc2/edit.do")
public class EditContoller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		MVCBoardDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/mvc2/Edit.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr == null) {
			JSFunction.alertBack(resp,"첨부 파일이 제한 용량을 초과합니다.");
			return;
		}
		
		String idx = mr.getParameter("idx");
		String prevOfile = mr.getParameter("prevOfile");
		String prevSfile = mr.getParameter("prevSfile");
		String id = req.getSession().getAttribute("id").toString();
		int downcount = Integer.parseInt(mr.getParameter("downcount"));
		int visitcount = Integer.parseInt(mr.getParameter("visitcount"));
		
		String nick = req.getSession().getAttribute("nick").toString();
		
		String content = mr.getParameter("content");
		String title = mr.getParameter("title");
		
		MVCBoardDTO dto = new MVCBoardDTO();
		
		dto.setIdx(idx);
		dto.setId(id);
		dto.setNick(nick);
		dto.setTitle(title);
		dto.setContent(content);
		
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName != null) {
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now + ext;
			
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFileName);
			oldFile.renameTo(newFile);
			
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
			
			FileUtil.deleteFile(req, "/uploads", prevSfile);
		}else {
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}
		
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.updatePost(dto);
		dao.close();
		
		if(result == 1) {
			resp.sendRedirect("../mvc2/view.do?idx="+idx);
		}else {
			JSFunction.alertLocation("아이디가 다릅니다.", "../mvc2/view.do?idx="+idx, resp);
		}
	}
	
	
	

}
