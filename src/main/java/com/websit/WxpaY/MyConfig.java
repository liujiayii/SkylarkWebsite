package com.websit.WxpaY;

import java.io.*;
import java.io.InputStream;
import java.util.Random;

/**
 * @author 
 * @return
 * @author
 */
/**
 *
 * @ClassName: MyConfig

 * @description 
 *
 * @author 
 * @createDate 2018年11月26日
 */

public final class MyConfig extends WXPayConfig {
    
    private byte[] certData;



    public MyConfig() throws Exception {
        
            /*String certPath = "/path/to/apiclient_cert.p12";
            File file = new File(certPath);
            InputStream certStream = new FileInputStream(file);
            this.certData = new byte[(int) file.length()];
            certStream.read(this.certData);
            certStream.close();*/

    //不是沙箱环境要要下载证书，开出来
        

      //  String certPath = "/path/to/apiclient_cert.p12";
		/*
		 * String path=this.getClass().getClassLoader().getResource("/").getPath();
		 * String certPath=path+ "apiclient_cert.p12"; File file = new File(certPath);
		 * 
		 * InputStream certStream = new FileInputStream(file);
		 * 
		 * this.certData = new byte[(int) file.length()];
		 * 
		 * certStream.read(this.certData);
		 * 
		 * certStream.close();
		 */

    }




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* (non-Javadoc)
     * @see com.cashier.wxpay.WXPayConfig#getAppID()
     */
    @Override
    String getAppID() {
        // TODO Auto-generated method stub
        return "wxb7e49e3a0bc42a51";
    }

    /* (non-Javadoc)
     * @see com.cashier.wxpay.WXPayConfig#getMchID()
     */
    @Override
    String getMchID() {
        // TODO Auto-generated method stub
        return "1530971811";
    }

    /* (non-Javadoc)
     * @see com.cashier.wxpay.WXPayConfig#getKey()
     */
    @Override
    String getKey() {
        // TODO Auto-generated method stub
        return "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ikk";
    }

    /* (non-Javadoc)
     * @see com.cashier.wxpay.WXPayConfig#getCertStream()
     */
    @Override
    InputStream getCertStream() {
        // TODO Auto-generated method stub
        // ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);

        return null;
    }

    /* (non-Javadoc)
     * @see com.cashier.wxpay.WXPayConfig#getWXPayDomain()
     */
    @Override
    IWXPayDomain getWXPayDomain() {
        // TODO Auto-generated method stub
        return WXPayDomainSimpleImpl.instance();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MyConfig [getAppID()=" + getAppID() + ", getMchID()=" + getMchID() + ", getKey()=" + getKey()
                + ", getCertStream()=" + getCertStream() + ", getWXPayDomain()=" + getWXPayDomain()
                + ", getHttpConnectTimeoutMs()=" + getHttpConnectTimeoutMs() + ", getHttpReadTimeoutMs()="
                + getHttpReadTimeoutMs() + ", shouldAutoReport()=" + shouldAutoReport() + ", getReportWorkerNum()="
                + getReportWorkerNum() + ", getReportQueueMaxSize()=" + getReportQueueMaxSize()
                + ", getReportBatchSize()=" + getReportBatchSize() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }
    
    

}
