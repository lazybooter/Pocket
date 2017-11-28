package cn.tarpas.pocket.service.im;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tarpas.pocket.mapper.UserMapper;
import cn.tarpas.pocket.po.User;
import cn.tarpas.pocket.service.UserService;

public class UserServiceIm implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceIm.class);
	private User loginUser;
	
	@Override
	public boolean userExist(User user) {
		loginUser = userMapper.userExist(user.getPhone());
		if(loginUser == null){
			LOGGER.info("用户不存在！");
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean login(User user) {
		if(!(user.getPassword().equals(loginUser.getPassword()))){
			LOGGER.info("密码错误！");
			return false;
		}
		return true;
	}

}
