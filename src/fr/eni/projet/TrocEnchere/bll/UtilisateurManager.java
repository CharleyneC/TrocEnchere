package fr.eni.projet.TrocEnchere.bll;

import java.sql.SQLException;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;
import fr.eni.projet.TrocEnchere.dal.DalException;
import fr.eni.projet.TrocEnchere.dal.UtilisateurDAO;
import fr.eni.projet.TrocEnchere.dal.UtilisateurFactory;

public class UtilisateurManager {
	
	// Cr�ation variable uDao pour r�cup�rer l'utilisateur dans la BDD
	private static UtilisateurDAO uDao;

	public UtilisateurManager() {
		uDao = UtilisateurFactory.getUtilisateurDAO();
	}
	
	//Apr�s v�rification
	//L'utilisateur peut etre ajouter � la BDD
	public void ajouterUser(Utilisateur user) throws BllException {
		validerUser (user);
		uDao.addUtilisateur(user);
	}

	//On v�rifie que les informations fournie par l'utilisateur
	//sont compl�te et bien celles que l'on demande
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

	public static int updateProfil(String pseudo, String nom,String prenom,String email,String telephone,String rue,String cp,String ville,String mdp, int numUtilisateur) throws DalException {
		return uDao.updateProfil(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp, numUtilisateur);
	}

}
