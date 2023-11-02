package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

class MyDB{
	
	public MyDB() {
		String url="jdbc:mysql://localhost/itbank2?characterEncoding=utf8";
		String user="itbank2";
		String pass="itbank2pass";
		
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loading OK");
			
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("DB Connect OK");
			
			Statement stmt = conn.createStatement();
			String sql;
			int affectedRowCount=0;
			
			//데이터에 영향을 미치는 질의 : INSERT , UPDATE , DELETE
			sql="";
			//sql=sql.format("insert into second_table (id,name,age,time) values ('test','tester2',34,now()) ");
			sql="update second_table set age='77' where idx<100 ";
			affectedRowCount = stmt.executeUpdate(sql);
			System.out.println(affectedRowCount);
			
			//데이터에 영향을 미치지 않는 질의 :SELECT 
			sql="select *from second_table";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			int count=0;
			while(rs.next()) {
				//idx , id ,name ,age ,time
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Timestamp time=rs.getTimestamp("time");
				
				count++;
				System.out.print("cnt = "+count+" , ");
				System.out.print("id = "+id+" , ");
				System.out.print("name = "+name+" , ");
				System.out.print("age = "+age+" , ");
				System.out.print("time = "+time+" , "+"\n");
				
				String result="";
				result= result.format("(cnt,idx,id,name,age,time) = (%d,%d,%s,%s,%d,%s)", count,idx,id,name,age,time);
				System.out.println(result);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
	}
	
}


public class Test {
	public static void main(String[] args) {
		MyDB db=new MyDB();
	}
}
