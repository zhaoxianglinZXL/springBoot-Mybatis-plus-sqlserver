package com.winner.mytabisplus.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winner.mytabisplus.entity.BaseUser;
import com.winner.mytabisplus.service.IBaseUserService;

import lombok.extern.java.Log;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
@RestController
@RequestMapping("base-user")
public class BaseUserController {

	@Autowired
	private IBaseUserService baseUserService;
	
	public static final Logger log = LoggerFactory.getLogger(BaseUserController.class);
	
	/**
	 * 保存一条数据
	 */
	@PostMapping("baseuser")
	public ResponseEntity baseUser(String st02, BaseUser bu) {
		log.debug("进入到MYBATIS-PLUS 单表单条数据保存");
		int result = baseUserService.saveUser(bu);
		if ( result == 0 ) { 
			return ResponseEntity.notFound().build(); }
		else { 
			return ResponseEntity.ok(result);
		}
	}
	
	/**
	 * 分页查询
	 */
	@GetMapping("baseuserpage")
	public ResponseEntity<IPage<BaseUser>> baseUserPage(){
		IPage<BaseUser> result= baseUserService.queryBaseUserByPage(); 
		return ResponseEntity.ok(result);
	}
}
