package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class JsoupFirsTest {
    @Test
    public void testurl() throws Exception{
        //解析url地址，第一个参数是访问url,第二个参数是访问超时时间
        Document doc = Jsoup.parse(new URL("http://itcast.cn"), 1000);

        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    @Test
    public void testFile() throws Exception{
        //解析文件
        Document doc = Jsoup.parse(new File("F://test.html"), "utf8");

        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    @Test
    public void testDom() throws Exception{
        //解析文件
        Document doc = Jsoup.parse(new URL("http://itcast.cn"), 10000);

        //获取元素
            //通过id获取
//        Element element = doc.getElementById("ui-gf");
            //通过标签获取
//        Element element = doc.getElementsByTag("span").first();
            //通过class获取
//        Element element = doc.getElementsByClass("li_9").first();
        //通过属性获取
//        Element element1 = doc.getElementsByAttribute("").first();
        Element element = doc.getElementsByAttributeValue("class", "city").first();
        //输出
        System.out.println("获取到的元素是："+element.text());
    }

    @Test
    public void testData() throws Exception{
        //解析文件
        Document doc = Jsoup.parse(new URL("http://itcast.cn"), 1000);

        String str = "1";

        Element element = doc.getElementById("html-gf");

        //获取id
//        str = element.id();
        //获取className
//        str = element.className();
        //存储到一个set集合
//        Set<String> strings = element.classNames();
        //获取属性值attr
//        str = element.attr("class");
        //获取所有属性值attributes
        Attributes attributes = element.attributes();
        System.out.println(attributes.toString());
        //获取文本内容,上述 text
        System.out.println("获取到的元素是："+str);
    }

    /*使用选择器
    * 通过标签查找元素，如：span  doc.select("span")
    * 通过ID查找元素，如：#id     doc.select("#html-gf")
    * 通过class名称查找，如：.class
    * 利用属性查找元素，如：[attribute]
    * 利用属性值查找元素，如：[attr=value]
    * */

    @Test
    public void pictest() throws Exception{
        Document doc = Jsoup.parse(new URL("https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&page=1&s=1&click=1"), 10000);
        Element spuele = doc.select("div#J_goodsList > ul > li").first();
        Element skuele = spuele.select("li.ps-item").first();
        String picurl = skuele.select("img[data-sku]").first().attr("data-lazy-img");
        System.out.println(picurl);
    }
}
