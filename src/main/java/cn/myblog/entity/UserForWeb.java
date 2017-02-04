package cn.myblog.entity;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

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
	private String userN;
	// 用户密码：加密规则，使用进行AES
	private String userP;
	// 用户email
	private String userEmail;
	// 用户ID
	private String userId;
	// 创建日期
	private Date createDate;

	public UserForWeb(){
		
	}
	public static UserForWeb setUser(JSONObject jsonObj){
		UserForWeb user = new UserForWeb();
		user.setUserN(jsonObj.optString("userName"));
		user.setUserP(jsonObj.optString("password"));
		user.setUserEmail(jsonObj.optString("email"));
		return user;
		
	}

	
	
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
