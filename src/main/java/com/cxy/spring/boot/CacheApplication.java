package com.cxy.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.cxy.spring.boot.**.mapper")
//@EnableAsync   （启动时或者类上注解，@Async异步才生效）
@EnableScheduling
@SpringBootApplication
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}
