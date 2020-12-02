<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Mon profil</h1>
	
	<form class="update-Profil" action="update" method="get">
		<label for="pseudo">Pseudo</label>
		<input type="text" id="pseudo" name="pseudo" <%-- placeholder=<% UtilisateurDaoJdbcImpl.getUuser; %> --%>/><br>
 		<label for="prenom">Prénom</label>
		<input type="text" id="prenom" name="prenom"/><br>
		<label for="nom">Nom</label>
		<input type="text" id="nom" name="nom"/><br>
		<label for="mailto"> Email</label>
		<input type="text" id="mailto" name="Email"/><br>
		<label for="numero">Téléphone</label>
		<input type="text" id="numero" name="numero"/><br>
		<label for="rue">Rue</label>
		<input type="text" id="rue" name="rue"/><br>
		<label for="cdp">Code Postal</label>
		<input type="text" id="cdp" name="cdp"/><br>
		<label for="ville">Ville</label>
		<input type="text" id="ville" name="ville"/><br>
		<label for="password">Mot de passe actuel:</label>
		<input type="text" id="password" name="mdp"/><br>
		<label for="newPassword">Nouveau Mot de passe</label>
		<input type="text" id="newPassword" name="newMdp"/><br>
		<label for="confirmationMdp">Confirmation</label>
		<input type="text" id="confirmationMdp" name="confirmationMdp"/><br>
	
	<button type="submit"> Enregistrer</button>
	<button> Supprimer mon compte</button>
	
	</form>

	
</body>
</html>