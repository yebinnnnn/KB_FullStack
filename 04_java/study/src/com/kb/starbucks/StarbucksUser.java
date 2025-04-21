package com.kb.starbucks;

import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.dao.ProductDAOArray;
import com.kb.starbucks.vo.Product;

import java.util.Scanner;

public class StarbucksUser {
    private Scanner sc;
    //결합도를 낮추고 응집도를 높인다. 더 상위인 추상클래스로 변수 선언하는 걸 지향.
    //private ProductDAOArray pDao;
    private ProductDAO pDao;
    public StarbucksUser(int size) {
        pDao=new ProductDAOArray(5); //최대 5개의 상품이 저장될 저장소
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
        Product[] all = pDao.findAll();
        for(Product p : all){
            //toString 을 오버라이드함
            System.out.println(p);
        }
    }

    public void searchByNo(){
        System.out.println(">>상품 상세조회<<");
        System.out.println("상품번호:");
        String prodNo = sc.nextLine();
        Product p = pDao.findByProdNo(prodNo);
        System.out.println(p); //p.getProdName(); NullPointerException발생가능
    }
    public static void main(String[] args) {
        StarbucksUser su= new StarbucksUser(100);
        //su.search();
        String otp;
        do {
            System.out.println("1-전체 조회 2-상품 추가 3-상품번호로 검색, 4-상품명으로 검색, 9-종료");
            System.out.println("작업을 선택하세요");
            otp = su.sc.nextLine();
            if(otp.equals("1")) {
                su.search();
            } else if (otp.equals("2")) {
                su.add();
            } else if (otp.equals("3")) {
                su.searchByNo();
            }
        }while(!otp.equals("9"));
    }
}
