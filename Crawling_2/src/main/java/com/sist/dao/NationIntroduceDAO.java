package com.sist.dao;
import java.util.*;
import java.sql.*;
public class NationIntroduceDAO {
   private Connection conn;
   private PreparedStatement ps;
   //private String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private String URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
   
   public NationIntroduceDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
  
   // 2번 => 이용 안내 (InformationUse 내용)
   public void NationIntroduceData(NationIntroduceVO vo) // 30
   { //  NINO nation, title IMAGE TIME WORK_STATE  
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO sul_nation_introduce_2_2(nino,nation,title,image) "
		   		    + "VALUES(sni_nino_seq.nextval,?,?,?)";
		   // SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // 실행전에 ?에 값을 채운다 
		   ps.setString(1, vo.getNation());
		   ps.setString(2, vo.getTitle());
		   ps.setString(3, vo.getImage());
		   // 실행요청 
		   ps.executeUpdate(); //commit()포함 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
}