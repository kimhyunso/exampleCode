package net.itback.com;

import java.util.ArrayList;
import java.util.List;

public class DBGuest extends DBGuestGlobal{
	public DBGuest() {
		DB db=new DB();
		con=db.getConnection();
	}
	
	public void dbinsert(int a,String b,String c,int d) {
		try {
			
			sql="insert into guest values( ? , ? , ? , sysdate , ? )";
			ps=con.prepareStatement(sql);
			ps.setInt(1,a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setInt(4, d);
			
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		
	}
	
	
	public List<?> dbSelect(){
		ArrayList<?> list=new ArrayList<>();
		try {
			
		}catch(Exception e) {
			
		}
		return list;
	}
	public void dbDelete() {
		try {
			
		}catch(Exception e) {
			
		}
	}
	
	public void dbUpdate() {
		try {
			
		}catch(Exception e) {
			
		}
	}
}
