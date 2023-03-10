<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Happy Camping</title> <!-- 쇼핑몰 창 이름 변경 -->
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.svg" />

    <!-- ========================= CSS here ========================= -->
    <link rel="stylesheet" href="assets/main/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/main/css/LineIcons.3.0.css" />
    <link rel="stylesheet" href="assets/main/css/tiny-slider.css" />
    <link rel="stylesheet" href="assets/main/css/glightbox.min.css" />
    <link rel="stylesheet" href="assets/main/css/main.css" />

</head>

<body>

    <!-- Preloader -->
    <div class="preloader">
        <div class="preloader-inner">
            <div class="preload" >
               <p style= "font-size :40px"> Happy Camping </p>
                <span></span>
                <span></span>
            </div>
        </div>
    </div>
    <!-- /End Preloader -->
    
	<!-- header.jsp -->
		<jsp:include page ="assets/main/header.jsp"></jsp:include>


 	<!-- Content -->
	<jsp:include page ="assets/main/content.jsp"></jsp:include>

	<!-- Footer -->
	<jsp:include page ="assets/main/footer.jsp"></jsp:include>

    <!-- ========================= scroll-top ========================= -->
    <a href="#" class="scroll-top">
        <i class="lni lni-chevron-up"></i>
    </a>

    <!-- ========================= JS here ========================= -->
    <script src="assets/main/js/bootstrap.min.js"></script>
    <script src="assets/main/js/tiny-slider.js"></script>
    <script src="assets/main/js/glightbox.min.js"></script>
    <script src="assets/main/js/main.js"></script>
    <script type="text/javascript">
        //========= Hero Slider 
        tns({
            container: '.hero-slider',
            slideBy: 'page',
            autoplay: true,
            autoplayButtonOutput: false,
            mouseDrag: true,
            gutter: 0,
            items: 1,
            nav: false,
            controls: true,
            controlsText: ['<i class="lni lni-chevron-left"></i>', '<i class="lni lni-chevron-right"></i>'],
        });

        //======== Brand Slider
        tns({
            container: '.brands-logo-carousel',
            autoplay: true,
            autoplayButtonOutput: false,
            mouseDrag: true,
            gutter: 15,
            nav: false,
            controls: false,
            responsive: {
                0: {
                    items: 1,
                },
                540: {
                    items: 3,
                },
                768: {
                    items: 5,
                },
                992: {
                    items: 6,
                }
            }
        });
    </script>
</body>

</html>