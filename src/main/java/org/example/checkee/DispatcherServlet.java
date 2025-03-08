package org.example.checkee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HelloServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = "Python Govno";
        String b = "Python Govno";
        String c = new String("Python Govno");
        StringBuilder sb = new StringBuilder("Python Govno");

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(sb.toString()==c);
        System.out.println(sb.toString()==a);
        System.out.println(a.equals(sb.toString()));
        System.out.println(c.equals(sb.toString()));
        resp.sendRedirect("/flights");
        //        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        req.getRequestDispatcher("/flights").include(req, resp);
//        try (PrintWriter printWriter = resp.getWriter()) {
//            printWriter.write("<h4>Dispatcher checking</h4>");
//        }

//        req.setAttribute("check", "checkingDispatcher");
    }
}
