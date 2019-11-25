package com.ssafy.safefood;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.safefood.interceptor.JwtInterceptor;

@SpringBootApplication
public class SafefoodUserServerApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SafefoodUserServerApplication.class, args);
	}

	@Autowired
	private JwtInterceptor jwtInterceptor;
	public SafefoodUserServerApplication() {
		// TODO Auto-generated constructor stub
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
												.excludePathPatterns(Arrays.asList("/auth/**"));
		
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","OPTIONS", "PUT");
	}
}
