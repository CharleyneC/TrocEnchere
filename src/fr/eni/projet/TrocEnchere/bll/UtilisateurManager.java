package fr.eni.projet.TrocEnchere.bll;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;
import fr.eni.projet.TrocEnchere.dal.DalException;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurFactory;

public class UtilisateurManager {
	
	// Création variable uDao pour récupérer l'utilisateur dans la BDD
	private UtilisateurDAO uDao;

	public UtilisateurManager() {
		uDao = UtilisateurFactory.getUtilisateurDAO();
	}
	
	public void ajouterUser(Utilisateur user) throws BllException {
		validerUser (user);
		uDao.addUtilisateur(user);
	}

	private void validerUser(Utilisateur user) throws BllException {
		if(user.getPseudo() != null &&
			user.getNom() != null &&
			user.getPrenom() != null &&
			user.getEmail() != null &&
			user.getNoTel() != null&&
			user.getRue() != null &&
			user.getCpo() != null &&
			user.getVille() != null &&
			user.getMdp() != null) {
		}else {
			BllException ex = new BllException("Les champs ne sont correctement renseignés");
			throw ex;	
		}
		
	}
	
	public Utilisateur trouverUser () throws DalException{
		 return uDao.findAllUtilisateur();
	} 

}
