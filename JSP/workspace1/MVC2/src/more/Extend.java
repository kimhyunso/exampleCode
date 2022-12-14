package more;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Extend{
	protected String sql;
	protected ResultSet rs=null;
	protected PreparedStatement ps=null;
	protected Statement st=null;
	protected DB db=null;
	
	public Extend() throws Exception{
		db=new DB();
	}
	
}
