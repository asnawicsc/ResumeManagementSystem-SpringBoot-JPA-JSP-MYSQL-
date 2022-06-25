<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	Error reason: ${model.error }
	<br>
	<a href="/index"><button type="button"
			class="btn btn-outline-danger">Back</button></a>
</body>
</html>