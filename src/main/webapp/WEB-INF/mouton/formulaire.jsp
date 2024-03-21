<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mouton</title>
</head>
<body>

	<%@ include file="../include/nav.jsp" %>
	
		<div class="container mt-5">
		
			<div class="d-flex justify-content-between p-1">
				<h2>${empty mouton.id ? 'Ajouter un nouveau mouton' : 'Modifier un mouton'}</h2>
			</div>
		
			<form action="${empty mouton.id ? 'ServletAjouterMouton': 'ServletModifierMouton'}" method="post" class="row g-3">
			
				
				<div class="col-md-8">
				  <label for="floatingInput" class="form-label">Nom du mouton</label>
				  <input type="text" class="form-control" id="floatingInput" name="nomMouton" value="${mouton.nom}" required min="4">
				</div>
				
				<div class="col-md-8">
				  <label for="floatingInput" class="form-label">Race</label>
				  <input type="text" class="form-control" id="floatingInput" name="race" value="${mouton.race }" required min="4">
				</div>
				
				<div class="col-md-8">
				  <label for="couleur" class="form-label">Couleur</label>
				  <input type="text" class="form-control" id="couleur" name="couleur" value="${mouton.couleur}" required min="4">
				</div>
				
				<div class="col-md-8">
				<select class="form-select" name="id_proprietaire" aria-label="Default select example">
					<option selected>Selection un proprietaire</option>
					<c:forEach var="proprietaire" items="${proprietaires}">
						  <option value="${proprietaire.id}">${proprietaire.nomComplet}</option>
					 </c:forEach>
				</select>
				</div>
				
				<input type="hidden" name="id_mouton" value="${mouton.id}">
				<div class="col-md-8 mt-4">
					<input type="submit" class="btn btn-primary text-bold " value="${empty mouton.id ? 'Enregistrer': 'Modifier'}"/>
				</div>
				
			</form>
		</div>


</body>
</html>