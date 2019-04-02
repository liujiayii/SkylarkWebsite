/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.websit.online.utils;

import com.alibaba.fastjson.JSONObject;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

/**
 * 请求类
 * @author fushan.cfs
 * @version $Id: MessageHttpClient.java, v 0.1 2018年05月24日 上午11:11 fushan.cfs Exp $
 */
public class MessageHttpClient {
    /** http请求的header设置 */
    private static final String CONTENT_TYPE = "application/json";
    private static final String CHARSET = "UTF-8";


    /** 用于发送消息的httpClient */
    private HttpClient httpClient;
    /**
     * httpClient的配置内容
     *
     */
    private int maxConnPerHost = 40;
    private int maxTotalConn = 200;
    /**
     * 默认等待连接建立超时，单位:毫秒
     */
    private int connectionTimeout = 1000;
    /**
     * 默认等待数据返回超时，单位:毫秒
     */
    private int soTimeout = 10000;
    /**
     * 默认请求连接池连接超时,单位:毫秒
     */
    private int connectionManagerTimeout = 1000;

    public MessageHttpClient() {
        createHttpClient();
    }

    /**
     * 构造httpClient用于对消息进行发送
     */
    public HttpClient createHttpClient(){
        HttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
        connectionManagerParams.setConnectionTimeout(connectionTimeout);
        connectionManagerParams.setSoTimeout(soTimeout);
        connectionManagerParams.setMaxTotalConnections(maxTotalConn);
        connectionManagerParams.setDefaultMaxConnectionsPerHost(maxConnPerHost);
        httpConnectionManager.setParams(connectionManagerParams);
        this.httpClient = new HttpClient(httpConnectionManager);
        this.httpClient.getParams().setConnectionManagerTimeout(connectionManagerTimeout);
        return this.httpClient;
    }

    /**
     * 发送消息的方法
     * @param message 序列化好的消息的json字符串 (计算digest也使用这个内容)
     * @param url 发送的url. 拼接好了tntInstId, scene, digest等内容
     * @return 返回发送结果
     * @throws Exception 异常抛出
     */
    public JSONObject sendMessage(String message, String url) throws Exception {
    	System.out.println("message:"+message+",url:"+url);
        RequestEntity requestEntity = new StringRequestEntity(message, CONTENT_TYPE, CHARSET);
        PostMethod postMethod = new PostMethod(url);
        try {
            postMethod.setRequestEntity(requestEntity);
            this.httpClient.executeMethod(postMethod);
            String responseStr = postMethod.getResponseBodyAsString();
            return JSONObject.parseObject(responseStr);
        } catch (Exception e) {
            throw new Exception("[ Send message error ]", e);
        } finally {
            postMethod.releaseConnection();
        }
    }

    /**
     * 获取一个fileKey所对应的文件的临时访问链接
     * @param url 文件的获取URL
     * @return JSON内容, 包含访问链接
     * @throws IOException 异常抛出
     */
    public JSONObject fetchFileUrl(String url) throws IOException {
        GetMethod getMethod= new GetMethod(url);
        try {
            this.httpClient.executeMethod(getMethod);
            String responseStr = getMethod.getResponseBodyAsString();
            return JSONObject.parseObject(responseStr);
        } catch (HttpException e) {
            throw new HttpException("[ fetch file url http error ] url = " + url, e);
        } catch (IOException e) {
            throw new IOException("[ fetch file url error ] url = " + url, e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    /**
     * 上传文件方法
     * @param file 二进制文件
     * @param url 发送的url, 拼接了tntInstid, scene, digest
     * @param type image, voice, video
     * @param fileName 保证后缀名正确的文件名字
     * @param timestamp 时间戳
     * @return 返回发送结果
     * @throws IOException 异常抛出
     */
    public JSONObject uploadFile(File file, String url, String type, String fileName, long timestamp)
            throws IOException {
        PostMethod postMethod = new PostMethod(url);

        //构造POST body内容
        FilePart filePart = new FilePart("file", file);
        StringPart typePart = new StringPart("type", type, CHARSET);
        StringPart fileNamePart = new StringPart("fileName", fileName, CHARSET);
        StringPart timestampPart = new StringPart("timestamp", Long.toString(timestamp), CHARSET);
        Part[] parts = { typePart, fileNamePart, timestampPart, filePart };

        MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, postMethod.getParams());
        postMethod.setRequestEntity(multipartRequestEntity);
        try {
            this.httpClient.executeMethod(postMethod);
            String responseStr = postMethod.getResponseBodyAsString();
            return JSONObject.parseObject(responseStr);
        } catch (HttpException he) {
            throw new HttpException("[ send message error ]", he);
        } catch (IOException ie) {
            throw new IOException("[ send message or get response error ]", ie);
        } finally {
            postMethod.releaseConnection();
        }
    }

    /**
     * base64文件上传 和 二进制上传 二选一即可
     * @param base64File base64文件, 去除base64的头
     * @param url 发送的URL
     * @param type 类型 image/voice/video
     * @param fileName 文件名称
     * @param timestamp 时间戳
     * @return 发送结果
     * @throws IOException 异常抛出
     */
    public JSONObject uploadBase64File(String base64File, String url, String type, String fileName, long timestamp) throws IOException {

        PostMethod postMethod = new PostMethod(url);
        StringPart base64FilePart = new StringPart("base64File", base64File, CHARSET);
        StringPart typePart = new StringPart("type", type, CHARSET);
        StringPart fileNamePart = new StringPart("fileName", fileName, CHARSET);
        StringPart timestampPart = new StringPart("timestamp", Long.toString(timestamp), CHARSET);
        Part[] parts = {typePart, fileNamePart, timestampPart, base64FilePart};
        MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, postMethod.getParams());
        try {
            postMethod.setRequestEntity(multipartRequestEntity);
            int status = this.httpClient.executeMethod(postMethod);
            if (status != HttpStatus.SC_OK) {
                return JSONObject.parseObject(postMethod.getResponseBodyAsString());
            }
            //这里是不是在response body有内容需要看一下
            return JSONObject.parseObject(postMethod.getResponseBodyAsString());
        }catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("unSupport encoding : " + CHARSET, e);
        }catch (HttpException he) {
            throw new HttpException("[ send message error ]", he);
        } catch (IOException ie) {
            throw new IOException("[send message or get response error ]", ie);
        } finally {
            postMethod.releaseConnection();
        }
    }
}