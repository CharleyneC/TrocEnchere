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
import fr.eni.projet.TrocEnchere.dal.DalException;


@WebServlet("/update")
public class ModificationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageModifierProfil.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choix = request.getParameter("choix");

		if (choix.equals("valider")) {
			request.setAttribute("Modification OK", "Votre profil vient d'être modifié");
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/acceuil.jsp").forward(request, response);

		} else {

			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
		}
		
		
		try {
			
			Utilisateur utilisateur = new Utilisateur();
			
			// Je recupère les informations en paramètres
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String noTel = request.getParameter("tel");
			String rue = request.getParameter("rue");
			String cpo = request.getParameter("cpo");
			String ville = request.getParameter("ville");
			String mdpUser = request.getParameter("mdp");
			
			HttpSession session = request.getSession();
			
			// J'ajoute les nouvelles données à la BDD
			try {
				UtilisateurManager.updateProfil(pseudo, nom, prenom, email, noTel, rue, cpo, ville, mdpUser, (int) session.getAttribute("numUtilisateur"));
			}catch (DalException e) {
				
				RequestDispatcher rd = request.getRequestDispatcher("profil.jsp");
				rd.forward(request, response);
			}
			
		}finally {
			
		}
	}
		
		
}
	
	

