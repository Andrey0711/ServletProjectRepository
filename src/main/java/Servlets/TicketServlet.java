package Servlets;

import DTO.TicketDto;
import Models.Ticket;
import Services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {

    private final static TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html");
        if (!req.getParameterMap().isEmpty()) {
            try (PrintWriter printWriter = resp.getWriter()) {
                TicketDto ticket = ticketService.findById(Long.valueOf(req.getParameter("flightId")));
                printWriter.write("""
                        <h4>Билет:</h4>
                        Id - %d, Name of buyer - %s, Cost - %s
                        """.formatted(ticket.getId(), ticket.getPassenger_name(), ticket.getCost()));
            }
            return;
        }
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h4>Билеты:</h4>");
            printWriter.write("<ul>");
            ticketService.findAll().forEach(e -> printWriter.write("""
                    <li>
                    %d - %s - %s
                    </li>
                    """.formatted(e.getId(), e.getPassenger_name(), e.getCost())));
            printWriter.write("</ul>");
        }
    }
}
