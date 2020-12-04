package fr.eni.projet.TrocEnchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectId(String idUser, String mdp) throws DalException;
	void addUtilisateur(Utilisateur user);
	Utilisateur findAllUtilisateur() throws DalException;
	Utilisateur seConnecter(String pIdentifiant, String pMdp) throws SQLException, DalException;
	
	


	
}
