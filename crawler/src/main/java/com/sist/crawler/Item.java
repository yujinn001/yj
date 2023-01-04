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
        this.stock = setRandomItemStock();
        this.icno = setItemCnoBy(cateNo);
    }

    private int setRandomItemStock() {
        // 100 ~ 1000 사이의 랜덤한 숫자
        return (int) ((Math.random() * 901) + 100);
    }

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
