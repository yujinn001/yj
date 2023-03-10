package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FaqDAO {
   private Connection conn;
   private PreparedStatement ps;
   private String URL="jdbc:oracle:thin:@localhost:1521:XE";
   //private String URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
   
   public FaqDAO()
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
   // 1번 => Faq 내용 추가
   public void FaqInsertData(FaqVO vo) // 30
   { // fno TYPE    SUBJECT CONTENT    
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO sul_faq_2_2(fno,type,subject,content,fcno) VALUES(sf_fno_seq.nextval,?,?,?,?)";
		   // SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // 실행전에 ?에 값을 채운다 
		   ps.setString(1, vo.getType());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setInt(4, vo.getFcno());
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