package fr.eni.projet.TrocEnchere.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;
import fr.eni.projet.TrocEnchere.dal.DalException;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurFactory;

public class UtilisateurManager {
	
	// Cr�ation variable uDao pour r�cup�rer l'utilisateur dans la BDD
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
			BllException ex = new BllException("Les champs ne sont pas correctement renseign�s");
			throw ex;	
		}
		
	}
	
	public Utilisateur trouverUser () throws DalException{		
		 return uDao.findAllUtilisateur();
	} 

	public List<Utilisateur> seConnecterUser(Utilisateur userCo) throws SQLException, DalException {
		return uDao.seConnecter(userCo);
	}

}
