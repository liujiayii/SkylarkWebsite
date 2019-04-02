package com.websit.until;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.websit.constant.ReturnCode;

/**
 * 快递信息查询（放弃合作）
 *
 * @ClassName: ExpressUtil

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月20日-下午2:33:31
 */
public class ExpressUtil {
	
	/** highapiKuaidi快递api地址 */
	private static final String HIGHAPI_KUAIDI_URL = "http://highapi.kuaidi.com/openapi-querycountordernumber.html?";
	/** highapiKuaidi身份授权 Key */
	private static final String HIGHAPI_KUAIDI_KEY = "bc98101ecb03bcd0ecf73c08c7ec7d76";
	/**
	 * 以下为阿里云快递物流查询常量
	 */
	/** 阿里云快递主机地址 */
	private static final String HOST = "http://wuliu.market.alicloudapi.com";
	/** 阿里云快递查询地址 */
	private static final String PATH = "/kdi";
	/** 阿里云快递查询请求方法 */
	private static final String METHOD = "GET";
	/** 阿里云快递查询appcode */
	private static final String APPCODE = "75dcd7626a2b4a7985d13941041d2208";
	/** 阿里云快递查询AppKey */
	private static final String APPKEY = "24830912";
	/** 阿里云快递查询AppSecret */
	private static final String APPSECRET = "bf09037ab21384313824e8d4d3e6efce";
	
	public static String fegine(Map<String, String> map) {
		
		Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + APPCODE); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
	
        HttpResponse response = null;
        String jsonStr = null;
        
		try {
			response = HttpUtils.doGet(HOST, PATH, METHOD, headers, map);
			jsonStr = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return jsonStr;
	}
	
	
	
	
	
	/**
	 * highapiKuaidi通过快递单号查询快递信息
	 *
	 * @Title: highapiKuaidi
	 * @description 
	 * @param nu 快递单号
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月21日-上午9:50:49
	 */
	public static String highapiKuaidi(Map<String, String> map) {
		String url = HIGHAPI_KUAIDI_URL + "id=" + HIGHAPI_KUAIDI_KEY;
		StringBuffer sb = new StringBuffer(url);
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> re = null;
		
		for (String key : map.keySet()) {
			sb.append("&" + key + "=" + map.get(key));
		}

		try {
			re = template.getForEntity(sb.toString(), String.class, map);
		} catch (RestClientException e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return re.getBody();
	}
	
	
	
	/** 测试 */
	public static void main(String[] args) {
		//圆通804977008350761269
		
		Map<String, String> map = new HashMap<> ();
		map.put("nu", "804977008350761269");
		System.out.println(ExpressUtil.highapiKuaidi(map));
	}
	
	
	
}
