<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des proprietaires</title>
</head>
<body>

	<%@ include file="../include/nav.jsp" %>
	
		<div class="container mt-5">
		
			<div class="d-flex justify-content-between p-1">
				<h2>Liste des proprietaires</h2>
				<form action="ServletAjouter" method="get">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
		
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Nom et Prenom</th>
			      <th scope="col">Telephone</th>
			      <th scope="col">Daral</th>
			      <th scope="col">Date d'ajout</th>
			      <th scope="col">Nombre de mouton</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="proprietaire" items="${proprietaires}">
				    <tr>
				      <th scope="row"><c:out value="${proprietaire.id}"/></th>
				      	<td><c:out value="${proprietaire.nomComplet}"/> </td>
						<td><c:out value="${proprietaire.telephone}"/></td>
						<td><c:out value="${proprietaire.daral}"/></td>
						<td><c:out value="${proprietaire.dateAjout}"/></td>
						<td><c:out value="${proprietaire.nombre}"/></td>
						<td class="d-flex justify-content-around">
							<a href="ServletModifier?id_prop=${proprietaire.id}" 
								class="btn btn-outline-primary btn-sm"> Modifier</a>
							<a href="ServletSupprimer?id_prop=${proprietaire.id}" 
								class="btn btn-outline-danger btn-sm">Supprimer</a>
						</td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		
		</div>


</body>
</html>