package model2.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;

public class MVCBoardDAO extends DBConnPool{
	
	public MVCBoardDAO() {
		super();
	}
	
	
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		
		String query =  "select count(*) from board";
		
		if(map.get("searchWord") != null) {
			query += " where "+map.get("searchField")+ " "
					+" like '%"+map.get("searchWord")+"%' ";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return totalCount;
	}
	
	
	
	public List<MVCBoardDTO> selectAll(Map<String, Object> map){
		List<MVCBoardDTO> list = new ArrayList<MVCBoardDTO>();
		
		try {
			String query = "select * from "
					+ "( select Tb.*, rownum rNum from ("
					+ "   select * from board ";
			if(map.get("searchWord") != null) {
				query += " where "+map.get("searchField")
					  +" like '%"+map.get("searchWord")+"%' ";
			}
			
			query +=" order by idx desc " 
					+"  )Tb  "
				  +" ) "
				  +" where rNum between ? and ? ";
			
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MVCBoardDTO dto = new MVCBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setNick(rs.getString("nick"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			
		}
		
		return list;
	}
	
	public int insertWrite(MVCBoardDTO dto) {
		int result = 0;
		String query = "insert into board ( idx, id, title, content, ofile, sfile, nick ) "
				+ "values (seq_board_num.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try{
			
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getNick());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	
	public MVCBoardDTO selectView(String idx) {
		MVCBoardDTO dto = new MVCBoardDTO();
		
		String query = "select * from board where idx = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setIdx(rs.getString("idx"));
				dto.setNick(rs.getString("nick"));
				dto.setContent(rs.getString("content"));
				dto.setTitle(rs.getString("title"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setId(rs.getString("id"));
			}
			
		}catch(Exception e) {
			
		}
		
		return dto;
	}
	
	public void updateVisitCount(String idx) {
		String query = "update board set visitcount=visitcount+1 where idx = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeQuery();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void downCountPlus(String idx) {
		String query = "update board set downcount=downcount+1 where idx = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int deletePost(String idx) {
		int result = 0;
		String query = "delete from board where idx = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int updatePost(MVCBoardDTO dto) {
		int result = 0;
		String query = "update board set title=?, nick=?, content=?, ofile=?, sfile=? where idx=? and id=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getNick());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getIdx());
			psmt.setString(7, dto.getId());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}

}
