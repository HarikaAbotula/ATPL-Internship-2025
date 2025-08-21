<%@ page import="com.aaslin.library.dao.BookDao" %>
<%@ page import="com.aaslin.library.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String role = (String) session.getAttribute("role");
    if (!"admin".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }

    int bookId = Integer.parseInt(request.getParameter("id"));
    BookDao dao = new BookDao();
    Book book = dao.getBookById(bookId);
    
%>
<html>
<head>
    <title>Edit Book</title>
     <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="container">
    <h2>Edit Book</h2>
    <form action="updateBook" method="post">
        <input type="hidden" name="id" value="<%= book.getBookId() %>" />

        <label>Title:</label>
        <input type="text" name="title" value="<%= book.getTitle() %>" required />

        <label>Author:</label>
        <input type="text" name="author" value="<%= book.getAuthor() %>" required />

        <label>ISBN:</label>
        <input type="text" name="isbn" value="<%= book.getIsbn() %>" required />

        <label>Available:</label>
        <select name="available">
            <option value="true" <%= book.isAvailable() ? "selected" : "" %>>Yes</option>
            <option value="false" <%= !book.isAvailable() ? "selected" : "" %>>No</option> 
        </select>

        <br> <br> <input type="submit" value="Update Book" />
    </form>

    <div class="back-link">
        <a href="viewBooks"> Back to Dashboard</a>
    </div>
</div>
</body>
</html>
