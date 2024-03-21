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
				<h2>${empty proprietaire.id ? 'Ajouter un nouveau proprietaire' : 'Modifier un proprietairet'}</h2>
			</div>
		
			<form action="${empty proprietaire.id ? 'ServletAjouter': 'ServletModifier'}" method="post" class="row g-3">
			
				
				<div class="col-md-8">
				  <label for="floatingInput" class="form-label">Nom complet</label>
				  <input type="text" class="form-control" id="floatingInput" name="nomComplet" value="${proprietaire.nomComplet}" required min="4">
				</div>
				
				<div class="col-md-8">
				  <label for="floatingInput" class="form-label">Numero de telephone</label>
				  <input type="number" class="form-control" id="floatingInput" name="telephone" value="${proprietaire.telephone }" required min="4">
				</div>
				
				<div class="col-md-8">
				  <label for="daral" class="form-label">Daral</label>
				  <input type="text" class="form-control" id="daral" name="daral" value="${proprietaire.daral}" required min="4">
				</div>
				<input type="hidden" name="id_prop" value="${proprietaire.id}">
				<div class="col-md-8 mt-4">
					<input type="submit" class="btn btn-primary text-bold " value="${empty proprietaire.id ? 'Enregistrer': 'Modifier'}"/>
				</div>
				
			</form>
		</div>


</body>
</html>