package fr.eni.projet.TrocEnchere.ihm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.TrocEnchere.bll.BllException;
import fr.eni.projet.TrocEnchere.bll.UtilisateurManager;
import fr.eni.projet.TrocEnchere.bo.Utilisateur;


@WebServlet("/update")
public class ModificationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageModifierProfil.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		// Je recupère les informations en paramètres
		try {
			
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String cpo = request.getParameter("code_postal");
			String ville = request.getParameter("ville");
			String mdp = request.getParameter("mot_de_passe");
			
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cpo, ville, mdp);
			utilisateur = (Utilisateur) session.getAttribute("Utilisateur");
			
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			utilisateurManager.updateProfil(utilisateur);
			
			
		} catch ( SQLException | BllException e) {
			e.printStackTrace();
		}
			
		RequestDispatcher rd = request.getRequestDispatcher("LancerApplicationServlet");
		rd.forward(request, response);
		
//		request.setAttribute("Modification OK", "Votre profil vient d'être modifié");
		
		System.out.println("Votre profil est bien modifié");
			
		}
	}
	
	

