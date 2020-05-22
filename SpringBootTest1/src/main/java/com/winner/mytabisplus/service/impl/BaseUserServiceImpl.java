package com.winner.mytabisplus.service.impl;

import com.winner.mytabisplus.entity.BaseUser;
import com.winner.mytabisplus.mapper.BaseUserMapper;
import com.winner.mytabisplus.service.IBaseUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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

}
