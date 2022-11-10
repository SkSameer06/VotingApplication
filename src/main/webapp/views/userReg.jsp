<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
.header{
  font-size: 40px;
  font-weight: 600;
  background-image: linear-gradient(to left, #553c9a, #b393d3);
  color: black;
  background-clip: text;
  -webkit-background-clip: text;
}

input[type=text] {
	width: 50%;
	box-sizing: border-box;
	border: 2px solid violet;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
   transition-duration: 0.4s;
  cursor: pointer;
}



.button4 {
 background-color: white; 
  color: black; 
  border-radius: 12px;
  border: 2px solid #4CAF50;
}

.button4:hover {
  background-color: #4CAF50;
  color: white;
}

body {
 background-color: #b0d4de;  
}
</style>
<title>Voting Application</title>
</head>
<body>
<div align="center" class="divv">
<h1 class="header">Registration Page</h1>
	<form action="registerUser" method="post" id="myform" name="myform">

<input type="hidden" name="id" id="id" />
<input type="text" name="username" placeholder="username"/><br>
<br>
<input type="text" name="password" placeholder="password"/><br>
<br>
<input type="text" name="email" placeholder="email" id="email" onchange="return fx();"/><br>
<br>
<input type="text" name="pnum" placeholder="phone number" pattern="[0-9]{3}[0-9]{3}[0-9]{4}"/><br>
<br>
<input type="hidden" name="status" id="status" value="null"/><br>
<br>
<button type="submit" name="register" value="Register" class="button button4" id="reg">Register</button>

<button type="submit" name="login" value="Login" formaction="loginPage" class="button button4">Login</button>




	</form>

</div>
<div align="center" class="prac"><h1><b>${result}</b></h1></div>

<script>

	$(document).ready(function() {
		var delay = 5000;
		$(".prac").show();
		setTimeout(function () {
		   $(".prac").hide();
		    
		}, delay);
		});
		
		
		function fx() {
			var em = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			var e = document.getElementById("email").value;
			if (e.match(em)) {
				return true;
			} else {
				alert("Invalid email");
				document.myform.email.focus();
				return false;
			}

		}
	</script>
</body>
</html>