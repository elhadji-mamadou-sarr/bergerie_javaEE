package jdbc.mouton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Mouton;

public class AjoutMoutonJdbc {

	Connection con = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;
	
	
	public void inserer(Mouton mouton) {

		acceAlabase();
		try {
			 String sql = "INSERT INTO `moutons`( `nom`, `race`, `couleur`, `id_proprietaire`)"
			 		+ " VALUES(?, ?, ?, ?)";
			 preparedStatement = con.prepareStatement(sql);
			 
			 preparedStatement.setString(1, mouton.getNom());
			 preparedStatement.setString(2, mouton.getRace());
			 preparedStatement.setString(3, mouton.getCouleur());
			 preparedStatement.setInt(4, mouton.getId_proprietaire());
			 
			 int proprietaire = mouton.getId_proprietaire();
			 Integer nbMouton = 0;
			 
			 String select = "SELECT * FROM `proprietaires` WHERE `id` = ?";
			 PreparedStatement prepStatement = con.prepareStatement(select);
			 prepStatement.setInt(1, proprietaire);
			 resultat = prepStatement.executeQuery();
			 if (resultat.next()) {
				nbMouton = resultat.getInt("nombreMouton");
			}
			 
			 String update = "UPDATE `proprietaires` SET `nombreMouton` = ? WHERE `proprietaires`.`id` = ?";		
			 
			 PreparedStatement preparedStmt = con.prepareStatement(update);
			 preparedStmt.setInt(1, nbMouton + 1);
			 preparedStmt.setInt(2, proprietaire);
				 
			 preparedStmt.executeUpdate();
				 
			 preparedStatement.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		
	}




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}

	
}
