package com.feidian.xiang.webfinal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiang
 */
@SpringBootApplication
@MapperScan("com.feidian.xiang.webfinal.dao.mapper")
public class WebFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFinalApplication.class, args);
	}

}
