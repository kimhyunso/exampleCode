package fileupload;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class MyFileDAO extends DBConnPool{
	
	public int insertFile(MyFileDTO dto) {
		int result = 0;
		
		try {
			String query = "insert into myfile( idx, name, title, cate, ofile, sfile) values ("
					+"seq_board_num.nextval, ?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			
			result = psmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("Insert 오류");
		}
		return result;
	}
	
	public List<MyFileDTO> myFileList(){
		List<MyFileDTO> list = new Vector<MyFileDTO>();
		
		String query = "select * from myfile order by idx desc";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				list.add(dto);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("Select 오류");
		}
		
		return list;
		
	}
	
	

}
