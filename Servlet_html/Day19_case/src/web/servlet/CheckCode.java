package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //1.
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0,0, width, height);

        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width-1, height-1);

        //2.3写验证码
        String checkCode = getCode();
        g.setColor(Color.yellow);
        g.setFont(new Font("黑体", Font.BOLD, 24));
        g.drawString(checkCode, 15, 25);
        request.getSession().setAttribute("checkCode", checkCode);

        //3.图片输出到展示页面
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected String getCode(){

        String line = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        Random ran = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(line.length());
            char ch = line.charAt(index);
            s.append(ch);
        }
        String code = s.toString();
        return code;
    }
}
