package ejb2;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @EJB
    HelloSessionRemote greeter;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getParameter("name") != null) {
            out.println(greeter.hiThere(request.getParameter("name")) + "<br />");
        }
        out.println("<form method=\"post\" action=\"HelloServlet\">");
        out.println("Your name:<input type=\"text\" name=\"name\" />");
        out.println("<input type=\"submit\" value=\"Say Hi\" />");
        out.println("</form>");
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
