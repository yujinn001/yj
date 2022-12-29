package com.sist.service;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.CategoryVO;
import com.sist.dao.itemDAO;

public class DataCollectionServer {
	public static void main(String[] args) {
		
		DataCollectionServer ds = new DataCollectionServer();
	    ds.campingCategoryGetData();
		//ds.campingDetailData();
	    //ds.goodsAllData();
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
 
			//Elements name =doc.select("div.description strong.name a");
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
	
	// 상품 데이터
    public void goodsAllData() {
        try {
           for(int i=1;i<=5;i++) {
              Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=201&page="+i).get();
              Elements image=doc.select("div.prdImg a img");
              for(int j=1;j<image.size();j++) {
                 System.out.println(image.get(j).attr("src"));
              }
              
           }
        
        }catch(Exception ex) {
           
        }
     
     }
	// 캠핑용품 상세 데이터 목록 출력
//	public void campingDetailData()
//	{
//		itemDAO dao = new itemDAO();
//		try
//		{
//			ArrayList<CategoryVO> list = dao.campingCategoryInfoData();
//			for(CategoryVO vo: list)
//			{
//				// 출력 확인 => 왜 1번이 아니라 117부터 나오는 이유를 모르겠음 
//				// 시퀀스 문제 => 삭제후 다시 생성 => 오류 해결
//				System.out.println(vo.getIcno()+" "+vo.getName()+" "+vo.getLink());
//				// 카테고리를 누르면 그페이지로 이동??
//				Document doc =Jsoup.connect(vo.getLink()).get();
//				//Elements link = doc.select("div.guide_contents li.liststylep_li a");
//				Elements link = doc.select("div#cate_bar dd.xans-element- xans-layout xans-layout-category slide_tap ul.firstul catedep1 a");
//				for(int i =0; i<link.size();i++)
//				   {
//					   System.out.println(link.get(i).attr("href"));
//					   Document doc2= Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
//				       //1.이미지
//				   }
//			}
//		}catch(Exception ex){}
//	}
}

















