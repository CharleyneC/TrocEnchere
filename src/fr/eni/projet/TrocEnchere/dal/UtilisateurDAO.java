package fr.eni.projet.TrocEnchere.dal;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur selectPseudo(String pseudo, String mdp) throws DalException;

	Utilisateur selectEmail(String email, String mdp) throws DalException;

	
}
