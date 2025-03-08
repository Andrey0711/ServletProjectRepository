package Servlets;

import DTO.Person.CreatePersonDto;
import Services.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/create")
public class PersonServlet extends HttpServlet {

    private final static TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tickets", ticketService.findAll());
        req.setAttribute("gender", List.of("MALE", "FEMALE"));
        req.getRequestDispatcher("WEB-INF/createPerson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreatePersonDto createPersonDto = CreatePersonDto.builder()
                    .name(req.getParameter("name"))
                    .email(req.getParameter("email"))
                    .role(req.getParameter("role"))
                    .gender(req.getParameter("gender"))
                    .password(req.getParameter("password"))
                    .birthday(req.getParameter("birthday"))
                .build();
    }
}
