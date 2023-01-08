<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- Start Header Area -->
    <header class="header navbar-area">
        <!-- Start Topbar -->
        <div class="topbar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-4 col-12">
                        <div class="top-left">
                            <ul class="menu-top-link">
                                <li>
                                <!-- 누르면 Shop창으로 이동 -->
                                <a href="index.html" >Shop</a>                             
                                
                                <!-- 가격 선택 -->
                                    <!-- <div class="select-position">
                                        <select id="select4">
                                            <option value="0" selected>$ USD</option>
                                            <option value="1">€ EURO</option>
                                            <option value="2">$ CAD</option>
                                            <option value="3">₹ INR</option>
                                            <option value="4">¥ CNY</option>
                                            <option value="5">৳ BDT</option>
                                        </select>
                                    </div> -->
                                </li>
                                <li>
                                <!-- 누르면 캠핑장 소개 창으로 이동 -->
                                <a href="index.jsp" >Camp</a>
                                <!-- 언어 선택 -->
                                   <!--  <div class="select-position">
                                        <select id="select5">
                                            <option value="0" selected>English</option>
                                            <option value="1">Español</option>
                                            <option value="2">Filipino</option>
                                            <option value="3">Français</option>
                                            <option value="4">العربية</option>
                                            <option value="5">हिन्दी</option>
                                            <option value="6">বাংলা</option>
                                        </select>
                                    </div> -->
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-12">
                        <div class="top-middle">
                            <ul class="useful-links">
                               <!-- 쇼핑몰 로고를 눌렀을 때 "홈" 으로 이동하게 할 생각! -->
                               <!--  <li><a href="index.html">Home</a></li> 
                                 <li><a href="about-us.html">About Us</a></li>
                                <li><a href="contact.html">Contact Us</a></li> -->
                            </ul>
                        </div>
                    </div>
                    <!-- col-lg-4(4열길이) col-md-4(Medium) col-12 -->
                    <div class="col-lg-4 col-md-4 col-12">
                        <div class="top-end">
                            <div class="user">
                                <i class="lni lni-user"></i>
                                user
                            </div> <!-- user div -->
                            <ul class="user-login">
                                <li>
                                    <a href="login.html">로그인</a>
                                </li>
                                
                                <li>
                                    <a href="register.html">회원가입</a>
                                </li>  
                                <li>
                                    <a href="register.html">주문조회</a>
                                </li>  
                                <!-- 마이쇼핑 아래 품목 추가하기 -->
                                <li>
                                    <a href="register.html">마이쇼핑</a>                               
                                </li>
                                                   
                            </ul> <!-- end : user-login -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Topbar -->
        <!-- Start Header Middle -->
        <div class="header-middle">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-md-3 col-7">
                        <!-- Start Header Logo -->
                        <a class="navbar-brand" href="index.jsp">
                        <!-- 메인페이지 로고 -->
                         <p style= "font-size :40px"> Happy Camping </p>
                        			<!--img => 홈페이지 로고  alt는 img를 보여주지 않을 때 해당 이미지 대신 나타나는 택스트   -->
                         <!--    <img src="assets/images/logo/logo.svg" alt="Logo"> -->
                        </a>
                        <!-- End Header Logo -->
                    </div>
                    <div class="col-lg-5 col-md-7 d-xs-none">
                        <!-- Start Main Menu Search -->
                        <div class="main-menu-search">
                            <!-- navbar search start -->
                            <div class="navbar-search search-style-5">
                                <div class="search-select">
                                    <div class="select-position">
                                    	<!-- 검색창 내용 -->
                                        <select id="select1">
                                            <option selected> 검색 조건 선택</option>
                                            <option value="1">상품명</option>
                                            <option value="2">제조사</option>
                                            <option value="3">모델명</option>
                                            <option value="4">브랜드명</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="search-input">
                                    <!-- placeholder은 검색을 하면 글씨가 사라진다 -->
                                    <input type="text" placeholder="원하는 제품을 검색하세요">
                                </div>
                                <div class="search-btn">
                                    <button><i class="lni lni-search-alt"></i></button>
                                </div>
                            </div>
                            <!-- navbar search Ends -->
                        </div>
                        <!-- End Main Menu Search -->
                    </div>
                    <div class="col-lg-4 col-md-2 col-5">
                        <div class="middle-right-area">
                            <!-- <div class="nav-hotline">
                                <i class="lni lni-phone"></i>
                                <h3>Hotline:
                                    <span>(+100) 123 456 7890</span>
                                </h3>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Header Middle -->
        <!-- Start Header Bottom -->
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-8 col-md-6 col-12">
                    <div class="nav-inner">
                        <!-- 카테고리 메뉴 시작 -->
                        <div class="mega-category-menu">
                            <span class="cat-button">
                            	<img src="assets/images/menu.svg" style="width:25px; height:25px; ">
                            	  &nbsp;&nbsp;C A T E G O R Y
                            	</span>
                            <ul class="sub-category">
                               <!-- li 대분류 카테고리 -->
                                <li><a href="product-grids.html"><b>텐트</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                    <!-- ul 소분류 카테고리 -->
                                    <ul class="inner-sub-category">
                                        <li><a href="product-grids.html">거실형텐트(리빙쉘)</a></li>
                                        <li><a href="product-grids.html">면/티피텐트</a></li>
                                        <li><a href="product-grids.html">돔/터널형(4인이상)</a></li>
                                        <li><a href="product-grids.html">미니멀/백패킹(1~3인)</a></li>
                                        <li><a href="product-grids.html">미니멀/백패킹(1~3인)</a></li>
                                        <li><a href="product-grids.html">차박텐트</a></li>
                                        <li><a href="product-grids.html">이너룸/이너텐트</a></li>
                                        <li><a href="product-grids.html">풋프린트/이너매트</a></li>
                                        <li><a href="product-grids.html">카페트/러그</a></li>                         
                                    </ul>
                                </li>
                                <li><a href="product-grids.html"><b>타프/쉘터</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
	                                 <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">렉타타프(사각)</a></li>
	                                        <li><a href="product-grids.html">헥사/옥타/윙타프</a></li>
	                                        <li><a href="product-grids.html">쉘터</a></li>
	                                        <li><a href="product-grids.html">윈트스크링/진막</a></li>                    
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>폴대/펙/스트링</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">폴대</a></li>
	                                        <li><a href="product-grids.html">팩/망치</a></li>
	                                        <li><a href="product-grids.html">스토퍼/스트링/로프</a></li>                   
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>테이블/체어</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">스노우피크 IGT</a></li>
	                                        <li><a href="product-grids.html">캠핑테이블</a></li>
	                                        <li><a href="product-grids.html">경량테이블</a></li> 
	                                        <li><a href="product-grids.html">폴딩/로우체어</a></li>
	                                        <li><a href="product-grids.html">경량체어</a></li>
	                                        <li><a href="product-grids.html">수납/거치대</a></li>  
	                                        <li><a href="product-grids.html">랙소토</a></li>
	                                        <li><a href="product-grids.html">체어스킨/커버</a></li>
	                                        <li><a href="product-grids.html">기타용품</a></li>                    
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>배드/침구/매트</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">코트/야전침대</a></li>
	                                        <li><a href="product-grids.html">자충/에어매트</a></li>
	                                        <li><a href="product-grids.html">침낭</a></li> 
	                                        <li><a href="product-grids.html">베개/쿠션/방석</a></li>
	                                        <li><a href="product-grids.html">블랭킷/담요/타월</a></li>
	                                        <li><a href="product-grids.html">발포/폴딩/패브릭</a></li> 
	                                        <li><a href="product-grids.html">기타용품</a></li>                            
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>스토브/랜턴</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">스토브/버너</a></li>
	                                        <li><a href="product-grids.html">전기/배터리랜턴</a></li>
	                                        <li><a href="product-grids.html">가스/오일랜턴</a></li>   
	                                        <li><a href="product-grids.html">헤드랜턴</a></li>
	                                        <li><a href="product-grids.html">스토브/랜턴용품</a></li>
	                                        <li><a href="product-grids.html">토치</a></li> 
	                                        <li><a href="product-grids.html">이소가스</a></li>  	                                                        
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>식기/쿠커</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">컵/시에라</a></li>
	                                        <li><a href="product-grids.html">커틀러리</a></li>
	                                        <li><a href="product-grids.html">접시/볼/그릇세트</a></li>
	                                        <li><a href="product-grids.html">코펠세트</a></li>
	                                        <li><a href="product-grids.html">쿠커/냄비/프라이팬</a></li>
	                                        <li><a href="product-grids.html">조리도구/키친툴</a></li>   
	                                        <li><a href="product-grids.html">보틀/텀블러/워터저그</a></li>
	                                        <li><a href="product-grids.html">주전자/퍼콜레이터</a></li>
	                                        <li><a href="product-grids.html">커피/드리퍼</a></li> 
	                                        <li><a href="product-grids.html">터치오븐</a></li>   
	                                        <li><a href="product-grids.html">기타용품</a></li>                  
	                                  </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>화로/BBQ</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">화로대</a></li>
	                                        <li><a href="product-grids.html">BBQ화로</a></li>
	                                        <li><a href="product-grids.html">삼각대/앵커</a></li>
	                                        <li><a href="product-grids.html">그리들/팬</a></li>
	                                        <li><a href="product-grids.html">그릴/플레이트</a></li>
	                                        <li><a href="product-grids.html">차콜스타터</a></li>
	                                        <li><a href="product-grids.html">화로대/BBQ용품</a></li>   
	                                        <li><a href="product-grids.html">수납/케이스</a></li>                                      
	                                  </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>냉방/난방</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">서큘/선풍기</a></li>
	                                        <li><a href="product-grids.html">화목난로</a></li>
	                                        <li><a href="product-grids.html">심지식난로</a></li>    
	                                        <li><a href="product-grids.html">팬히터</a></li>
	                                        <li><a href="product-grids.html">가스히터</a></li>
	                                        <li><a href="product-grids.html">연로통/기름통</a></li>
	                                        <li><a href="product-grids.html">기타난방용품</a></li>              
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>수납/케이스</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">스노우피크 기어</a></li>
	                                        <li><a href="product-grids.html">박스/컨테이너</a></li>
	                                        <li><a href="product-grids.html">다용도수납/케이스</a></li>      
	                                        <li><a href="product-grids.html">테이블/체어케이스</a></li>
	                                        <li><a href="product-grids.html">그릴/오픈/화로케이스</a></li>
	                                        <li><a href="product-grids.html">랜턴/버너케이스</a></li>
	                                        <li><a href="product-grids.html">폴대/팩케이스</a></li>   
	                                        <li><a href="product-grids.html">식기/보틀케이스</a></li>
	                                        <li><a href="product-grids.html">하드쿨러</a></li>
	                                        <li><a href="product-grids.html">소프트쿨러</a></li> 
	                                        <li><a href="product-grids.html">쿨러용품</a></li>   
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>나이프/공구/위생</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">나이프/멀티툴</a></li>
	                                        <li><a href="product-grids.html">도끼/공구</a></li>
	                                        <li><a href="product-grids.html">글로브/장갑</a></li>
	                                        <li><a href="product-grids.html">이소가스</a></li>
	                                        <li><a href="product-grids.html">멀티탭/코드릴</a></li>
	                                        <li><a href="product-grids.html">카빙</a></li>
	                                        <li><a href="product-grids.html">위생용품</a></li>   
	                                        <li><a href="product-grids.html">장식용품</a></li>
	                                        <li><a href="product-grids.html">애견용품</a></li>
	                                        <li><a href="product-grids.html">기타용품</a></li>                    
	                                    </ul>
	                            </li>
                                <li><a href="product-grids.html"><b>배낭/디팩/모자</b>
                                <img src="assets/images/chevron-right.svg" style="width:15px; height:15px; float: right; ">
                                </a>
                                      <ul class="inner-sub-category">
	                                        <li><a href="product-grids.html">소형(30L 이하)</a></li>
	                                        <li><a href="product-grids.html">중형(65L 이하)</a></li>
	                                        <li><a href="product-grids.html">대형(70L 이하)</a></li>         
	                                        <li><a href="product-grids.html">디팩</a></li>
	                                        <li><a href="product-grids.html">캐리어</a></li>
	                                        <li><a href="product-grids.html">더플/보스턴/드라이팩</a></li>
	                                        <li><a href="product-grids.html">보조가방/액세사리</a></li>   
	                                        <li><a href="product-grids.html">모자/양말</a></li>   
	                                  </ul>
	                           </li>
                            </ul>
                        </div>
                        <!-- 카테고리 메뉴 끝 -->
                        <!-- Start Navbar -->
                        <nav class="navbar navbar-expand-lg">
                            <button class="navbar-toggler mobile-menu-btn" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                                <span class="toggler-icon"></span>
                                <span class="toggler-icon"></span>
                                <span class="toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse sub-menu-bar" id="navbarSupportedContent">
                                <ul id="nav" class="navbar-nav ms-auto">
                                    <li class="nav-item">
                                        <a href="index.html" class="active" aria-label="Toggle navigation">홈</a>
                                    </li>
                                    <li class="nav-item">
                                    <!-- 카테고리 옆 큰 카테고리 뭐 넣을지 생각 => 추가하기 -->
                                    
                                    
                                        <a class="dd-menu collapsed" href="javascript:void(0)" data-bs-toggle="collapse"
                                            data-bs-target="#submenu-1-2" aria-controls="navbarSupportedContent"
                                            aria-expanded="false" aria-label="Toggle navigation">공지/게시판</a>
                                            <!-- page에 대한 소분류 -->
                                        <ul class="sub-menu collapse" id="submenu-1-2">
                                            <li class="nav-item"><a href="about-us.html">NOTICE</a></li>
                                            <li class="nav-item"><a href="faq.html">Q&A</a></li>
                                            <li class="nav-item"><a href="login.html">REVIEW</a></li>
                                         <!-- 무이자할부안내는 넣을지 모르겠음  
                                            <li class="nav-item"><a href="register.html">무이자할부안내</a></li> -->
                                        </ul>
                                    </li>
                                </ul>
                            </div> <!-- navbar collapse -->
                        </nav>
                        <!-- End Navbar -->
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-12">
                                            <div class="navbar-cart">
                                <div class="wishlist">
                                    <a href="javascript:void(0)">
                                        <!-- 찜한 목록? 이미지 변경하기 (i)-->
                                        <img src="assets/images/heart.svg" style ="width:20px; height :20px;">                                     
                                        <span class="total-items">1</span>
                                    </a>
                                </div>
                                <div class="cart-items">
                                    <a href="javascript:void(0)" class="main-btn">
                                        <!-- 장바구니 내용의 수량 이미지 변경하기 (i)- -->
                                        <img src="assets/images/shopping-basket.svg" style ="width:20px; height :20px;">  
                                        <span class="total-items">2</span>
                                    </a>
                                    <!-- Shopping Item (장바구니 내용)-->
                                    <div class="shopping-item">
                                        <div class="dropdown-cart-header">
                                            <span>2 Items</span>
                                            <a href="cart.html">View Cart</a>
                                        </div>
                                        <ul class="shopping-list">
                                            <li>
                                                <a href="javascript:void(0)" class="remove" title="Remove this item"><i
                                                        class="lni lni-close"></i></a>
                                                <div class="cart-img-head">
                                                    <a class="cart-img" href="product-details.html"><img
                                                            src="assets/images/header/cart-items/item1.jpg" alt="#"></a>
                                                </div>
												<!-- 장바구니 내용물 1 -->
                                                <div class="content">
                                                    <h4><a href="product-details.html">
                                                            Apple Watch Series 6</a></h4>
                                                    <p class="quantity">1x - <span class="amount">$99.00</span></p>
                                                </div>
                                            </li>
                                            <li>
                                                <a href="javascript:void(0)" class="remove" title="Remove this item"><i
                                                        class="lni lni-close"></i></a>
                                                <div class="cart-img-head">
                                                    <a class="cart-img" href="product-details.html"><img
                                                            src="assets/images/header/cart-items/item2.jpg" alt="#"></a>
                                                </div>
                                                <!-- 장바구니 내용물2 -->
                                                <div class="content">
                                                    <h4><a href="product-details.html">Wi-Fi Smart Camera</a></h4>
                                                    <p class="quantity">1x - <span class="amount">$35.00</span></p>
                                                </div>
                                            </li>
                                        </ul>
                                        <!-- 장바구니 물건 합계 -->
                                        <div class="bottom">
                                            <div class="total">
                                                <span>Total</span>
                                                <span class="total-amount">$134.00</span>
                                            </div>
                                            <div class="button">
                                                <a href="checkout.html" class="btn animate">주문하기</a>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/ End Shopping Item -->
                                </div>
                            </div>
                    <!-- Start Nav Social : 사용하지 않을거 같음-->
                 <!--    <div class="nav-social">
                        <h5 class="title">Follow Us:</h5>
                        <ul>
                            <li>
                                <a href="javascript:void(0)"><i class="lni lni-facebook-filled"></i></a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"><i class="lni lni-twitter-original"></i></a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"><i class="lni lni-instagram"></i></a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"><i class="lni lni-skype"></i></a>
                            </li>
                        </ul>
                    </div> -->
                    <!-- End Nav Social -->
                </div>
            </div>
        </div>
        <!-- Header 끝!!!!!!!! -->
        <!-- End Header Bottom -->
         </header>
</body>
</html>