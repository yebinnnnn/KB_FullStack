package com.my.starbucks;

import com.my.starbucks.config.Config;
import com.my.starbucks.dao.ProductDAO;
import com.my.starbucks.service.ProductService;
import com.my.starbucks.vo.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context;
//
        context= new AnnotationConfigApplicationContext(Config.class);
//        context= new ClassPathXmlApplicationContext("applicationContext.xml");
        Product p =  context.getBean("p", Product.class);
        System.out.println(p); //null 아닌 값

//        ProductDAO dao = (ProductDAO) context.getBean("daomysql", ProductDAO.class);
//        System.out.println(dao);

        Product p2=context.getBean("p", Product.class);
        System.out.println(p==p2?"스프링빈은 싱글톤으로 관리": "서로 다른객체");

        ProductService ps= context.getBean("service",ProductService.class);
        System.out.println(ps);
    }
}