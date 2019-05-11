package com.imooc.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 是否支持cookie跨域
        config.setAllowedOrigins(Arrays.asList("*")); // 原始域  http://www.hs.com
        config.setAllowedHeaders(Arrays.asList("*")); // 允许头
        config.setAllowedMethods(Arrays.asList("*")); // 允许所有方法（POST GET PUT等）
        config.setMaxAge(300l); // 允许300S内相同的跨域请求不再拦截


        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }


}
