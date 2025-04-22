package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Customer;

public interface CustomerDAO {
    /**
     * 고객의 아이디가 이미 존재하면 이미존재합니다 출력 후 저장하지 않는다
     * @param customer
     */
    public void insert(Customer customer);
    public Customer searchById(String id);
}
