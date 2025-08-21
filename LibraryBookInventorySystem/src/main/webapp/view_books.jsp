<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aaslin.library.model.Book" %>
<html>
<head>
    <title>Library Dashboard</title>
    <link rel="stylesheet" href="css/viewStyles.css">
</head>
<body>

<%
    String role = (String) session.getAttribute("role");
    String username = (String) session.getAttribute("username");
    boolean isAdmin = "admin".equals(role);
    boolean isUser = "user".equals(role);
%>

<div class="navbar">
    <div>
        <span><strong>Library Dashboard - <%= isAdmin ? "Admin" : "User" %></strong></span>
        <a href="viewBooks">View Books</a>
        <% if (isAdmin) { %>
            <a href="add_book.jsp">Add Book</a>
            <a href="view_all_issued_books.jsp">IssuedBooks</a>
        <% } %>
    </div>
    <div class="right">
        <span>Welcome, <%= username != null ? username : "Guest" %></span>
        <form action="logout" method="post" style="margin-left: 15px;">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>
</div>

<div class="container">
    <h2>Available Books</h2>

    <% String message = (String) session.getAttribute("message");
       if (message != null) { %>
        <p style="color:green;text-align:center;"> <%= message %> </p>
        <% session.removeAttribute("message"); } %>

    <table>
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>ISBN</th><th>Available</th><th>Actions</th>
        </tr>
        <%
            List<Book> books = (List<Book>) request.getAttribute("books");
            if (books != null && !books.isEmpty()) {
                for (Book b : books) {
        %>
        <tr>
            <td><%= b.getBookId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getIsbn() %></td>
            <td><%= b.isAvailable() ? "Yes" : "No" %></td>
            <td class="action-icons">
                <% if (isAdmin) { %>
                    <a class="edit-btn" href="editBook.jsp?id=<%= b.getBookId() %>">Edit</a>
                    <a class="delete-btn" href="deleteBook?id=<%= b.getBookId() %>" onclick="return confirm('Are you sure you want to delete this book?')">Delete</a>
                    <% if (b.isAvailable()) { %>
                        <a class="issue-btn" href="issue_book.jsp?bookId=<%= b.getBookId() %>">Issue</a>
                        
                    <% } else { %>
                        <span style="color:gray;">Issued</span>
                        <a class="return-btn" href="return_book.jsp?bookId=<%= b.getBookId() %>">Return</a>
                    <% } %>
                <% }  else { %>
                    <span style="color:gray;">Can accessible to admin only</span> 
                <% } %>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No books available.</td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>