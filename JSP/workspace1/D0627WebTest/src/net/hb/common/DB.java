package net.hb.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
   public static Connection getConnection( ){
  	 Connection CN=null;
  	 try{
  		  //����1 ����Ŭ����̺� ���̺귯�� �ε�, database���� ����ϴ� ����޶��
  		  Class.forName("oracle.jdbc.driver.OracleDriver");
  		  //����2 Database��������,����id,��й�ȣ�� CN���� �����Ѽ� ���߿� ��ɾ����
  		  String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
  		  CN=DriverManager.getConnection(url,"system", "oracle");
  		  //System.out.println("db���Ἲ�� db�۾����� 06-17-������ "); //���߿��ּ�ó��
  		 }catch(Exception ex){System.out.println("db�������:" +ex); }
  	 return CN;
   }//end
}//end
