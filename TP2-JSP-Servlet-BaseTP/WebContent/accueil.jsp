<%@include file="includes/header.jsp" %>

<center>
<table border="1">
	<tr>
		<td><b>Titre</b></td>
		<td><b>Date d�but</b></td>
		<td><b>Date fin</b></td>
		<td><b>[COMMANDES]</b></td>
	</tr>

<!-- TODO Parcourir les divers �v�nements trouves dans la servlet a l'aide de c:forEach-->
<c:forEach var="event" items="${eventList}" varStatus="status">
		<tr>
			<td>${event.titre}</td>
			<td>fmt:formatDate sur ${event.dateDebut}</td>
			<td>fmt:formatDate sur ${event.dateFin}</td>
			<td><a href="show/${event.id}">D�tail</a><br/><a href="edit/${event.id}">Editer</a><br/><a href="delete/${event.id}">Supprimer</a></td>
		</tr>	
</c:forEach>

</table>
<hr/>
<!-- TODO ajouter le lien pour l'ajout d'un nouvel �v�nement -->
<center><a href="add">Ajouter un nouvel �v�nement</a></center>
</center>

<%@include file="includes/footer.jsp" %>
