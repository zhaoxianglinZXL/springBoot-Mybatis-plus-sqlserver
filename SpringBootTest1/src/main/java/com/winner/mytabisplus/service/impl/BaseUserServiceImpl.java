package com.winner.mytabisplus.service.impl;

import com.winner.mytabisplus.entity.BaseUser;
import com.winner.mytabisplus.mapper.BaseUserMapper;
import com.winner.mytabisplus.service.IBaseUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
@Service
public class BaseUserServiceImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements IBaseUserService {

	// 保存一条数据
	@Override
	public int saveUser(BaseUser baseUser) { 
		return baseMapper.insert(baseUser);
	}

	/**
             *  根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     * 
     * RowBounds对象有2个属性，offset和limit。
	 * offset:起始行数
	 * limit：需要的数据行数  
             *   取出来的数据就是：从第offset+1行开始，取limit行 即相当于每页的行数
     */
	@Override
	public IPage<BaseUser> queryBaseUserByPage() {
		// TODO Auto-generated method stub
		Page<BaseUser> page  = new Page<>(1,5);
		IPage<BaseUser> pageResult = baseMapper.selectPage(page, null);
		System.out.println(pageResult);
		return pageResult; 
	}

	/**
	 * 根据wrapper 进行查询
	 */
	@Override
	public BaseUser queryBaseUserByWrapper(BaseUser uesr) {
		// TODO Auto-generated method stub
		QueryWrapper<BaseUser> queryWrapper = new QueryWrapper<>();
		//queryWrapper.eq("BU00", uesr.getBu00());
		//queryWrapper.between("BU00", 38, 42);
		// 测试insql
		//queryWrapper.inSql("BU00", "SELECT BU00 FROM BASE_USER WHERE (BU00 BETWEEN 38 AND 42) ");
		Page<BaseUser> page = new Page<>(1,5);
		queryWrapper.eq("BU29", "002");
		IPage<BaseUser> pageUser = baseMapper.selectPage(page, queryWrapper);
		List<BaseUser> resultList = pageUser.getRecords();
		// and 和 or的复杂嵌套使用
		//queryWrapper.eq("BU29", "002").and( wrapper -> wrapper.eq("BU00", "38").or().eq("BU00", "39" ));
		
		// 使用queryWrapper进行分页查询
		//List<BaseUser> resultList = baseMapper.selectList(queryWrapper);
		System.out.println(resultList.toString());
		return resultList.get(0);
	}

	@Override
	public BaseUser queryByCustomerSql() {
		// TODO Auto-generated method stub
		// 根据传入的参数 以及实体类进行查询
		/*
		 * BaseUser queryUser = new BaseUser(); queryUser.setBu00(38); List<BaseUser>
		 * user = baseMapper.queryBaseUser2("42",queryUser);
		 */
		
		// 返回的参数设定为map集合
		//Map<String, Object> map = baseMapper.queryBaseUser("42");
		
		// 返回的参数设定为list + map 的集合
		BaseUser queryUser = new BaseUser(); 
		queryUser.setBu00(38);
		List<Map<String, Object>>  list = baseMapper.queryBaseUser3("42",queryUser);
		System.out.println(list.toString());
		return null;
	}
	
	
	
}
