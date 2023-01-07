package com.sist.crawler;

import lombok.Getter;

import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Item {

    private int ino;

    private String name;

    private String image;

    private String brand;

    private int price;

    private String description;

    private int stock;

    private String status;

    private int icno;

    public Item(int cateNo) {
        this.stock = setRandomItemStock(); //재고량
        this.icno = setItemCnoBy(cateNo); //itemcategoty no
    }

    private int setRandomItemStock() {
        // 100 ~ 1000 사이의 랜덤한 숫자
        return (int) ((Math.random() * 901) + 100);
    }
    /* Array.stream은 람다를 활용할 수 있는 기술
     * 
     * filter : 요소들을 조건에 따라 걸러내는 작업을 해준다
     *          길이의 제한, 특정 문자 포함 등의 작업을 하고 싶을 때 사용이 가능하다
     * findFirst() : filter 조건에 일치하는 element1개를 Optional로 리턴한다
     *               조건에 일치하는 요소가 없다면 empty가 리턴된다
     *               => 가장 앞에 있는 요소를 리턴함
     * orElseThrow : Optional의 인자가 null일 경우 예외처리를 시킨다
     */
    private int setItemCnoBy(int cateNo) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getCode() == cateNo)
                .findFirst()
                .orElseThrow().getCno();
    }

    @Override
    public String toString() {
        return "Item = " + name + " " + image + " " + brand + " " + price + " " + stock + " " + icno + " " + status + " " + description;
    }


}
