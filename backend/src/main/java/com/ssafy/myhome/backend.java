package com.ssafy.myhome;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ssafy.myhome.model.dao", annotationClass = Mapper.class)
@SpringBootApplication
public class backend {

	public static void main(String[] args) {
		SpringApplication.run(backend.class, args);
	}

}
