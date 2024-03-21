package jdbc.proprietaire;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Proprietaire;
import jdbc.mouton.DatabaseConnectionManager;

public class ModifierProprietaireJdbc {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public Proprietaire prop_a_modifier(Integer id) {
		Proprietaire propritaire = new Proprietaire();
		acceAlabase();
	    String sql = "SELECT * FROM `proprietaires` WHERE `id` = ?";
	   
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, id);
	        
	         resultat = preparedStatement.executeQuery();
	        if (resultat.next()) {
				String nom = resultat.getString("nomComplet");
				Long telephone = resultat.getLong("telephone");
				Date dateAjout = resultat.getDate("dateAjout");
				String daral = resultat.getString("daral");
				Integer nbMouton = resultat.getInt("nombreMouton");

				propritaire.setId(id);
				propritaire.setNomComplet(nom);
				propritaire.setTelephone(telephone);
				propritaire.setDateAjout(dateAjout);
				propritaire.setDaral(daral);
				propritaire.setNombre(nbMouton);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return propritaire;
	}


	public void update(Proprietaire prop) {
		acceAlabase();
		
		try {
			 String update = "UPDATE `proprietaires` SET `nomComplet`=?,`telephone`=?,"
			 		+ "`daral`=? WHERE id = ?";
			
			 preparedStatement = con.prepareStatement(update);
			 preparedStatement.setString(1, prop.getNomComplet());
			 preparedStatement.setLong(2, prop.getTelephone());
			 preparedStatement.setString(3, prop.getDaral());
			 preparedStatement.setInt(4, prop.getId());
			 preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			
		}
		
	}
	
	
	

}
