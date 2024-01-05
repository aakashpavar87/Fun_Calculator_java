<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
  font-size: 40px;
  text-align:center;
  background: linear-gradient(to right,  #2b40ff,#07121a);
}

h1,h3{
color: white;
margin:15px;
}
input, button {
  font-size:40px;
  color: white;
  border-radius: 5%;
  background-color: black;
  border: 2px solid white;
}

img{
width: 20%;
height:20%;
margin-top: 20px;
filter: drop-shadow(20px 10px 10px black);
}
img:hover{
  -ms-transform: scale(1.1); /* IE 9 */
  -webkit-transform: scale(1.1); /* Safari 3-8 */
  transform: scale(1.1); 
}
button{
	color:white;
	padding: 20px;
	border: none;
	border-radius: 5px;
	font-size: larger;
	background-color: crimson;
}
</style>
</head>
<body>
	<img style="width:50%;height:50vh;" alt="Goku GIF" src="images/goku.gif">
	<h1>Joke of the Day!</h1>
	<h3><%=request.getParameter("joke")%></h3>
	<%@include file="index.html" %>
	<h2 class="head">Result is : <%=request.getParameter("result")%></h2>
	<form action="history" method="get">
		<button type="submit">History</button>
	</form>
</body>
</html>