package fr.eni.projet.TrocEnchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.TrocEnchere.bll.UtilisateurManager;
import fr.eni.projet.TrocEnchere.bo.Utilisateur;

/**
 * Servlet implementation class AffichageProfil
 */
@WebServlet("/AffichageProfil")
public class AffichageProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
    public AffichageProfil() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("pseudo");
		String m = request.getParameter("mdp");

		// Cr�er un nouvel UtilisateurManager pour utiliser ses fonctions non instanci�es			
		UtilisateurManager uManager = new UtilisateurManager();

		try {	
			if (uManager.selectUser(p, m) != null) {

				//La BDD retrouve � qui appartient le couple Pseudo/Mdp
				Utilisateur user = uManager.seConnecterUser(p, m);
				//ouverture de session
				HttpSession sessionUser = request.getSession(true);
				sessionUser.setAttribute("Utilisateur", user);
				request.setAttribute("Utilisateur", user);
				
				//On l'envoie sur sa page de profil
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
				rd.forward(request, response);

			}
					
		} catch (Exception e) {
			System.out.println("erreur");
			System.out.println(e.getMessage());
	        RequestDispatcher rd=request.getRequestDispatcher("SeConnecterServlet");
	        rd.include(request,response);
		}
	}

}
