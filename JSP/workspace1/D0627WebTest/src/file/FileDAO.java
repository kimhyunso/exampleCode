package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.hb.common.DB;


public class FileDAO {
	
	private Connection CN;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//  create table files(
	//   fileName varchar(200),
	//	 fileRealName varchar(200),
	//   downloadCount int
	// );
	

	
	public FileDAO() {
		CN=DB.getConnection();
	}
	
	public int upload(String fileName, String fileRealName) {
		
		String SQL ="insert into files values(?,?,0)";
		PreparedStatement ps;
		try {
			ps = CN.prepareStatement(SQL);
			ps.setString(1, fileName);
			ps.setString(2, fileRealName);
			return ps.executeUpdate();
		} catch (SQLException e) {System.out.println("파일저장에러 " + e);		}
		return -1;
	}//end
	
	
	public ArrayList<FileDTO> getList(){
		String SQL ="select * from files";
		PreparedStatement ps;
		ArrayList<FileDTO> list = new ArrayList<>();
		try {
			ps = CN.prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			while(rs.next()==true) {
				FileDTO file = new FileDTO(rs.getString(1), rs.getString(2) );
				//FileDTO file = new FileDTO(rs.getString(1), rs.getString(2) ,rs.getInt(3));
				System.out.println(rs.getString(1) +" " + rs.getString(2));
				list.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}//class end
