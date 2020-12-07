package fr.eni.projet.TrocEnchere.bll;

import java.sql.SQLException;

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
	
	//Après vérification
	//L'utilisateur peut etre ajouter à la BDD
	public void ajouterUser(Utilisateur user) throws BllException {
		validerUser (user);
		uDao.addUtilisateur(user);
	}

	//On vérifie que les informations fournie par l'utilisateur
	//sont complète et bien celles que l'on demande
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
			BllException ex = new BllException("Les champs ne sont pas correctement renseignés");
			throw ex;	
		}
		
	}
	
	public Utilisateur selectUser(String idPseudo, String mdp) throws DalException {
		return uDao.selectId(idPseudo, mdp);
	}
	
	public Utilisateur trouverUser () throws DalException{		
		 return uDao.findAllUtilisateur();
	} 

	public Utilisateur seConnecterUser(String userCo, String userMdp) throws SQLException, DalException {
		return uDao.seConnecter(userCo, userMdp);
	}
	
	public Utilisateur updateProfil(Utilisateur userUpdate) throws SQLException {
		return uDao.updateProfil(userUpdate);
		
	}

}
