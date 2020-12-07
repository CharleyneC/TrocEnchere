<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projet.TrocEnchere.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">    
    <!-- Personnal CSS-->
    <link rel="stylesheet" href="css/style.css">
    <!--icons-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil utilisateur</title>

</head>
<body>
<header>
    <nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
        <a class="navbar-brand" href="index.html">
            <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
            <strong>Modifier mon profil</strong>
        </a>
        <a class="navbar-brand" href="#" alt="Gérer mon profil" title="Gérer mon profil">
            <img class="small-icon" src="images/user.svg">
            <span class="align-middle text-muted">${Utilisateur.nom} ${Utilisateur.prenom}, ${Utilisateur.credit}</span>
        </a>
    </nav>
</header>
	
<div class="form-filter">	
	
	<h1> Bonjour!</h1>
	<p><label>Pseudo : </label> 
                 <span id="pseudo">${Utilisateur.pseudo}</span><br>
                   
                 <label>Nom : </label>   
                 <span id="nom">${Utilisateur.nom}</span><br>
                 
                 <label>Prénom : </label>
                 <span id="prenom">${Utilisateur.prenom}</span><br>
                 
                 <label>E-mail : </label>
                 <span id="email">${Utilisateur.email}</span><br>
                 
                 <label>Téléphone : </label>
                 <span id="telephone">${Utilisateur.noTel}</span><br>
                  
                 <label>Rue : </label> 
                 <span id="rue">${Utilisateur.rue}</span><br>
                 
                 <label>Code Postale : </label>
                 <span id="cpo">${Utilisateur.cpo}</span><br>
                 
                 <label>Ville : </label>
                 <span id="ville">${Utilisateur.ville}</span><br></p>
                 
</div>
	                
<form class="form-bouton" method="post" action="update">
	<input type="submit" value="Modifier mon profil"/>
</form>

<form class="form-bouton" method="post" action="SeDeconnecterServlet">
	<input type="submit" value="Deconnexion"/>
</form>
	
<footer class="border-top text-center align-bottom">
            <div class="mt-3">
                <img class="small-icon" src="images/ateni.svg" alt="Eni Ecole">
                <small class="d-block text-muted">&copy; ENI Ecole 2020</small>
                <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
            </div>
 </footer>

<<<<<<< HEAD
		<a href="WEB-INF/jsp/supprimerProfil.jsp"><button> Supprimer Votre Profil </button></a>
=======
>>>>>>> branch 'master' of https://github.com/CharleyneC/TrocEnchere.git
</body>
</html>