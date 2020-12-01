package fr.eni.projet.TrocEnchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class ConnectionProvider {
	private static DataSource dataSource;
	
	static {
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/seConnecter");
		}catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'acc�der � la base de donn�es");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
}