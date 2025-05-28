package org.scoula.ex02;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = {"/yyy", "/xxx"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>Hello</title></head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init Call");
        message = "Hello World?";
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy Call");
    }
}
