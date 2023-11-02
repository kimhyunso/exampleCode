package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect{
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		String query ="select count(*) from board";
		if(map.get("searchWord") != null) {
			query += " where "+map.get("searchField") + " "
				  + " Like '%" +map.get("searchWord") +"%'";
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
	
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		String query = "select * from board ";
		if(map.get("searchWord")!=null) {
			query += "where "+map.get("searchField")+" "
					+ " Like '%" + map.get("searchWord") +"%' ";
		}
		query += " order by num "+map.get("sort");
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return bbs;
	}
	
	public List<BoardDTO> selectListPage(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>();
		
		String query = "select * from ( "
					+"    select Tb.*, rownum rNum from (  "
					+"      select * from board ";
		
		if(map.get("searchWord") != null) {
			query += " where "+map.get("searchField")
				  +" LIKE '%" +map.get("searchWord") +"%' ";
		}
		
		query +="      order by num "+map.get("sort")+" "
		      +"                     ) Tb "
		      +" ) "
		      +"where rNum between ? and ?";
		      
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		return bbs;
		
	}
	
	public int insertWrite(BoardDTO dto) {
		int result = 0;
		
		
		try {
			String query = "insert into board ( num, title, content, id, visitcount )"
					+ " values (seq_board_num.NEXTVAL, ?, ?, ?, 0)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		
		String query = "select B.*, M.name from member M inner join board B "
				+"on M.id=B.id where num=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	public void updateVisitCount(String num) {
		String query = "update board set visitcount=visitcount+1 where num=?";
		
		try{
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public int updateEdit(BoardDTO dto) {
		int result = 0;
		try {
			String query = "update board set title=?, content=? where num=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			
		}
		
		return result;
	}
	
	public int deletePost(BoardDTO dto) {
		int result = 0;
		
		try {
			String query = "delete from board where num=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			
		}
		
		
		return result;
	}

	
	
}
