package org.example.checkee;

import Services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flight")
public class FlightServlet extends HttpServlet {

    private static final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
        if(param != null && param.matches("[0-9]+")){
            req.setAttribute("flight", flightService.findById(Long.valueOf(param)));
        }
        req.setAttribute("flights", flightService.findAll());
        req.getRequestDispatcher("WEB-INF/flight.jsp").forward(req, resp);
    }
}
