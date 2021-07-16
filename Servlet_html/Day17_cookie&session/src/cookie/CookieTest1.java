package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieTest1")
public class CookieTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cs = request.getCookies();
        boolean flag = false;
        if (cs != null && cs.length != 0){
            for (Cookie c : cs) {
                if (c.getName().equals("LastTime")){
                    //有Cookie，不是第一次访问
                    flag = true;
                    //获取上次访问时间数据
                    String value = c.getValue();
                    System.out.println("解码前：value="+value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：value="+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");

                    //重新设置时间数据
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String new_date = sdf.format(date);
                    /**
                     * cookie中不能存在特殊字符如空格 对应ASCII码为 32
                     * 应使用URL编码和解码
                     */
                    System.out.println("URL编码前："+new_date);
                    new_date = URLEncoder.encode(new_date, "utf-8");
                    System.out.println("URL编码后："+new_date);

                    c.setValue(new_date);
                    c.setMaxAge(60 * 60 * 24);
                    response.addCookie(c);
                    System.out.println(System.getProperty("file.encoding"));
                    System.out.println("0信1息2信息3");
                }
            }
        }

        if (cs == null || cs.length == 0 || !flag){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String new_date = sdf.format(date);
            System.out.println("URL编码前："+new_date);
            new_date = URLEncoder.encode(new_date, "utf-8");
            System.out.println("URL编码后："+new_date);
            Cookie cookie = new Cookie("LastTime", new_date);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎首次访问</h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
