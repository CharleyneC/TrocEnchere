package fr.eni.projet.TrocEnchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectPseudo(String pseudo, String mdp) throws DalException;
	Utilisateur selectEmail(String email, String mdp) throws DalException;
	void addUtilisateur(Utilisateur user);
	Utilisateur findAllUtilisateur() throws DalException;
	Utilisateur seConnecter(String pIdentifiant) throws SQLException, DalException;


	
}
