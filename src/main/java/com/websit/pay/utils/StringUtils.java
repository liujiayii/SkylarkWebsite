package com.websit.pay.utils;

import java.util.Random;

/**
 * 
 *
 * @ClassName: StringUtils
 *
 * @description 获取一定长度的随机字符串，范围0-9，a-z
 *
 * @author HanMeng
 * @createDate 2019年1月24日-上午11:41:47
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

	/**
	 * 
	 * @Title: getRandomStringByLength
	 * @description: 获取一定长度的随机字符串，范围0-9，a-z
	 *
	 * @param length  指定字符串长度
	 * @return    一定长度的随机字符串
	 * @return String   
	 *
	 * @author HanMeng
	 * @createDate 2019年1月24日-上午11:41:32
	 */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
