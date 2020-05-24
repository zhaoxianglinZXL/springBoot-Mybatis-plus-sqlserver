package com.winner;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;


@SpringBootApplication
@Configuration
@MapperScan("com.winner.mytabisplus.mapper")
public class SpringBootStart {

	private static final Logger log = LoggerFactory.getLogger(SpringBootStart.class);
	
	/**
	     * 分页插件
	* @return
	*/
	@Bean public PaginationInterceptor paginationInterceptor() {
	    PaginationInterceptor page = new PaginationInterceptor(); return page; 
	}
	 
	
	/**
	 * springboot启动类 main方法
	 */
	public static void main(String[] args) {
		log.info("==========开始启动SpringBootTest1============");
		SpringApplication.run(SpringBootStart.class, args);
		log.info("==========启动SpringBootTest1成功============");
	}
}
