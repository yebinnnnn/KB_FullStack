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

    //이름 똑같아야 오버라이딩됨
    @Override
    public String toString(){
        return prodNo+":"+prodName+":"+prodPrice+":"+prodDt;
    }
    
    //얘도 오버라이드. alt+insert 하면 재정의 할 수 있다 ㅎ

    /**
     * 인자로 쓰이는 상품의 상품번호와 현재객체의 상품 번호가 같으면 true반환
     * 그렇지 않으면 false
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof Product){
            Product p = (Product) obj;
            return p.getProdNo().equals(this.getProdNo());
        }else{
            return false;
        }
    }
}
