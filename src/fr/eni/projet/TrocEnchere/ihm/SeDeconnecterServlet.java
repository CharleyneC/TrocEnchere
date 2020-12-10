package fr.eni.projet.TrocEnchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SeDeconnecterServlet")
public class SeDeconnecterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SeDeconnecterServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On recupère la connexion
		HttpSession sessionUser = request.getSession(false);
		
		//On fait une deconnexion
		try {
			if(sessionUser != null) {
			sessionUser.removeAttribute("SeConnecterServlet");
			sessionUser.invalidate();
			
			System.out.println("Déconnection");
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//On renvoie sur la page accueil
		RequestDispatcher rd = request.getRequestDispatcher("LancerApplicationServlet");
		rd.forward(request, response);
	}

}
