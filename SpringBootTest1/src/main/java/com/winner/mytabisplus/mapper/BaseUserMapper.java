package com.winner.mytabisplus.mapper;

import com.winner.mytabisplus.entity.BaseUser;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-22
 */
public interface BaseUserMapper extends BaseMapper<BaseUser> {

	// 将返回结果集转为map
	@Select("SELECT * FROM BASE_USER WHERE bu00 = #{bu00}")
	public Map<String, Object> queryBaseUser(@Param("bu00") String bu00);
	
	// 根据参数参数
	@Select("SELECT * FROM BASE_USER WHERE bu00 = #{bu00} or bu00 = #{user.bu00}")
	public BaseUser queryBaseUser1(@Param("bu00") String bu00,BaseUser user);
	
	// 根据实体类查询
	@Select("SELECT * FROM BASE_USER WHERE bu00 = #{bu00} or bu00 = #{user.bu00}")
	public List<BaseUser> queryBaseUser2(@Param("bu00") String bu00,BaseUser user);
	
	// 将返回结果集转为list<map<String, Object>>
	@Select("SELECT BU00,BU01,BU03,BU04,BU05 FROM BASE_USER WHERE bu00 = #{bu00} or bu00 = #{user.bu00}")
	public List<Map<String, Object>> queryBaseUser3(@Param("bu00") String bu00,BaseUser user);
}
