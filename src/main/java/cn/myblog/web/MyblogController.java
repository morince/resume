package cn.myblog.web;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myblog.entity.UserInfo;
import cn.myblog.service.UserService;

@Controller
@RequestMapping("/")
public class MyblogController {
	@Autowired
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserInfo user;

	/**
	 * 
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		return "index";

	}

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login2";
	}

	/**
	 * 登录界面，校对，存储到session中
	 * 
	 * @param userName
	 * @param password
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public @ResponseBody Model apiLogin(String userName, String password, Model model, HttpServletRequest request) {
		if (userService.login(userName, password)) {
			user = userService.getUserInfo(userName);
			request.getSession().setAttribute("user", user);
			model.addAttribute("code", 200);
			model.addAttribute("message", "成功");
			model.addAttribute("result", true);
			return model;
		} else {
			// model.addAttribute("userLogin", false);
			model.addAttribute("code", "");
			model.addAttribute("message", "请输入正确的账户或密码");
			model.addAttribute("result", false);
			return model;
		}

	}

	/**
	 * 退出登录，同时注销session
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout") // @Param("userName") @Param("password")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login2";
	}

}
