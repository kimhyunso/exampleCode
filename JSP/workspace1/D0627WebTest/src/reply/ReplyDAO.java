package reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.hb.common.DB;

public class ReplyDAO {
	
	Connection CN;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ReplyDAO() {
    CN=DB.getConnection();
	}//end
	
	public int insertReply(ReplyDTO dto) {
		String SQL ="insert into bbsreply values(bbsreply_seq.nextVal,?,?,sysdate,?)";
		try {
			pstmt= CN.prepareStatement(SQL);
			pstmt.setString(1, dto.getBr_writer());
			pstmt.setString(2, dto.getBr_content());
			pstmt.setInt(3, dto.getBr_sabun());
			return pstmt.executeUpdate();
		} catch (SQLException e) { }
		return -1;
	}
	public ArrayList<ReplyDTO> getList(int br_sabun){
		ArrayList<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		String SQL = "SELECT * FROM  bbsreply WHERE br_sabun=?";
		try {
			pstmt=CN.prepareStatement(SQL);
			pstmt.setInt(1, br_sabun);
			rs =pstmt.executeQuery();
			while(rs.next()==true) {
				ReplyDTO reply = new ReplyDTO();
				reply.setBr_num(rs.getInt(1));
				reply.setBr_writer(rs.getString(2));
				reply.setBr_content(rs.getString(3));
				reply.setBr_date(rs.getDate(4));
				reply.setBr_sabun(rs.getInt(5));
				replyList.add(reply);  //Áß¿ä
			}
		} catch (SQLException e) {	}
		return replyList;
	}
}//class END
