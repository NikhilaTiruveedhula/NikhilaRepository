<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Donor Application::</title>
<link rel="stylesheet" type="text/css" href="addDonor.css"></link>
</head>
<body>
<center>
<h2>Welcome to Donor Application</h2>
<br/><br/>
<!--This code below displays the form to add a Donation to the database	-->
<h3>Please Enter the Donation Details</h3>
<form action="addDonorServlet" method="post">
<table class="tab">

<tr>
<td>Donor Name:<span style="color:red;">*</span></td>
<td><input type="text" name="donorName" title="min 1 and max 20 alphabets" placeholder="Enter name in alphabets only" pattern="[A-Za-z]{1,20}"required/></td>
<td style="color: red;"></td>
</tr>

<tr>
<td>Donor Phone Number:<span style="color:red;">*</span></td>
<td><input type="text" name="phoneNumber" title="eneter 10 digits number"  placeholder="Enter numerals only" pattern="[0-9]{10}"required/></td>
<td style="color: red;"></td>
</tr>

<tr>
<td>Donor Address:<span style="color:red;">*</span></td>
<td><textarea name="address" rows="4" cols="15" placeholder="Enter address" required></textarea></td> 
<td style="color: red;"></td>
</tr>

<tr>
<td>Donation Amount:<span style="color:red;">*</span></td>
<td><input type="text" name="amount" title="enter only digits" placeholder="Enter amount" pattern="[0-9]{1,10}"required /></td>
<td style="color: red;"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Donate Now"></input></td>
</tr>
</table><br/>
<a href="index.jsp">Go Back To HomePage</a>
</form>
</center>
</body>
</html>