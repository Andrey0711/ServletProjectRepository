package org.example.checkee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Stream;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/first")
public class HelloServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestParam = req.getParameter("name");
        Map<String, String[]> requestParams = req.getParameterMap();
        System.out.println(requestParam);
        try(PrintWriter printWriter = resp.getWriter()){
            printWriter.write("First servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(BufferedReader reader = req.getReader();
            Stream<String> lines = reader.lines()){
            lines.forEach(System.out::println);
        }
    }

    public void destroy() {
        super.destroy();
    }
}