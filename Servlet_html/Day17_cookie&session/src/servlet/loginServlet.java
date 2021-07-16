package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数map
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3.获取checkCode,判断验证码是否正确
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute("checkCode");
        if (code.equalsIgnoreCase(checkCode)){
            if ("zhh".equals(username) && "123456".equals(password)){
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("err_msg", "账号或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("err_msg", "验证码错误");
            System.out.println("验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
