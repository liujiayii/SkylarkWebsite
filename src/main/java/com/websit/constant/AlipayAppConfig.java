package com.websit.constant;
/**
 * 移动端支付宝常量配置
 *
 * @ClassName: AlipayConfig

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月26日-上午8:54:27
 */
public class AlipayAppConfig {
	// 商户appid
	public static final String APPID = "2019032763691457";
	// app端支付宝支付异步通知结果；服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// http://www.yunquekeji.com
	
	public static final String notify_url = "http://www.yunquekeji.com/aliPayApp/notify_url";
	// 支付完成跳转页面
	public static final String return_url = "";
	// 请求网关地址
	public static final String URL = "https://openapi.alipay.com/gateway.do";
	// 编码格式
	public static final String CHARSET = "UTF-8";
	// 返回格式
	public static final String FORMAT = "json";
	// 支付宝公钥
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAihVpOv/6jiDo4aULVNxy+zfP3cDb21fvQj4/jpcQHDMOdvr4JCiqHK4J9GQzi6Kqv4msHwzxZTJJdouTmhQQkkwKi8SGZnwHxAFETGJr90NNIsyJKgkzvs0wXOdrg++6oijSXWTwtvE6SmYWQKR4BQHUpZLcWU0g6JZPEaYlWIaEZScIZh7hKzIFy83yu3pwczYjI8BkyIhqOWRPO0FXt8MaKgSJATfpsTYcwyALNxpt+S1fYfe8OxbfMWyM32Rchv5TTTd3YcILRSRJU5/dyWkjWimULEll2ojAF/aW8OksvkmV430mCs6sg9NGoEVc+7jmmYumwayrP69g1ScgPwIDAQAB";
	// 应用私钥
	public static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDD/QJ4PRoq6n4+cD9kMK1BXo+D9YgCzWFFaQ6etn3wjGRNSieqnWgXgqcUsSYWr1oSh3YXCvwEB24N0J76dypyOSn3l0pq4GjiVCdaL4SO5m0tVABsPxy4uvp28XCXhSOzzXD5TRDouqYYVN/6ovSqNfAc1wUqDrLC3Wd1j+GXxgZI2CkZTyiZbLBQ4nZv8JsxOFtXmIig+QXyIiMBdriFTQ/9WC+v7pqEeDgKLp+RAOBaRGZVbAr+nCAbKvsoGcHCioWGiS5zpTqK5VEM1+0FOa1W9r9N2IYpHXy3DP/YRfkBRqTb2jKq8o1ED+VkXlkkBoIM9OwrnZlWvFtstQrZAgMBAAECggEAS5pRFpLzgjSc6HcibQK+AuZ4VD4l7nbNnBnvstfQ8zclBg+iB5Xa7p7O1xOTDtMr2tP4gOES4HcBREEC4rmPXSqh/smUwm+45f3yhD6qUvmeigrKcvdRnA08yx9OAJUydYy9lN3etPgzVFWBZUzxNqvB6U4kxtmOqc8Atv/+1S24lhK8IQ7FnURisfMoF3RdDFVWr2xC/V/4ktF3DU6xGjF1I7Vq7XFzLKJPDFY4Fr/6quGmIHvMlx/8ECJynAML8AC8oliv6NOGXC2SnArtuTgEwzFzhAfCQw5jwCIEqBKI7IIp52dCHAg9Ns8nVehNAcuXlvm2RNMzJVeBYObFAQKBgQDoc8FYcHQCJbpZemllKfeJ563V3aWxe48pgP7CUBY+Z5eqkuGdFLrrWJ5LkZ97eJ8rPERVCMwBsfXIBN/BkGXhKYcNMYnQgVnDho3sAkvNWXapCgZQKZcI3V2yQ2DzbnNFJKczK4N6AKCdhpHdurFCuDDiXEpWOYV55zJs6ZRVYQKBgQDX16CmjpmQ9W7rYq54+Ciinw2DdBs4LcxjreKAJaiNEDRnzdDM9wCFQhf1vW9KM0vfB+bX2iY/fEHcLpI+Eua4rgdXiFBSveCUx+OF38oHBbcbzR/WdtzIFvmdABBUh/d9tOBuBHSO2fM5S9pB+paG/jZlU8FtjAHn/97sbqaweQKBgQDXbyjbUWWC8/pwoU3671k3G1x2ILVG94/oVGBIMLdc4N+ku/qTfbn7Eqequ+0GHvXNuU5PTRbd31Q+K55BJBX4B2feJ3JlpuxNlXAFMt+UEv0xj1PoiZMsKRWEeIPrOQtmIqE/gG2a7eft9uFLkZJllpXfxM80eJ0nLMoEPLs4IQKBgFBRMbuoxqY1XjADCY+EMILLEtk+pD5UdIEHHIi4+q57QDT8Vl1e8Hel74qHElmXGv2EUDc0OxVWpJ9NSSgGGorQX3UICXOwqlhSxWx0qRXR36BdxSImGuPuALaWZn0+Fy9U1kq6J7FckvBYNIBmwgq7n/w2nXypI7Bz+z0Zs7dpAoGAKjx+6BkHej2v76BsxHDyIwfimDV/CXAu6pvUoniN1vcLHcC7tkN/xGEnwp7IvHZPWqJHv7o+5aEjhO/o11Ure/F3m2wSqcMMfch+w2OqLWxYQgxBVMZL2GXzeOvwBC5lrDHKM7+N6KEOM8L/pCF1yA8meSNVtDdYXjIVEbnCuhg=";
	// 加密类型RSA2
	public static final String SIGNTYPE = "RSA2";
	
	
}
