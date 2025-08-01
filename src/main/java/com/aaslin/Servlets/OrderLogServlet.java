package com.aaslin.Servlets;

import com.aaslin.util.DbUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/order")
public class OrderLogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int generateOrderId() {
        return new Random().nextInt(900000) + 100000; // 6-digit random ID
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemIdParam = request.getParameter("item_id");
        String qtyParam = request.getParameter("qty");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (itemIdParam == null || qtyParam == null) {
            out.println("<h3>Missing item_id or qty</h3>");
            return;
        }

        try (Connection conn = DbUtil.getConnection()) {
            int itemId = Integer.parseInt(itemIdParam);
            int qty = Integer.parseInt(qtyParam);
            int orderId = generateOrderId();

            String sql = "INSERT INTO orders_harika (id, item_id, qty, order_time) VALUES (?, ?, ?, NOW())";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, orderId);
                stmt.setInt(2, itemId);
                stmt.setInt(3, qty);
                stmt.executeUpdate();
            }

            request.getSession().setAttribute("orderId", orderId);

            out.println("<h2> Order Created</h2>");
            out.println("<p>Order ID: " + orderId + "</p>");
            out.println("<p>Item ID: " + itemId + ", Qty: " + qty + "</p>");

        } catch (NumberFormatException e) {
            out.println("<h3>item_id and qty must be valid numbers</h3>");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }
}
