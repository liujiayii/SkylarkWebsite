/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.websit.online.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;

import com.alibaba.fastjson.JSONObject;



/**
 * 加密工具类
 * @author fushan.cfs
 * @version $Id: EncryptUtil.java, v 0.1 2018年05月24日 上午11:13 fushan.cfs Exp $
 */
public class EncryptUtil {

    /**
     * 转十六进制使用的字符
     */
    private static final String HEX_DIGITS   = "0123456789abcdef";

    /**
     * 二进制字节数组转十六进制
     *
     * @param v 二进制数组内容
     * @return 十六进制字符串
     */
    private static String toHexString(byte[] v) {
        StringBuilder sb = new StringBuilder(v.length * 2);
        for (int i = 0; i < v.length; i++) {
            int b = v[i] & 0xFF;
            sb.append(HEX_DIGITS.charAt(b >>> 4)).append(
                    HEX_DIGITS.charAt(b & 0xF));
        }
        return sb.toString();
    }
    /**
     * hmac_sha1算法计算内容摘要
     *
     * value的生成流程请看详细文档对于不同的消息类型构造方式不同
     * <ul>
     *   <li>文本消息：toJSONString( MessageContent ) + timestamp</li>
     *   <li>base64文件：base64字符串 + timestamp</li>
     * </ul>
     *
     * @param value 原始数据的字符串
     * @param key   密钥
     * @return 加密后的字符串
     */
    public static String hmac_sha1(String value, String key) {
    	System.out.println("hmac_sha1"+value+",key"+key);
        try {
            byte[] keyBytes = key.getBytes("utf-8");
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(value.getBytes("utf-8"));
            String digest = toHexString(rawHmac);
            return digest;
        } catch (Exception ex) {
            return null;
        }
    }


    /**
     * hmac_sha1算法计算内容摘要
     *
     * 主要用于二进制的文件摘要计算
     * <ul>
     *     <li>二进制文件消息： byte[] file + byte timestamp </li>
     * </ul>
     * @param bytes 需要加密的二进制数组
     * @param key 私钥
     * @return 加密后的字符串
     */
    public static String hmac_sha1(byte[] bytes, String key) {
        try {
            byte[] keyBytes = key.getBytes("utf-8");
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(bytes);
            String digest = toHexString(rawHmac);
            return digest;
        } catch (Exception ex) {
            return null;
        }
    }
}