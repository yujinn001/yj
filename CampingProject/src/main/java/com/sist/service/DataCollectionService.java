package com.sist.service;
import java.lang.reflect.Array;


import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.CategoryVO;
import com.sist.dao.itemDAO;
// import com.sist.dao.*;

public class DataCollectionService {
   public static void main(String[] args) {
      DataCollectionService ds = new DataCollectionService();
      //1) 카테고리 데이터 목록 가져오기
       //ds.campingCategoryGetData();
      //
      //ds.campingDetailData();
      // 캠핑용품 상품 데이터 가져오기
       ds.goodsAllData();
      
   }
   // 대분류 카테고리창 (텐트, 타프 쉘더)
   public void campingCategoryGetData()
   {

      itemDAO dao = new itemDAO();
      try
      {
         // 사이트 연결 => HTML 태그 읽기
         // 캠핑 리스트 
         Document doc = Jsoup.connect("https://campinglist.co.kr").get();
         // 확인 => html 나오는거
         //System.out.println(doc.toString());
         Elements name =doc.select("#left_cate > div > ul div.catenabber  a");
                           
            for(int i=0; i<name.size()-1; i++)
            {
              System.out.println(i+1);
              System.out.println(name.get(i+1).text());

              System.out.println("===============");
              
              CategoryVO vo = new CategoryVO();
              //vo.setName(name.get(i+1).text());
              // 데이터 수집 (camping category)
             // dao.campingCategoryInsert(vo);           
            }      
      }catch (Exception e) {}
   }
   
   ///////////////////////////////////////캠핑용품
   public void goodsAllData() {
      try
      {
         // 페이지가 있는 경우 for문으로 가져온다
         // 우선 텐트 페이지 목록 상품출력 하기
         //itemDAO dao = new itemDAO();
         System.out.println("goodsAllData");
            for(int i=1;i<=5;i++) {
                //Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=169&page="+i).get(); //cno=12
                //Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=47&page="+i).get(); //cno=11
                //Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=45&page="+i).get(); //cno=10(5page)
                //Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=92&page="+i).get(); //cno=9(3page)
                //Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=42&page="+i).get(); //cno=8(4page) 화로/비비큐
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=26&page="+i).get(); //cno=7(9page) 식기/쿠커
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=42&page="+i).get(); //cno=6(4page) 스토브/랜턴
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=15&page="+i).get(); //cno=5(4page) 베드,침구,매트
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=28&page="+i).get(); //cno=4(6page) 테이블/체어
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=282&page="+i).get(); //cno=3(4page) 폴대
//                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=210&page="+i).get(); //cno=2(2page) 타프/쉘터
                Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=201&page="+i).get(); //cno=1(5page) 텐트
                Elements link=doc.select("div.prdImg a");// 제품 상세보기 링크
             // <a href="/product/텐트마크디자인-서커스-이너-세트-하프-이너텐트-그라운드시트-tm-1812/3342/category/201/display/1/" name="anchorBoxName_3342"><img src="//campinglist.co.kr/web/product/medium/202212/73c83770a31ef46a7db3d6e03c946bf7.jpg" onmouseover="this.src='//campinglist.co.kr/web/product/big/202212/d784a5b70cb59d19bc2ad541081e065f.jpg'" onmouseout="this.src='//campinglist.co.kr/web/product/medium/202212/73c83770a31ef46a7db3d6e03c946bf7.jpg'" id="eListPrdImage3342_1" alt="텐트마크디자인 서커스 이너 세트 하프 (이너텐트 + 그라운드시트) (TM-1812)"></a>
                
                // 링크가 제대로 들어왔는지 확인
                System.out.println(link.size()); // link는 한페이지당의 갯수를 보여줘서 텐트일경우 총 상품 300개로 60개가 나오는게 맞다
            for(int j =0; j<link.size(); j++)
            {            
               // 상품 상세 페이지(링크) 접근할 수 있는 주소 확인 완료
               //System.out.println(link.get(j).attr("href")); // 텐트 페이지 300개 나오는거 확인
               // 넣는 의미 상세페이지 안으로 들어가겠다
               
               Document doc2= Jsoup.connect("https://www.campinglist.co.kr/"+link.get(j).attr("href")).get();
               
               // 상품 이미지  
               Element image=doc2.selectFirst("#contents > div > div.bg_gray.guide_100p > div > div.xans-element-.xans-product.xans-product-detail > div.detailArea > div.imgArea > div.xans-element-.xans-product.xans-product-image > div.keyImg > div > a > img");
               // 이미지 출력 확인
               System.out.println(image.attr("src"));
               
               // 상품 이름
               Element name = doc2.selectFirst("#contents > div > div.bg_gray.guide_100p > div > div.xans-element-.xans-product.xans-product-detail > div.detailArea > div.infoArea > div.headingArea > h2");
               System.out.println(name.text());
               
               // 가격
               Element price = doc2.selectFirst("#span_product_price_text");
               System.out.println(price.text());
               
               // 찜하기
               
               // 장바구니 추가 기능
               // 적립금??
               
               // 배송비 => String으로 그냥 적기
            }            
          }
      }catch(Exception ex) {}
   }
}
















