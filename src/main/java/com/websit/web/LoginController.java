package com.websit.web;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.websit.entity.T_access;
import com.websit.entity.T_user;
import com.websit.entityvo.Logivo;
import com.websit.entityvo.UserRegister;
import com.websit.service.IT_accessService;
import com.websit.service.IT_userService;
import com.websit.until.JYSMSUtil;
import com.websit.until.JsonUtil;
import com.websit.until.VerifyUtil;

import net.minidev.json.JSONUtil;

/**
 * 
 *
 * @ClassName: LoginController
 * 
 * @description 登陆和注册控制器
 *
 * @author lishaozhang
 * @createDate 2019年3月13日
 */
@Controller
public class LoginController {

	@Autowired
	private IT_userService userService;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private IT_accessService accessService;

	/**
	 * 
	 *
	 * @Title: captcha
	 * 
	 * @description 获取验证码
	 *
	 * @param @param
	 *            request
	 * @param @param
	 *            response
	 * @param @throws
	 *            ServletException
	 * @param @throws
	 *            IOException
	 * 
	 * @return void
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping(value = "/createValicode")
	public void valicode(HttpServletResponse response, HttpSession session) throws Exception {
		// 利用图片工具生成图片
		// 第一个参数是生成的验证码，第二个参数是生成的图片
		Object[] objs = VerifyUtil.createImage();
		// 将验证码存入Session
		session.setAttribute("imageCode", objs[0]);
		System.out.println(session.getAttribute("imageCode"));
		// 将图片输出给浏览器
		BufferedImage image = (BufferedImage) objs[1];
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	/***
	 * 
	 *
	 * @Title: getmsg
	 * 
	 * @description 获取短信验证码
	 *
	 * 
	 * @param @throws
	 *            phone 要发送验证码的电话
	 * 
	 * @return void
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping("/getmsg")
	@ResponseBody
	public String getmsg(String phone) {
		Map<String, String> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("phone", phone);

		List<T_user> selectByMap = userService.selectByMap(map2);
		if (!selectByMap.isEmpty()) {
			return JsonUtil.getResponseJson(1, "该手机号已注册过", null, null);
		}
		int a = (int) ((Math.random() * 9 + 1) * 100000);

		map.put("time", "3");

		map.put("code", a + "");

		JYSMSUtil.sendMessage(phone, "2201", map);

		redisTemplate.opsForValue().set(phone + "", a + "", 30, TimeUnit.MINUTES);
		return null;
	}

	/**
	 * 
	 *
	 * @Title: register
	 * 
	 * @description 注册账户
	 *
	 * @param @param
	 *            phone
	 * @param @param
	 *            code
	 * @param @param
	 *            msgcode
	 * @param @param
	 *            password
	 * @param @param
	 *            session
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(@RequestBody UserRegister user, HttpSession session) {

		try {
			// 验证改手机号有没有注册过
			Map<String, Object> map2 = new HashMap<>();
			map2.put("phone", user.getPhone());

			List<T_user> selectByMap = userService.selectByMap(map2);
			if (!selectByMap.isEmpty()) {
				return JsonUtil.getResponseJson(1, "该手机号已注册过", null, null);
			}

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// 获取图片验证码和短信验证码
			String Scode = (String) session.getAttribute("imageCode");
			String Pcode = redisTemplate.opsForValue().get(user.getPhone() + "");

			if (Scode == null || Pcode == null) {
				return JsonUtil.getResponseJson(1, "验证码已过期或者不对", null, null);
			}
			if (!user.getCode().equalsIgnoreCase(Scode) && !user.getMsg_code().equals(Pcode)) {
				return JsonUtil.getResponseJson(1, "验证码已过期或者不对", null, null);
			}

			// 用户表添加用户
			T_user t_user = new T_user();
			Date date = new Date();
			t_user.setCreate_time(date);
			t_user.setPhone(user.getPhone());
			t_user.setPassword(user.getPassword());
			userService.insert(t_user);
			// 注册成功后当日注册量+1
			String format = simpleDateFormat.format(date);
			Map map = new HashMap<String, Object>();
			map.put("create_time", format);
			List<T_access> selectByMap1 = accessService.selectByMap(map);

			if (selectByMap1.isEmpty()) {
				T_access t_access = new T_access();
				t_access.setCount(1l);
				t_access.setCreate_time(date);
				accessService.insert(t_access);
			} else {
				T_access t_access = selectByMap1.get(0);
				t_access.setCount(t_access.getCount() + 1);
				accessService.updateById(t_access);
			}

			return JsonUtil.getResponseJson(1, "成功", null, null);

		} catch (Exception e) {

			System.out.println("异常");
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "验证码不对或已过期", null, null);
		}

	}

	/**
	 * 
	 *
	 * @Title: register
	 * 
	 * @description 登陆
	 * @param @param
	 *            phone 电话号码
	 * @param @param
	 *            password 密码
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月13日
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String register(@RequestBody Logivo log, HttpSession session) {

		Page<T_user> selectPage = userService.selectPage(new Page<>(), new EntityWrapper<T_user>().eq("phone", log.getPhone()));

		List<T_user> records = selectPage.getRecords();

		if (records.isEmpty()) {
			return JsonUtil.getResponseJson(1, "没有这个用户", null, null);
		}

		T_user t_user = records.get(0);

		String password2 = t_user.getPassword();
		String Scode = (String) session.getAttribute("imageCode");
        System.out.println(password2+"password2");
        System.out.println(log.getPassword()+"password");
        System.out.println(Scode+"Scode");
        System.out.println(log.getCode()+"log.getCode()");
		if (password2.equals(log.getPassword()) && Scode.equalsIgnoreCase(log.getCode())) {
			session.setAttribute("username", t_user.getNickname());

			return JsonUtil.getResponseJson(1, "登陆成功", null, null);
		}
		// return "redirect:views/login.html";
		// return "index.html";
		return JsonUtil.getResponseJson(1, "密码或验证码错误", null, null);

	}
	

}
