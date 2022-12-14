package itbank.hb.com;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import itbank.hb.dto.BordDTO;
import itbank.hb.dto.PageDTO;

@SuppressWarnings("unchecked")
@Controller
public class BordController {
	private static final Logger logger = LoggerFactory.getLogger(BordController.class);
	
	@Autowired
	@Inject
	private ServletContext application;
	
	
	@Autowired
	@Inject
	private BordService service;
	
	private PageDTO pdto;
	private ModelAndView mav=new ModelAndView();
	private List<?> list;
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String bord_write(Locale locale, Model model) {
		
		return "WEB-INF/views/bordWrite.jsp";
	}
	
	@RequestMapping("/update.do")
	public String bord_update() {
		return "";
	}
	
	public Map<String, String> controllmap(String key,String value){
		Map<String, String> map=new HashMap<String, String>();
		map.put(key, value);
		return map;
	}
	
	public void pageing(String skey,String sval,int pnum,boolean flag) {
		
		pdto=new PageDTO();
		pdto.setSkey(skey);
		pdto.setSval(sval);
		
		if(flag) {
			if(skey.equals("tc")) {
				pdto.setSskey("content");
				pdto.setSkey("title");
			}
		}
		
		pdto.setPnum(pnum);
		pdto.setStart((pdto.getPnum()*10)-9);
		pdto.setEnd(pdto.getStart()+9);
		
		pdto.setTotal((service.count(1)/10)+1);
		
		pdto.setTemp((pdto.getPnum()-1)%10);
		pdto.setPagestart(pdto.getPnum()-pdto.getTemp());
		pdto.setPageend(pdto.getPagestart()+9);
		
		if(pdto.getPageend()>pdto.getTotal()) {
			pdto.setPageend(pdto.getTotal());
		}
	}
	
	
	@RequestMapping(value = "/list.do")
	public ModelAndView bord_list(
			@RequestParam(value="pnum",defaultValue ="1") int pnum,
			@RequestParam(value ="skey",defaultValue="title") String skey,
			@RequestParam(value="sval", defaultValue="") String sval,
			@RequestParam(value="kind", defaultValue="") String kind,
			@RequestParam(value="jsp" , defaultValue="bord") String jsp) {
		
		Map<?, ?> map=(HashMap<String, String>)controllmap(kind, jsp+".jsp");
		
		Iterator<?> it = map.keySet().iterator();
		while(it.hasNext()) {
			String s=(String)it.next();
			System.out.println(s+map.get(s));
		}
		
		
		pageing(skey, sval, pnum, true);
		
		if(pdto.getSskey()==null) {
			list=(List<BordDTO>)service.select(1,pdto);
		}else {
			list=(List<BordDTO>)service.select(2,pdto);
		}
	
		mav.addObject("pdto", pdto);
		mav.addObject("count", service.count(1));
		mav.addObject("list",list);
		mav.setViewName("WEB-INF/views/bordList.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="/insert.do" , method = RequestMethod.POST)
	public String bord_insert(BordDTO dto) {
		
		String path=application.getRealPath("/resources/upload");
		String img=dto.getUpload_f().getOriginalFilename();
		try {
			File file=new File(path,img);
			dto.getUpload_f().transferTo(file);
			dto.setImg_file_name(img);
			service.insert(1,dto);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return "redirect:/list.do";
	}
	
	
	@RequestMapping("/detail.do")
	public ModelAndView bord_detail(
			@RequestParam("idx") int idx,
			@RequestParam(value="skey", defaultValue="") String skey,
			@RequestParam(value="sval", defaultValue="") String sval,
			@RequestParam(value="pnum", defaultValue="1") int pnum) {
		
		pageing(skey, sval, pnum, false);
		mav.addObject("dto",service.detail(idx));
		mav.setViewName("WEB-INF/views/bordDetail.jsp");
		return mav;
	}
	
	@RequestMapping("/delete.do")
	public String bord_delete(@RequestParam("idx") int idx) {
		service.delete(1,idx);
		return "redirect:/list.do";
	}
	
	
}