<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link href="stylerr.css" rel="stylesheet" type="text/css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" type="text/css" href="footer.css">
 <script src="validation.js"></script>
</head>
<body><br>
	<header>
	
			<div class="row">
				<div class="logo"></div>
					
				
				
			<ul class="main-nav"><br>
				<li><a herf="index.jsp"> Home </a></li>
				<li><a herf=""> Room Booking </a></li>
				<li><a herf=""> Event Booking </a></li>
				<li><a herf="About us.jsp"> About Us </a></li>
				<li><a herf="contactus.jsp"> Contact Us </a></li>		
			
			</ul>
			
			</div>

			<div class="register">
				<h2>Register Here</h2>
			<form method="post" name="register" onsubmit="validate()" action="register">
				
				
				<label> First Name</label><br>
				<input type="text" name="fname" id="name" placeholder="Enter First Name"><br><br>
				
				<label> Last Name</label><br>
				<input type="text" name="lname" id="name" placeholder="Enter Lirst Name"><br><br>
				
				<label> Mobile Number</label><br>
				<select id="ph">
					<option>+91</option>
					<option>+92</option>
					<option>+93</option>
					<option>+94</option>
					<option>+95</option>
				</select>
				<input type="number" name="MNum" id="num" placeholder="Enter Mobile Number"><br><br>
				
				<label> Email</label><br>
				<input type="email" name="email" id="name" placeholder="Enter Email"><br><br>
				
				<label> Password</label><br>
				<input type="password" name="pass" id="name" placeholder="Enter Password"><br><br>
				
				<label> Confirm Password</label><br>
				<input type="password" name="pass2" id="name" placeholder="Re-Enter Password"><br><br>
				
				<input type="radio" name="gender" id="male">
				<span id="male"> &nbsp; Male</span>&nbsp;&nbsp;
				<input type="radio" name="gender" id="male">
				<span id="fmale"> &nbsp; Female</span>&nbsp;&nbsp;<br><br>
			
				<input type="submit" value="Submit" id="sub"><br><br>	
			
			</form>
			</div>
			
	
</body>
<%@include file="footer.jsp" %>
</html>