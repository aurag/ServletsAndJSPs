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
<% String error= (String) request.getAttribute("error"); %>
<% if(error != null) { %>
    	<div class="alert alert-error">
    		${error}
    	</div>
<% } %>
		<form name="registration" action="addEvent" method="Post"> 
			Titre: <input type="text" name="title"> <br /> 
			Type: 
			<select name="type">
			    <c:forEach items="${typeList}" var="type">
			        <option value="${type.id}"><c:out value="${type.libelle}" /></option>
			    </c:forEach>
			</select><br/>
			Date début : <script type="text/javascript">
$(function() {
    $("#debut").datepicker({
    	language: "fr"
    });
});
</script>


<input type="text" name="start_date" id="debut" class="date_input" value="" style="width:90px;" />
<input type="text" name="start_date_hour" style="width:40px;" /> h 
<input type="text" name="start_date_min" style="width:40px;"/> <br/>
			Date fin : <script type="text/javascript">
$(function() {
    $("#fin").datepicker({
    	language: "fr"
    });
});
</script>


<input type="text" name="end_date" id="fin" class="date_input" value=""  style="width:90px;"/>
<input type="text" name="end_date_hour"  style="width:40px;" /> h 
<input type="text" name="end_date_min" style="width:40px;"/><br/> 
			Description: <input type="text" name="description" /><br/> 
			<input type="submit" value="Submit" /> 
		</form>
	</body>
</html>