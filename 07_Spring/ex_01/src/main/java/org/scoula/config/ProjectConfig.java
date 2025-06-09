package org.scoula.config;

import org.scoula.domain.Parrot;
import org.scoula.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 컨텍스트 구성 시 사용할 구성 클래스 정의
@Configuration
public class ProjectConfig {
    //프록시임. (위임이 아니라 상속을 이용)
    @Bean //맴객체 -> 메서드 명이 키가 되고, 값으로 인스턴스를 참조하는 형태.
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }
    //빈으로 등록등록
    @Bean
    String hello()
    {
        return "Hello";
    }
    @Bean
    Integer ten()
    {
        return 10;
    }
    
    //이 상태에서는 Parrot 과 person이 관련이 없음
    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Ella");
        //이걸 통해서 메서드 호출
        p.setParrot(parrot);
        return p;
    }
}
