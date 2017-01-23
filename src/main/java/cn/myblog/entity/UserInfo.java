package cn.myblog.entity;

/**
 * @Title: UserInfo.java
 * @Package cn.myblog.entity
 * @Description: 用户的详细信息
 * @author kilid
 * @date 2017年1月10日
 * @version V1.0
 */
public class UserInfo {
	// userId 主键1
	String userId;
	// 用户真实姓名
	String name;
	// 用户的昵称
	String nickName;
	// 用户的注册邮箱
	String mail;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
