package jdbc.proprietaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.mouton.DatabaseConnectionManager;


public class SupprimerProprietaireJdbc {
	

	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;


	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public void supprimerProp(int id) {
		acceAlabase();
		
		try {
			String sql = "DELETE FROM `proprietaires` WHERE id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
