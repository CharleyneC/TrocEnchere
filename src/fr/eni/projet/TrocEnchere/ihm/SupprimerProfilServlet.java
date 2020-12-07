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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager uM = new UtilisateurManager();
		
		String p = request.getParameter("pseudo");
		String m = request.getParameter("mdp");
		
		//On recupère la connexion
		HttpSession sessionUser = request.getSession(true);
		sessionUser.setAttribute("Utilisateur", uM);
		
		//on efface 
		try {
			if (uM.selectUser (p, m)!= null) {
				
				//La BDD retrouve à l'utilisateur  avec pseudo et mdp
				Utilisateur user = uM.deleteProfil(p, m);
				
				}
				
		} catch (Exception e) {
			e.printStackTrace();
			
	}
				//On renvoie sur la page d'accueil
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
				rd.forward(request, response);
}
	
}