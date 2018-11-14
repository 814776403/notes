package com.liaoheng.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    //配置访问源
    public static String[] originVals={
            "127.0.0.1:8080",
            "localhost:8080",

    };
   /*配置跨域的过滤器*/
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        this.addAllowOrign(corsConfiguration);
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);//允许跨域
       //设置了的话 所有的请求都能访问后台
       corsConfiguration.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }

    private void addAllowOrign(CorsConfiguration corsConfiguration) {
       for(String origin:originVals){
           corsConfiguration.addAllowedOrigin("http://"+origin);
           corsConfiguration.addAllowedOrigin("https://"+origin);
       }
    }
}
