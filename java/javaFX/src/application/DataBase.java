package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
	
	private Connection conn;
	private Statement stmt;
	
	public DataBase() {
		String url="jdbc:mysql://localhost/itbank2?characterEncoding=utf8";
		String user="itbank2";
		String pass="itbank2pass";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loading OK");
			
			conn = DriverManager.getConnection(url,user,pass);
			stmt = conn.createStatement();
			
			System.out.println("DB Connect OK");
		}catch (Exception e) {}
	}
	

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
}
