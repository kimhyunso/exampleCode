package net.itback.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection() {
		Connection con=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="system";
		String pw="oracle";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,id,pw);
		}catch(Exception e){
			System.out.print("연결실패");
		}
		return con;
	}
}
