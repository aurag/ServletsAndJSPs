<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="includes/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition d'un évènement</title>
</head>
	<body>
		<h1>Edition de l'évènement ${event.titre}</h1>
		<form name="registration" action="editEvent" method="Post"> 
			Titre: <input type="text" name="title" value="${event.titre}"> <br /> 
			Type: 
			<select name="type">
			    <c:forEach items="${typeList}" var="type">
			        <option value="${type.id}" ${type.id == event.type.id ? 'selected="selected"' : ''}><c:out value="${type.libelle}" /></option>
			    </c:forEach>
			</select>
			Date début : <input type="text" name="start_date" value="${event.dateDebut}" /> 
			Date fin : <input type="text" name="end_date" value="${event.dateFin}" /> 
			Description: <input type="text" name="description" value="${event.description}" /> 
			<input type="hidden" name="id" value="${event.id}" />
			<input type="submit" value="Submit" /> 
		</form>
	</body>
</html>