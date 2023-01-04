package com.sist.crawler;

public enum ItemStatus {

    ON_SALE("판매 중"),
    NOT_ON_SALE("판매 중지"),
    STORE_SALE("매장 판매"),
    OUT_OF_STOCK("재고 없음");

    private final String status;

    ItemStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
