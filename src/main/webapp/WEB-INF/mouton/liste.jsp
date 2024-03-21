<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des moutons</title>
</head>
<body>

	<%@ include file="../include/nav.jsp" %>
	
		<div class="container mt-5">
		
			<div class="d-flex justify-content-between p-1">
				<h2>Liste des Moutons</h2>
				<form action="ServletAjouterMouton" method="get">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
		
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Nom du mouton</th>
			      <th scope="col">Race</th>
			      <th scope="col">Couleur</th>
			      <th scope="col">Proprietaire</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="mouton" items="${moutons}">
				    <tr>
				      <th scope="row"><c:out value="${mouton.id}"/></th>
				      	<td><c:out value="${mouton.nom}"/> </td>
						<td><c:out value="${mouton.race}"/></td>
						<td><c:out value="${mouton.couleur}"/></td>
						<td><c:out value="${mouton.id_proprietaire}"/></td>
						<td class="d-flex justify-content-around">
							<a href="ServletModifierMouton?id_mouton=${mouton.id}" 
								class="btn btn-outline-primary btn-sm"> Modifier</a>
							<a href="ServletSupprimerMouton?id_mouton=${mouton.id}" 
								class="btn btn-outline-danger btn-sm">Supprimer</a>
						</td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		
		</div>


</body>
</html>