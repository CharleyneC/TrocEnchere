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
                    <strong>Supprimer mon profil</strong>
                </a>
                <a class="navbar-brand" href="#" alt="Supprimer mon profil" title="Supprimer mon profil">
                    <img class="small-icon" src="images/user.svg">
                    <span class="align-middle text-muted">XXXXX xxx, 0 crédit(s)</span>
                </a>
            </nav>
        </header>


<p> Etes-vous sûr de vouloir supprimer votre profil ?</p>

<form action="supprimerProfil" action="delete" method="get">
<button type="submit"> OUI</button>
</form>


<a href="WEB-INF/jsp/profil.jsp"><button> NON </button></a>


</body>
</html>