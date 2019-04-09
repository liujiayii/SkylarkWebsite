package com.websit.online.utils;
/**
 * 
 *
 * @ClassName: OnlineConfig
 *
 * @description 在线客服常量
 *
 * @author HanMeng
 * @createDate 2019年3月27日-下午5:21:50
 */
public class OnlineConfig {
	 /* 根据自己所在租户的环境选择对应的URL */// https://cschat-ccs.aliyun.com/index.htm?tntInstId=_0rhgRUW&scene=SCE00004278
    /** 阿里云云客服URL */
    public static final String HOST_URL                 = "https://cschat-ccs.aliyun.com/openapi/";
    /** 金融云云客服URL */
    public static final String HOST_URL_ALIPAY          = "https://cschat.cloud.alipay.com/openapi/";

    //--------------------------------------------------------------------------------

    /* 以下内容需要联系技术支持获取 */
    /** 租户的密钥, 用来计算digest */
    public static final String key              = "xJIevGL2oPSsMIhYue7qzCgk9MIkECUW";

    //--------------------------------------------------------------------------------

    /* 以下内容在开通租户后, 按照文档即可获取, 不懂联系技术支持 */
    /** 租户ID */
    public static final String tntInstId        = "_0rhgRUW";
    /** */
    public static final String scene            = "SCE00004278";

    //--------------------------------------------------------------------------------
    /* 以下内容为固定写死内容, 无需关心 */
    /** 开放渠道, 固定为outerservice */
    public static final String src           = "outerservice";
    /** 发送消息的URL PATH */
    public static final String MESSAGE_PATH             = "forwardMessage";
    /** 上传文件的URL PATH */
    public static final String UPLOAD_FILE_API_PATH     = "/uploadFile";
}
