package com.aaslin.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.util.DbUtil;

@WebServlet("/order/list")

public class ShowAllOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DbUtil.getConnection()) {
            String query = "SELECT * FROM orders_harika";
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                out.println("<h2>All Orders</h2>");
                out.println("<table border='1'>");
                out.println("<tr><th>Order ID</th><th>Item ID</th><th>Quantity</th><th>Order Time</th></tr>");

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    int id = rs.getInt("id");
                    int itemId = rs.getInt("item_id");
                    int qty = rs.getInt("qty");
                    Timestamp time = rs.getTimestamp("order_time");

                    out.println("<tr>");
                    out.println("<td>" + id + "</td>");
                    out.println("<td>" + itemId + "</td>");
                    out.println("<td>" + qty + "</td>");
                    out.println("<td>" + time + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");

                if (!found) {
                    out.println("<p>No orders found.</p>");
                }

            }

        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

}
