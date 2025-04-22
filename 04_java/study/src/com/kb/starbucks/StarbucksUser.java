package com.kb.starbucks;

import com.kb.starbucks.dao.CustomerDAOArray;
import com.kb.starbucks.dao.ProductDAO;
import com.kb.starbucks.dao.ProductDAOArray;
import com.kb.starbucks.vo.Customer;
import com.kb.starbucks.vo.Product;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Scanner;


public class StarbucksUser {
    private Scanner sc;
    //결합도를 낮추고 응집도를 높인다. 더 상위인 추상클래스로 변수 선언하는 걸 지향.
    //private ProductDAOArray pDao;
    private ProductDAO pDao;
    private com.kb.starbucks.dao.CustomerDAO cDao;
    public StarbucksUser(int size) {
        //1. dao.properties 파일을 JVM 에 로딩해서 property 로 관리.
        java.util.Properties env = new java.util.Properties();
        try {
            env.load(new FileInputStream("c:\\dao.properties"));
            String className=env.getProperty("pDao");
            //pDao 에 해당하는 값으로 찾아옴.
            //2. 클래스 이름으로 클래스 파일찾아 JVM 에 로드
            Class c= Class.forName(className);
//            java.lang.reflect.Method[] ms=c.getDeclaredMethods();
//            for(Method m:ms){
//                System.out.println(m.getName());
////            }
        //3. 객체 생성 절차. 생성해서 pDao 에 대입.
//            c.newInstance();
//            Constructor.newInstance
            pDao = (ProductDAO) c.newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
//        pDao=new ProductDAOArray(5); //최대 5개의 상품이 저장될 저장소
        cDao = new CustomerDAOArray(10); //최대 고객을 10명 저장할 수 있는 저장소
        sc=new Scanner(System.in);
    }
    public void addCustomer(){
        System.out.println(">>고객추가<<");
        System.out.println("고객 ID:");
        String id=sc.nextLine();
        System.out.println("고객 비번:");
        String pwd=sc.nextLine();
        System.out.println("고객 이름:");
        String name=sc.nextLine();
        cDao.insert(new Customer(id,pwd,name));
    }

    public void searchById(){
        System.out.println(">>고객ID로 조회<<");
        System.out.println("고객ID:");
        String id=sc.nextLine();
        Customer c= cDao.searchById(id);
        System.out.println(c);
        //고객 정보는 다음과 같이 출력된다. id는 XXX, pwd 는 YYY, 이름은 ZZZ
        //해당 id의 고객이 없다면 null이 출력된다.
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
            System.out.println("1-전체 조회 2-상품 추가 3-상품번호로 검색, 4-상품명으로 검색, " +
                    "5-고객 추가 6-ID로 고객조회 9-종료");
            System.out.println("작업을 선택하세요");
            otp = su.sc.nextLine();
            if(otp.equals("1")) {
                su.search();
            } else if (otp.equals("2")) {
                su.add();
            } else if (otp.equals("3")) {
                su.searchByNo();
            } else if(otp.equals("4")) {
                su.search();
            }else if(otp.equals("5")) {
                su.addCustomer();
            }
            else if(otp.equals("6")) {
                su.searchById();
            }
        }while(!otp.equals("9"));
    }
}
