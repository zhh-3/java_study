package web.servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1。设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = new User();
        login.setUsername(username);
        login.setPassword(password);

        //4.调用UserDao中login方法
        UserDao dao = new UserDao();
        User user = dao.login(login);

        //5。判断User
        if (user != null){
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }else {
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
