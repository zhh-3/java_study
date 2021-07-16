package test;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Httppostfaramtest {
    public static void main(String[] args) throws Exception {
        //创建一个HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //使用post请求
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");

        //声明list集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址是：http://yun.itheima.com/search?keys=java
        params.add(new BasicNameValuePair("keys","java"));

        //创建表单中的entity对象，第一个参数就是封装好的表单数据，第二个数据就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf8");

        //设置表单的Entity对象到post请求中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;

        try {
            //使用HttpClient对象发起请求，获取response
            response = httpClient.execute(httpPost);

            //解析响应
            if (response.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
