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
	
	//registrationBean.addUrlPatterns("/api/usuario/*");
	//registrationBean.addUrlPatterns("/api/producto/*");
	
	registrationBean.addUrlPatterns("/api/producto/agregar/");
	registrationBean.addUrlPatterns("/api/producto/actualizar/*");
	registrationBean.addUrlPatterns("/api/producto/borrar");
	
	registrationBean.addUrlPatterns("/api/categoria/agregar/");
	registrationBean.addUrlPatterns("/api/categoria/actualizar/*");
	registrationBean.addUrlPatterns("/api/categoria/borrar");
	
	registrationBean.addUrlPatterns("/api/marca/agregar/");
	registrationBean.addUrlPatterns("/api/marca/actualizar/*");
	registrationBean.addUrlPatterns("/api/marca/borrar");
	
	registrationBean.addUrlPatterns("/api/coleccion/agregar/");
	registrationBean.addUrlPatterns("/api/coleccion/actualizar/*");
	registrationBean.addUrlPatterns("/api/coleccion/borrar");
	
	registrationBean.addUrlPatterns("/api/usuario/todo");
	registrationBean.addUrlPatterns("/api/usuario/actualizar/*");
	registrationBean.addUrlPatterns("/api/usuario/borrar");
	
	return registrationBean;
	}
	
}
