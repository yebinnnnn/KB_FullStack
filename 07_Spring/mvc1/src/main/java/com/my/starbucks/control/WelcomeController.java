package com.my.starbucks.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//앞서 배운 어노테이션들 @Component , @Service , @Repository,
@RestController
//Controller 어노테이션은 웹 애플리케이션 컨텍스트에서만 쓰이는 어노테이션.
//요청을 처리해줄 클래스에 붙이는것( 스프링부트에서 쓰는거랑 같다~)
//설정해둔 Dispatcher Servlet 이 모든 요청을 받는다. 이 요청에 대한 처리는 Handler Mapper
//도우미들을 통해 처리. 이 Handler 들이 컨트롤러를 찾아내서 처리한다.(매서드 호출)
public class WelcomeController {

    @GetMapping("/welcome") //또는 GetMapping 가능.
    public String a(){
        return "WELCOME";
//        return "a.jsp"; //->a.jsp 페이지로 이동하라는 의미
    }
}
