<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>All Students</h2>

<c:if test="${empty students}">
    <p>No students found.</p>
</c:if>

<c:forEach var="student" items="${students}">
    <div style="margin-bottom:10px; border-bottom:1px solid #ccc; padding-bottom:10px;">
        <b>ID:</b> ${student.id}<br/>
        <b>Name:</b> ${student.name}<br/>
        <b>Email:</b> ${student.email}<br/>
        <b>Age:</b> ${student.age}<br/>
        <a href="${pageContext.request.contextPath}/students/add/${student.id}">View</a> |
        <a href="${pageContext.request.contextPath}/students/update/${student.id}">Edit</a> |
        <a href="${pageContext.request.contextPath}/students/delete/${student.id}" onclick="return confirm('Delete student?');">Delete</a>
    </div>
</c:forEach>

<br/>
<a href="${pageContext.request.contextPath}/students/add">Add New Student</a>
</body>
</html>
