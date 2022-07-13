package com.outshoes.servidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.outshoes.servidor.jwt.config.JwtFilter;

@SpringBootApplication
public class ServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
	FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
	registrationBean.setFilter(new JwtFilter());
	registrationBean.addUrlPatterns("/api/usuario/*");
	registrationBean.addUrlPatterns("/api/producto/*");
	return registrationBean;
	}
	
}
