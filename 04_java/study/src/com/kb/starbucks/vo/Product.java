package com.kb.starbucks.vo;

import java.util.Date;

public class Product {
    private String prodNo;
    private String prodName;
    private int prodPrice;
    private Date prodDt; //상품 제조 일자

    //세 생성자가 오버로드상태.(매개변수 다름 상태)
    public Product(){}
    public Product(String prodNo, String prodName, int prodPrice) {
//        this.prodNo = prodNo;
//        this.prodName = prodName;
//        this.prodPrice = prodPrice;
        //생성자 오버로드
        this(prodNo, prodName, prodPrice, null);
    }
    public Product(String prodNo, String prodName, int prodPrice, Date prodDt) {
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDt = prodDt;
    }
    //java 빈이 되기 위해선 생성자를 만들어야함

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Date getProdDt() {
        return prodDt;
    }

    public void setProdDt(Date prodDt) {
        this.prodDt = prodDt;
    }
}
