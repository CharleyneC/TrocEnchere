<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="fr.eni.projet.TrocEnchere.bo.Utilisateur" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- Personnal CSS-->
    <link rel="stylesheet" href="css/style.css">

    <!--icons-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--emptyHeader-->
        <header>
            <nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
                <!-- Brand/logo -->
                <a class="navbar-brand" href="index.html">
                    <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
                    <strong>Modifier mon profil</strong>
                </a>
                <a class="navbar-brand" href="#" alt="Gérer mon profil" title="Gérer mon profil">
                    <img class="small-icon" src="images/user.svg">
                    <span class="align-middle text-muted"><%-- ${Utilisateur.nom} ${Utilisateur.pseudo}, ${Utilisateur.credit} --%></span>
                </a>
            </nav>
        </header>

	<form action="update" method="post">
	
		<label>Pseudo</label>
		<input type="text" name="pseudo" required="required"/><br>
		
 		<label>Prénom:</label>
		<input type="text"  name="prenom" required="required"/><br>
		
		<label>Nom: </label>		
		<input type="text" name="nom" required="required"/><br>
		
		<label> Email:</label>		
		<input type="email"  name="email" required="required"/><br>
		
		<label>Téléphone:</label>		
		<input type="text"  name="telephone" required="required"/><br>
		
		<label>Rue: </label>		
		<input type="text"  name="rue" required="required"/><br>
		
		<label>Code Postal: </label>
		<input type="text"  name="cdp" required="required"/><br>
		
		<label>Ville: </label>
		<input type="text"  name="ville" required="required"/><br>
		
		<label>Modifier mon mot de passe: </label>
		<input type="password"  name="mdp" required="required" maxlength="30"/><br>
		
		
		<label>Crédit:</label></br>
		
		
		<button type="submit" value="valider" name="newUtilisateur"> Enregistrer</button>
		
	</form>
	
		
	<footer class="border-top text-center align-bottom">
	            <div class="mt-3">
	                <img class="small-icon" src="images/ateni.svg" alt="Eni Ecole">
	                <small class="d-block text-muted">&copy; ENI Ecole 2020</small>
	                <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
	            </div>
	 </footer>
		
</body>
</html>