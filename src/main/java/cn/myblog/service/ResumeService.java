package cn.myblog.service;

import org.json.JSONObject;

import cn.myblog.entity.UserInfo;

public interface ResumeService {
	/**
	 * 保存简历至数据库
	 * @param jsonObj
	 * @return
	 */
	boolean saveProfile(JSONObject jsonObj);
	/**
	 * 更新简历至数据库
	 * @param jsonObj
	 * @return
	 */
	boolean updateProfile(JSONObject jsonObj);
}
