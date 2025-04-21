package com.kb.starbucks;

import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.vo.Product;

import java.util.Scanner;

public class StarbucksUser {
    private Scanner sc;
    private ProductDAO pDao;
    public StarbucksUser(int size) {
        pDao=new ProductDAO(5); //최대 5개의 상품이 저장될 저장소
        sc=new Scanner(System.in);
    }
    public void add(){
        System.out.println("상품추가");
        System.out.println("상품번호:");
        String prodNo=sc.nextLine();
        System.out.println("상품이름");
        String prodName=sc.nextLine();
        System.out.println("상품가격");
        int prodPrice=Integer.parseInt(sc.nextLine());
        pDao.insert(new Product(prodNo,prodName,prodPrice));
        System.out.println("상품 추가 성공!");
    }

    public void search(){
        System.out.println(">>상품 전체조회<<");
        Product[] all=pDao.findAll();
        for(Product product:all){ //향상된 for 문
            System.out.println(product); //p.getProdName() 하면 Null포인터예외 발생할 수 있음
        }
    }
    public static void main(String[] args) {
        StarbucksUser su= new StarbucksUser(100);
        //su.search();
        System.out.println("1-전체 조회 2-상품 추가");
    }
}
