package itbank.hb.com;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import itbank.hb.dao.LoginDAO;
import itbank.hb.dto.LoginDTO;

@Controller
public class LoginController {
	
	@Autowired
	LoginDAO loginDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	@RequestMapping(value="login.do",method=RequestMethod.GET)
	 public String login(Model model){
		return "WEB-INF/views/login.jsp"; 
	}//end
	
	@RequestMapping(value="loginprocess.do")
	public String loginprocess(LoginDTO dto, HttpServletResponse response, HttpSession session)	throws Exception
	{
		System.out.println("\n�α�����Ʈ��ó���� �Ѿ��userid=" + dto.getUserid() );
		System.out.println("�α�����Ʈ��ó���� �Ѿ��pwd=" + dto.getPwd());
		
		String result=null ;
		result=loginDAO.login(dto);	
		session.setAttribute("daum",result );
				
		if(result==null || result=="" ){
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().append("<script>"
							+ "alert('LoginController ���̵� ��й�ȣ�� ��ġ�����ʽ��ϴ�.');"
				        		 + "window.history.back();"
							  + "</script>").flush();
			return "redirect:/login.do";
		}
		//������ ��쿡�� ������������ �̵�
		return "redirect:/list.do";
	}//end
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session){
		//���� �ʱ�ȭ
		session.invalidate(); 
		//������������ �����̷�Ʈ
		return "redirect:/index.jsp";
	}//end
	
}//LoginController class END