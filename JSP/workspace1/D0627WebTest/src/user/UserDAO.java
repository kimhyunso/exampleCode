package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.hb.common.DB;

public class UserDAO {
	private Connection CN;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		 CN=DB.getConnection();
	}//end
	
	public int login(int sabun,String pwd ) {
		String SQL = "select b_pwd from bbs where b_sabun=?";
		try {
			pstmt = CN.prepareStatement(SQL);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("b_pwd").equals(pwd))
					return 1;
				else
					return 0;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2;
	}//end
	
	public int join(UserDTO user) {
		String SQL ="insert into bbs values(bbs_seq.nextval,?,?,?,0,?,?,?,sysdate,?,?,?,'','',0)";
		try {
			pstmt= CN.prepareStatement(SQL);
			pstmt.setInt(1, user.getSabun());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getTitle());
			pstmt.setString(4, user.getContent());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getPwd());
			pstmt.setString(7, user.getJuso1());
			pstmt.setString(8, user.getJuso2());
			pstmt.setString(9, user.getEmail());
			System.out.println( " 넘어온사번: " + user.getSabun() );
			System.out.println( " 넘어온이름: " + user.getName() );
			System.out.println( " 넘어온제목: " + user.getTitle() );
			System.out.println( " 넘어온내용: " + user.getContent() );
			System.out.println( " 넘어온전화번호: " + user.getPhone() );
			System.out.println( " 넘어온비밀번호: " + user.getPwd() );
			System.out.println( " 넘어온주소1: " + user.getJuso1() );
			System.out.println( " 넘어온주소2: " + user.getJuso2() );
			System.out.println( " 넘어온메일: " + user.getEmail() );
			return pstmt.executeUpdate();
		} catch (SQLException e) {System.out.println("저장에러 "+ e);	}
		return -1;
	}//end
	
	public int getNext() {
		String SQLs ="select b_no from bbs order by b_no desc";
		try {
			PreparedStatement psSub = CN.prepareStatement(SQLs);
			ResultSet rsSub = psSub.executeQuery();
			if(rsSub.next()) {
				System.out.println("rs: "+rsSub.getInt(1));
				return rsSub.getInt(1)+1;
			}else
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}//end
	
	public ArrayList<UserDTO> getList(int pageNumber){
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		String SQL = "SELECT * FROM (SELECT * FROM BBS WHERE b_no < ? ORDER BY b_no desc) WHERE ROWNUM BETWEEN 1 AND 10 ";
		int last = getNext()-(pageNumber-1)*10;
		try {
			pstmt=CN.prepareStatement(SQL);
			System.out.println("next "+getNext());
			pstmt.setInt(1, last);
			rs =pstmt.executeQuery();
			while(rs.next()==true) {
				UserDTO user = new UserDTO();
				user.setNo(rs.getInt("b_no"));
				user.setSabun(rs.getInt("b_sabun"));
				user.setName(rs.getString("b_name"));
				user.setTitle(rs.getString("b_title"));
				user.setContent(rs.getString("b_content"));
				user.setPhone(rs.getString("b_phone"));
				user.setPwd(rs.getString("b_pwd"));
				user.setWdate(rs.getDate("b_wdate"));
				user.setJuso1(rs.getString("b_juso1"));
				user.setJuso2(rs.getString("b_juso2"));
				user.setEmail(rs.getString("b_email"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}//end
	
	public boolean nextPage(int pageNumber){
		String SQL = "SELECT * FROM BBS WHERE b_no < ? ";
		try {
			pstmt=CN.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
			rs =pstmt.executeQuery();
			if(rs.next())
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end
	
	public UserDTO getUser(int no) {
		String SQL = "SELECT * from bbs where b_no=?";
		try {
			pstmt=CN.prepareStatement(SQL);
			System.out.println("next "+getNext());
			pstmt.setInt(1, no);
			rs =pstmt.executeQuery();
			if(rs.next()==true) {
				UserDTO user = new UserDTO();
				user.setNo(rs.getInt("b_no"));
				user.setSabun(rs.getInt("b_sabun"));
				user.setName(rs.getString("b_name"));
				user.setTitle(rs.getString("b_title"));
				user.setContent(rs.getString("b_content"));
				user.setPhone(rs.getString("b_phone"));
				user.setPwd(rs.getString("b_pwd"));
				user.setCnt(rs.getInt("b_cnt"));
				user.setWdate(rs.getDate("b_wdate"));
				user.setJuso1(rs.getString("b_juso1"));
				user.setJuso2(rs.getString("b_juso2"));
				user.setEmail(rs.getString("b_email"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}//end
	
	public ArrayList<UserDTO> search(String name){
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		String SQL = "SELECT * FROM bbs where b_name like ? ";
		try {
			pstmt=CN.prepareStatement(SQL);
			pstmt.setString(1, "%"+name+"%");
			rs =pstmt.executeQuery();
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setNo(rs.getInt("b_no"));
				user.setSabun(rs.getInt("b_sabun"));
				user.setName(rs.getString("b_name"));
				user.setTitle(rs.getString("b_title"));
				user.setContent(rs.getString("b_content"));
				user.setPhone(rs.getString("b_phone"));
				user.setPwd(rs.getString("b_pwd"));
				user.setWdate(rs.getDate("b_wdate"));
				user.setJuso1(rs.getString("b_juso1"));
				user.setJuso2(rs.getString("b_juso2"));
				user.setEmail(rs.getString("b_email"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}//end
	
	public int updateCnt(int cnt, int sabun) {
		String SQL = "update  bbs set b_cnt=? where b_sabun=? ";
		try {
			pstmt=CN.prepareStatement(SQL);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, sabun);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}//end
	
}//class END
