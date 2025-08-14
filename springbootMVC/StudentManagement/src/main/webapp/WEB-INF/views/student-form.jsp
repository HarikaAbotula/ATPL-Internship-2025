<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Student</title>
    <style>.error {color:red;}</style>
</head>
<body>
<h2>Add Student</h2>

<form:form modelAttribute="student" method="post"
           action="${pageContext.request.contextPath}/students/add">
    ID: <form:input path="id"/>  <form:errors path="id" cssClass="error"></form:errors><br><br>
    Name: <form:input path="name" />  <form:errors path="name" cssClass="error"></form:errors><br/><br/>
    Email: <form:input path="email" />  <form:errors path="email" cssClass="error"></form:errors><br/><br/>
    Age: <form:input path="age" />  <form:errors path="age" cssClass="error"></form:errors><br/><br/>
    <input type="submit" value="Add Student"/>
</form:form>

</body>
</html>