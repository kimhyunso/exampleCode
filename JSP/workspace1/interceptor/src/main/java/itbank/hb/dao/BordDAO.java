package itbank.hb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import itbank.hb.dto.BordDTO;
import itbank.hb.dto.PageDTO;

@Repository
public class BordDAO {
	//org.mybatis.spring.SqlSessionTemplate

	@Autowired
	private SqlSessionTemplate temp;
	
	public BordDTO detail_select(int idx) {
		return (BordDTO)temp.selectOne("board.selectOne",idx);
	}
	
	public void Bord_insert(BordDTO dto) {
		temp.insert("board.add",dto);
	}
	
	public void Reply_insert() {
		
	}
	
	public int Bord_count() {
		return (Integer)temp.selectOne("board.countAll");
	}
	
	public int reply_count() {
		return 0;
	}
	
	public List<?> Bord_select(PageDTO pdto) {
		return temp.selectList("board.selectAll",pdto);
	}
	
	public List<?> Bord_selectss(PageDTO pdto) {
		return temp.selectList("board.selectss",pdto);
	}
	
	public List<?> Reply_select(){
		return temp.selectList("");
	}
	
	public void Bord_delete(int idx) {
		temp.delete("board.del", idx);
	}
	
	public void reply_delete() {
		
	}
	
}
