<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Donated::</title>
</head>
<body bgcolor="#CCD1D1">
<center><br/>
<h3>Congrats!Donation Made Successfully.</h3><br/><br/>
<!-- Dispaly the Data stored in session -->
<table width="500" align="center">
	<tr>
		<td>Donor ID:</td>
		<td>${sessionScope.d.donorid}</td>
	</tr>
	<tr>
		<td>Donor Name:</td>
		<td>${sessionScope.d.donorname}</td>
	</tr>
	<tr>
		<td>Phone Number:</td>
		<td>${sessionScope.d.phonenumber}</td>
	</tr>
	<tr>
		<td>Address:</td>
		<td>${sessionScope.d.address}</td>
	</tr>
	<tr>
		<td>Donated Amount:</td>
		<td>Rs.${sessionScope.d.amount}</td>
	</tr>
	<tr>
		<td>Donated Date:</td>
		<td>${sessionScope.d.donationdate}</td>
	</tr>
</table>
<br/>
<br/><br/><br/><a href="index.jsp">Go Back To HomePage</a> 
</center>
</body>
</html>