package net.itbank.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class DBConnecter {
	private DB db;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	private Statement st=null;
	private String sql;
	private ArrayList<DTOGuest> list=(ArrayList<DTOGuest>) Collections.synchronizedList(new ArrayList<DTOGuest>());
	private DTOGuest dto;
	private DTOReplyGuest rdto;
	private ArrayList<DTOReplyGuest> rlist=(ArrayList<DTOReplyGuest>)Collections.synchronizedCollection(new ArrayList<DTOReplyGuest>());
	
	public DBConnecter() throws Exception{
		db=new DB();
	}
	
	public void Insert(DTOGuest dto) throws Exception{
		sql="insert into guest values( ? , ? , ? , sysdate , ? , 0 )";
		ps=db.getCon().prepareStatement(sql);
		ps.setInt(1, dto.getSabun());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getTitle());
		ps.setInt(4, dto.getPay());
		ps.executeUpdate();
	}
	
	public void Delete(int sabun) throws Exception{
		st=db.getCon().createStatement();
		sql="delete from guest where sabun = "+sabun;
		st.executeUpdate(sql);
	}
	
	public ArrayList<DTOGuest> AllSelect(DTOPage pdto) throws Exception{
		list=new ArrayList<DTOGuest>();
		st=db.getCon().createStatement();
		sql="select *from (select rownum rn , g.*from ( select *from guest where "+pdto.getSkey()+" like '%"+pdto.getSval()+"%' ) g ) where rn between "+pdto.getStart()+" and  "+pdto.getEnd();
		rs=st.executeQuery(sql);
		
		while(rs.next()) {
			dto=new DTOGuest();
			dto.setRn(rs.getInt("rn"));
			dto.setSabun(rs.getInt("sabun"));
			dto.setName(rs.getString("name"));
			dto.setTitle(rs.getString("title"));
			dto.setNalja(rs.getDate("nalja"));
			dto.setPay(rs.getInt("pay"));
			dto.setPoint(rs.getInt("point"));
			list.add(dto);
		}
		
		return list;
	}
	
	public int Count(DTOPage pdto) throws Exception{
		st=db.getCon().createStatement();
		sql="select count(*) as cnt from guest where "+pdto.getSkey()+" like " +"'%"+pdto.getSval()+"%'";
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	public void point(int sabun) throws Exception{
		st=db.getCon().createStatement();
		sql="update guest set point=point+1 where sabun = "+sabun;
		st.executeUpdate(sql);
	}
	
	
	public DTOGuest Select(int sabun) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from guest where sabun = "+sabun;
		rs=st.executeQuery(sql);
		dto=new DTOGuest();
		
		Statement st1=null;
		ResultSet rs1=null;
		String ssql="select count(*) as cnt from guest g inner join guestreply r on g.sabun=r.sabun and r.sabun = "+sabun;
		st1=db.getCon().createStatement();
		rs1=st1.executeQuery(ssql);
		rs1.next();
		dto.setCnt(rs1.getInt("cnt"));
		
		while(rs.next()) {
			dto.setSabun(rs.getInt("sabun"));
			dto.setName(rs.getString("name"));
			dto.setTitle(rs.getString("title"));
			dto.setNalja(rs.getDate("nalja"));
			dto.setPay(rs.getInt("pay"));
			dto.setPoint(rs.getInt("point"));
		}
		return dto;
	}
	
	public void Update(DTOGuest dto) throws Exception{
		sql="update guest set name = ? , title = ? , nalja = sysdate , pay = ? , point = 0  where sabun = "+dto.getSabun();
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getTitle());
		ps.setInt(3, dto.getPay());
		ps.executeUpdate();
	}
	
	public void ReplyDelete(int sabun) throws Exception{
		st=db.getCon().createStatement();
		sql="delete from guestreply where sabun = "+sabun;
		st.executeUpdate(sql);
	}
	
	public void ReplyInsert(DTOReplyGuest dto) throws Exception{
		sql="insert into guestreply values( 0 , ? , ? , ? )";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getWriter());
		ps.setString(2, dto.getContent());
		ps.setInt(3, dto.getSabun());
		ps.executeUpdate();
	}
	
	public ArrayList<DTOReplyGuest> ReplySelectAll(int sabun) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from ( select rownum rn , r.*from guest g inner join guestreply r on g.sabun=r.sabun and r.sabun = " +sabun+ " )";
		rs=st.executeQuery(sql);
		rlist= new ArrayList<DTOReplyGuest>();
		
		while(rs.next()) {
			rdto=new DTOReplyGuest();
			rdto.setRn(rs.getInt("rn"));
			rdto.setSabun(rs.getInt("sabun"));
			rdto.setContent(rs.getString("content"));
			rdto.setWriter(rs.getString("writer"));
			rlist.add(rdto);
		}	
		return rlist;
	}
}