<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<title>Employee Registration System</title>
<script>
        function my_button_clicked(){
                alert('Employees Information deleted!');
        }
</script>
</head>
<body style="background-color: #eff7e3;">
        <h1>A Spring RESTful Web Services</h1>
        <p>This is an employee registration system. The database comes pre-loaded with 2 active employees.</p>
        <br>
        
        
        <form:form action="/employees" method="get" modelAttribute="employee">
                <h4>(GET)<br>Show all current employees on the database. <form:button>Click Here</form:button></h4>
        </form:form>
        <br>

        
        <h4>(POST)<br>New Employee Registration Form</h4>
        <form:form action="/addemployees" method="post" modelAttribute="employee">

                <form:label path="firstName">First Name:</form:label>
                <form:input path="firstName"></form:input>

                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName"></form:input>

                <form:label path="role">Company Role (e.g.CEO,Accountant):</form:label>
                <form:input path="role"></form:input>

                <form:button>Submit</form:button>

        </form:form>
        <br>

        
        <h4>(PUT)<br>Update a current employee's information.</h4>
        <form:form action="/putemployees" method="put" modelAttribute="employee">
                <form:label path="id">Current employee's ID number:</form:label>
                <form:input path="id"></form:input>

                <form:label path="firstName">Change First Name:</form:label>
                <form:input path="firstName"></form:input>

                <form:label path="lastName">Change Last Name:</form:label>
                <form:input path="lastName"></form:input>

                <form:label path="role">Change company role:</form:label>
                <form:input path="role"></form:input>
                <form:button>Update</form:button>
        </form:form>
        <br>

        
        <h4>(DELETE)<br>Delete an employee from the database.</h4>
        <br>
        <form:form action="/deleteemployees" method="delete" modelAttribute="employee">

                <form:label path="id">Employee ID number to delete.</form:label>
                <form:input path="id"></form:input>

                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName"></form:input>

                <form:button onclick="my_button_clicked()">Delete</form:button>
        </form:form>

</body>
</html>
