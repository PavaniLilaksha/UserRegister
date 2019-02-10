<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<link href="stylec.css" rel="stylesheet" type="text/css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" type="text/css" href="footer.css">
</head>
<body>

	<header>
	
			<div class="row">
				<div class="logo"></div>
				
				
			
			<ul class="main-nav"><br><br>
				<li><a herf="index.jsp"> Home </a></li>
				<li><a herf=""> Room Booking </a></li>
				<li><a herf=""> Event Booking </a></li>
				<li><a herf="About us.jsp"> About Us </a></li>
				<li class="active"><a herf=""> Contact Us </a></li>		
			
			</ul>	
			
			</div>
			
			
		<div class="contact-form">
			<h1>Contact Us</h1>
		
		<div class="txtb">
			<label>Full Name</label><br>
			<input type="text" name="fname" id="num" placeholder="Enter Name"><br><br>
		</div>
		
		<div class="txtb">
			<label>Email</label><br>
			<input type="email" name="email" id="num" placeholder="Enter Email"><br><br>
		</div>
		
		<div class="txtb">
			<label>Phone Number</label><br>
			<input type="text" name="number" id="num" placeholder="Enter Phone Number"><br><br>
		</div>
		
		<div class="txtb">
			<label>Message</label><br>
			<textarea id="num" > </textarea><br><br>
		</div>
		
		<input type="submit" value="Submit" id="sub"><br><br>
		
		</div>	
			

</body>
<%@include file="footer.jsp" %>
</html>