<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bookId = request.getParameter("bookId") != null ? request.getParameter("bookId") : "";
%>
<html>
<head>
    <title>Return Book</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

<h2>Return Book</h2>

<form method="post" action="returnBook">
    <label>Issue ID:</label> <input type="text" name="issue_id" required/><br/>
    <label>Book ID:</label> <input type="text" name="book_id" value="<%= bookId %>" required/><br/>
    <label>Return Date:</label> <input type="date" name="return_date" required/><br/>
    <input type="submit" value="Return Book"/>
</form>

<p style="color:green">${message}</p>

<a href="viewBooks" class="back-btn">Back to Dashboard</a>

</body>
</html>

