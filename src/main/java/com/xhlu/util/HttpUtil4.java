package com.xhlu.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * <pre>
 *   依赖 Apache HttpClient 4.x
 *   Http请求工具,编码都默认为UTF-8
 * </pre>
 * <p/>
 * Created by luxiaohu at 16/5/5 16:05
 */
public class HttpUtil4 {


    private static String ENCODE = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(HttpUtil4.class);


    /**
     * get请求,数据按表单形式提交.支持受信任的https请求
     *
     * @param url 请求地址
     * @return
     */
    public static String httpGet(String url) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        return doGet(url, httpClient);

    }

    /**
     * post请求,数据按表单形式提交.支持受信任的https请求
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return
     */
    public static String httpPost(String url, Map<String, Object> params) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        return doPost(url, params, httpClient);
    }

    /**
     * post请求,数据按表单形式提交.支持不受信任的https请求
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return
     */
    public static String httpsPost(String url, Map<String, Object> params) {

        CloseableHttpClient httpClient = createSSLClientDefault();

        return doPost(url, params, httpClient);
    }


    /**
     * @param url        url地址
     * @param params     参数
     * @param httpClient client
     * @return
     */
    private static String doPost(String url, Map<String, Object> params, CloseableHttpClient httpClient) {

        HttpContext httpContext = new HttpClientContext();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        Set<String> stringSet = params.keySet();
        Iterator<String> iterator = stringSet.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            formParams.add(new BasicNameValuePair(key, String.valueOf(params.get(key))));
        }

        UrlEncodedFormEntity urlEncodedFormEntity = null;
        String result = "";
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(formParams, ENCODE);
            httpPost.setEntity(urlEncodedFormEntity);

            logger.info("post {} ;request data is  {}", url, EntityUtils.toString(urlEncodedFormEntity));

            CloseableHttpResponse response = httpClient.execute(httpPost, httpContext);
            logger.debug("headers:{}", response.getAllHeaders());
            logger.debug("response status:{}", response.getStatusLine());
            //logger.debug("local:{}", response.getLocale().getDisplayName());

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);

            logger.info("post {} ;response status is {} ;response data is {}", url, response.getStatusLine(), result);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(" post 请求 {} 出现异常:", url, e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
            }
        }
        return result;
    }

    /**
     * @param url        地址
     * @param httpClient client
     * @return
     */
    private static String doGet(String url, CloseableHttpClient httpClient) {
        String result = "";
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpContext context = new HttpClientContext();

            CloseableHttpResponse response = httpClient.execute(httpGet, context);
            logger.debug("headers:{}", response.getAllHeaders());
            logger.debug("response status:{}", response.getStatusLine());
            //logger.debug("local:{}", response.getLocale().getDisplayName());
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);

            logger.info("get {} ;response status is {} ;response data is {}", url, response.getStatusLine(), result);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error(" post 请求 {} 出现异常:", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 处理https请求不受信任站点的情况
     * <pre>
     *     解决https 以下异常:
     *     javax.net.ssl.SSLException: hostname in certificate didn't match:www.XXX.com != www.xxx.com
     * </pre>
     *
     * @return
     */
    public static CloseableHttpClient createSSLClientDefault() {

        try {

            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            //ALLOW_ALL_HOSTNAME_VERIFIER 所有的主机验证都通过
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return null;

    }


}
