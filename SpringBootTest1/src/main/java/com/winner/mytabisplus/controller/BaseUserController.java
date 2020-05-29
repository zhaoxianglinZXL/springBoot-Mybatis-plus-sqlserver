package com.winner.mytabisplus.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.winner.mytabisplus.entity.BaseUser;
import com.winner.mytabisplus.service.IBaseUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
@Api(description = "用户操作接口")
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
			return ResponseEntity.notFound().build(); 
		}
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
	
	/**
	 * 分页查询
	 */
	@GetMapping("baseuserbywrapper")
	public ResponseEntity<String> baseuserbywrapper(BaseUser user){
		BaseUser bu = baseUserService.queryBaseUserByWrapper(user);
		System.out.println(bu.toString());
		return ResponseEntity.ok("123");
	}
	
	// 方法名
	@ApiOperation(value = "获取otp", notes="通过手机号获取OTP验证码")
	// 参数
	@ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = false)
	@GetMapping("selectcustomersql")
	public ResponseEntity<String> selectCustomerSql(@Param("telephone")String telephone) {
		System.out.println("电话好嘛"+telephone);
		BaseUser bu = baseUserService.queryByCustomerSql();
		return ResponseEntity.ok("成功操作");
	}
}
