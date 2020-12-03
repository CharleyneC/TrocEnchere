<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.projet.TrocEnchere.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil utilisateur</title>

</head>
<body>

<h1> Bonjour ${Utilisateur.nom} ${Utilisateur.prenom} !</h1>
<p> ${Utilisateur.credit} </p>


</body>
</html>