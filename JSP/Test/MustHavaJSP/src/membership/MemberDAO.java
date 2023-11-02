package membership;

import common.JDBConnect;

public class MemberDAO extends JDBConnect{
	public MemberDAO(String drv, String url, String id, String pwd) {
		super(drv,url,id,pwd);
	}
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=? and pass=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	
}
