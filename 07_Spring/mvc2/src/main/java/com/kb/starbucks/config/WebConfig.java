package com.kb.starbucks.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
/**
 * web.xml문서대신
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    /**
     * ContextLoaderListener용 설정
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    /**
     * DispatcherServlet용 설정
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MVC2Config.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}