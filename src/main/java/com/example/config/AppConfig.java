package com.example.config;

import com.example.scope.ThreadLocalScope;
import com.example.service.MyBean;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer =new CustomScopeConfigurer();
        Map<String,Object> scopes=new HashMap<>();
        scopes.put("thread-local",new ThreadLocalScope());
        configurer.setScopes(scopes);
        return configurer;
    }

    @Bean
    @org.springframework.context.annotation.Scope("thread-local")
    public MyBean myBean() {
        return new MyBean();
    }


}
