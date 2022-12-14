package Bord;

import java.util.ArrayList;
import java.util.Date;

import List.DTOList;
import List.DTOWishList;
import Login.DTOLogin;
import Reply.DTOReply;
import member.DTOMember;
import more.DTOPage;
import more.Extend;

public class DAOBord extends Extend{
	
	private ArrayList<DTOBord> list=new ArrayList<DTOBord>();
	private DTOBord dto;
	
	private DTOReply redto;
	private ArrayList<DTOReply> relist=new ArrayList<DTOReply>();
	
	private DTOLogin logindto;
	private ArrayList<DTOLogin> loginlist=new ArrayList<DTOLogin>();
	
	private DTOList ldto;
	private ArrayList<DTOList> llist=new ArrayList<DTOList>();
	
	private DTOWishList wishdto;
	private ArrayList<DTOWishList> wishlist=new ArrayList<DTOWishList>();
	
	public DAOBord() throws Exception{
	}
	
	public int Count(DTOPage pdto) throws Exception{
		st=db.getCon().createStatement();
		sql="select count (*) as cnt from bord where content like '%"+pdto.getSval()+"%'";
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	public synchronized DTOBord Select(int num) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from bord where num = "+num;
		rs=st.executeQuery(sql);
		dto=new DTOBord();
		
		while(rs.next()) {
			dto.setNum(rs.getInt("num"));
			dto.setCo_date(rs.getDate("co_date"));
			dto.setUser_id(rs.getString("user_id"));
			dto.setUser_pw(rs.getString("user_pw"));
			dto.setImg(rs.getString("img"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
		}
		return dto;
	}
	
	public synchronized ArrayList<DTOBord> SelectAll(DTOPage pdto) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from (select rownum rn , b.* from bord b where content like '%"+pdto.getSval()+"%' ) where rn between "+pdto.getStart()+" and "+pdto.getEnd();
		rs=st.executeQuery(sql);
		
		while(rs.next()) {
			dto=new DTOBord();
			dto.setNum(rs.getInt("num"));
			dto.setRn(rs.getInt("rn"));
			dto.setCo_date(rs.getDate("co_date"));
			dto.setUser_id(rs.getString("user_id"));
			dto.setUser_pw(rs.getString("user_pw"));
			dto.setImg(rs.getString("img"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			list.add(dto);
		}
		return list;
	}
	
	public void ReplyInsert(DTOReply dto) throws Exception{
		sql="insert into bordreply values( ? , ? , ? , ? ,bordreply_seq.nextval,'reply.png', ?  ,sysdate, ? )";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.setString(2, dto.getUser_pw());
		ps.setString(3, dto.getNickname());
		ps.setInt(4, dto.getNum());
		ps.setString(5, dto.getContent());
		ps.setInt(6, 0);
		ps.executeUpdate();
	}
 	
	public int ReplyCount(int num) throws Exception{
		sql="select count (*) as cnt from (select rownum rn , r.content , r.img, r.num, r.re_date, b.user_id from bordreply r inner join bord b on r.num=b.num and r.num = "+num+" )";
		st=db.getCon().createStatement();
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	public int ReplyMCount(int num)throws Exception{
		sql="select count(*) as cnt from bordreply where num = "+num;
		st=db.getCon().createStatement();
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	
	public void ReplyDelete(DTOReply dto) throws Exception{
		sql="delete from bordreply where kind = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setInt(1, dto.getKind());
		ps.executeUpdate();
	}
	
	public synchronized ArrayList<DTOReply> ReplySelectAll(DTOPage dto,int num) throws Exception{
		sql="select *from ( select rownum rn , r.content , r.img , r.num , r.re_date , r.kind , b.user_id , b.user_pw , r.nickname from bordreply r inner join bord b on r.num=b.num and r.num = "+num+" ) where rn between "+dto.getStart()+" and "+dto.getEnd();
		st=db.getCon().createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			redto=new DTOReply();
			redto.setNum(rs.getInt("num"));
			redto.setNickname(rs.getString("nickname"));
			redto.setKind(rs.getInt("kind"));
			redto.setImg(rs.getString("img"));
			redto.setDate(rs.getDate("re_date"));
			redto.setContent(rs.getString("content"));
			redto.setUser_id(rs.getString("user_id"));
			redto.setUser_pw(rs.getString("user_pw"));
			relist.add(redto);
		}
		
		return relist;
	}
	
	public DTOReply ReplySelect(int kind) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from bordreply where kind =  "+kind;
		rs=st.executeQuery(sql);
		redto=new DTOReply();
		while(rs.next()) {
			redto.setUser_id(rs.getString("user_id"));
			redto.setUser_pw(rs.getString("user_pw"));
			redto.setNickname(rs.getString("nickname"));
			redto.setNum(rs.getInt("num"));
			redto.setKind(rs.getInt("kind"));
			redto.setImg(rs.getString("img"));
			redto.setContent(rs.getString("content"));
			redto.setDate(rs.getDate("re_date"));
			redto.setView_count(rs.getInt("reply_view"));
		}
		return redto;
	}
	
	public void ReplyUpdate(DTOReply dto) throws Exception{
		sql="update bordreply set content = ? where kind = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getContent());
		ps.setInt(2, dto.getKind());
		ps.executeUpdate();
	}
	
	public synchronized ArrayList<DTOLogin> LoginSelectAll() throws Exception{
		st=db.getCon().createStatement();
		sql="select *from login ";
		rs=st.executeQuery(sql);
		
		while(rs.next()) {
			logindto =new DTOLogin();
			logindto.setUser_id(rs.getString("user_id"));
			logindto.setUser_pw(rs.getString("user_pw"));
			logindto.setNickname(rs.getString("nickname"));
			loginlist.add(logindto);
		}
		
		return loginlist;
	}
	
	public int LoginSelect(String id) throws Exception{
		sql="select *from login where user_id = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	public DTOLogin LoginSelectDTO(String id) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from login where user_id =  '"+id+"'";
		logindto=new DTOLogin();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			logindto.setUser_id(rs.getString("user_id"));
			logindto.setUser_pw(rs.getString("user_pw"));
			logindto.setNickname(rs.getString("nickname"));
			logindto.setDelable(rs.getInt("delable"));
		}
		return logindto;
	}
	
	public boolean LoginSelect(DTOLogin dto) throws Exception{
		boolean check=false;
		st=db.getCon().createStatement();
		sql="select *from login where user_id = '"+dto.getUser_id()+"' and user_pw = '"+dto.getUser_pw()+"'";
		rs=st.executeQuery(sql);
		if(rs.next()) {
			dto.setNickname(rs.getString("nickname"));
			dto.setDelable(rs.getInt("delable"));
			check=true;
		}
		return check;
	}
	
	public void LoginInsert(DTOMember dto) throws Exception{
		sql="insert into login values( ? , ? , ? , ? )";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.setString(2, dto.getUser_pw());
		ps.setString(3, dto.getNickname());
		ps.setInt(4, 0);
		
		ps.executeUpdate();
	}
	
	public void LoginDelete(String id) throws Exception{
		sql="delete from login where user_id = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
	}
	
	
	public int ListCount(DTOPage dto,String id,String pw) throws Exception{
		st=db.getCon().createStatement();
		sql="select count(*) as cnt from (select *from list l inner join bord b on l.num=b.num and l.user_id = '"+id+"' ) where "+dto.getSkey()+" like '%"+dto.getSval()+"%'";
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	public synchronized ArrayList<DTOList> ListSelectAll(DTOPage dto,String id,String pw) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from (select rownum rn, g.*from (select *from bord b inner join list l on b.num=l.num and l.user_id = '"+id+"' )g where "+dto.getSkey()+" like '%"+dto.getSval()+"%' )where rn between "+dto.getStart()+" and "+dto.getEnd();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			ldto=new DTOList();
			ldto.setUser_id(rs.getString("user_id"));
			ldto.setUser_pw(rs.getString("user_pw"));
			ldto.setCount(rs.getInt("count"));
			ldto.setNum(rs.getInt("num"));
			ldto.setOption(rs.getString("op"));
			ldto.setImg(rs.getString("img"));
			ldto.setTitle(rs.getString("title"));
			ldto.setContent(rs.getString("content"));
			ldto.setKind(rs.getInt("kind"));
			llist.add(ldto);
		}
		return llist;
	}
	
	public void ListInsert(DTOList dto) throws Exception{
		sql="insert into list values( ? , ? , ? , list_seq.nextval , ? , ? , ?)";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.setString(2, dto.getUser_pw());
		ps.setString(3, dto.getNick());
		ps.setInt(4, dto.getCount());
		ps.setString(5, dto.getOption());
		ps.setInt(6, dto.getNum());
		ps.executeUpdate();
	}
	
	public void ListDelete(DTOList dto) throws Exception{
		sql="delete from list where kind = ? and user_id = ? and user_pw = ?";
		ps=db.getCon().prepareStatement(sql);
		ps.setInt(1, dto.getKind());
		ps.setString(2, dto.getUser_id());
		ps.setString(3, dto.getUser_pw());
		ps.executeUpdate();
	}
	
	public void MemberDelete(String id) throws Exception{
		sql="delete from member where user_id = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
	}
	
	public void MemberInsert(DTOMember dto) throws Exception{
		sql="insert into member values( ? , ? , ? , ? , ? , ? , sysdate )";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.setString(2, dto.getUser_pw());
		ps.setString(3, dto.getNickname());
		ps.setString(4, dto.getEmail());
		ps.setString(5, dto.getLocation());
		ps.setString(6, dto.getJob());
		ps.executeUpdate();
	}
	
	public int Who(String who,String data) throws Exception{
		sql="select *from member where "+who+" = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, data);
		return ps.executeUpdate();
	}
	
	public String MemberSelectW(DTOMember dto) throws Exception{
		String who=null;
		int n;
		
		n = Who("user_id", dto.getUser_id());
		if(n!=0) {
			who="아이디";
			return who;
		}
		
		n = Who("user_pw", dto.getUser_pw());
		if(n!=0) {
			who="비밀번호";
			return who;
		}
		
		n = Who("nickname", dto.getNickname());
		if(n!=0) {
			who="닉네임";
			return who;
		}
		
		n = Who("email", dto.getEmail());
		if(n!=0) {
			who="이메일";
			return who;
		}
		
		return who;
	}
	
	public int MemberSelect(String id) throws Exception{
		sql="select *from member where user_id = ? ";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	public int WishListCount(DTOPage dto,String id) throws Exception{
		sql="select count(*) as cnt from (select *from wishlist l inner join bord b on l.num=b.num and l.user_id = '"+id+"' ) where "+dto.getSkey()+" like '%"+dto.getSval()+"%'";
		rs=st.executeQuery(sql);
		rs.next();
		return rs.getInt("cnt");
	}
	
	public void WishListInsert(DTOWishList dto) throws Exception{
		sql="insert into wishlist values( ? , ? , ? , wishlist_seq.nextval , ? , ? , ? , ?)";
		ps=db.getCon().prepareStatement(sql);
		ps.setString(1, dto.getUser_id());
		ps.setString(2, dto.getUser_pw());
		ps.setString(3, dto.getNick());
		ps.setInt(4, dto.getCount());
		ps.setString(5, dto.getOp());
		ps.setInt(6, dto.getNum());
		ps.setInt(7, 0);
		ps.executeUpdate();
	}
	
	public void WishListDelete(int kind) throws Exception{
		sql="delete from wishlist where kind = ?";
		ps=db.getCon().prepareStatement(sql);
		ps.setInt(1, kind);
		ps.executeUpdate();
	}	
	
	public synchronized ArrayList<DTOWishList> WishListSelectAll(DTOPage dto,String id,String pw) throws Exception{
		st=db.getCon().createStatement();
		sql="select *from (select rownum rn , w.*from (select *from bord b inner join wishlist l on b.num=l.num and l.user_id = '"+id+"' )w where "+dto.getSkey()+" like '%"+dto.getSval()+"%' )where rn between "+dto.getStart()+" and "+dto.getEnd();
		rs=st.executeQuery(sql);
		while(rs.next()) {
			wishdto=new DTOWishList();
			wishdto.setUser_id(rs.getString("user_id"));
			wishdto.setUser_pw(rs.getString("user_pw"));
			wishdto.setCount(rs.getInt("count"));
			wishdto.setNum(rs.getInt("num"));
			wishdto.setOp(rs.getString("op"));
			wishdto.setImg(rs.getString("img"));
			wishdto.setTitle(rs.getString("title"));
			wishdto.setContent(rs.getString("content"));
			wishdto.setKind(rs.getInt("kind"));
			wishdto.setGrade(rs.getInt("grade"));
			wishlist.add(wishdto);
		}
		return wishlist;
	}
	
}