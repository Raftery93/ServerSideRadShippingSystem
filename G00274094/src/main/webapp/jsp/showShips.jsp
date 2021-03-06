<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 <!-- CSS Styling -->
		<style type="text/css">
			table, th, td {
		    border: 1px solid black;
		}
	</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Ships</title>
	</head>
	<body>
		<h1>Ships</h1>
		<table>
			<tr>
			 <!-- Table headers -->
		        <th>Name</th>
		        <th>Passengers</th>
		        <th>Cost</th>
		        <th>Length(Meters)</th>
		        <th>Shipping Company</th>
		    </tr>
		     <!-- Loop which loops through each ship to be displayed -->
		    <c:forEach items="${ships}" var="ship">
		        <tr>
		         <!-- Data to display ship details using Ship.java -->
		            <td>${ship.name}</td>
		            <td>${ship.passengers}</td>
		           	<td>${ship.cost}</td>
		            <td>${ship.metres}</td>
		            <td>${ship.shippingCompany}</td>
		        </tr>
		    </c:forEach>
		</table>
		 <!-- Link back to index page -->
		<a href="/">Home</a>
	</body>

</html>