package web.Servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {
//    只执行一次，被创建时执行
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

//    每次被调用时执行
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

//    执行一次，在被销毁时执行
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
