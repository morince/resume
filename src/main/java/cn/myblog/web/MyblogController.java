package cn.myblog.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.myblog.entity.UserInfo;
import cn.myblog.service.ResumeService;
import cn.myblog.service.UserService;
import cn.myblog.utils.WebTools;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/")
public class MyblogController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;

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
	public String index(Model model) {

		JSONArray showProduct = new JSONArray();

		// showProduct = resumeService.showIndex(user);

		model.addAttribute("productList", showProduct);

		return "index";

	}

	/**
	 * 登录界面
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
			model.addAttribute("code", 201);
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

	/**
	 * 注册界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/signup")
	public String regsiter() {
		return "register";
	}

	/**
	 * 注册界面，校对，存储到session中
	 * 
	 * @param userName
	 * @param password
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	@ResponseBody
	public Model apiRegister(String userName, String password, String email, Model model, HttpServletRequest request,
			@RequestBody String user) throws Exception {
		JSONObject jsonObj = WebTools.getJsonFromRequest(request);
		boolean flag = userService.registerUser(jsonObj);
		if (flag) {
			model.addAttribute("code", 200);
			model.addAttribute("message", "成功");
			model.addAttribute("result", true);
			return model;
		} else {
			model.addAttribute("code", 201);
			model.addAttribute("message", "注册失败");
			model.addAttribute("result", false);
			return model;
		}
	}

	/**
	 * 创建新的简历文本
	 * 
	 * @return
	 */
	@RequestMapping("/newprofile")
	public String newprofile() {
		return "newprofile";
	}

	/**
	 * 
	 * 提交简历至数据库中保存
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsubmit", method = RequestMethod.POST)
	public String newsubmit(Model model, HttpServletRequest request) throws Exception {
		JSONObject jsonObj = WebTools.getJsonFromRequest(request);
		// TODO userid应当从缓存中获取
		boolean flag = resumeService.saveProfile(jsonObj);

		return "newsubmit";
	}

	/**
	 * 进入到简历的编辑页面
	 * 
	 * @return
	 */
	@RequestMapping("/eidtprofile")
	public String eidtprofile() {
		return "eidtprofile";
	}

	/**
	 * 简历编辑后更新到数据中
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editsubmit", method = RequestMethod.POST)
	public String editsubmit(Model model, HttpServletRequest request) throws Exception {
		JSONObject jsonObj = WebTools.getJsonFromRequest(request);
		// TODO userid应当从缓存中获取
		boolean flag = resumeService.updateProfile(jsonObj);

		return "editsubmit";
	}

}
