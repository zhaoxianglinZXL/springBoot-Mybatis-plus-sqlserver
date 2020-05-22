package com.winner.mytabisplus.service;

import com.winner.mytabisplus.entity.BaseUser;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
public interface IBaseUserService extends IService<BaseUser> {

	int saveUser(BaseUser baseUser);
	
	IPage<BaseUser> queryBaseUserByPage();
}
