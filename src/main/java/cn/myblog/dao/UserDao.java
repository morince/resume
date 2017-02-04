package cn.myblog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.myblog.entity.UserForWeb;

@Repository
public interface UserDao {

	/**
	 * 保存用户注册信息
	 * @param user
	 * @return
	 */
	int registry(@Param("UserForWeb") UserForWeb user);

	/**
	 * 对用户登录进行识别，若有记录返回记录数量
	 * @param userName
	 * @param userP
	 * @return
	 */
	int login(@Param("userN") String userName, @Param("userP") String userPW);

}
