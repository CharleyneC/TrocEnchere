package fr.eni.projet.TrocEnchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.TrocEnchere.bo.Utilisateur;

public class UtilisateurDaoJdbcImpl implements UtilisateurDAO {

	private final String SELECT_ALL = "USE enchere_bdd SELECT * FROM utilisateurs";
	private final String SELECT_PSEUDO = "use enchere_bdd SELECT * FROM utilisateurs WHERE pseudo = ? and mot_de_passe = ?";
	private final String SELECT_EMAIL = "use enchere_bdd SELECT * FROM utilisateurs WHERE email = ? and mot_de_passe = ?";
	private final String INSERT_USER = "USE enchere_bdd INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal,ville, mot_de_passe, credit, administrateur) "
										+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	
	@Override
	public Utilisateur selectPseudo(String pseudo, String mdp) throws DalException {
		Utilisateur userPseudo = null;
		
		try (Connection connect = ConnectionProvider.getConnection();
			PreparedStatement pstt = connect.prepareStatement(SELECT_PSEUDO)){
			pstt.setString(1, pseudo);
			pstt.setString(2, mdp);
			
			ResultSet rsPseudo = pstt.executeQuery();

			if (rsPseudo.next()) {;
				String pseudoUser = rsPseudo.getString(2);
				String email = rsPseudo.getString(5);
				String mdpUser = rsPseudo.getString(10);
				
				userPseudo = new Utilisateur(pseudoUser, email, mdpUser);
			}else {
				System.out.println("Pseudo ou mot de passe non reconnu!");
			}
			pstt.close();
			rsPseudo.close();			
		}catch(Exception e) {
			throw new DalException(e.getMessage());
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
				String pseudo = rsEmail.getString(2);
				String emailUser = rsEmail.getString(5);
				String mdpUser = rsEmail.getString(10);
				
				userEmail = new Utilisateur(pseudo, emailUser, mdpUser);
			}else {
				System.out.println("Pseudo ou mot de passe non reconnu!");
			}
			pstt.close();
			rsEmail.close();			
		}catch(Exception e) {
			throw new DalException(e.getMessage());
		}
		return userEmail;
	}

	@Override
	public void addUtilisateur(Utilisateur user) {
		try (Connection connect = ConnectionProvider.getConnection()) {
			PreparedStatement pstt = connect.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
			pstt.setString(1, user.getPseudo());
			pstt.setString(2, user.getNom());
			pstt.setString(3, user.getPrenom());
			pstt.setString(4, user.getEmail());
			pstt.setString(5, user.getNoTel());
			pstt.setString(6, user.getRue());
			pstt.setString(7, user.getCpo());
			pstt.setString(8, user.getVille());
			pstt.setString(9, user.getMdp());
			pstt.setInt(10, user.getCredit());
			pstt.setByte(11, user.getAdmin());
			
			pstt.executeUpdate();
			
			ResultSet rsAdd = pstt.getGeneratedKeys();
			if(rsAdd.next()) {
				int id = rsAdd.getInt(1);
				user.setNoUser(id);
			}
			rsAdd.close();
			pstt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Utilisateur findAllUtilisateur() throws DalException {
		Utilisateur userAll = null;
		
		try (Connection connect = ConnectionProvider.getConnection();
				PreparedStatement pstt = connect.prepareStatement(SELECT_ALL)){
				
				ResultSet rs = pstt.executeQuery();

				if (rs.next()) {	
					int noUser = rs.getInt(1);
					String pseudo = rs.getString(2);
					String nom = rs.getString(3);
					String prenom = rs.getString(4);
					String emailUser = rs.getString(5);
					String noTel = rs.getString(6);
					String rue = rs.getString(7);
					String cpo = rs.getString(8);
					String ville = rs.getString(9);
					String mdpUser = rs.getString(10);
					int credit = rs.getInt(11);
					byte admin = rs.getByte(12);
					
					userAll = new Utilisateur(noUser, pseudo, nom, prenom, emailUser, noTel, rue, cpo, ville, mdpUser, credit, admin);
				}
				rs.close();	
				pstt.close();
			}catch(Exception e) {
				throw new DalException(e.getMessage());
			}
			return userAll;
	}

	@Override
	public List<Utilisateur> seConnecter(Utilisateur userCo) throws SQLException, DalException {
		
		List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
		
		try (Connection connect = ConnectionProvider.getConnection();
				PreparedStatement pstt = connect.prepareStatement(SELECT_ALL)){
				
				ResultSet rs = pstt.executeQuery();
				
				while(rs.next()) {
					int noUser = rs.getInt(1);
					String pseudo = rs.getString(2);
					String nom = rs.getString(3);
					String prenom = rs.getString(4);
					String emailUser = rs.getString(5);
					String noTel = rs.getString(6);
					String rue = rs.getString(7);
					String cpo = rs.getString(8);
					String ville = rs.getString(9);
					String mdpUser = rs.getString(10);
					int credit = rs.getInt(11);
					byte admin = rs.getByte(12);
					Utilisateur trouve = new Utilisateur(noUser, pseudo, nom, prenom, emailUser, noTel, rue, cpo, ville, mdpUser, credit, admin);
					listeUser.add(trouve);
				}
				rs.close();
	}catch(Exception e) {
		throw new DalException(e.getMessage());
	}
	return listeUser;
}
}
