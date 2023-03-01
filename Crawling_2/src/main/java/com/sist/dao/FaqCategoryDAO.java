package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FaqCategoryDAO {
   private Connection conn;
   private PreparedStatement ps;
   private String URL="jdbc:oracle:thin:@localhost:1521:XE";
   //private String URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
   
   public FaqCategoryDAO()
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
   public void FaqCategoryData(FaqCategoryVO vo) // 30
   { // SFCNO CATE  
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO sul_faq_category_2_2 VALUES(sfc_fcno_seq.nextval,?)";
		   // SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // 실행전에 ?에 값을 채운다 
		   ps.setString(1, vo.getCate());
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