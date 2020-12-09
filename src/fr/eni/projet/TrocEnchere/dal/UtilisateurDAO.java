package fr.eni.projet.TrocEnchere.dal;

import java.sql.SQLException;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectId(String idPseudo, String mdp) throws DalException;
	void addUtilisateur(Utilisateur user);
	Utilisateur findAllUtilisateur() throws DalException;
	Utilisateur seConnecter(String pIdentifiant, String pMdp) throws SQLException, DalException;
	void updateProfil(Utilisateur utilisateur) throws SQLException;
	void deleteProfil(String p) throws SQLException;

	
		
	
	
	

}
