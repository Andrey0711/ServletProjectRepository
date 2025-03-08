package Servlets;

import Services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h4>Список перелетов:<h4>");
        printWriter.write("<ul>");
        flightService.findAll().forEach(e ->
                printWriter.write("""
                        <li>
                            <a href="/ticket?flightId=%d">%s</a>
                        </li>
                        """.formatted(e.getId(), e.getDescription())));
        printWriter.write("</ul>");
        System.out.println();

    }
}
