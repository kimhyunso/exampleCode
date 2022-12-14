package itbank.hb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import itbank.hb.dto.LoginDTO;

@Repository
@Component
public class LoginDAO {

@Autowired
SqlSessionTemplate temp;
	
 	 public List<LoginDTO> dbSelect( ){
		  List<LoginDTO> list=temp.selectList("login.selectAll");
		  return list;
	 }//end
 	 
 	 public String login(LoginDTO dto){
		String dtoRest=temp.selectOne("login.selectDetail",dto);
		System.out.println("�Ѱǻ� ó�� �����  = " +  dtoRest);
 		return  dtoRest;
	 }//end

}//LoginDAO end
