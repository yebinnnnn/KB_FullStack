package com.kb.starbucks.control;


import com.kb.starbucks.vo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
    //@RequestMapping("/") requestMapping 보단 get이나 post 로 나눠서 요청한다.
    @GetMapping("/a")
    public String a(){ //스프링 빈의 웹용 일반 메서드
        System.out.println("a메서드 호출됨 ");
        return "/a";
    }

    //RequestParam 에서 url 딸 수 있음
    //http://localhost:8080/b?name=test&price=1000&n=test
    @GetMapping("/b")
    public String b(@RequestParam(value="n") String no, //만약 b?no=1 의 형태면 no 에 할당가능. 매개변수 이름 다르게 사용하고 싶을떄.
            @RequestParam String name, @RequestParam int price){
        System.out.println("b메서드 호출됨");
        System.out.println(name+","+ price+","+no); //n으로 매개변수에 할당하여 이름은 no 로 쓴다.
        return "/a";
    }

    //http://localhost:8080/c?cArr=one&cArr=two&cArr=three
    @GetMapping("/c")
    public String c(@RequestParam String[] cArr){
        for(String c : cArr){
            System.out.println(c);
        }
        return "/a";
    }

    //http://localhost:8080/d?prodNo=C0001&prodName=ame&prodPrice=1000
    @GetMapping("/d")
    public String d(Product p){
        System.out.println(p);
        return "/a";
    }
    
    //------------Model And View 는 모델 정보와 뷰 정보를 둘 다 담고 있음
    @GetMapping("/f")
    public ModelAndView f(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/a"); //오홍
        mav.addObject("p", "메시지 입니다."); //이 정의된 attribute 를 view jsp 에서 이름값으로 쓸 수 있다.
        return mav;

    }

    @GetMapping("/h")
    public String h(){ //redirect 콜론이란: dispatcher Servlet 이 포워딩 방식으로 이동하는걸 안하겠단 소리.
        //서버사이드로의 이동을 하지않고 클라이언트 차원에서의 재요청 처리
        return "redirect://naver.com";
    }

    @GetMapping("/i")
    @ResponseBody //JSON 스트링 그대로 반환받기 위한 어노테이션
    public String i(){
        return "JSON RESPONSE";
    }
}
