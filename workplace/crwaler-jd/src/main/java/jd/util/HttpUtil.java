package jd.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import sun.net.www.http.HttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Component
public class HttpUtil {
    private PoolingHttpClientConnectionManager cm;

    public HttpUtil(){
        this.cm = new PoolingHttpClientConnectionManager();
        this.cm.setMaxTotal(100);
        this.cm.setDefaultMaxPerRoute(10);
    }

    public String doGetHtml(String url){
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        //创建HttpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用httpGet发起请求，获取响应
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode()==200){
                //判断响应体的Entity是否不为空
                if (response.getEntity()!=null){
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "错误";
    }

    public String doGetImage(String url){
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        //创建HttpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用httpGet发起请求，获取响应
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode()==200){
                //判断响应体的Entity是否不为空
                if (response.getEntity()!=null){
                    //下载图片
                    //获取图片后缀名
                    String extName = url.substring(url.lastIndexOf("."));
                    //重命名图片
                    String picName = UUID.randomUUID().toString()+extName;
                    //下载图片
                        //下载地址
                        OutputStream os = new FileOutputStream(
                                new File("E:\\Users\\haha\\Desktop\\images\\"+picName));
                    response.getEntity().writeTo(os);
                    //返回图片名称
                    return picName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "图片下载错误";
    }

    private RequestConfig getConfig(){
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(1000)
                .setConnectionRequestTimeout(500)
                .setConnectTimeout(10000)
                .build();
        return config;
    }
}
