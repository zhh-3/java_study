package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取参数
        String verifycode = request.getParameter("verifycode");
        String code = (String)request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");

        //3.验证
        //验证验证码正确性
        if (!code.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equalsIgnoreCase("zhh") && password.equals("123456")){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
