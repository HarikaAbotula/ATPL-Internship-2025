<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit Student</title>
    <style>.error {color:red;}</style>
</head>
<body>
<h2>Edit Student</h2>

<form:form modelAttribute="student" method="post"
           action="${pageContext.request.contextPath}/students/update/${student.id}">
    ID: <form:input path="id" readOnly="true"/>
    <form:errors path="id" cssClass="error"></form:errors> <br><br>
    
    Name: <form:input path="name" />
    <form:errors path="name" cssClass="error"></form:errors><br/><br/>
    
    Email: <form:input path="email" />
    <form:errors path="email" cssClass="error"></form:errors><br/><br/>
    
    Age: <form:input path="age" />
    <form:errors path="age" cssClass="error"></form:errors><br/><br/>
    <input type="submit" value="Update Student"/>
</form:form>

</body>
</html>