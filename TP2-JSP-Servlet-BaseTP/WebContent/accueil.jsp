<%@include file="includes/header.jsp" %>

<center>
<table border="1">
	<tr>
		<td><b>Titre</b></td>
		<td><b>Date d�but</b></td>
		<td><b>Date fin</b></td>
		<td><b>[COMMANDES]</b></td>
	</tr>

<!-- TODO Parcourir les divers �v�nements trouves dans la servlet a l'aide de c:forEach
		<tr>
			<td>${evt.titre}</td>
			<td>fmt:formatDate sur ${evt.dateDebut}</td>
			<td>fmt:formatDate sur ${evt.dateFin}</td>
			<td><a href="...">D�tail</a><br/><a href="...">Editer</a><br/><a href="...">Supprimer</a></td>
		</tr>
-->

</table>
<hr/>
<!-- TODO ajouter le lien pour l'ajout d'un nouvel �v�nement -->
<center><a href="...">Ajouter un nouvel �v�nement</a></center>
</center>

<%@include file="includes/footer.jsp" %>
