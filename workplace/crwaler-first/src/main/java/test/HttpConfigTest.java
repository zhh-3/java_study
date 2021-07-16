package test;


import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpConfigTest {
    public static void main(String[] args) throws Exception {
        //1.打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2.输入网址,发起get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

            //设置请求信息
            RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //创建连接最长时间
                                                         .setConnectionRequestTimeout(500) //获取连接的最长时间
                                                         .setSocketTimeout(10*1000) //数据传输最长时间
                                                         .build();
            //给请求设置请求信息
            httpGet.setConfig(config);

        //3.按回车，发起请求，返回响应，使用HttpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4.解析响应，获取数据
            //判断状态码是否正常,即为200
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntiy = response.getEntity();
            String content = EntityUtils.toString(httpEntiy, "utf8");
            System.out.println(content);
        }
    }
}
