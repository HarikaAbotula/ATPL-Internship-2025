<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Student</title>
</head>
<body>
<h2>Student Details</h2>

<p><b>ID:</b> ${student.id}</p>
<p><b>Name:</b> ${student.name}</p>
<p><b>Email:</b> ${student.email}</p>
<p><b>Age:</b> ${student.age}</p>

<br/>
<a href="${pageContext.request.contextPath}/students">Back to Student List</a> |
<a href="${pageContext.request.contextPath}/students/update/${student.id}">Edit</a>

</body>
</html>
