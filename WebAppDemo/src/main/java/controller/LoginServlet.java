package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Step 1: Get the username and password from the request
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Step 2: Create an instance of the User class
        User user = new User();
        Boolean isValid = user.validation(username, password);

        // Step 3: Forward to the appropriate view
        if (isValid) {
            req.setAttribute("username", username);
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Invalid username or password!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}