<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookAdvisor-Admin</title>
</head>
<body>
	<h2>Admin</h2>
	<p>
		<b>Numero de usuarios: </b>${fn:length(usuarios)}</p>

	<h2>Usuarios</h2>
	<table border="1">
		<c:forEach items="${usuarios}" var="usuarioi">
			<tr>
				<td>${usuarioi.nombre}</td>
				<td>${usuarioi.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>Registrar un nuevo usuario</h2>
	<%@ include file="FormCreaUsuario.jsp"%>

	<h2>Salir de la aplicación</h2>
	<%@ include file="FormLogout.jsp"%>
</body>
</html>