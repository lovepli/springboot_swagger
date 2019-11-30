package com.itguang;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itguang.mapper")
public class SpringbootSwaggerDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerDemo1Application.class, args);
	}
}
