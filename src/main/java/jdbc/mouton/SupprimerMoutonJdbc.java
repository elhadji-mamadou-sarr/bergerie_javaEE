package jdbc.mouton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupprimerMoutonJdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;


	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public void deleteMouton(int id) {
		acceAlabase();
		
		try {
			String deleteMouton = "DELETE FROM `moutons` WHERE id_mouton = ?";
			
			int proprietaire = 0;
			String selectMouton = "SELECT * FROM `moutons` WHERE `id_mouton` = ?";
			PreparedStatement prepStmt = con.prepareStatement(selectMouton);
			prepStmt.setInt(1, id);
			 resultat = prepStmt.executeQuery();
			 if (resultat.next()) {
				 proprietaire = resultat.getInt("id_proprietaire");
			}
			
			
			Integer nbMouton = 0;
			String select = "SELECT * FROM `proprietaires` WHERE `id` = ?";
			 PreparedStatement prepStatement = con.prepareStatement(select);
			 prepStatement.setInt(1, proprietaire);
			 resultat = prepStatement.executeQuery();
			 if (resultat.next()) {
				nbMouton = resultat.getInt("nombreMouton");
			}
			 
			 String updatenombreMouton = "UPDATE `proprietaires` SET `nombreMouton` = ? WHERE `proprietaires`.`id` = ?";		
			 
			 PreparedStatement preparedStmt = con.prepareStatement(updatenombreMouton);
			 preparedStmt.setInt(1, nbMouton - 1);
			 preparedStmt.setInt(2, proprietaire);
			 preparedStmt.executeUpdate();
			
			
			preparedStatement = con.prepareStatement(deleteMouton);
			preparedStatement.setInt(1, id);	
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


}
