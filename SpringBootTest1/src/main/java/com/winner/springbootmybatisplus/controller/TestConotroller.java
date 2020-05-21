package com.winner.springbootmybatisplus.controller;

import javax.servlet.jsp.jstl.sql.Result;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConotroller {

	/**
	 * @return
	 */
	@PostMapping("student")
	public ResponseEntity<String> test(String param1) {
		System.out.println("测试类进入正常"+param1);
		return ResponseEntity.ok(param1);
	}
}
