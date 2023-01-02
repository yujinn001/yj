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
				  vo.setName(name.get(i+1).text());
				  // 데이터 수집 (camping category)
				  dao.campingCategoryInsert(vo);			  
				}		
		}catch (Exception e) {}
	}
	
	///////////////////////////////////////캠핑용품
	public void goodsAllData() {
		try
		{
			// 페이지가 있는 경우 for문으로 가져온다
			// 우선 텐트 페이지 목록 상품출력 하기
			itemDAO dao = new itemDAO();

			for(int i=0; i<=5; i++) // 텐트 페이지가 15페이지 까지 있음
			{
				// 페이지 누른후 링크 가져오기
				//Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=210&page="+i).get();	
				Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=210&page="+i).get();				
				Elements link = doc.select("div.prdImg a");

				for(int j =0; j<=link.size(); j++)
				{
					//System.out.println(link.size());
					// 상품 상세 페이지(링크) 접근할 수 있는 주소 확인 완료
					System.out.println(link.get(j).attr("href"));
					
					// 상품 이미지 출력
					Document doc2 = Jsoup.connect("https://m.campinglist.co.kr"+link.get(j).attr("href")).get();
					Element image = doc2.selectFirst("div.prdImgView a#prdDetailImg img");
					System.out.println(image.attr("src"));
					
					// 상품 이름 가져오기
					Element name =doc2.selectFirst("#contents > div.xans-element-.xans-product.xans-product-detail h1.name");
					System.out.println(name.text());
					
					// 가격
				    Element price =doc2.selectFirst("#contents > div.xans-element-.xans-product.xans-product-detail > div.prdDesc > div:nth-child(1) > div > div.pricearea_a2 p"); 
				    System.out.println(price.text());
				    
				    // 적립금 내용 추가 예정
				    
				    
				    // 상품 배송비 delivery_price (상품 상세 내용인거 같음)
				    //Element delivery_price = doc2.selectFirst("#contents > div.xans-element-.xans-product.xans-product-detail > div.prdDesc > div:nth-child(1) > table > tbody.delvtype > tr:nth-child(2) > td > span > span > strong");
				    //System.out.println("배송비 : " +delivery_price.text());				    				    
				}				
		    }
		}catch(Exception ex) {}
	}
	//Document doc2 =Jsoup.connect(link.get(j).attr("href")).get();
	//Element image =doc2.selectFirst("div.xans-element- div.prdImgView img");
	//System.out.println(image.toString());	
	

	// 상품 데이터 가져오기 (2 => 다시 정리해보기)
	/*   public void goodsAllData() {
		try 
		// 수정된 cate_code 가져오기
		Document doc = Jsoup.connect("https://campinglist.co.kr").get();
		Elements name =doc.select("#left_cate > div > ul div.catenabber  a");
		
		//카테고리 비교 (=> <a href="/product/list.html?cate_no=117">#브랜드관#</a>)		
		String cate_no="";
		for(int c =0; c <name.size();c++)			
		{
			// cate_no => 카테고리별 페이지를 비교해서 상품을 보이게 하려고 한다
		    cate_no=name.get(c).attr("href");
			cate_no=cate_no.substring(27); // 예) cate_no => 텐트 : 201
			// 117,20,210,282,28,25,44,26,42,92,45,47,169 (cate_no 출력확인)
	     	//System.out.println(cate_no);			
					
		// 상품 페이지가 있는 경우 for문으로 가져온다
		// 상품 페이지의 cate_no와 카테고리별을 추가해서 상품 출력
	       for(int i=1;i<=cate_no.length();i++) 
		   {
	    	Document doc2=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no="+cate_no).get();
	    	// 태그가 있는 문장 보려고
	    	//System.out.println(doc2.toString
	    	// cate_no와 cate_no1을 비교
	    	Elements cate_no1 = doc.select("#left_cate > div > ul div.catenabber  a");
	    	 for(int a =1; a<cate_no1.size();a++)
	    	 {
	    		 System.out.println(a+1);
	    		 System.out.println(cate_no1.get(a).attr("href"));
	    	 }
	    	 System.out.println("=============");
	    			
	     
	          
	    	 
	          // 이전 코드 (언니가 보내준 소스) 
	    	 
	    	  * for(int i=1;i<=5;i++) {
	           Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=201&page="+i).get();
	           Elements image=doc.select("div.prdImg a img");
	           for(int j=1;j<image.size();j++) {
	              System.out.println(image.get(j).attr("src"));
	    	  
	
	          Elements image=doc.select("div.prdImg a img");
				              for(int j=1;j<image.size();j++) 
				              {
				 System.out.println(image.get(j).attr("src"));
				             }
	          
	       } //2번째 for문 종료
		} // 첫번째 for문 종료
	    
	    }catch(Exception ex) {}   
	 }
	*/    
	// 캠핑용품 상세 데이터 목록 출력
	/*	public void campingDetailData()
		{
			itemDAO dao = new itemDAO();
			try
			{
				ArrayList<CategoryVO> list = dao.campingCategoryInfoData();
				for(CategoryVO vo: list)
				{
					// 출력 확인 => 왜 1번이 아니라 117부터 나오는 이유를 모르겠음 
					// 시퀀스 문제 => 삭제후 다시 생성 => 오류 해결
					System.out.println(vo.getIcno()+" "+vo.getName()+" "+vo.getLink());
					// 카테고리를 누르면 그페이지로 이동??
					Document doc =Jsoup.connect(vo.getLink()).get();
					//Elements link = doc.select("div.guide_contents li.liststylep_li a");
					Elements link = doc.select("div#cate_bar dd.xans-element- xans-layout xans-layout-category slide_tap ul.firstul catedep1 a");
					for(int i =0; i<link.size();i++)
					   {
						   System.out.println(link.get(i).attr("href"));
						   Document doc2= Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
					       //1.이미지
					   }
				}
			}catch(Exception ex){}
		}*/
}

















