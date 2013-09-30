<%@include file="includes/header.jsp" %>

<center>
<table border="1">
	<tr>
		<td><b>Titre</b></td>
		<td><b>Date début</b></td>
		<td><b>Date fin</b></td>
		<td><b>[COMMANDES]</b></td>
	</tr>

<!-- TODO Parcourir les divers événements trouves dans la servlet a l'aide de c:forEach
		<tr>
			<td>${evt.titre}</td>
			<td>fmt:formatDate sur ${evt.dateDebut}</td>
			<td>fmt:formatDate sur ${evt.dateFin}</td>
			<td><a href="...">Détail</a><br/><a href="...">Editer</a><br/><a href="...">Supprimer</a></td>
		</tr>
-->

</table>
<hr/>
<!-- TODO ajouter le lien pour l'ajout d'un nouvel événement -->
<center><a href="...">Ajouter un nouvel événement</a></center>
</center>

<%@include file="includes/footer.jsp" %>
