<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>::View Donations::</title>
</head>
<body bgcolor="#FFF8DC">
<center>
<h3>*** DONAR DETAILS ***</h3>
</center>
<!-- Display Error Message if not Retrieved -->
<c:if test="${sessionScope.error ne null}">
	<h3>${sessionScope.error}</h3>
</c:if>

<!-- Display the List of Data stored in session if data available -->

<c:if test="${sessionScope.d1 ne null}">
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>Donor ID</th>
		<th>Donor Name</th>
		<th>Phone Number</th>
		<th>Address</th>
		<th>Donated Amount</th>
		<th>Donated Date</th>
	</tr>
	<c:forEach var="d1" items="${sessionScope.d1}">
		<tr>
			<td>${d1.donorid}</td>
			<td>${d1.donorname}</td>
			<td>${d1.phonenumber}</td>
			<td>${d1.address}</td>
			<td>Rs.${d1.amount}</td>
			<td>${d1.donationdate}</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<center><br/>
<a href="index.jsp">Go Back To HomePage</a>
</center>

</body>
</html>