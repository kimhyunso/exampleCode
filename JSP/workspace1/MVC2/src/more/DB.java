package more;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private Connection con=null;
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String id="system";
	private String pw="oracle";
	
	public DB() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,id,pw);
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
}
