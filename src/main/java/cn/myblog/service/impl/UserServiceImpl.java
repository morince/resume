package cn.myblog.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.myblog.dao.UserDao;
import cn.myblog.entity.UserForWeb;
import cn.myblog.entity.UserInfo;
import cn.myblog.service.UserService;
import cn.myblog.utils.AESUtil;

/**
 * @Title: UserServiceImpl.java
 * @Package cn.myblog.service.impl
 * @Description: 该类主要涉及到密码的校验规则
 * @author kilid
 * @date 2017年1月10日
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	public UserInfo getUserInfo(String userName) {
		UserInfo user = new UserInfo();

		return user;
	}

	public boolean login(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
		if (AESUtil.validate(password)) {
			int count = dao.login(userName, password);
			if (count == 1) {
				System.out.println(userName + ":" + password);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean registerUser(JSONObject jsonObj) {
		UserForWeb user = UserForWeb.setUser(jsonObj);
		dao.registry(user);
		return true;
	}

}
