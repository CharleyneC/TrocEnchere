package fr.eni.projet.TrocEnchere.ihm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.TrocEnchere.bll.UtilisateurManager;
import fr.eni.projet.TrocEnchere.bo.Utilisateur;
import fr.eni.projet.TrocEnchere.dal.DalException;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDaoJdbcImpl;

/**
 * Servlet implementation class SeConnecterServlet
 */
@WebServlet("/SeConnecterServlet")
public class SeConnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeConnecterServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String p = request.getParameter("pseudo");
	    String em = request.getParameter("email");
		String m = request.getParameter("mdp");

		// Créer un nouvel UtilisateurManager pour utiliser ses fonctions non instanciées			
		UtilisateurManager uManager = new UtilisateurManager();

			HttpSession sessionUser = request.getSession();
			sessionUser.setAttribute("Utilisateur", uManager);

	
		try {	
			if (uManager.selectUser(p, m) != null) {

				Utilisateur user = uManager.seConnecterUser(p, m);
				request.setAttribute("Utilisateur", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
				rd.forward(request, response);

			}
					
		} catch (Exception e) {
			System.out.println("erreur");
			System.out.println(e.getMessage());
	        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/pageLogin.jsp");
	        rd.include(request,response);
		}
		
	}
	
}









