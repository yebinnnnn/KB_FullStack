package com.kb.starbucks.dao;

import com.kb.starbucks.vo.Customer;

public class CustomerDAOArray implements CustomerDAO{

    private Customer[] customers; //저장소
    private int totalCnt; //저장된 상품 수
    public CustomerDAOArray(){

    }

    public CustomerDAOArray(int size) {
        //size 만큼 저장소를 만들어보자. 배열 형태가 될 수도 있고
        //리스트가 될수도 있다. 전달된 인자의 갯수만큼 배열 생성
        customers= new Customer[size];
    }

    @Override
    public void insert(Customer customer) {
        for(int i=0; i<totalCnt; i++){
            //굳이 이름으로 판별하지 않아도 객체로 equals
            //Nullpoint Exception 피하기
            if(customers[i].getId().equals(customer.getId())){
                System.out.println("이미 존재하는 아이디입니다.");
                return;//이미 저장소에 있는 경우
            }
        }
        //상품번호가 같은지 확인 먼저 해야함
        customers[totalCnt] = customer;
        totalCnt++;
    }
    public Customer searchById(String id){
        for(int i=0; i<totalCnt; i++){
            if(customers[i].getId().equals(id)){
                return customers[i];//이미 저장소에 있는 경우
            }
        }
        return null;
    }
}
