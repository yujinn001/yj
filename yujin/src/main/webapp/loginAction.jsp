<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="com.sist.user.*,java.io.PrintWriter" %>
<!--  ojbc8: sqldeveloper을 사용할 수 있게 만드는 드라이버 lib -->    
<!-- 우리가 만든 클래스 사용 방법 -->
<% request.setCharacterEncoding("UTF-8"); %>

<!-- 아래와 같이 해줌으로써 현재 페이지만 Bean을 사용한다 | class name에 들어가는 패키지(풀네임으로).클래스파일-->
<jsp:useBean id ="user" class="com.sist.user.User" scope ="page"/>
<!-- 이페이지안에 userID, userPassword가 넘어와 담긴다 -->
<jsp:setProperty name ="user" property="userID"/>
<jsp:setProperty name ="user" property="userPassword"/>
<!-- 로그인 기능 추가 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	 <!-- result에 각각의 로그인 결과값 1,0,-1,-2의 값이 저장된다 -->
     <%
         UserDAO userDAO =new UserDAO();
     
         int result = userDAO.login(user.getUserID(), user.getUserPassword());
         
         if(result==1) // 로그인이 성공했을 경우 main.jsp페이지로 이동
         {
        	 PrintWriter script=response.getWriter();
        	 script.println("<script>");
        	 script.println("location.href = 'main.jsp'");
        	 script.println("</script>");
         }
         
         else if(result ==0)// 비밀번호가 틀릴 경우
         {
        	 PrintWriter script=response.getWriter();
        	 script.println("<script>");
        	 script.println("alert('비밀번호가 틀립니다.')");
        	 script.println("history.back()"); // 이전페이지로 사용자를 돌려보낸다
        	 script.println("</script>");
        	 
         } 
         else if(result == -1)// 아이디가 존재하지 않을 경우
         {
        	 PrintWriter script=response.getWriter();
        	 script.println("<script>");
        	 script.println("alert('존재하지 않는 아이디 입니다.')");
        	 script.println("history.back()"); // 이전페이지로 사용자를 돌려보낸다
        	 script.println("</script>");
         }
         
         else if(result == -2)// 데이터 베이스 오류
         {
        	 PrintWriter script=response.getWriter();
        	 script.println("<script>");
        	 script.println("alert('데이터베이스 오류가 발생했습니다')");
        	 script.println("history.back()"); // 이전페이지로 사용자를 돌려보낸다
        	 script.println("</script>");
         }
     %>
</body>
</html>





















