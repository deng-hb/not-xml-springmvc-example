package com.denghb.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by ppd on 16/11/23.
 */
public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Spring MVC
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(SpringMvcConfig.class);
        ServletRegistration.Dynamic mvc = servletContext.addServlet("mvc", new DispatcherServlet(mvcContext));
        mvc.setLoadOnStartup(1);
        mvc.addMapping("/");

        // 字符过滤
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic encoding = servletContext.addFilter("encodingFilter",encodingFilter);
        encoding.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
