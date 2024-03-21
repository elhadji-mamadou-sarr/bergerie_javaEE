package jdbc.proprietaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Proprietaire;
import jdbc.mouton.*;

public class AjoutProprietaireJdbc {
	
	Connection con = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;
	
	
	public void inserer(Proprietaire prop) {

		acceAlabase();
		try {
			 String sql = "INSERT INTO `proprietaires`(`nomComplet`, `telephone`, `dateAjout`, `daral`, `nombreMouton`)"
			 		+ " VALUES(?, ?, ?, ?, ?)";
			 preparedStatement = con.prepareStatement(sql);
			 
			 preparedStatement.setString(1, prop.getNomComplet());
			 preparedStatement.setLong(2, prop.getTelephone());
			 preparedStatement.setDate(3, prop.getDateAjout());
			 preparedStatement.setString(4, prop.getDaral());
			 preparedStatement.setInt(5, prop.getNombre());
			 
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
