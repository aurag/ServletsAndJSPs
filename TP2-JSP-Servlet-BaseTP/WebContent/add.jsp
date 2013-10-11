<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'un nouvel évènement</title>
</head>
	<body>
		<h1>Création d'un nouvel évènement</h1>
		<form name="registration" action="addEvent" method="Post"> 
			Titre: <input type="text" name="title"> <br /> 
			Type: 
			<select name="type">
			    <c:forEach items="${typeList}" var="type">
			        <option value="${type.id}"><c:out value="${type.libelle}" /></option>
			    </c:forEach>
			</select>
			Date début : <input type="text" name="start_date" /> 
			Date fin : <input type="text" name="end_date" /> 
			Description: <input type="text" name="description" /> 
			<input type="submit" value="Submit" /> 
		</form>
	</body>
</html>

<%@include file="includes/footer.jsp" %>