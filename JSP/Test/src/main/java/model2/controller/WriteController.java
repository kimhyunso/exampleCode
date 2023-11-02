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
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import model2.board.MVCBoardDAO;
import model2.board.MVCBoardDTO;
import utils.JSFunction;


@WebServlet("/mvc2/write.do")
public class WriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/mvc2/Write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nick = req.getSession().getAttribute("nick").toString();
		String id = req.getSession().getAttribute("id").toString();
		
		if(id == null || id.equals("")) {
			JSFunction.alertLocation("로그인을 해주세요.", "../mvc2/member.do", resp);
			return;
		}
		
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		
		ServletContext application = getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr == null) {
			JSFunction.alertLocation("첨부 파일이 제한 용량을 초과합니다.", "../mvc2/write.do", resp);
			return;
		}
		
		MVCBoardDTO dto = new MVCBoardDTO();
		
		
		
		dto.setId(id);
		dto.setNick(nick);
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName != null) {
			String now = new SimpleDateFormat("yyyyMMdd").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now + ext;
		
			File oldFile = new File(saveDirectory + File.separator +fileName);
			File newFile = new File(saveDirectory + File.separator +newFileName);
			oldFile.renameTo(newFile);
			
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
		}
		
		
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.insertWrite(dto);
		dao.close();
		
		if(result == 1) {
			resp.sendRedirect("../mvc2/list.do");
		}else {
			resp.sendRedirect("../mvc2/write.do");
		}
	}
	

}
