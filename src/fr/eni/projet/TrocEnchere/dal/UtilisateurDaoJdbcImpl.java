package fr.eni.projet.TrocEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public class UtilisateurDaoJdbcImpl implements UtilisateurDAO {

	private final String SELECT_PSEUDO = "SELECT * FROM utlisateur WHERE pseudo = ?, mdp = ?";
	private final String SELECT_EMAIL = "SELECT * FROM utilisateur WHERE email = ?, mdp = ?";
	
	
	@Override
	public Utilisateur selectPseudo(String pseudo, String mdp) throws DalException {
		Utilisateur userPseudo = null;
		
		try (Connection connect = ConnectionProvider.getConnection();
			PreparedStatement pstt = connect.prepareStatement(SELECT_PSEUDO)){
			pstt.setString(1, pseudo);
			pstt.setString(2, mdp);
			
			ResultSet rsPseudo = pstt.executeQuery();

			if (rsPseudo.next()) {
				int noUser = rsPseudo.getInt(1);
				String pseudoUser = rsPseudo.getString(2);
				String nom = rsPseudo.getString(3);
				String prenom = rsPseudo.getString(4);
				String email = rsPseudo.getString(5);
				String noTel = rsPseudo.getString(6);
				String rue = rsPseudo.getString(7);
				String cpo = rsPseudo.getString(8);
				String ville = rsPseudo.getString(9);
				String mdpUser = rsPseudo.getString(10);
				int credit = rsPseudo.getInt(11);
				byte admin = rsPseudo.getByte(12);
				
				userPseudo = new Utilisateur(noUser, pseudoUser, nom, prenom, email, noTel, rue, cpo, ville, mdpUser, credit, admin);
			}else {
				System.out.println("Pseudo ou mot de passe non reconnu!");
			}
			rsPseudo.close();			
		}catch(Exception e) {
			throw new DalException("Utilisateur introuvable");
		}
		return userPseudo;
	}
	
	@Override
	public Utilisateur selectEmail(String email, String mdp) throws DalException {
		Utilisateur userEmail = null;
		
		try (Connection connect = ConnectionProvider.getConnection();
			PreparedStatement pstt = connect.prepareStatement(SELECT_EMAIL)){
			pstt.setString(1, email);
			pstt.setString(2, mdp);
			
			ResultSet rsEmail = pstt.executeQuery();

			if (rsEmail.next()) {
				int noUser = rsEmail.getInt(1);
				String pseudo = rsEmail.getString(2);
				String nom = rsEmail.getString(3);
				String prenom = rsEmail.getString(4);
				String emailUser = rsEmail.getString(5);
				String noTel = rsEmail.getString(6);
				String rue = rsEmail.getString(7);
				String cpo = rsEmail.getString(8);
				String ville = rsEmail.getString(9);
				String mdpUser = rsEmail.getString(10);
				int credit = rsEmail.getInt(11);
				byte admin = rsEmail.getByte(12);
				
				userEmail = new Utilisateur(noUser, pseudo, nom, prenom, emailUser, noTel, rue, cpo, ville, mdpUser, credit, admin);
			}else {
				System.out.println("Pseudo ou mot de passe non reconnu!");
			}
			rsEmail.close();			
		}catch(Exception e) {
			throw new DalException("Utilisateur introuvable");
		}
		return userEmail;
	}
}
