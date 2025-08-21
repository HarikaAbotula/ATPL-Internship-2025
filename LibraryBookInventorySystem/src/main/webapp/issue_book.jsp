<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bookId = request.getParameter("bookId"); 
%>
<html>
<head>
    <title>Issue Book</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h2>Issue a Book</h2>
<form method="post" action="issueBook">
    <label>Book ID:</label>
    <input type="text" name="book_id" value="<%= bookId != null ? bookId : "" %>" readonly/><br/>

    <label>User ID:</label>
    <input type="text" name="user_id" required/><br/>

    <label>Notes:</label>
    <input type="text" name="notes"/><br/>

    <!-- Due date calculated automatically in Servlet -->
    <input type="submit" value="Issue Book"/>
</form>
  <div class="back-link">
        <a href="viewBooks">&larr; Back to Dashboard</a>
    </div>
<p style="color:green">${message}</p>
</body>
</html>
