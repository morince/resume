package cn.myblog.entity;

import java.io.Serializable;

/**  
 * @Title: UserForWeb.java
 * @Package cn.myblog.entity
 * @Description: 用户登录校验
 * @author kilido
 * @date 2017年1月10日
 * @version V1.0  
 */
public class UserForWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5677041539267154933L;
	// 用户名
	String userN;
	// 用户密码：加密规则，使用进行RSA
	String userP;
	// 用户ID
	String userId;
	// 创建日期
	String createDate;

	public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN;
	}

	public String getUserP() {
		return userP;
	}

	public void setUserP(String userP) {
		this.userP = userP;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
