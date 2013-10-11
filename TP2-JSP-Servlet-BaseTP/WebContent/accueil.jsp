<%@include file="includes/header.jsp" %>

<center>
<table border="1">
	<tr>
		<td><b>Titre</b></td>
		<td><b>Type</b></td>
		<td><b>Date début</b></td>
		<td><b>Date fin</b></td>
		<td><b>[COMMANDES]</b></td>
	</tr>

<c:forEach var="event" items="${eventList}" varStatus="status">
		<tr>
			<td>${event.titre}</td>
			<td>${event.type.libelle}</td>
			<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${event.dateDebut}" /></td>
			<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${event.dateFin}" /></td>
			<td><a href="show?id=${event.id}">Détail</a><br/><a href="edit?id=${event.id}">Editer</a><br/><a href="delete/${event.id}">Supprimer</a></td>
		</tr>	
</c:forEach>

</table>
<hr/>

<center><a href="add">Ajouter un nouvel événement</a></center>
</center>

<%@include file="includes/footer.jsp" %>
