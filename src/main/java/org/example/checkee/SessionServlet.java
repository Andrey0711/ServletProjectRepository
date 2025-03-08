package org.example.checkee;

import DTO.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    private static final String USER_ID = "userId";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = (UserDto) session.getAttribute(USER_ID);
        if(user == null){
            user = UserDto.builder()
                    .id(24L)
                    .email("lg700444@gmail.com")
                    .build();
            session.setAttribute(USER_ID, user);
        }
        System.out.println(session.isNew());
    }
}
