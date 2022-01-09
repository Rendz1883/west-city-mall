package io.github.ireflux.westcitymall.util;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONString;
import cn.hutool.json.JSONUtil;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.*;

import static cn.hutool.json.JSON.*;

public class HttpClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    // 编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    //设置链接超时时间
    private static final int CONNECT_TIMEOUT = 3000;

    //设置获取数据的响应时间
    private static final int SOCKET_TIMEOUT = 3000;


    //重定向
    public static final List<String> REDIRECT_CODE= new ArrayList<String>(){{
        add("300");add("301");add("302");add("303");add("305");add("307");}};


        //fd6939cfbfec079ba55848444c58372e
    /**
     * @param url:
     * @return Map<String,String>
     * @author rdz
     * @description 发送get请求 不带请求头和参数
     * @date 2022/1/8 下午1:35
     */
    public static Map<String,String> sendGet(String url)throws Exception{
        return sendGet(url,null,null);
    }

    /**
     * @param url:
     * @param params:
     * @return Map<String,String>
     * @author rdz
     * @description get请求 带请求参数
     * @date 2022/1/8 下午4:24
     */
    public static Map<String,String> sendGet(String url,Map<String,Object> params)throws Exception {
        return sendGet(url, null, params);
    }

    /**
     * 发送get请求 带请求头和请求参数
     * @param url:
     * @param headers:
     * @param params:
     * @return Map<String,String>
     * @author rdz
     * @description TODO
     * @date 2022/1/8 下午1:43
     */
    public static Map<String, String> sendGet(String url, Map<String,String>  headers, Map<String,Object> params) throws Exception {
        logger.info("httpClient-get请求参数为--url:{};headers:{};param:{}",url,headers,params);
        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建访问地址
        URIBuilder uriBuilder = new URIBuilder();
        if ((null!=params)&&(!params.isEmpty())){
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String,Object> entry:entrySet){
                uriBuilder.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        //创建http对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpGet.setConfig(requestConfig);

        //设置请求头
        packageHeader(headers, httpGet);

        //创建httpResponse对象
        CloseableHttpResponse httpResponse = null;
        try {
            return getHttpClientResult(httpResponse, httpClient, httpGet);
        }finally {
                //释放资源
            release(httpResponse,httpClient);

        }


    }

    /**
     * @param url:
     * @return Map<String,String>
     * @author rdz
     * @description post请求 不带请求头和请求参数
     * @date 2022/1/8 下午4:28
     */
    public static Map<String,String> sendPost(String url) throws Exception {
        return sendPost(url, null, null);
    }

    /**
     * @param url:
     * @param params:
     * @param formOrJson:
     * @return Map<String,String>
     * @author rdz
     * @description 带请求参数 post请求
     * @date 2022/1/8 下午4:30
     */
    public static Map<String, String> sendPost(String url, Map<String,Object> params, Integer formOrJson) throws Exception{
        return sendPost(url,null, params, formOrJson);
    }

    /**
     * @param url:
     * @param headers:
     * @param params:
     * @param formOrJson:
     * @return Map<String,String>
     * @author rdz
     * @description 带请求头和请求参数
     * @date 2022/1/8 下午4:37
     */
    public static Map<String,String> sendPost(String url,Map<String,String> headers,Map<String,Object> params,Integer formOrJson)throws Exception{
        logger.info("httpClient-post请求参数为--url:{};headers:{};params:{};formOrJson:{}",url,headers,params,formOrJson);

        //创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建http对象post
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        // 设置请求头
		/*httpPost.setHeader("Cookie", "");
		httpPost.setHeader("Connection", "keep-alive");
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
		httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
		httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");*/
        packageHeader(headers, httpPost);

        //封装请求参数
        if ((null!=formOrJson)&&(1 ==formOrJson)) {//form传参
            packageParamOfForm(params, httpPost);
        }else {//json 传参
            packageParamOfJson(params,httpPost);
        }
        CloseableHttpResponse httpResponse= null;
        try {
            return getHttpClientResult(httpResponse,httpClient,httpPost);
        }finally {
            release(httpResponse,httpClient);
        }

    }

    /**
     * 发送put请求；不带请求参数
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static Map<String,String> sendPut(String url) throws Exception {
        return sendPut(url,null,null);
    }

    /**
     * @param url:
     * @param params:
     * @param formOrJson:
     * @return Map<String,String>
     * @author rdz
     * @description TODO
     * @date 2022/1/8 下午8:18
     */
    public static Map<String,String> sendPut(String url, Map<String, Object> params,Integer formOrJson) throws Exception {
        logger.info("httpClient-put请求参数为--url:{};params:{}",url,params);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPut.setConfig(requestConfig);

        // 封装请求参数
        if((null!=formOrJson)&&(1 == formOrJson)){//form传参
            packageParamOfForm(params, httpPut);
        }else{//json传参
            packageParamOfJson(params, httpPut);
        }

        CloseableHttpResponse httpResponse = null;

        try {
            return getHttpClientResult(httpResponse, httpClient, httpPut);
        } finally {
            release(httpResponse, httpClient);
        }
    }

    /**
     * @param params:
     * @param httpMethod:
     * @return void
     * @author rdz
     * @description 封装请求参数-json方式
     * @date 2022/1/8 下午7:38
     */
    public static void packageParamOfJson(Map<String, Object> params, HttpEntityEnclosingRequest httpMethod) throws UnsupportedEncodingException{
        if ((null != params) && (!params.isEmpty())) {
            httpMethod.setEntity(new StringEntity(JSONUtil.toJsonStr(params)));
        }
    }

    /**
     * @param params:
     * @param httpMethod:
     * @return void
     * @author rdz
     * @description 封装请求参数-form方式
     * @date 2022/1/8 下午7:05
     */
    public static void packageParamOfForm(Map<String, Object> params, HttpEntityEnclosingRequest httpMethod) throws UnsupportedEncodingException {

        if ((null!=params)&&(!params.isEmpty())){
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps,ENCODING));


        }

    }


    /**
     * @param httpResponse:
     * @param httpClient:
     * @return void
     * @author rdz
     * @description 释放资源
     * @date 2022/1/8 下午4:25
     */
    public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws  Exception {
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }

    }

    /**
     * @param httpResponse:
     * @param httpClient:
     * @param httpMethod:
     * @return Map<String,String>
     * @author rdz
     * @description 获得响应结果
     * @date 2022/1/8 下午2:43
     */
    public static Map<String, String> getHttpClientResult(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws Exception {

        Map<String, String> result = new HashMap<String,String>();
        result.put("statusCode",String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));

        //执行请求
        httpResponse = httpClient.execute(httpMethod);
        logger.info("httpClient请求响应结果为--httpResponse:{}",httpResponse);

        //获取返回结果
        if (null != httpResponse && httpResponse.getStatusLine() != null) {
            result.put("statusCode",String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            result.put("content", (null != httpResponse.getEntity()) ? EntityUtils.toString(httpResponse.getEntity(), ENCODING) : "");
            //判定重定向
            if (REDIRECT_CODE.contains(String.valueOf(httpResponse.getStatusLine().getStatusCode()))) {
                Header locationHeader = httpResponse.getFirstHeader("location");
                result.put("location", (null != locationHeader) ? locationHeader.getValue() : "");
            }

        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("httpClient请求响应结果为--httpResponse:{}",result);
            }
        }).start();
        return result;

    }

    /**
     * @param params:
     * @param httpMethed:
     * @return void
     * @author rdz
     * @description 封装请求头
     * @date 2022/1/8 下午2:37
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethed) {
        if ((null!=params)&&(!params.isEmpty())){
            Set<Map.Entry<String,String>> entrySet = params.entrySet();
            for (Map.Entry<String,String> entry: entrySet){
                httpMethed.setHeader(entry.getKey(),entry.getValue());
            }
        }
    }
    public static String doPost(String url, Map<String, String> headers, Map<String, Object> params) throws Exception {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建http对象
        HttpPost httpPost = new HttpPost(url);
        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        // 设置请求头
        /*httpPost.setHeader("Cookie", "");
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");*/
        packageHeader(headers, httpPost);

        // 封装请求参数
        packageParam(params, httpPost);

        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = null;

        String result = "";
        try {

            // 执行请求
            httpResponse = httpClient.execute(httpPost);

            // 获取返回结果
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                if (httpResponse.getEntity() != null) {
                    result = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
            }

        } finally {
            // 释放资源
            release(httpResponse, httpClient);
        }
        return result;
    }
    /**
     * Description: 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException
     */
    public static void packageParam(Map<String, Object> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // 封装请求参数
        if (null != params && params.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }


}
