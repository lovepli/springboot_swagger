package com.neo;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;

@SpringBootApplication
@EnableSwagger2Doc
@MapperScan("com.neo.mapper")
public class MybatisXmlApplication {

  //  Array[] array = new Array[]{};
	public static void main(String[] args) {
		SpringApplication.run(MybatisXmlApplication.class, args);
	}
}
