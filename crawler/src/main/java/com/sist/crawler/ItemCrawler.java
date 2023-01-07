package com.sist.crawler;

import com.sist.util.DBConn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemCrawler {

	// 캠핑리스트 사이트
    private static final String DOMAIN = "https://campinglist.co.kr";

    private static final String ITEM_LIST = "https://campinglist.co.kr/product/list.html?cate_no=";

    // 시작 페이지
    private static final int START_PAGE = 1;

    // 끝 페이지
    private static final int LAST_PAGE = 1;
    
    /*  String은 변경 불가능한 문자열을 생성하지만 StringBuilder는 변경 가능한 문자열을 만들어준다
     *  
     *  StringBuilder의 객체를 생성한 후 .append("문자열")의 인자로 연결하고자하는 문자열을 넣어쇼ㅓ
     *  StringBuilder의 객체를 통해 호출한다
     */
    private final StringBuilder sb = new StringBuilder();

    private Connection conn;

    private PreparedStatement pstmt;

    private final DBConn dbConn;

    public ItemCrawler() {
        this.dbConn = DBConn.getInstance();

    }

    public void run(int cateNo) {
        String url = ITEM_LIST + cateNo + "&page=";
        try {
            System.out.println("카테고리 번호: " + cateNo + "번 크롤링 중...");
            for (int page = START_PAGE; page <= LAST_PAGE; page++) {
                Document document = Jsoup.connect(url + page).get();
                Elements elements = document.select("#contents div.guide_contents ul.prdList li");
                for (Element element : elements) {
                    String itemDetailPage = element.select("div.description strong.name a").attr("href");
                    if (itemDetailPage.length() == 0) {
                        continue;
                    }
                    // DOMAIN => 캠핑사이트 
                    Item item = into(DOMAIN + itemDetailPage, cateNo);
                    insertDatabase(item);
                }
            }
            System.out.println("카테고리 번호: " + cateNo + "번 크롤링 끝...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Item into(String url, int cateNo) {
        Item item = new Item(cateNo);
        String itemName = "", itemImage = "", itemBrand = "", itemDescription = "", itemStatus = ItemStatus.ON_SALE.getStatus();
        int itemPrice = 0;
        try {
            Document document = Jsoup.connect(url).get();
            Elements dataArea = document.select("#contents div.detaarea div.detailArea");

            // 상품 이미지
            Elements imgArea = dataArea.select("div.imgArea");
            for (Element element : imgArea) {
                // 대표 이미지
                String mainImage = "https:" + element.select("div.keyImg div.thumbnail a img").attr("src");
                sb.append(mainImage).append(",");
                Elements listImg = element.select("div.listImg ul li img.ThumbImage");
                for (Element img : listImg) {
                    String subImg = "https:" + img.attr("src");
                    sb.append(subImg).append(",");
                }
                // deleteCharAt : 특정 위치의 문자열을 삭제한다
                sb.deleteCharAt(sb.length() - 1);
                itemImage = sb.toString();
                sb.setLength(0);
            } // end for

            // 상품 기본 정보
            for (Element element : dataArea) {
                Elements itemInfos = element.select("div.infoArea");
                for (Element itemInfo : itemInfos) {
                    itemName = itemInfo.select("div.headingArea h2").text();
                    Elements select = itemInfo.select("div.disno ul.disnoul li.xans-record-");
                    for (Element s : select) {
                        Elements list = s.select("div.disnoul_left span");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).text().equals("브랜드")) {
                                itemBrand = s.select("div.disnoul_right span").get(i).text();
                            }
                            String tempMoney = "";
                            if (list.get(i).text().equals("기존판매가")) {
                                tempMoney = s.select("div.disnoul_right span span strike").text();
                                itemPrice = convert(tempMoney);
                            } else if (list.get(i).text().equals("판매가")) {
                                tempMoney = s.select("div.disnoul_right span strong").text();
                                if (tempMoney.equals("")) {
                                    itemPrice = 0;
                                    itemStatus = ItemStatus.STORE_SALE.getStatus();
                                } else {
                                    itemPrice = convert(tempMoney);
                                }
                            } // end if
                        } // end for
                    } // end for
                } // end for
            } // end for

            // 상품 설명
            Elements descImg = document.select("#contents div.detaarea div.xans-element- div.cont div.guide_contents div.continner img");
            String tempImg = "";
            for (Element element : descImg) {
                tempImg = DOMAIN + element.attr("src");
                sb.append(tempImg).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            itemDescription = sb.toString();
            sb.setLength(0);

            item.setName(itemName);
            item.setImage(itemImage);
            item.setBrand(itemBrand);
            item.setPrice(itemPrice);
            item.setStatus(itemStatus);
            item.setDescription(itemDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    private int convert(String temp) {
        temp = temp.replaceAll("\\,", "");
        return Integer.parseInt(temp.substring(0, temp.length() - 1));
    }

    private void insertDatabase(Item item) {
        String sql =
                "INSERT INTO HC_ITEM_2 (ino, name, image, brand, price, stock, description, status, icno) " +
                        "VALUES (HC_ITEM_INO_SEQ_2.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = dbConn.createConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getImage());
            pstmt.setString(3, item.getBrand());
            pstmt.setInt(4, item.getPrice());
            pstmt.setInt(5, item.getStock());
            pstmt.setString(6, item.getDescription());
            pstmt.setString(7, item.getStatus());
            pstmt.setInt(8, item.getIcno());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection(pstmt, conn);
        }
    }

}
