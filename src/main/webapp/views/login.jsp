<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

input[type=text] {
	width: 50%;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

input[type=password] {
	width: 50%;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

.button {
  display: inline-block;
  border-radius: 3px;
  background-color: green;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 16px;
  padding: 15px 32px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 4px 2px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.header{
  font-size: 60px;
  font-weight: 600;
  background-image: linear-gradient(to left, #553c9a, #b393d3);
  color: transparent;
  background-clip: text;
  -webkit-background-clip: text;
}

.mark{
color: violet;
}
</style>
<title>Voting App</title>
</head>
<body>
<marquee class="mark">Vote is our fundamental right, Vote for the right candidate.</marquee>
<div align="center">
<form action="loginUser" method="post">
<h1 class="header"><b>Login Page</b></h1>

<input type="text" name="username" placeholder="username"/><br>
<br>
<input type="password" name="password" placeholder="password"/><br>
<br>
<button type="submit" name="vote" class="button" id="log"><span>Login</span></button>

<button type="submit" name="register" formaction="registrationPage" class="button"><span>Register</span></button>

</form>
<div align="center" class="resu"><h1><b>${result}</b></h1></div>
</div>


<script>

$(document).ready(function() {
	var delay = 5000;
	$(".resu").show();
	setTimeout(function () {
	   $(".resu").hide();
	    
	}, delay);
	});

</script>
</body>
</html>