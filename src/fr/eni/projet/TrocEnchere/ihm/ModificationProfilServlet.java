package fr.eni.projet.TrocEnchere.ihm;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
		
		
		
		try {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String eMail = request.getParameter("email");
		String noTel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String cpo = request.getParameter("cpo");
		String ville = request.getParameter("ville");
		
		
		
		String mdpUser = request.getParameter("mdp");
		
		Utilisateur updateUser = new Utilisateur(pseudo, nom, prenom, eMail, noTel, rue, cpo, ville, mdpUser);
		UtilisateurManager updateUM = new UtilisateurManager();
		
		//On ajoute les modifications à la BDD
		updateUM.updateProfil(updateUser);
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("SeConnecterServlet");
		rd.forward(request, response);
		
	}
	
	
	
}
