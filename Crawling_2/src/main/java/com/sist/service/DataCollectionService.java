package com.sist.service;

import com.sist.dao.*;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataCollectionService {
	public static void main(String[] args) {
		DataCollectionService ds = new DataCollectionService();
		//ds.FaqCategoryGetData();
		ds.faqGetData();
		//ds.InformationUseGetData();
		//ds.NationIntroduceGetData();
		
		
	}

	
	// faq category data
	// 국가센터 정보 가져오기
	public void FaqCategoryGetData() 
		{
			FaqCategoryDAO dao = new FaqCategoryDAO();
			// SFCNO CATE  
			try {
				// 사이트 연결 => HTML 태그 읽기
				Document doc = Jsoup.connect("https://post.malltail.com/faqs/index").get();
				//System.out.println(doc.toString()); // 몰테일의 국가센터정보 html =>  html 들어옴(확인 완료)
			    Elements cate = doc.select("#content > div.page-body > div.faq_re > div.faq_re_menu > ul > li");
				System.out.println(cate.toString()); //p 태그값 들어옴(확인 완료)
			    
			    for(int i=0;i<cate.size();i++)
				{
					System.out.println(i+1);
					System.out.println(cate.get(i).text());
					System.out.println("====================");
					FaqCategoryVO vo = new FaqCategoryVO();
					vo.setCate(cate.get(i).text());
					dao.FaqCategoryData(vo);
					// 데이터 수집
				}
			} catch (Exception ex) {}
	}
	
	// faq 정보 가져오기
	public void faqGetData() 
	{
		FaqDAO dao = new FaqDAO();
		// fno TYPE   SUBJECT CONTENT 
		try {
			// 사이트 연결 => HTML 태그 읽기
			Document doc = Jsoup.connect("https://post.malltail.com/faqs/index").get();
			//System.out.println(doc.toString()); // 몰테일의 faq html =>  html 들어옴(확인 완료)
			//=> 데이터에서 삭제함 Elements cate = doc.select("#content > div.page-body > div.faq_re > div.faq_re_menu > ul > li > span");
			//System.out.println(cate.toString()); //span 태그값 들어옴(확인 완료)
			Elements type = doc.select(".faq_con > ul > li > dl > dt > div.con_tit");
			//System.out.println(type.toString()); //div 태그값 들어옴(확인 완료)
			Elements subject = doc.select(".faq_con > ul > li > dl > dt > div.con_text");
			//System.out.println(subject.toString());
			Elements content = doc.select(".faq_con > ul > li > dl > dd");
			// System.out.println(content.toString()); // dd 태그값 들어옴 (확인 완료)
			for(int i=0;i<type.size();i++)
			{
				System.out.println(i+1);
				System.out.println(type.get(i).text()); 
				System.out.println(subject.get(i).text());
				System.out.println(content.get(i).text());
				int[] num = {1,2,3,4,5,6,7,8};
				
				System.out.println("====================");
				FaqVO vo = new FaqVO();
				vo.setType(type.get(i).text());
				vo.setSubject(subject.get(i).text());
				vo.setContent(content.get(i).text());
				if(vo.getType().equals("배송신청")||vo.getType().equals("트래킹 추가")||vo.getType().equals("회원가입"))
				{
					   vo.setFcno(num[1]); // 2번 배송신청서&회원 관련
				}
				else if(vo.getType().equals("입고지연")||vo.getType().equals("보관료"))
				{
					   vo.setFcno(num[2]); // 3번 입고관련
				}
				else if(vo.getType().equals("무조건 보상제")||vo.getType().equals("통관조회")||vo.getType().equals("배송조회"))
				{
					   vo.setFcno(num[3]); // 4번 배송관련
				}
				else if(vo.getType().equals("카드결제")||vo.getType().equals("직구페이 결제")||vo.getType().equals("관부가세"))
				{
					   vo.setFcno(num[4]); // 5번 결제관련
				}
				else if(vo.getType().equals("반송신청")||vo.getType().equals("반송비 결제"))
				{
					   vo.setFcno(num[5]); // 6번 반송결제
				}
				else if(vo.getType().equals("결제")||vo.getType().equals("배송")||vo.getType().equals("상품구매")||vo.getType().equals("일반"))
				{
					   vo.setFcno(num[6]); // 7번 다해줌
				}
				else if(vo.getType().equals("쿠폰/프로모션")||vo.getType().equals("세금계산서"))
				{
					   vo.setFcno(num[7]); // 8번 기타
				}
				dao.FaqInsertData(vo);
				// 데이터 수집
			}
		} catch (Exception ex) {}
	}
	
	// 이용안내 정보 가져오기
	public void InformationUseGetData() 
	{
		InformationUseDAO dao = new InformationUseDAO();
		// IUNO SUBJECT CONTENT IMAGE  REGDATE HIT 
		try {
			// 사이트 연결 => HTML 태그 읽기
			Document doc = Jsoup.connect("https://post.malltail.com/useguides/index").get();
			//System.out.println(doc.toString()); // 몰테일의 이용안내 html =>  html 들어옴(확인 완료)
		    Elements subject = doc.select("#b_inner_wrap > table > tbody > tr > td.txt_left > span");
			//System.out.println(subject.toString()); //span 태그값 들어옴(확인 완료)
		    
		    // 이미지 태그 다 다름 
			/* String[] url= {"",
					"malltails/direct_info",
					"buy_guides/polo_guide",
					"buy_guides/amazon_guide",
					"buy_guides/gap_guide",
					"buy_guides/taobao_guide",
					"buy_guides/rakuten_guide"};//라쿠렌톻?
			for(int i=0;i <url.length;i++)
			{
				Document doc2 = Jsoup.connect("http://post.malltail.com/"+url[i]).get();
				Elements image =doc2.select("div.list-photo_wrap img.center-croping");
			       
			}*/
		    
			for(int i=0;i<subject.size();i++)
			{
				System.out.println(i+1);
				System.out.println(subject.get(i).text());
				System.out.println("====================");
				InformationUseVO vo = new InformationUseVO();
				vo.setSubject(subject.get(i).text());
				dao.InformationUseInsertData(vo);
				// 데이터 수집
			}
		} catch (Exception ex) {}
	}
	
	// 국가센터 정보 가져오기
	public void NationIntroduceGetData() 
	{
		NationIntroduceDAO dao = new NationIntroduceDAO();
	//  NINO nation, title IMAGE TIME WORK_STATE
		try {
			// 사이트 연결 => HTML 태그 읽기
			Document doc = Jsoup.connect("https://post.malltail.com/faqs/index").get();
			//System.out.println(doc.toString()); // 몰테일의 국가센터정보 html =>  html 들어옴(확인 완료)
		    Elements nation = doc.select("p.nat");
			//System.out.println(nation.toString()); //p 태그값 들어옴(확인 완료)
		    Elements title = doc.select("p.tit");
			//System.out.println(title.toString()); //p 태그값 들어옴(확인 완료)
		    Elements image = doc.select("div > div.img-box > img");
			//System.out.println(image.toString()); //img 태그값 들어옴(확인 완료)
		    
			for(int i=0;i<title.size();i++)
			{
				System.out.println(i+1);
				System.out.println(nation.get(i).text());
				System.out.println(title.get(i).text());
				System.out.println("https://post.malltail.com"+image.get(i).attr("src"));
				System.out.println("====================");
				NationIntroduceVO vo = new NationIntroduceVO();
				vo.setNation(nation.get(i).text());
				vo.setTitle(title.get(i).text());
				vo.setImage("https://post.malltail.com"+image.get(i).attr("src"));
				dao.NationIntroduceData(vo);
				// 데이터 수집
			}
		} catch (Exception ex) {}
	}
	
		
}
