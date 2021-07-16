package test;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class First {
    public static void main(String[] args) throws Exception {
        //1.打开浏览器，创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2.输入网址,发起get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet("https://www.liepin.com/zhaopin/?industries=&subIndustry=&dqs=&salary=&jobKind=&pubTime=&compkind=&compscale=&searchType=1&isAnalysis=&sortFlag=15&d_headId=e7ae308da9f8db22cd75b861f0d9d258&d_ckId=e7ae308da9f8db22cd75b861f0d9d258&d_sfrom=search_fp&d_curPage=0&d_pageSize=40&siTag=LiAE77uh7ygbLjiB5afMYg%7EfA9rXquZc5IkJpXC-Ycixw&key=java");

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
