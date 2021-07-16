package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rdemo1")
public class Servletdemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式: GET
        String method = request.getMethod();
        System.out.println(method);
        //获取虚拟目录: /day13
        String contextpath = request.getContextPath();
        System.out.println(contextpath);
        //获取servlet路径: /rdemo1
        String servletpath = request.getServletPath();
        System.out.println(servletpath);
        //获取get请求参数: name=zhh
        String querystring = request.getQueryString();
        System.out.println(querystring);
        //获取URI: /day13/rdemo1
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //获取URL: http://lochost/day13/rdemo1
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //获取协议及版本: HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //获取客户机的IP地址: 0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
