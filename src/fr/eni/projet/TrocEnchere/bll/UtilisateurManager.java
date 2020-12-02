package fr.eni.projet.TrocEnchere.bll;

import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurFactory;

public class UtilisateurManager {
	
	// Création variable uDao pour récupérer l'utilisateur dans la BDD
	private UtilisateurDAO uDao;

	public UtilisateurManager() {
		uDao = UtilisateurFactory.getUtilisateurDAO();
	}

}
