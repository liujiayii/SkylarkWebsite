package com.websit.online.utils;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import com.alipay.fc.csplatform.common.crypto.Base64Util;

public class OnlinePubKeyUtil {
	/** 这个密钥请联系云客服获取. 该密钥仅做DEMO展示使用. 拿到公钥后, 不要换行 放到这里即可. */
    private static String PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtTJ9Oo/gvo6476PYi4zADnCVhtLxI8q9HsN1EkRJfna85p95WrNOxjdH5E3PfDBQolTnvNzdxGeetYA6UFczndXbeWfHeijQQyuBJ57hKYbCtLmG10K8VcpekgDf76NCETmX3HN4HQAYioLojn3MmwzP+95K89lLzB2XdJz4gjNQDcdILS3CIpsj1hjroGnZSIkluwfELjJNDW6sU019lHMJ7OB6KPbFEcEEsahLmtMP2ua/C5rZjbRyP24cAbTc2yrjm3A1M8WoUbcvcIIpRw93BoYfK985vbI4M6WNfYl0/wOpYrhom6oo19dGJRlBBeKnjiW2Wa5MFUvBOHEXTQIDAQAB";

  //还原出RSA公钥对象
    public static PublicKey getPubKey() throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64Util.decode(PUB_KEY));
        KeyFactory keyFactory;
        keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        return key;
    }
}
