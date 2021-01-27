package com.lzq.demo.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lzq.demo.entity.TwoColorBall;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 11:08 2021/1/27
 */
public class HttpClient {
    /**
     * 连接超时时间(20s)
     */
    private static int CONNECT_TIME_OUT = 20 * 1000;

    /**
     * 读取数据超时时间(20s)
     */
    private static int READ_TIME_OUT = 20 * 1000;

    private static String REQUEST_ACCEPT = "application/json, text/javascript, */*; q=0.01";
    private static String REQUEST_ACCEPT_ENCODING="gzip, deflate";
    private static String REQUEST_ACCEPT_LANGUAGE="zh-CN,zh;q=0.9";
    private static String REQUEST_CONNECTION="keep-alive";
    private static String REQUEST_USER_AGENT="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36";
    private static String REQUEST_X_REQUESTED_WITH="XMLHttpRequest";

    private static String RESPONSE_CACHE_CONTROL="No-Cache";
    private static String RESPONSE_CONNECTION="keep-alive";
    private static String RESPONSE_CONTENT_LENGTH="81798";
    private static String RESPONSE_CONTENT_TYPE="application/json;charset=UTF-8";
    private static String RESPONSE_DATE="Wed, 27 Jan 2021 03:00:32 GMT";
    private static String RESPONSE_EXPIRES="Thu, 01 Jan 1970 00:00:00 GMT";
    private static String RESPONSE_PRAGMA="No-Cache";
    private static String RESPONSE_SERVER= "waf/4.25.1-0.el6";
    private static String RESPONSE_X_FRAME_OPTIONS= "SAMEORIGIN";
    private static String RESPONSE_X_VIA= "1.1 PS-CZX-015gG81:5 (Cdn Cache Server V2.0), 1.1 dianxin79:2 (Cdn Cache Server V2.0)";
    private static String RESPONSE_X_WS_REQUEST_ID="6010d750_PS-MIG-01WSy108_9675-61530";
    /**
     * 以get方式调用第三方接口
     *
     * @param url
     * @return
     */
    public static String doGet(String url,String cookie,String host,String referer) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = null;
        String result = "";
        try {
            httpClient = HttpClients.custom().build();
            // 创建httpGet远程连接实例
            httpGet = new HttpGet(url);
            httpGet.addHeader("Accept",REQUEST_ACCEPT);
            httpGet.addHeader("Accept-Encoding",REQUEST_ACCEPT_ENCODING);
            httpGet.addHeader("Accept-Language",REQUEST_ACCEPT_LANGUAGE);
            httpGet.addHeader("Connection",REQUEST_CONNECTION);
            httpGet.addHeader("Cookie",cookie);
            httpGet.addHeader("Host",host);
            httpGet.addHeader("Referer",referer);
            httpGet.addHeader(HTTP.USER_AGENT, REQUEST_USER_AGENT);
            httpGet.addHeader("X-Requested-With",REQUEST_X_REQUESTED_WITH);
            // 设置配置请求参数
            RequestConfig requestConfig = RequestConfig.custom()
                    // 连接主机服务超时时间
                    .setConnectTimeout(CONNECT_TIME_OUT)
                    // 请求超时时间
                    .setConnectionRequestTimeout(CONNECT_TIME_OUT)
                    // 数据读取超时时间
                    .setSocketTimeout(READ_TIME_OUT)
                    .build();
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            // 通过返回对象获取返回数据
            HttpEntity httpEntity = response.getEntity();
            // 通过EntityUtils中的toString方法将结果转换为字符串
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK && httpEntity != null) {
                //返回json格式
                result = EntityUtils.toString(httpEntity, "UTF-8");
                EntityUtils.consume(httpEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            closeHttp(response, httpClient);
        }
        return result;
    }
    /**
     * 关闭连接
     *
     * @param response
     * @param httpClient
     */
    private static void closeHttp(CloseableHttpResponse response, CloseableHttpClient httpClient) {
        try {
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
