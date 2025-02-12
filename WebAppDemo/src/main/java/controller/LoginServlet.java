package controller;

import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import util.DatabaseUtil;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (EntityManager em = DatabaseUtil.getEntityManager()) {
            User user = em.find(User.class, username);
            
            if (user != null && user.validation(username, password)) {
                req.setAttribute("username", username);
                req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Invalid username or password!");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}