package servlet;

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
        //1.
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0, width, height);

        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width-1, height-1);

        //2.3写验证码
        String line = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        Random ran = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(line.length());
            char ch = line.charAt(index);
            s.append(ch);
            g.drawString(""+ch, width/5*i ,25);
        }

        String checkCode = s.toString();
        request.getSession().setAttribute("checkCode", checkCode);
        //2.4画干扰线
        g.setColor(Color.green);

        for (int i = 0; i < 10; i++) {
            int x1,x2,y1,y2;
            x1 = ran.nextInt(width);
            x2 = ran.nextInt(width);
            y1 = ran.nextInt(height);
            y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //3.图片输出到展示页面
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
