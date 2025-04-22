package com.kb.starbucks.vo;

public class Customer {
    private String id;
    private String pwd;
    private String name;

    public Customer(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }
    public Customer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "고객 아이디:"+ id+"고객 비번:"+pwd+"고객이름:"+name+";";
    }

    //얘도 오버라이드. alt+insert 하면 재정의 할 수 있다 ㅎ
    //
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof Customer){
            Customer c= (Customer) obj;
            return c.getId().equals(this.getId());
        }else{
            return false;
        }
    }
}
