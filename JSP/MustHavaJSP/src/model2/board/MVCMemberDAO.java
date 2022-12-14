package model2.board;

import common.DBConnPool;

public class MVCMemberDAO extends DBConnPool{
	
	public MVCMemberDAO() {
		super();
	}
	
	public MVCMemberDTO selectOne(String id, String pass) {
		MVCMemberDTO dto = new MVCMemberDTO();
		
		String query = "select * from member where id = ? and pass = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setNick(rs.getString("nick"));
				dto.setRdate(rs.getDate("date"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	public int insert(MVCMemberDTO dto) {
		int result = 0;
		
		String query = "insert into member (midx, id, pass, nick) values (seq_member_num.NEXTVAL, ?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getNick());
			
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	public int delete(MVCMemberDTO dto) {
		int result = 0;
		
		String query = "delete from member where id = ? and pass = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	

}
