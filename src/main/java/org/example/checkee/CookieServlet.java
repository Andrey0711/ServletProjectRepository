package org.example.checkee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/second")
public class CookieServlet extends HttpServlet {

    private static final String UNIQUE_ID = "userId";
    private static final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Cookie[]> cookieServlet = Optional.ofNullable(req.getCookies());
        if(cookieServlet.isEmpty() || Arrays.stream(cookieServlet.get()).
                filter(e -> UNIQUE_ID.equals(e.getName()))
                .findFirst().isEmpty()){
            counter.incrementAndGet();
            Cookie cookie = new Cookie(UNIQUE_ID, "91225342345");
            cookie.setPath("cookies");
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
        }
        counter.incrementAndGet();
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("""
                    <h4>Counter: %s</h4>
                    """.formatted(counter.get()));
        }
    }

}
