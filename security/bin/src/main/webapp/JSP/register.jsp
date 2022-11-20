<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/api/add" method="post">
   <label for="fname">Username:</label><br>
  <input type="text" id="fname" name="username" value="John"><br>
  <label for="fname">Role:</label><br>
  <input type="text" id="fname" name="roles" value="ROLE_USER"><br>
  <label for="lname">Password:</label><br>
  <input type="text" id="lname" name="password" value="Doe"><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>