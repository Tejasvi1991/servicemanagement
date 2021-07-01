<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Service Details</title>
<style type="text/css">
    label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
    }
    input[type=text], select {
        width: 200px;  
    }
    
    button {
        padding: 10px;
        margin: 10px;
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div align="center">
    	<nav class="navbar navbar-expand-lg navbar-light justify-content-center" style="background-color: #4293f5">
      		<h2>Update Service Details</h2>
        </nav>
        <form:form action="/updateservice?id=${id}" method="post" modelAttribute="service">
            <form:label path="serviceName">Service name</form:label>
            <form:input path="serviceName"/><br/>
             
            <form:label path="url">URL</form:label>
            <form:input path="url"/><br/>
            
            <form:button class="btn btn-success btn-lg">Update</form:button>
        </form:form>
    </div>
</body>
</html>