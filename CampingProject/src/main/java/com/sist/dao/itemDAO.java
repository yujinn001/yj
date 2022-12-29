package com.sist.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class itemDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String  URL="jdbc:oracle:thin:@211.63.89.131:1521:XE";
	
	public itemDAO()
	{// 드라이버 등록
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	public void getConnection()
	{
		try {
			conn =DriverManager.getConnection(URL,"hr","happy");
			
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try {
			if(conn!=null)conn.close();
			if(ps!=null)ps.close();
		}catch(Exception ex) {}
	}
	// 캠핑용품 카테고리 추가 
	// VO에 담아서 넘어온다 // ?개 카테고리 등록
	public void campingCategoryInsert(CategoryVO vo) // ? 일때 매개변수를 넣어줘야하는건
	{
		try {
			// 1. 연결
			getConnection();
			// 2. sql문장 전송
			// nextval  => 다음값읽기
			// 결과값이 없는 경우 commit 포함 =>executeUpdate()
			String sql ="INSERT INTO item_category_2 "
					+ "VALUES(ic_icno_seq_2.nextval,?) ";
			// sql 문장 전송
			ps=conn.prepareStatement(sql);
			// ? 값을 넣어 준다
			ps.setString(1, vo.getName());	
			// 실행 요청
			ps.executeUpdate(); //commit 	   
					
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	// 카테고리에서 카테고리 번호, 링크, 제목 읽기
	public ArrayList<CategoryVO> campingCategoryInfoData()
	{
		ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();
		try
		{
			// 1. 연결
			getConnection();
			// 2. sql문장 제작
			String sql="SELECT icno, name"
					+ "FROM item_category_2 ORDER BY icno ASC";
			// 3. SQL 문장 전송
			ps=conn.prepareStatement(sql);
			// 4. sql 문장 실행 => 결과값 저장
			ResultSet rs = ps.executeQuery();
			// 5. ArrayList에 담는다
			while(rs.next())
			{
				CategoryVO vo = new CategoryVO();
				vo.setIcno(rs.getInt(1));
				vo.setName(rs.getString(2));
				list.add(vo);
			}
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}

/*
 * INO            NOT NULL NUMBER        
IMAGE          NOT NULL VARCHAR2(260) 
NAME           NOT NULL VARCHAR2(300) 
PRICE          NOT NULL NUMBER        
DESCRIPTION    NOT NULL CLOB          
STOCK          NOT NULL NUMBER        
STATUS         NOT NULL VARCHAR2(200) 
DISCOUNT                NUMBER        
DELIVERY_PRICE NOT NULL NUMBER        
LIKE_CNT                NUMBER        
JJIM_CNT                NUMBER        
ICNO                    NUMBER        
LINK                    VARCHAR2(300) 
 */
	// 캠핑 목록 상세 페이지 내용
	public void campingDetailInsert(itemVO vo) // item voitem_ino_seq_2
	{
		try
		{
			getConnection();
			String sql ="INSERT INTO item_2(ino, image, name, price, description, stock,status, "
					+ "discount, delivery_price, like_cnt, jjim_cnt, icno, link "
					+ "VALUES(item_ino_seq_2,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//? 값을 추가해준다
			ps.setString(1, vo.getImage());
			ps.setString(2, vo.getName());
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
















