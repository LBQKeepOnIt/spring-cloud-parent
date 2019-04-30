package cn.com.lbq.order.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/25 17:07
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * POST请求，参数为JSON格式
     * @param json
     * @param url
     * @param readTimeout
     * @param connectTimeout
     * @return
     * @throws Exception
     */
    public static String postJson(String json, String url,int readTimeout, int connectTimeout) throws Exception {

        String responseBody =null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setSocketTimeout(readTimeout).build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        // 解决中文乱码问题
        StringEntity stringEntity = new StringEntity(json, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        try {

            httpPost.setEntity(stringEntity);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {//
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {

                        HttpEntity entity = response.getEntity();

                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
            responseBody = httpClient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            throw new Exception(e.getMessage());
        } finally {
            httpPost.abort();
            EntityUtils.consume(stringEntity);
        }
        return responseBody;
    }

}
