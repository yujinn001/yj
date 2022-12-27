<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.min.css">  <!-- 참조해서 사용하겟다 --> 
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<nav class ="navbar navbar-default">
		<div class ="navber-header">
			<button type ="button" class ="navbar-toggle collapsed"
				data-toggle="collapse" data-target ="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class ="icon-bar"></span> <!-- icon var : 짝대기 -->
				<span class ="icon-bar"></span>
				<span class ="icon-bar"></span>
			</button>
			<a class ="navbar-brand" href ="main.jsp">JSP 게시판 웹사이트</a>			
		</div>
		
		<div class = :collapse navbar-collapse" id ="bs-example-navbar-collapse-1">
			<ul class = "nav navbar-nav">
				<li><a href="main.jsp">메인</a>
				<li><a href="main.jsp">게시판</a>
			</ul>
			<ul class ="nav navbar-nav navbar-right">
				<div class ="dropdown">
					<a href="#" class= "dropdown-toggle"
						data-toggle ="dropdown" role ="button" aria-haspopup="true"						
						aria-expanded ="false">접속하기<span class ="caret"></span></a>
						<!-- 접속하기라는 드랍 다운 메뉴가 생긴다 => 접속하기를 눌렀을때 메뉴가 나오게 한다 -->
					<ul class ="dropdown-menu">
						<li class= "active"><a href ="login.jsp">로그인</a></li>
						<!-- active는 빼준다 단 한개의 홈페이지에만 들어가기 때문에 위에만 넣어준다 -->
						<li><a href ="join.jsp">회원가입</a></li>
					</ul>
				</div>
			</ul>
		</div>
		
	</nav>
	<!-- 양식 만들기 => container 감쌀수 있게 한다 => 마치 컨테이너 안을 생각하면 된다-->
	<div class ="container">
		<div class ="col-lg-4"></div>
		<div class ="col-lg-4">
	<!-- 회원가입 내용 -->
   <div class="jumbotron" style="padding-top: 50px;margin-top: 20px;">
		    <!-- loginAction이라는 페이지로 로그인 정보를 보내주겠다 -->
		    
		  	<form method ="post" action ="joinAction.jsp">
		  	    <h3 style ="text-align : center;">회원가입 화면</h3>
		  	    
		  	    <!-- ID 관련 내용 -->
		  	    <div class ="form-group">
		  	          <!-- placeholder은 단지 어떠한 것도 입력되지 않았을 때 보여지는 것 (칸안에 "아이디" 글씨가 있다가 아이디를 입력하게 되면 사라지는 글씨-->
		  	          <input type ="text" class ="form-control" placeholder ="아이디" name = "userID" maxlength ="20"> <!-- ID의 길이를 20자로 제한 -->
		  	    </div>
		  	    
		  	    <!-- PWD 관련 내용 /  [소문자] user [대문자] ID ,Password-->
		  	    <div class ="form-group">		  	         
		  	          <input type ="password" class ="form-control" placeholder ="비밀번호" name = "userPassword" maxlength ="20">
		  	    </div>
		  	    <div class ="form-group">		  	         
		  	          <input type ="text" class ="form-control" placeholder ="이름" name = "userName" maxlength ="20">
		  	    </div>
		  	    <!-- 성별 선택 -->        
		  	    <div class ="form-group" style = "text-align: center">		  	         
		  	          <div class ="btn-group" data-toggle ="buttons">
		  	          	<label class =" btn btn-primary active">
		  	          	   <input type ="radio" name ="userGender" autocomplete ="off" value="남자" checked>남자
		  	          	</label>
		  	          	<label class =" btn btn-primary ">
		  	          	   <input type ="radio" name ="userGender" autocomplete ="off" value="여자" checked>여자
		  	          	</label>
		  	          </div>
		  	    </div>
		  	    <!-- 이메일 -->
		  	    <div class ="form-group">		  	         
		  	          <input type ="email" class ="form-control" placeholder ="이메일" name = "userEmail" maxlength ="20">
		  	    </div>
		  	    <input type ="submit" class="btn btn-primary form-control" value ="회원가입">
		  	</form>
		</div>
		<div class ="col-lg-4"></div>
		
	</div>
  	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 <script src="js/bootstrap.js"></script>
</body>
</html>

