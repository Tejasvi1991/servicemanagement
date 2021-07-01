<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  </head>
  <body>
  	  <nav class="navbar navbar-expand-lg navbar-light justify-content-center" style="background-color: #4293f5">
      		<h2>Service Details</h2>
      </nav>
      <table class="table table-striped" style=" margin-top: -10%">
      <thead>
    	<tr>
      	  <th scope="col">Service Name</th>
      	  <th scope="col">URL</th>
      	  <th scope="col">Create Date</th>
      	  <th scope="col">Update Date</th>
      	  <th scope="col"></th>
      	  <th scope="col"></th>
      	  <th scope="col"></th>
    	</tr>
  	 </thead>
  	 <tbody>
       <c:forEach items="${serviceDataList}" var="serviceList">
        <tr>
         <td>${serviceList.serviceName}</td>
         <td>${serviceList.url}</td>
         <td>${serviceList.createDate}</td>
         <td>${serviceList.updateDate}</td>
	     <td><a type="button" class="btn btn-info btn-sm" href="/check?id=${serviceList.id}">Check</a></td>
         <td><a type="button" class="btn btn-success btn-sm" href="/update?id=${serviceList.id}">Update</a></td>
         <td><a type="button" class="btn btn-danger btn-sm" href="/delete?id=${serviceList.id}">Delete</a></td><br>
        </tr>
     </c:forEach>
     </tbody>
     </table>
     <div align="center">
  		<h4><a type="button" class="btn btn-primary btn-lg" href="/add">Add Service</a></h4>
  	 </div>
	 </body>
</html>