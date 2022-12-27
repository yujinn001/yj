package com.sist.user;
// dao는 데이터 베이스 접근 객체 약자로써 
// 실질적으로 데이터베이스에서 회원 정보를 불러오거나 데이터 베이스에 회원 정보를 넣고자 할 때 사용한다.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn; // 데이터베이스의 접근하게 해주는 하나의 객체
	private PreparedStatement ps; // 
	private ResultSet rs; // 결과값을 담을 수 있는 하나의 객체
	private final String dbURL ="jdbc:oracle:thin:@localhost:1521:XE";
	private String dbID ="hr";
	private String dbPassword = "happy";
	
	public UserDAO()
	{ // 드라이브 연결 => 방법) Class.forName()
		try 
		{// sql 드라이버에 접속할 수 있도록 하는 매개체 역할
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void getConnection()
	{
		try
		{
			conn =DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception ex)
		{
			ex.printStackTrace();	
		}
	}
	public void disConnection()
	{
		try {
			if(conn != null) conn.close();
			if(ps!=null)ps.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();		
		}
	}
	
	// loginAction 페이지에 이 기능을 넣으면 된다
	// 실제로 로그인 시도하는 함수 => 하나의 계정에 대한 로그인 시도를 한 기능 (간단하 로그인 기능)
	public int login(String userID, String userPassword) 
	{
		getConnection();
		
		String SQL ="SELECT userPassword "
				+ "FROM member1 "
				+ "WHERE userID = ? ";
		
		//sql인젝션 해킹기법을 방지하기 위해  PreparedStatement를 사용한다
		try {
			ps=conn.prepareStatement(SQL);
			// ? 값을 넣어 준다 => 이때 ? 의 갯수가 여러개 일 경우 아래와 같이 1,2,3...이런식으로 넣어준다
			ps.setString(1, userID);
		//  ps.setString(2, userID); 물음표가 두개 일경우
			
			rs =ps.executeQuery();
			if(rs.next())
			{  // 결과값을 받아서 확인 => 접속을 시도한 유저 패스워드와 동일하다면 로그인 성공
				if(rs.getString(1).equals(userPassword))
				{
					return 1; //로그인 성공 => sql에서 찾는 userPassword와 if문안에 있는 userPassword가 일치 한다면 성공
				}
				else
					return 0; // 비밀번호 불일치 
			}
			return -1;// 아이디가 없음
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
//		finally
//		{
//			disConnection();
//		}
		return -2; //데이터베이스 오류 
	}
}






































