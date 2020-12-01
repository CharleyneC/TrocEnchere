package fr.eni.projet.TrocEnchere.dal;

public class UtilisateurFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDaoJdbcImpl();
	}
	
}
