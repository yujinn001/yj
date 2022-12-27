package com.sist.user;
// 이런식으로 하나의 데이터를 관리하고 처리할 수 있게 만드는 기법을 jsp에서 구하는 것을 => 자바 빈즈
/*
 *   이름           널?       유형           
------------ -------- ------------ 
USERID       NOT NULL VARCHAR2(20) 
USERPASSWORD          VARCHAR2(20) 
USERNAME              VARCHAR2(20) 
USERGENDER            VARCHAR2(20) 
USEREMAIL             VARCHAR2(50) 
 */
// 각각의 데이터 베이스에 있는 회원 정보를 자바에서도 사용할 수 있게 해준다
public class User {
	private String userID, userPassword,userName, userGender, userEmail;

	// JSP에서도 사용할 수 있게 getter /setter을 해준다
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
