package org.example.checkee;

import Services.FlightService;
import Services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final static FlightService flightService = FlightService.getInstance();
    private final static TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tryGetTicketId = req.getParameter("id");
        if(tryGetTicketId != null && tryGetTicketId.matches("[0-9]+")){
            System.out.println("checking");
            req.setAttribute("ticket", ticketService.findById(Long.valueOf(tryGetTicketId)));
        }
        req.setAttribute("tickets", ticketService.findAll());
        req.getRequestDispatcher("WEB-INF/content.jsp").forward(req, resp);
    }
}
