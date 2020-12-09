package fr.eni.projet.TrocEnchere.dal;

import java.sql.SQLException;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectId(String idPseudo, String mdp) throws DalException;
	void addUtilisateur(Utilisateur user);
	Utilisateur findAllUtilisateur() throws DalException;
	Utilisateur seConnecter(String pIdentifiant, String pMdp) throws SQLException, DalException;
	void deleteProfil(String p) throws SQLException;
//	Utilisateur updateProfil(Utilisateur userUpdate) throws SQLException;
	
	int updateProfil(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cp,
			String ville, String mdp, int numUtilisateur) throws DalException;

		
	
	
	

}
