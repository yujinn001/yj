package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FaqDAO {
   private Connection conn;
   private PreparedStatement ps;
   private String URL="jdbc:oracle:thin:@localhost:1521:XE";
   
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
		   String sql="INSERT INTO sul_faq_2_2(fno,type,subject,content) VALUES(sf_fno_seq.nextval,?,?,?)";
		   // SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // 실행전에 ?에 값을 채운다 
		   ps.setString(1, vo.getType());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
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
  
   
   // 카테고리에서 카테고리 번호  , 제목 => findByCno() 
   // Faq 내용 추가
  /* public ArrayList<FaqVO> faqInfoData()
   {// fno TYPE    SUBJECT CONTENT 
	   ArrayList<FaqVO> list=new ArrayList<FaqVO>();
	   try
	   {
		   //1. 연결 
		   getConnection();
		   //2. SQL문장 제작 
		   String sql="SELECT fno,cate,type,subject,content FROM sul_faq_2_2 ORDER BY cno ASC";
		   //3. SQL문장 전송
		   ps=conn.prepareStatement(sql);
		   //4. SQL문장 실행 요청 => 결과값 저장 
		   ResultSet rs=ps.executeQuery();
		   //5. ArrayList에 담기
		   while(rs.next())
		   {
			   FaqVO vo=new FaqVO();
			   vo.setFno(rs.getInt(1));
			   vo.setCate(rs.getString(2));
			   vo.setType(rs.getString(3));
			   vo.setSubject(rs.getString(4));
			   vo.setContent(rs.getString(5));
			   
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }*/
   /*
    *   CREATE TABLE project_food(
    fno NUMBER,
    cno NUMBER,
    poster VARCHAR2(1000) CONSTRAINT pf_poster_nn NOT NULL,
    name VARCHAR2(100) CONSTRAINT pf_name_nn NOT NULL,
    score NUMBER(2,1) CONSTRAINT pf_score_nn NOT NULL,
    address VARCHAR2(250) CONSTRAINT pf_address_nn NOT NULL,
    tel VARCHAR2(20) CONSTRAINT pf_tel_nn NOT NULL,
    type VARCHAR2(100) CONSTRAINT pf_type_nn NOT NULL,
    price VARCHAR2(20),
    parking VARCHAR2(20),
    time VARCHAR2(20),
    menu VARCHAR2(500),
    jjim_count NUMBER DEFAULT 0,
    like_count NUMBER DEFAULT 0,
    hit NUMBER DEFAULT 0,
    good , soso , bad
    CONSTRAINT pf_fno_pk PRIMARY KEY(fno),
    CONSTRAINT pf_cno_fk FOREIGN KEY(cno)
    REFERENCES project_category(cno)
);
    */
	/* public void foodDetailInsert(FoodVO vo)
	 {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO project_food(fno,cno,poster,name,score,address,tel,type,price,parking,"
				     +"time,menu,good,soso,bad) VALUES(pf_fno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setInt(1, vo.getCno());
		   ps.setString(2, vo.getPoster());
		   ps.setString(3, vo.getName());
		   ps.setDouble(4, vo.getScore());
		   ps.setString(5, vo.getAddress());
		   ps.setString(6, vo.getTel());
		   ps.setString(7, vo.getType());
		   ps.setString(8, vo.getPrice());
		   ps.setString(9, vo.getParking());
		   ps.setString(10, vo.getTime());
		   ps.setString(11, vo.getMenu());
		   ps.setInt(12, vo.getGood());
		   ps.setInt(13,vo.getSoso());
		   ps.setInt(14, vo.getBad());
		   
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	 }*/
}