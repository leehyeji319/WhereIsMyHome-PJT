package com.ssafy.myhome.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	
	
	//=== root-context.xml ===//
	//WebMvcConfigurer 임플리해서
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/user/login_form.do").setViewName("user/login");
//		registry.addViewController("/dept/register_form.do").setViewName("dept/register_form");
	}
	
}
