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
 * Servlet implementation class SupprimerProfilServlet
 */
@WebServlet("/Supprimer")
public class SupprimerProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SupprimerProfilServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/supprimerProfil.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionUser = request.getSession(false);
			
		//on efface 
		try {
				
				Utilisateur u = (Utilisateur) sessionUser.getAttribute("Utilisateur");
					
				
				UtilisateurManager deleteUser = new UtilisateurManager();
				
				deleteUser.effacer(u.getPseudo());
				
				try {
		            if(sessionUser != null) {
		            sessionUser.removeAttribute("SeConnecterServlet");
		            sessionUser.invalidate();

		            System.out.println("Déconnection");
		            }

		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
					
		
		} catch (Exception e) {
			e.printStackTrace();
			
	}
		
		//On renvoie sur la page d'accueil
				RequestDispatcher rd = request.getRequestDispatcher("LancerApplicationServlet");
				rd.forward(request, response);
}
	
}