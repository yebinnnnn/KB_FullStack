package org.scoula.domain;

import jakarta.annotation.PostConstruct;

public class Parrot {
    private String name;
    //디폴트 생성자

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    //디폴트 생성자 호출 후 PostConstuct 로 이후 속성 호출
//    //원래 null 이었다가 초기화된 객체로 준비가능~!
//    @PostConstruct
//    public void init() {
//        this.name = "Kiki";
//    } //이제 koko 가 아니라 kiki 로 출력됨

    @Override
    public String toString() {
        return "Parrot : " + name;
    }


}
