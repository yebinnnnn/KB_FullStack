package com.my.starbucks.config;

import com.my.starbucks.dao.ProductDAO;
import com.my.starbucks.dao.ProductDAOMySQL;
import com.my.starbucks.service.ProductService;
import com.my.starbucks.vo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration

@ComponentScan(basePackages = {
        "com.my.starbucks.vo",
        "com.my.starbucks.dao",
        "com.my.starbucks.service"})
public class Config {
    //빈 어노테이션을 일일이 등록하는것도 일이다.. 컴포넌트 스캔을 써서 한번에 등록 가능
    //빈 어노테이션은 설정용 메서드 윗부분에 작성한다.
//    @Bean
//    public ProductDAO pDAO(){
//        return new ProductDAOMySQL();
//    }
//
//    //정석적으로 bean 클래스 설정하는 모습
//    @Bean
//    Product p (){
//        Product p = new Product();
//        p.setProdNo("C0001");
//        p.setProdName("아메리카노");
//        p.setProdPrice(1000);
//        return p;
//    }
//    @Bean
//    public ProductDAO daoYourSql(){
//        return new ProductDAOMySQL();
//    }

//    @Bean
//    public ProductService pService(){
//        ProductDAO dao1 = daoMysql();
//        ProductService service=new ProductService();
//        service.setDao(dao1);
//        return service;
////        return new ProductService(dao);
//    }
//
//    private ProductDAO daoMysql() {
//        ProductDAO dao = new ProductDAOMySQL();
//        return dao;
//    }
}
