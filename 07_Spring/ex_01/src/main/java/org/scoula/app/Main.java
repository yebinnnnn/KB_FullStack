package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //ProjectConfig 가 생성될때 Config 에 있는 Bean 이 붙어있는 메서드들을 다 한번씩 실행해줌.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2= context.getBean(Parrot.class);
        System.out.println(p2.getName());
        System.out.println(p==p2);

        String s = context.getBean(String.class);
        System.out.println(s);
        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
