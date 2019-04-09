package com.websit.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.websit.online.utils.EncryptUtil;
import com.websit.online.utils.MessageHttpClient;
import com.websit.online.utils.OnlineConfig;
import com.websit.service.OnlineService;

@Controller
public class OnlineController {
	@Autowired
	private OnlineService onlineService;

	@RequestMapping(value = "/sengMessage", produces = "application/json; charset=utf-8")
	@ResponseBody
	
	public JSONObject sendMessage(String userId, String content) {

		System.out.println(userId);
		System.out.println(content);
		JSONObject json = new JSONObject();
		try {
			// JSONObject result = onlineService.sendMessage(userId, content);
			JSONObject result = onlineService.sendMessage("15227", "我是谁 我在哪");
			System.out.println("result:" + result);
			int code = Integer.valueOf((String) result.get("code"));
			if (code == 200) {
				json.put("用户id", userId);
				json.put("内容", content);
				json.put("msg", "发送成功");
				json.put("code", 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("json::::" + json);
		return json;
	}	 

	@RequestMapping(value = "/sendManage", produces = "application/json; charset=utf-8")
	@ResponseBody
	public JSONObject sendManage(String userId, String content,MultipartFile file2, String path) throws IOException {

    File file = new File(path); 
    FileUtils.copyInputStreamToFile(file2.getInputStream(), file);

		if (content != null && content !="") {
			
			
				// 测试发送文本消息
				try {
					JSONObject res = onlineService.sendMessage(userId, content);
					System.out.println(res);
					return res;
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		 
		if (file != null) {

			String fileName = file.getName();
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			String msgType = null;
			try {
				if (isBinary(file)) {

					if (suffix.equals("bmp") || suffix.equals("gif") || suffix.equals("jpg") || suffix.equals("png")) {
						msgType = "image";
					} else if (suffix.equals("voi")) {
						msgType = "voice";
					} else if (suffix.equals("mpg") || suffix.equals("wmv") || suffix.equals("rmvb")
							|| suffix.equals("avi") || suffix.equals("asf") || suffix.equals("mpeg")
							|| suffix.equals("mov")) {
						msgType = "video";
					}
					JSONObject res = uploadFile(file, msgType, "." + suffix);
					String fileKey = res.getString("fileKey");

					JSONObject json = onlineService.sendMessage(userId, fileKey);
					System.out.println("json:" + json);
					return json;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (path != null) {

			// String path = "E:/file/www.jpg";
			// String pathPattern = "^[A-z]:\\\\(.+?\\\\)*$";
			// if (path.matches(pathPattern)) {
			String pattern = "[A-Za-z0-9/+]+[=]{0,2}";
			String base64File = fileToBase64(path);
			System.out.println("base64File:" + base64File);
			Boolean isBase64File = base64File.matches(pattern);
			if (isBase64File) {
				try {
					JSONObject res = uploadBase64File(base64File, "image", ".jpg");
					System.out.println("Base64File结果：" + res);
					String fileKey = res.getString("fileKey");
					JSONObject json = onlineService.sendMessage(userId, fileKey);
					System.out.println("发送结果：" + json);
					return json;

				} catch (Exception e) {
					e.printStackTrace();
				}
				// }
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: sendMessagesssssssssssssssss
	 * @description:发送消息
	 *
	 * @param userId
	 * @param content
	 * @return
	 * @throws Exception
	 * @return JSONObject
	 *
	 * @author HanMeng
	 * @createDate 2019年3月30日-上午11:10:13
	 */
	public JSONObject sendMessages(String userId, String content) throws Exception {

		System.out.println("userId:" + userId);
		System.out.println("content:" + content);
		JSONObject json = new JSONObject();
		// 拿到当前的 毫秒 时间戳
		long timestamp = System.currentTimeMillis();
		System.out.println("时间戳：" + timestamp);
		// 构造一个文本消息 消息的字段参考文档
		JSONObject message = new JSONObject();
		message.put("userId", userId);
		message.put("msgType", "text");
		message.put("content", content);
		message.put("timestamp", timestamp);
		// messageStr 就是发送请求的post body内容, 也是计算摘要的内容. 一定要保持一致, 否则digest计算失败
		String messageStr = message.toJSONString();
		System.out.println("messageStr:" + messageStr);
		// 计算安全摘要, 计算的传入内容请参考文档
		// 如果想要知道自己计算的摘要是否正确
		// 校验网址: https://1024tools.com/hmac
		// 选择算法: sha1
		// 密钥填写: key的内容
		// 内容就是hmac_sha1的value内容
		String digest = EncryptUtil.hmac_sha1(messageStr + timestamp, OnlineConfig.key);
		System.out.println("digest:" + digest);
		// 拼接URL
		String messageUrl = OnlineConfig.HOST_URL + OnlineConfig.MESSAGE_PATH + "?tntInstId=" + OnlineConfig.tntInstId
				+ "&scene=" + OnlineConfig.scene + "&digest=" + digest + "&timestamp=" + timestamp + "&src="
				+ OnlineConfig.src;
		System.out.println("messagUrl:" + messageUrl);
		// 发送消息
		// 成功返回内容为:
		// {
		// "code": "200",
		// "msg": "success"
		// }
		// 失败情况下, 请查看返回code, 参考文档
		MessageHttpClient httpClient = new MessageHttpClient();
		System.out.println("我走这了");
		return httpClient.sendMessage(messageStr, messageUrl);
	}

	/**
	 * 上传二进制文件 上传文件后返回里会拿到fileKey fileKey通过发送消息(sendMessage)来发送到客服
	 * 
	 * @param file
	 *            文件
	 * @param type
	 *            image/voice/video bmp/gif/jpg/png .voi mpg - wmv - rmvb - avi
	 *            - asf - mpeg - mov
	 * @param fileName
	 *            文件名字,保证后缀名正确即可
	 * @return 上传结果
	 * @throws IOException
	 *             抛出异常
	 */
	public static JSONObject uploadFile(File file, String type, String fileName) throws IOException {
		System.out.println("file=" + file + "type=" + type + "fileName=" + fileName);
		// 拿到当前的 毫秒 时间戳
		long timestamp = System.currentTimeMillis();

		byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(file));
		byte[] timeBytes = Long.toString(timestamp).getBytes();
		byte[] digestBytes = ArrayUtils.addAll(fileBytes, timeBytes);
		String digest = EncryptUtil.hmac_sha1(digestBytes, OnlineConfig.key);

		// 拼接URL
		String fileUrl = OnlineConfig.HOST_URL + OnlineConfig.UPLOAD_FILE_API_PATH + "?tntInstId="
				+ OnlineConfig.tntInstId + "&scene=" + OnlineConfig.scene + "&digest=" + digest + "&timestamp="
				+ timestamp + "&src=" + OnlineConfig.src;

		MessageHttpClient httpClient = new MessageHttpClient();
		return httpClient.uploadFile(file, fileUrl, type, fileName, timestamp);
	}

	/**
	 * 上传base64文件
	 * 
	 * @param base64File
	 *            base64文件内容
	 * @param type
	 *            image/voice/video
	 * @param fileName
	 *            文件名字,保证后缀名正确即可
	 * @return 上传结果
	 * @throws IOException
	 *             抛出异常
	 */
	public static JSONObject uploadBase64File(String base64File, String type, String fileName) throws IOException {
		// 拿到当前的 毫秒 时间戳
		long timestamp = System.currentTimeMillis();

		// 计算摘要
		String digest = EncryptUtil.hmac_sha1(base64File + timestamp, OnlineConfig.key);

		// 拼接URL
		String fileUrl = OnlineConfig.HOST_URL + OnlineConfig.UPLOAD_FILE_API_PATH + "?tntInstId="
				+ OnlineConfig.tntInstId + "&scene=" + OnlineConfig.scene + "&digest=" + digest + "&timestamp="
				+ timestamp + "&src=" + OnlineConfig.src;

		MessageHttpClient httpClient = new MessageHttpClient();
		return httpClient.uploadBase64File(base64File, fileUrl, type, fileName, timestamp);
	}

	/**
	 * 获取文件的临时url
	 * 
	 * @param fileKey
	 *            文件的file key (在上传的时候获取，或者在接收消息的时候由云客服发送过来的)
	 * @return success 返回内容(json)：
	 *         <ul>
	 *         <li>type : image/video/voice</li> 文件类型
	 *         <li>mediaUrl: "https://oss.aliyun.com/example/url</li> 文件临时url
	 *         <li>expiretime : 12344312</li> url过期时间
	 *         </ul>
	 *         error 返回内容：
	 *         <ul>
	 *         <li>code : 404</li> 错误码
	 *         <li>msg : "error message"</li> 错误消息提示
	 *         </ul>
	 * @throws IOException
	 *             异常内容 一般情况下都是httpClient抛出的
	 */
	public static JSONObject fetchFileUrl(String fileKey) throws IOException {
		System.out.println("传fileKey：" + fileKey);
		// 获取时间戳
		long timestamp = System.currentTimeMillis();
		String digest = EncryptUtil.hmac_sha1(fileKey + timestamp, OnlineConfig.key);

		// 拼接URL
		String fileUrl = OnlineConfig.HOST_URL + OnlineConfig.UPLOAD_FILE_API_PATH + "?fileKey=" + fileKey
				+ "&timestamp=" + timestamp + "&digest=" + digest + "&timestamp=" + timestamp + "&src="
				+ OnlineConfig.src;

		MessageHttpClient httpClient = new MessageHttpClient();

		return httpClient.fetchFileUrl(fileUrl);
	}

	/**
	 * file转成base64
	 * 
	 * @param path
	 * @return
	 */

	public static String fileToBase64(String path) {
		String base64 = null;
		InputStream in = null;
		try {
			File file = new File(path);
			in = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			in.read(bytes);
			base64 = Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return base64;
	}

	// BASE64解码成File文件
	public static void base64ToFile(String destPath, String base64, String fileName) {
		File file = null;
		// 创建文件目录
		String filePath = destPath;
		File dir = new File(filePath);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}
		BufferedOutputStream bos = null;
		java.io.FileOutputStream fos = null;
		try {
			byte[] bytes = Base64.getDecoder().decode(base64);
			file = new File(filePath + "/" + fileName);
			fos = new java.io.FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 判断文件是否是二进制文件
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isBinary(File file) {
		boolean isBinary = false;
		try {
			FileInputStream fin = new FileInputStream(file);
			long len = file.length();
			for (int j = 0; j < (int) len; j++) {
				int t = fin.read();
				if (t < 32 && t != 9 && t != 10 && t != 13) {
					isBinary = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isBinary;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * JSONObject result = sendManage("11","lailailai吗", null ,null);
	 * System.out.println("最后的结果："+result); File file = new
	 * File("C:/Users/Administrator/Desktop/1.jpg"); JSONObject result1 =
	 * sendManage(null, file,null, null); System.out.println("最后的结果："+result1);
	 * String path = "C:/Users/Administrator/Desktop/1.jpg"; JSONObject result2
	 * = sendManage(null, null,path); System.out.println("最后的结果："+result2); }
	 */
}
