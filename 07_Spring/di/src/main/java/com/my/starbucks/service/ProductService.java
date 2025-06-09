package com.my.starbucks.service;

import com.my.starbucks.dao.ProductDAO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//의존성 주입: Service 가 DAO 를 사용할거다. 다만, new 로 직접적 사용하지 않을것.
@Service("service")
public class ProductService {
    @Qualifier("daoMysql")
    final private ProductDAO dao;
    //어떤 객체 주입을 원하는건지 몰라서 dao 에 빨간줄 생김
    @Autowired
    public ProductService(@Qualifier("daoMysql")ProductDAO dao) {
        this.dao=dao;
    }
//    public ProductService(ProductDAO dao) {
//        this.dao = dao;
//    }
    
//    //setdao 메서드를 통해 주입도 가능
//    public void setDao(ProductDAO dao) {
//        this.dao = dao;
//    }
}
