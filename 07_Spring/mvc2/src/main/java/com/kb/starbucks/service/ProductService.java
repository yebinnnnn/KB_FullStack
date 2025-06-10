package com.kb.starbucks.service;

import com.kb.starbucks.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service")
//@RequiredArgsConstructor
public class ProductService {
    final private ProductDAO dao;

    public ProductService(@Qualifier("daoYoursql") ProductDAO dao) {
        this.dao = dao;
    }
//
//    public void setDao(ProductDAO dao) {
//        this.dao = dao;
//    }
}
