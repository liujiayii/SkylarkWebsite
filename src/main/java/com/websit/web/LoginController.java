package com.websit.web;

import java.awt.image.BufferedImage;

import java.io.OutputStream;
import java.lang.reflect.Method;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.websit.entity.T_access;
import com.websit.entity.T_user;
import com.websit.entityvo.Logivo;
import com.websit.entityvo.UserRegister;
import com.websit.service.IT_accessService;
import com.websit.service.IT_userService;
import com.websit.until.DesUtil;

import com.websit.until.HttpClientUtil;
import com.websit.until.JYSMSUtil;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;
import com.websit.until.Security;
import com.websit.until.VerifyUtil;

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
	String key = "12345678";
	@Autowired
	private IT_userService userService;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private IT_accessService accessService;
	Security DesUtilt = new Security();

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
	@RequestMapping(value = "/getmsg")
	@ResponseBody
	public String getmsg(String phone, String code, HttpSession session) {

		// 1、获取图片验证码
		String Scode = (String) session.getAttribute("imageCode");

		if (Scode == null) {
			return JsonUtil.getResponseJson(-1, "验证码不能为空", null, null);
		}
		if (!code.equalsIgnoreCase(Scode)) {
			return JsonUtil.getResponseJson(-1, "验证码已过期或者不对", null, null);
		}

		// https://www.ouyepuhui.com/loginAndRegiste/registerUser?params=

		// 2、判断该手机号有没有注册在数据库中

		// 将手机号码加密
		String encode = DesUtil.encode("yunquekj", phone);
		// 调用验证接口正式
		String doPost = "";
		try {

			doPost = HttpClientUtil.doPost("https://www.ouyepuhui.com/loginAndRegiste/isExistMobile?params=" + encode);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(1, "请求异常", null, null);
		}
		// 测试

		/*
		 * String doPost = HttpClientUtil
		 * 
		 * .doPost(
		 * "http://192.168.1.101:8000/loginAndRegiste/isExistMobile?params=" +
		 * encode);
		 */

		// 解析验证信息
		JSONObject parse = null;
		try {
			parse = (JSONObject) JSONObject.parse(doPost);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(1, "请求异常", null, null);
		}

		// 获取返回信息
		Integer Pcode = (Integer) parse.get("code");
		// -200 代表已经注册过 终止程序返回信息
		if (Pcode == -200) {
			return JsonUtil.getResponseJson(1, (String) parse.get("message"), null, null);
		}

		// 手机号并未注册过

		Map<String, String> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("phone", phone);

		// 这段代码貌似已经无用/*
		/*
		 * List<T_user> selectByMap = userService.selectByMap(map2); if
		 * (!selectByMap.isEmpty()) { return JsonUtil.getResponseJson(2,
		 * "该手机号已注册过", null, null); }
		 */
		// */
		int a = (int) ((Math.random() * 9 + 1) * 100000);

		map.put("time", "5");

		map.put("code", a + "");

		boolean sendMessage = JYSMSUtil.sendMessage(phone, "3537", map);

		redisTemplate.opsForValue().set(phone + "", a + "", 5, TimeUnit.MINUTES);

		if (!sendMessage) {
			return JsonUtil.getResponseJson(2, "手机号码不正确", null, null);

		}

		return JsonUtil.getResponseJson(1, "发送成功", null, null);
	}

	/***
	 * 
	 *
	 * @Title: getmsg
	 * 
	 * @description 移动端获取短信验证码
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
	@RequestMapping(value = "/getMmsg")
	@ResponseBody
	public String getMmsg(String phone, HttpSession session) {

		// 1、获取图片验证码

		// https://www.ouyepuhui.com/loginAndRegiste/registerUser?params=

		// 2、判断该手机号有没有注册在数据库中

		// 将手机号码加密
		String encode = DesUtil.encode("yunquekj", phone);
		// 调用验证接口正式

		String doPost = "";
		try {

			doPost = HttpClientUtil.doPost("https://www.ouyepuhui.com/loginAndRegiste/isExistMobile?params=" + encode);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(1, "请求异常", null, null);
		}
		// 测试

		/*
		 * String doPost = HttpClientUtil
		 * 
		 * .doPost(
		 * "http://192.168.1.101:8000/loginAndRegiste/isExistMobile?params=" +
		 * encode);
		 */

		// 解析验证信息
		JSONObject parse = null;
		try {
			parse = (JSONObject) JSONObject.parse(doPost);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(1, "请求异常", null, null);
		}
		// 获取返回信息
		Integer Pcode = (Integer) parse.get("code");
		// -200 代表已经注册过 终止程序返回信息
		if (Pcode == -200) {
			return JsonUtil.getResponseJson(1, (String) parse.get("message"), null, null);
		}

		// 手机号并未注册过

		Map<String, String> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("phone", phone);

		// 这段代码貌似已经无用/*
		/*
		 * List<T_user> selectByMap = userService.selectByMap(map2); if
		 * (!selectByMap.isEmpty()) { return JsonUtil.getResponseJson(2,
		 * "该手机号已注册过", null, null); }
		 */
		// */
		int a = (int) ((Math.random() * 9 + 1) * 100000);

		map.put("time", "5");

		map.put("code", a + "");

		boolean sendMessage = JYSMSUtil.sendMessage(phone, "3537", map);

		redisTemplate.opsForValue().set(phone + "", a + "", 5, TimeUnit.MINUTES);

		if (!sendMessage) {
			return JsonUtil.getResponseJson(2, "手机号码不正确", null, null);

		}

		return JsonUtil.getResponseJson(1, "发送成功", null, null);
	}

	/**
	 * 
	 *
	 * @Title: register
	 * 
	 * @description pc端注册账户
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
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public synchronized String register(@RequestBody UserRegister user, HttpSession session) {
		//System.out.println(user);
		// 校验手机号码格式是否正确
		String regularp = "^((13[0-9])|(14[0-9])|(19[0-9])|(16[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))(\\d{8})$";
		String phone = user.getPhone();

		if (!phone.matches(regularp)) {
			return JsonUtil.getResponseJson(-1, "手机号码错误", null, null);
		}
		// 使用正则验证密码格式是否正确
		String regular = "^([^\\s'‘’]{" + 8 + "," + 15 + "})$";
		boolean matches = user.getPassword().matches(regular);
		if (!matches) {
			return JsonUtil.getResponseJson(-1, "密码必须是8-15位数字字母混合的", null, null);
		}

		// 密码md5加密 测试
		// String hash = MD5Utils.hash(user.getPassword() + "KwX3jBV5hOmTSUdc");

		// 正式
		// 测试KwX3jBV5hOmTSUdc
		String hash = MD5Utils.hash(user.getPassword() + "Ht3aZQ1EuyhbgPu7");
		try {
			// 验证改手机号有没有存在于自己的数据库
			Map<String, Object> map2 = new HashMap<>();
			map2.put("phone", user.getPhone());

			List<T_user> selectByMap = userService.selectByMap(map2);
			if (!selectByMap.isEmpty()) {
				return JsonUtil.getResponseJson(-1, "该手机号已注册过", null, null);
			}

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// 获取图片验证码和短信验证码
			String Scode = (String) session.getAttribute("imageCode");
			String Pcode = redisTemplate.opsForValue().get(user.getPhone() + "");

			if (Scode == null || Pcode == null) {

				return JsonUtil.getResponseJson(-1, "验证码已过期或者不对", null, null);
			}

			if (!user.getCode().equalsIgnoreCase(Scode) || !user.getMsg_code().equals(Pcode)) {
				return JsonUtil.getResponseJson(-1, "验证码已过期或者不对", null, null);
			}

			// 给普惠发送手机号和密码注册
			Integer cilent = null;
			if (null == user.getCilent() || 0 == user.getCilent()) {
				cilent = 1;
			}

			Map<String, String> map21 = new HashMap<String, String>();
			map21.put("phone", user.getPhone());
			map21.put("password", hash);
			map21.put("client", cilent + "");
			Object json = JSONObject.toJSON(map21);
			String pw = json.toString();
			// 加密
			String encode = DesUtil.encode("yunquekj", pw);
			// 发送信息
			String doPost = HttpClientUtil
					.doPost("https://www.ouyepuhui.com/loginAndRegiste/registerUser?params=" + encode);
			JSONObject object = JSONObject.parseObject(doPost);
			Integer code = (Integer) object.get("code");
			// 获取返回信息值 200 则注册成功 -200 失败
			if (200 == code) {
				Integer id = (Integer) object.get("userId");

				// 用户表添加用户
				T_user t_user = new T_user();
				Date date = new Date();
				t_user.setCreate_time(date);
				t_user.setPhone(user.getPhone());
				t_user.setPassword(hash);
				t_user.setPhid((Long.parseLong(id + "")));
				userService.insertWithPh(t_user);
				// 注册成功后当日注册量+1
				String format = simpleDateFormat.format(date);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("create_time", format);
				List<T_access> selectByMap1 = accessService.selectByMap(map);

				if (selectByMap1.isEmpty()) {
					T_access t_access = new T_access();
					t_access.setCount(1l);
					t_access.setCreate_time(date);
					accessService.insert(t_access);
				} else {
					T_access t_access = selectByMap1.get(0);

					t_access.setCount(userService.slectCount());
					accessService.updateById(t_access);
				}

				return JsonUtil.getResponseJson(1, "成功", null, null);

			}

			// 注册失败则返回失败信息
			String msge = (object.get("message") + "" + object.get("msg")).replaceAll("null", "");
			return JsonUtil.getResponseJson(-1, msge, null, null);

		} catch (Exception e) {

			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "验证码不对或已过期", null, null);
		}

	}

	/**
	 * 
	 *
	 * @Title: register
	 * 
	 * @description 移动端注册接口
	 *
	 * @param @param
	 *            user
	 * @param @param
	 *            session
	 * @param @return
	 *            cilent 2 安卓 3 ios
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年3月21日
	 */

	@RequestMapping("/mRegister")
	@ResponseBody
	public String mRegister(/* @RequestBody */ UserRegister user, HttpSession session) {

		// 校验手机号码格式是否正确
		String regularp = "^((13[0-9])|(14[0-9])|(19[0-9])|(16[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))(\\d{8})$";
		String phone = user.getPhone();

		if (!phone.matches(regularp)) {
			return JsonUtil.getResponseJson(-1, "手机号码错误", null, null);
		}
		// 使用正则验证密码格式是否正确
		String regular = "^([^\\s'‘’]{" + 8 + "," + 15 + "})$";
		boolean matches = user.getPassword().matches(regular);
		if (!matches) {
			return JsonUtil.getResponseJson(-1, "密码必须是8-15位数字字母混合的", null, null);
		}

		// 密码md5加密
		// String hash = MD5Utils.hash(user.getPassword() + "KwX3jBV5hOmTSUdc");

		// 正式
		// KwX3jBV5hOmTSUdc
		String hash = MD5Utils.hash(user.getPassword() + "Ht3aZQ1EuyhbgPu7");
		try {
			// 验证改手机号有没有存在于自己的数据库
			Map<String, Object> map2 = new HashMap<>();
			map2.put("phone", user.getPhone());

			List<T_user> selectByMap = userService.selectByMap(map2);
			if (!selectByMap.isEmpty()) {
				return JsonUtil.getResponseJson(-1, "该手机号已注册过", null, null);
			}

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// 获取图片验证码和短信验证码
			/* String Scode = (String) session.getAttribute("imageCode"); */
			String Pcode = redisTemplate.opsForValue().get(user.getPhone() + "");

			if ( /* Scode == null || */ Pcode == null) {
				return JsonUtil.getResponseJson(-1, "验证码已过期或者不对", null, null);
			}
			if ( /* !user.getCode().equalsIgnoreCase(Scode) && */ !user.getMsg_code().equals(Pcode)) {
				return JsonUtil.getResponseJson(-1, "验证码已过期或者不对", null, null);
			}

			// 给普惠发送手机号和密码注册
			Integer cilent = null;
			if (null == user.getCilent() || 0 == user.getCilent()) {
				cilent = 1;
			}

			Map<String, String> map21 = new HashMap<String, String>();
			map21.put("phone", user.getPhone());
			map21.put("password", hash);
			map21.put("client", cilent + "");
			Object json = JSONObject.toJSON(map21);
			String pw = json.toString();
			// 加密
			String encode = DesUtil.encode("yunquekj", pw);
			// 发送信息
			String doPost = HttpClientUtil
					.doPost("https://www.ouyepuhui.com/loginAndRegiste/registerUser?params=" + encode);
			JSONObject object = JSONObject.parseObject(doPost);
			Integer code = (Integer) object.get("code");
			// 获取返回信息值 200 则注册成功 -200 失败

			if (200 == code) {
				Integer id = (Integer) object.get("userId");

				// 用户表添加用户
				T_user t_user = new T_user();
				Date date = new Date();
				t_user.setCreate_time(date);
				t_user.setPhone(user.getPhone());
				t_user.setPassword(hash);
				t_user.setPhid((Long.parseLong(id + "")));
				userService.insertWithPh(t_user);
				// 注册成功后当日注册量+1
				String format = simpleDateFormat.format(date);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("create_time", format);
				List<T_access> selectByMap1 = accessService.selectByMap(map);

				if (selectByMap1.isEmpty()) {
					T_access t_access = new T_access();
					t_access.setCount(1l);
					t_access.setCreate_time(date);
					accessService.insert(t_access);
				} else {
					T_access t_access = selectByMap1.get(0);

					t_access.setCount(userService.slectCount());
					accessService.updateById(t_access);
				}

				return JsonUtil.getResponseJson(1, "成功", null, null);

			}

			// 注册失败则返回失败信息
			String msge = (object.get("message") + "" + object.get("msg")).replaceAll("null", "");
			return JsonUtil.getResponseJson(1, msge, null, null);

		} catch (Exception e) {

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
	@RequestMapping("/doLogin")
	@ResponseBody
	
	public String login(@RequestBody Logivo log, HttpSession session) {
		// 校验5分钟之内有没有登陆过 登陆过 几次
		String num = null;
		Long time = null;
		try {
			num = redisTemplate.opsForValue().get("log" + log.getPhone());

			time = redisTemplate.getExpire("log" + log.getPhone(), TimeUnit.SECONDS);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "redis连接异常", null, null);
		}

		if (null == num || "".equals(num)) {
			// 5分钟之内没登陆过
			num = "1";
			time =300l;
		} else {

			// 5分之内登陆错误超过3次 15分钟内无法登录
			if (Integer.parseInt(num) >= 3) {
				
				return JsonUtil.getResponseJson(-1, "多次登陆失败请" + (time/60) + "分钟后重试", null, null);
			}

			num = (Integer.parseInt(num) + 1) + "";
		}

		// MD5密码
		// String hash = MD5Utils.hash(log.getPassword() + "KwX3jBV5hOmTSUdc");

		// 正式
		// KwX3jBV5hOmTSUdc
		String hash = MD5Utils.hash(log.getPassword() + "Ht3aZQ1EuyhbgPu7");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", log.getPhone());
		// 先在商城数据库中查询信息
	
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("phone", log.getPhone());
		columnMap.put("password", log.getPassword());
		List<T_user> records = userService.selectByMap(columnMap);

		// List<T_user> records = user.get(0).getRecords();
		// 如果没有去普惠查询
		if (records.isEmpty()) {

			Map<String, String> map3 = new HashMap<String, String>();
			map3.put("phone", log.getPhone());

			map3.put("password", hash);
			Object json = JSONObject.toJSON(map3);
			String msg = json.toString();
			// 加密
			String encode = DesUtil.encode("yunquekj", msg);
			String doPost = HttpClientUtil
					.doPost("https://www.ouyepuhui.com/loginAndRegiste/loginingUser?params=" + encode);
			// 如果普惠有
			JSONObject logjson = JSONObject.parseObject(doPost);

			Integer code = (Integer) logjson.get("code");
			if (200 == code) {

				// 根据电话号码查询我我们的数据库
				List<T_user> selectByMap = userService.selectByMap(map);
				// 号码不存在则将账号密码添加进我的的user表
				if (selectByMap.isEmpty()) {
					T_user t_user = new T_user();
					t_user.setPhone(log.getPhone());
					t_user.setPassword(hash);
					Integer phid = (Integer) logjson.get("userId");
					// Long phid = (Long) juser.get("id");
					t_user.setPhid(Long.parseLong(phid + ""));
					userService.insertWithPh(t_user);

					records.add(t_user);
				} else {
					// 存在则表示密码已经修改过我们也要修改密码
					T_user t_user = selectByMap.get(0);
					t_user.setPassword(hash);
					userService.updateById(t_user);
					records.add(t_user);
				}

			} else {
				// 没有则登陆失败 返回没有用户信息

				// 记录当前次数和过期时间
				redisTemplate.opsForValue().set("log" + log.getPhone(), num, time, TimeUnit.SECONDS);

				// 如果超过三次 则将时间设为 15分钟
				if (Integer.parseInt(num) >= 3) {
					redisTemplate.opsForValue().set("log" + log.getPhone(), num, 15, TimeUnit.MINUTES);
				}

				String msge = (logjson.get("message") + "" + logjson.get("msg")).replaceAll("null", "");
				return JsonUtil.getResponseJson(-1, msge, null, null);
			}
		}

		// 如果有则将用户信息存入session
		T_user t_user = records.get(0);
		String Scode = (String) session.getAttribute("imageCode");

		if (Scode.equalsIgnoreCase(log.getCode())) {
			session.setAttribute("user", t_user);

			return JsonUtil.getResponseJson(1, "登陆成功", null, t_user);
		}

		return JsonUtil.getResponseJson(-1, "密码或验证码错误", null, null);

	}

	/**
	 * 
	 *
	 * @Title: login
	 * 
	 * @description 移动端登陆接口
	 *
	 * @param @param
	 *            log
	 * @param @param
	 *            session
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @throws Exception
	 * @createDate 2019年3月21日
	 */
	@RequestMapping("/mLogin")
	@ResponseBody
	public String login(Logivo log) throws Exception {
		
		// 校验5分钟之内有没有登陆过 登陆过 几次
				String num = null;
				Long time = null;
				try {
					num = redisTemplate.opsForValue().get("log" + log.getPhone());

					time = redisTemplate.getExpire("log" + log.getPhone(), TimeUnit.SECONDS);
				} catch (Exception e) {
					return JsonUtil.getResponseJson(-1, "redis连接异常", null, null);
				}

				if (null == num || "".equals(num)) {
					// 5分钟之内没登陆过
					num = "1";
					time =300l;
				} else {

					// 5分之内登陆错误超过3次 15分钟内无法登录
					if (Integer.parseInt(num) >= 3) {
						
						return JsonUtil.getResponseJson(-1, "多次登陆失败请" + (time/60) + "分钟后重试", null, null);
					}

					num = (Integer.parseInt(num) + 1) + "";
				}
		
		
		
		log.setPassword(Security.decode(log.getPassword()));

		// MD5密码
		// String hash = MD5Utils.hash(log.getPassword() + "KwX3jBV5hOmTSUdc");

		// 正式
		// KwX3jBV5hOmTSUdc
		String hash = MD5Utils.hash(log.getPassword() + "Ht3aZQ1EuyhbgPu7");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", log.getPhone());
		// 先在商城数据库中查询信息
		// Page<T_user> selectPage = userService.selectPage(new Page<>(),
		// new EntityWrapper<T_user>().eq("phone",
		// log.getPhone()).eq("password", hash));
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("phone", log.getPhone());
		columnMap.put("password", log.getPassword());
		List<T_user> records = userService.selectByMap(columnMap);

		// List<T_user> records = selectPage.getRecords();
		// 如果没有去普惠查询
		if (records.isEmpty()) {

			Map<String, String> map3 = new HashMap<String, String>();
			map3.put("phone", log.getPhone());

			map3.put("password", hash);
			Object json = JSONObject.toJSON(map3);
			String msg = json.toString();
			// 加密
			String encode = DesUtil.encode("yunquekj", msg);
			String doPost = HttpClientUtil
					.doPost("https://www.ouyepuhui.com/loginAndRegiste/loginingUser?params=" + encode);
			// 如果普惠有
			JSONObject logjson = JSONObject.parseObject(doPost);

			Integer code = (Integer) logjson.get("code");
			if (200 == code) {

				// 根据电话号码查询我我们的数据库
				List<T_user> selectByMap = userService.selectByMap(map);
				// 号码不存在则将账号密码添加进我的的user表
				if (selectByMap.isEmpty()) {
					T_user t_user = new T_user();
					t_user.setPhone(log.getPhone());
					t_user.setPassword(hash);
					Integer phid = (Integer) logjson.get("userId");
					// Long phid = (Long) juser.get("id");
					t_user.setPhid(Long.parseLong(phid + ""));
					userService.insertWithPh(t_user);

					records.add(t_user);
				} else {
					// 存在则表示密码已经修改过我们也要修改密码
					T_user t_user = selectByMap.get(0);
					t_user.setPassword(hash);
					userService.updateById(t_user);
					records.add(t_user);
				}

			} else {
				// 没有则登陆失败 返回没有用户信息

				// 记录当前次数和过期时间
				redisTemplate.opsForValue().set("log" + log.getPhone(), num, time, TimeUnit.SECONDS);

				// 如果超过三次 则将时间设为 15分钟
				if (Integer.parseInt(num) >= 3) {
					redisTemplate.opsForValue().set("log" + log.getPhone(), num, 15, TimeUnit.MINUTES);
				}
				
				String msge = (logjson.get("message") + "" + logjson.get("msg")).replaceAll("null", "");
				return JsonUtil.getResponseJson(-1, msge, null, null);
			}
		}

		// 如果有则将用户信息存入session
		T_user t_user = records.get(0);

		Map<String, Object> resault = new HashMap<String, Object>();
		resault.put("id", Security.encode(t_user.getId().toString()));// 加密userid
		resault.put("phid", t_user.getPhid());
		// 返回加密userid
		//System.out.println(Security.encode(JsonUtil.getResponseJson(1, "登陆成功", null, resault)));

		return JsonUtil.getResponseJson(1, "登陆成功", null, resault);

	}

	@RequestMapping("/tologin")
	@ResponseBody
	public void tologin(HttpSession session) {

		T_user t_user = new T_user();
		t_user.setNickname("刘加一");
		session.setAttribute("user", t_user);

	}

	@RequestMapping("/tohome")
	public String tohome() {
		return "home.html";

	}

	@RequestMapping("/yaozi")
	@ResponseBody
	public String yaozi(String a) {

		return "给姚子骏的接口 " + "";

	}

}
