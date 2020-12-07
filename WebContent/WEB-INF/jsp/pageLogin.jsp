<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    <!-- Personnal CSS-->
    <link rel="stylesheet" href="css/style.css">

	<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/style.css">
	
    <!--icons-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <title>ENI-Encheres : Connexion</title>
</head>
<body>

<header>
	<div class="mx-auto text-center">
                <h1>Connexion</h1>
                <img class="mb-4 large-icon rounded-circle" src="images/user.svg" alt="">
            </div>
</header>
 <!--formulaire-->
        
            <form class="form-login" action="SeConnecterServlet" method="POST">
                <label for="inputIdentifiant" class="sr-only">Identifiant</label>
                <input type="text" id="inputIdentifiant" class="form-control" name="pseudo" placeholder="Pseudo" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control" name="mdp" placeholder="Mot de passe" required>
                <div class="checkbox mb-3">
                    <label>
                    <input type="checkbox" name="remember" value="remember"> Se souvenir de moi
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit" title="Me connecter">
                	<img class="small-icon" src="images/connect.svg" alt="Me connecter">
                </button>
                <a href="#">Mot de passe oublié</a>
            </form>
            
            <form class="form-login" action="CreerCompteServlet" method="get">
                <button class="btn btn-lg btn-primary btn-block" type="submit" title="Créer un compte">
                	<img class="small-icon" src="images/user.svg" alt="Créer un compte">
                </button>   

            </form>

<!--footer-->
        <footer class="border-top text-center align-bottom">
            <div class="mt-3">
                <img class="small-icon" src="images/ateni.svg" alt="Eni Ecole">
                <small class="d-block text-muted">&copy; ENI Ecole 2020</small>
                <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
            </div>
		</footer>
</body>
</html>