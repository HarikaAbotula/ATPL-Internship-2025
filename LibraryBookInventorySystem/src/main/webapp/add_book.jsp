<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h2>Add Book</h2>
<form action="addBook" method="post">
    <label>Book ID:</label> <input type="text" name="book_id" required/><br/>
    <label>Title:</label> <input type="text" name="title" required/><br/>
    <label>Author:</label> <input type="text" name="author" required/><br/>
    <label>ISBN:</label> <input type="text" name="isbn" required/><br/>
    <input type="submit" value="Add Book"/>
    
</form>
	<% if ("admin".equals(session.getAttribute("role"))) { %>
    <a href="viewBooks" class="back-btn">Back to Admin Dashboard</a>
<% } %>
	
<br/>
<p style="color:green">${message}</p>
</body>
</html>