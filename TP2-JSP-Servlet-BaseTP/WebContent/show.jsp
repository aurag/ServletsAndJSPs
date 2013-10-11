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
		<h1>Détail de l'évènement ${event.titre}</h1>
			Titre : ${event.titre} <br /> 
			Type : ${event.type.libelle} <br /> 
			Date début : <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${event.dateDebut}" />  <br /> 
			Date fin : <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${event.dateFin}" /> <br /> 
			Description : ${event.description}
	</body>
</html>

<%@include file="includes/footer.jsp" %>