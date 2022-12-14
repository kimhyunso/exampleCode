package itbank.hb.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import itbank.hb.dao.BordDAO;
import itbank.hb.dto.BordDTO;
import itbank.hb.dto.PageDTO;

@Service
@Component
public class BordService {

	@Autowired
	private BordDAO dao;
	
	
	public BordDTO detail(int idx) {
		return (BordDTO)dao.detail_select(idx);
	}
	
	
	public void insert(int name,BordDTO dto) {
		switch (name) {
		case 1:
			dao.Bord_insert(dto);
			break;
		case 2:
			break;
		}
	}
	
	public void selectOne(int name) {
		switch(name) {
		case 1:
			break;
		case 2:
			break;
		}
	}
	
	public int count(int name) {
		switch(name) {
		case 1:
			return dao.Bord_count();
		case 2:
			return dao.reply_count();
		}
		return 0;
	}
	
	
	public List<?> select (int name,PageDTO pdto) {
		List<?> list;
		switch(name) {
		case 1:
			list = dao.Bord_select(pdto);
			return list;
		case 2:
			list = dao.Bord_selectss(pdto);
			return list;
		case 3:
			list = dao.Reply_select();
			return list;
		}
		return null;
	}
	
	public void delete(int name,int idx) {
		switch(name) {
		case 1:
			dao.Bord_delete(idx);
			break;
		case 2:
			break;
		}
	}
	
}