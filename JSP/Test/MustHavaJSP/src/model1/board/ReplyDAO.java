package model1.board;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class ReplyDAO extends JDBConnect{
	public ReplyDAO(ServletContext application) {
		super(application);
	}
	
	public List<ReplyDTO> selectAll(String num){
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();

		try {
			String query = "select * from board_reply where bno="+num+" order by rno desc";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setRno(rs.getInt("rno"));
				dto.setBno(rs.getString("bno"));
				dto.setGrp(rs.getInt("grp"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getDate("wdate"));
				
				list.add(dto);
			}
			

		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return list;	
	}
	
	public int insert(ReplyDTO dto) {
		int result = 0;
		
		try {
			String query = "insert into board_reply values(reply_seq.NEXTVAL, ?, ?, ?, sysdate, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getWriter());
			psmt.setInt(2, dto.getGrp());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getBno());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public int update(int rno, String content) {
		int result = 0;
		try{
			String query = "update board_reply set content=?, wdate=sysdate where rno="+rno;
			psmt = con.prepareStatement(query);
			psmt.setString(1, content);
			result = psmt.executeUpdate();
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
	
	public int delet(int rno) {
		int result = 0;
		
		try {
			String query = "delete from board_reply where rno="+rno;
			psmt = con.prepareStatement(query);
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public ReplyDTO selectOne(int rno) {
		ReplyDTO dto = new ReplyDTO();
		
		try{
			String query = "select * from board_reply where rno="+rno;
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getString("bno"));
				dto.setRno(rs.getInt("rno"));
				dto.setContent(rs.getString("content"));
				dto.setGrp(rs.getInt("grp"));
				dto.setWriter(rs.getString("writer"));
				dto.setWdate(rs.getDate("wdate"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	
	}
	
	
}
