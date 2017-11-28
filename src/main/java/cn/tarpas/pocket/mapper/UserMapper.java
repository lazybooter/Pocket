package cn.tarpas.pocket.mapper;

import cn.tarpas.pocket.po.User;

public interface UserMapper {
	/**
	 * 自定义SQL函数
	 * */
	User userExist(String phone);
	
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}