<%@ page import="java.util.List" %>
<%@ page import="com.aaslin.library.model.IssuedBook" %>
<html>

<head>
    <title>All Issued Books</title>
    <link rel="stylesheet" href="css/styles.css">
</head>

<h2>All Issued Books</h2>
<body>
<form method="get" action="viewAllIssuedBooks">
    <label>Search by User ID:</label>
    <input type="text" name="userId" placeholder="Enter User ID"/>
    <input type="submit" value="Search"/>
</form>

<% String message = (String) request.getAttribute("message");
   if (message != null) { %>
    <p style="color:red;text-align:center;"><%= message %></p>
<% } %>

<%
    List<IssuedBook> issuedBooks = (List<IssuedBook>) request.getAttribute("issuedBooks");
    if (issuedBooks != null && !issuedBooks.isEmpty()) {
%>
<table border="1" style="margin: 20px auto; width: 90%;">
    <tr>
        <th>Issue ID</th>
        <th>Book ID</th>
        <th>User ID</th>
        <th>Issue Date</th>
        <th>Due Date</th>
        <th>Return Date</th>
        <th>Returned</th>
        <th>Notes</th>
    </tr>
<%
    for (IssuedBook ib : issuedBooks) {
%>
    <tr>
        <td><%= ib.getIssueId() %></td>
        <td><%= ib.getBookId() %></td>
        <td><%= ib.getUserId() %></td>
        <td><%= ib.getIssueDate() %></td>
        <td><%= ib.getDueDate() %></td>
        <td><%= ib.getReturnDate() != null ? ib.getReturnDate() : "-" %></td>
        <td><%= ib.isReturned() ? "Yes" : "No" %></td>
        <td><%= ib.getNotes() %></td>
    </tr>
<% } %>
</table>
<% } else { %>
    <p>No issued books found.</p>
<% } %>
</div>

<div>
    <a href="viewBooks" class="back-btn">Back to Dashboard</a>
</div>
</body>
</html>
