<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
input[type="radio"] {
    height: 1.2rem;
    width: 1.2rem;
    margin-right: 0.5rem;
    accent-color: var(--checked-color);
}

input[type="submit"] {
	background-color: #04AA6D!important;
    border-radius: 5px;
    font-size: 17px;
    font-color: white;
    font-family: 'Source Sans Pro', sans-serif;
    padding: 6px 18px;
}
body {
 background-color: #90EE90;  
}
</style>
<title>Vote Page</title>
</head>
<body>
<div align="right">
<a href="loginPage">Log out</a><br></div>
<img src="https://media.istockphoto.com/id/947111452/vector/vote-with-swooshed-design-of-american-usa-flag-icon-illustration.jpg?s=612x612&w=0&k=20&c=xkc0n_OShd8UIsQrYijSlWZLPV_PkhYubn84nwsytEk=" style="width:80px;height:80px;">
<form action="voteOpeariton" method="post">
<div align="center">

<h1><b>Voting Page</b></h1>
<input type="radio" id="can1" name="group" value="can1"> Candidate 1 <br>
<br>
<input type="radio" id="can2" name="group" value="can2"> Candidate 2 <br>
<br>
<input type="radio" id="can3" name="group" value="can3"> Candidate 3 <br>
<br>
<input type="radio" id="can4" name="group" value="can4"> Candidate 4 <br>
<br>
<input type="submit" value="Vote" name="vote"/><br>
<br>
<br>
<div class="resultofvote">
<h2><b>${res}</b></h2><br></div>
<br>
</div>
</form>
<script>
$(document).ready(function() {
	var delay = 5000;
	$(".resultofvote").show();
	setTimeout(function () {
	   $(".resultofvote").hide();
	    
	}, delay);
	});

</script>
</body>
</html>