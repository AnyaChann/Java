package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import util.DatabaseUtil;

@WebServlet(name = "TestServlet", value = "/testdb")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try (EntityManager em = DatabaseUtil.getEntityManager()) {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();

            out.println("<html><body>");
            out.println("<h2>Database Connection Test</h2>");
            if (users.isEmpty()) {
                out.println("<p>No users found in the database.</p>");
            } else {
                out.println("<p>Users found in the database:</p>");
                out.println("<ul>");
                for (User user : users) {
                    out.println("<li>" + user.getUsername() + "</li>");
                }
                out.println("</ul>");
            }
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h2>Database Connection Test</h2>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</body></html>");
        }
    }
}