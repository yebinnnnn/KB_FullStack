package com.kb.starbucks.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc //<mvc:annotation-driven />과 같은 역할
/*<mvc:annotation-driven/>
@Controller, @RequestMapping
등 인식
RequestMappingHandlerMapping, RequestMappingHandlerAdapter 자동 등록
@RequestBody, @ResponseBody
등을 위한 HttpMessageConverters 자동 등록 (ex: JSON 변환)
@Valid 지원
기본 Formatter, Validator 등록
 */
@ComponentScan(basePackages = {"com.kb.starbucks.control"})
public class MVC2Config implements WebMvcConfigurer {
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //정적 파일을 외부 URL로 접근 가능하게 연결하는 설정.
        registry.addResourceHandler("/r/**")
                .addResourceLocations("/resources/");
    }
}