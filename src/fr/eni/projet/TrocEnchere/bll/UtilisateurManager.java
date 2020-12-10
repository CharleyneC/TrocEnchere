package fr.eni.projet.TrocEnchere.bll;

import java.sql.SQLException;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;
import fr.eni.projet.TrocEnchere.dal.DalException;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurFactory;

public class UtilisateurManager {
	
	// Crï¿½ation variable uDao pour rï¿½cupï¿½rer l'utilisateur dans la BDD
	private static UtilisateurDAO uDao;

	public UtilisateurManager() {
		uDao = UtilisateurFactory.getUtilisateurDAO();
	}
	
	//Aprï¿½s vï¿½rification
	//L'utilisateur peut etre ajouter ï¿½ la BDD
	public void ajouterUser(Utilisateur user) throws BllException {
		validerUser (user);
		uDao.addUtilisateur(user);
	}

	//On vï¿½rifie que les informations fournie par l'utilisateur
	//sont complï¿½te et bien celles que l'on demande
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
	
	
	public void effacer(String pseudo) throws SQLException, BllException {
        if (pseudo != null) {
         uDao.deleteProfil(pseudo);
        } 
        else { 
            throw new BllException("pas de pseudo");
        }
    }

	public void updateProfil(Utilisateur utilisateur) throws SQLException, BllException {
		validerUser (utilisateur);
		uDao.updateProfil(utilisateur);
	}

}
