package cn.myblog.service;

import cn.myblog.entity.UserInfo;

public interface UserService {
	UserInfo getUserInfo(String userName);
	
	 boolean login(String userName,String password);
}
