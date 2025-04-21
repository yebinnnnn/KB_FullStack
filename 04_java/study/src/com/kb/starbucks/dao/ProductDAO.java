package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Product;
//Product 를 다루기 위한 CRUD 클래스(DAO)
//상품의 값을 책임지는 클래스가 (VO value of Object)-> DB 테이블과는 관계없다. Entity 와 다르다.
//값을 가지고 있는 객체에 불과함. Entity 는 실제 저장소와 똑같이 생긴 형태
public class ProductDAO {
    //외부에 노출되지 않는 상품들이 저장되는 저장소
    private Product[] products; //저장소
    private int totalCnt; //저장된 상품 수
    public ProductDAO(){}

    /**
     * 저장소의 크기만큼 저장소를 만든다.
     * @param size 저장소의 크기
     */
    public ProductDAO(int size) {
        //size 만큼 저장소를 만들어보자. 배열 형태가 될 수도 있고
        //리스트가 될수도 있다. 전달된 인자의 갯수만큼 배열 생성
        products = new Product[size];
    }

    /**
     * 상품을 저장소에 추가한다.
     * 단, 상품 번호가 같은 상품이 이미 저장소에 있다면 추가하지 않는다
     * @param product 상품
     */
    public void insert(Product product) {
        for (Product value : products) {
            if (value.getProdNo().equals(product.getProdNo())) {
                return;
            }
        }
        //상품번호가 같은지 확인 먼저 해야함
        products[totalCnt] = product;
        totalCnt++;
    }

    /**
     * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다.
     * @param prodNo 상품번호
     * @return 상품을 반환한다. 단 상품이 없을 경우 null을 반환한다.
     */
    public Product findByProdNo(String prodNo) {
        for (Product product : products) {
            if (product.getProdNo().equals(prodNo)) {
                return product;
            }
        }
        return null;
    }

    /**
     *저장소의 모든 상품을 반환한다.
     * @return 저장소를 반환하는것이 아니라 저장소에 저장된 상품들만 반환한다.
     */
    public Product[] findAll(){
        return products;
//        Product[] pArr=new Product[totalCnt];
//        System.arraycopy(products, 0, pArr, 0, totalCnt);
//        return pArr;
        //Arrays.copyOf(products, totalCnt)을 사용하는 방법도 있음.
    }
    public void update(Product product) {

    }
    public void delete(String prodNo) {
        for(Product product : products) {
            if (product.getProdNo().equals(prodNo)) {
            }
        }
    }
}
