package cn.tarpas.pocket.service;

import cn.tarpas.pocket.po.User;

public interface UserService {
	public boolean userExist(User user);
	
	public boolean login(User user);
}
