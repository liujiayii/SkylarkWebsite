package com.websit.until;






import com.shove.security.Encrypt;

/**
 * ID加密、解密类
 * 
 * @description 
 *
 * @author ChenZhipeng
 * @createDate 2015年12月18日
 */
public class Security {
	
	/** 设置密钥 */
	public static final String key="12345678";

	/**
	 * 加密
	 * @description 
	 *
	 * @author Chenzhipeng
	 * @createDate 2015年12月18日
	 * @param id 需要加密的Id
	 * @param action 加密action标识
	 * @param encryptionKey 加密Key
	 * @return
	 */
	public static String encode(String data) {
		
		/*当前时间利用3des加密 */
		String des = Encrypt.encrypt3DES(data,key);

		return des;
	}
	
	/**
	 * 解密
	 * @description 
	 *
	 * @author Chenzhipeng
	 * @createDate 2015年12月18日
	 * @param sign 密文
	 * @param action 加密action标识
	 * @param validLength 密文有效时长
	 * @param encryptionKey 加密Key
	 * @return
	 */
	public static String decode(String data) {



	String  validTime = Encrypt.decrypt3DES(data,key);


		
  	return validTime;
	}
	
	
	public static void main(String[] args) {
		Security  Securit=new Security();
		Security.encode("12345678");
		System.out.println();
		System.out.println(Securit.encode("12345678"));
	}
	}
   

