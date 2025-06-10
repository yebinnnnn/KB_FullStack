package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Product;

import java.util.List;

public interface ProductDAO {
    /**
     * 상품을 저장소에 추가한다
     * 단, 상품번호가 같은 상품이 이미 저장소에 있다면 추가하지 않는다
     * @param product 상품
     */
    void insert(Product product);

    /**
     * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다
     * @param prodNo 상품번호
     * @return 상품을 반환한다. 단 상품이 없을 경우 null을 반환한다
     */
    Product findByProdNo(String prodNo);


    /**
     * 저장소의 모든 상품을 반환한다
     * @return 저장소를 반환하는 것이 아니라
     *         저장소에 저장된 상품들만 반환한다
     */
    List<Product> findAll();

    /**
     * 구간에 해당하는 상품들을 반환한다
     * @param offset 시작행
     * @param count 검색할 행수
     * @return
     */
    List<Product> findAll(int offset, int count);

    /**
     * 전체 상품수를 반환한다
     * @return
     */
    long findCount();

    /**
     * 단어를 포함한 상품목록을 반환한다
     * @param word
     * @return
     */
    List<Product> findByProdNoContainingOrProdNameContaining(String word);
    void update(Product product);
    void delete(String prodNo);
}
