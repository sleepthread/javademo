package com.ewater.jwt_hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtHelloApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtAuthenticationFilterRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(new JwtAuthenticationFilter());
        //拦截规则
        registration.addUrlPatterns("/api/*");
        //过滤器名称
        registration.setName("jwtAuthenticationFilter");
        return registration;
    }
}
