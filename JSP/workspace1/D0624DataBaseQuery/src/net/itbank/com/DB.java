package net.itbank.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private Connection con=null;
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String user="system";
	private String password="oracle";
	
	public DB() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url, user, password);
	}

	public Connection getCon() {
		return con;
	}
	
}
