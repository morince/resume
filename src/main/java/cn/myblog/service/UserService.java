package cn.myblog.service;

import org.json.JSONObject;

import cn.myblog.entity.UserInfo;

public interface UserService {
	/**
	 * 获取用户名
	 * @param userName
	 * @return
	 */
	UserInfo getUserInfo(String userName);

	/**
	 * 判断登录信息
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean login(String userName, String password);

	/**
	 * 注册新用户
	 * @param jsonObj
	 * @return
	 */
	boolean registerUser(JSONObject jsonObj);
}
