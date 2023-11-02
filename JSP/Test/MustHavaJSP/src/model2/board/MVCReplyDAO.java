package model2.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.DBConnPool;
import model1.board.ReplyDTO;

public class MVCReplyDAO extends DBConnPool{
	public MVCReplyDAO() {
		super();
	}
	
	public MVCReplyDTO selectOne(String ridx) {
		MVCReplyDTO dto = new MVCReplyDTO();
		
		String query = "select * from reply where idx = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, ridx);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setRidx(rs.getString("ridx"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setNick(rs.getString("nick"));
				dto.setRdate(rs.getDate("rdate"));
				dto.setRgroup(rs.getInt("rgroup"));
				dto.setCl(rs.getInt("class"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	public List<MVCReplyDTO> selectAll(String idx){
		List<MVCReplyDTO> list = new ArrayList<MVCReplyDTO>();
		
		try {
			
			String query = "select * from reply where rgroup = ? order by ridx desc";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MVCReplyDTO dto = new MVCReplyDTO();
				dto.setRidx(rs.getString("ridx"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setNick(rs.getString("nick"));
				dto.setRdate(rs.getDate("rdate"));
				dto.setRgroup(rs.getInt("rgroup"));
				dto.setCl(rs.getInt("class"));
				
				list.add(dto);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public int insert(MVCReplyDTO dto) {
		int result = 0;
		
		String query = "insert into reply (ridx, id, content, nick, rgroup, class) "
				+ "values (seq_reply_num.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNick());
			psmt.setInt(4, dto.getRgroup());
			psmt.setInt(5, dto.getCl());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int delete(String idx, String ridx) {
		int result = 0;
		String query = "delete from reply where rgroup = ? and ridx = ? ";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.setString(2, ridx);
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int update(MVCReplyDTO dto) {
		int result = 0;
		String query = "update reply set content = ? where ridx = ? and rgroup = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getContent());
			psmt.setString(2, dto.getRidx());
			psmt.setInt(3, dto.getRgroup());
			
			result = psmt.executeUpdate();
		}catch (Exception e) {
			
		}
				
		return result;
		
	}
	
	

}
