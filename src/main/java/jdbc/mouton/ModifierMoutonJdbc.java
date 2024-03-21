package jdbc.mouton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Mouton;

public class ModifierMoutonJdbc {
	

	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;
    PreparedStatement preparedStatement = null;




	private void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();		
	}


	public Mouton mouton_a_modifier(Integer id) {
		Mouton mouton = new Mouton();
		acceAlabase();
	    String sql = "SELECT * FROM `moutons` WHERE `id_mouton` = ?";
	   
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, id);
	        
	         resultat = preparedStatement.executeQuery();
	        if (resultat.next()) {
	        	String nom = resultat.getString("nom");
				String race = resultat.getString("race");
				String couleur = resultat.getString("couleur");
				Integer id_proprietaire = resultat.getInt("id_proprietaire");

				mouton.setId(id);
				mouton.setNom(nom);
				mouton.setRace(race);
				mouton.setCouleur(couleur);
				mouton.setId_proprietaire(id_proprietaire);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return mouton;
	}


	public void update(Mouton mouton) {
		acceAlabase();
		
		try {
			 String update = "UPDATE `moutons` SET `nom`=?,`race`=?, `couleur`=?,"
			 		+ "`id_proprietaire`=? WHERE id_mouton = ?";
			
			 preparedStatement = con.prepareStatement(update);
			 preparedStatement.setString(1, mouton.getNom());
			 preparedStatement.setString(2, mouton.getRace());
			 preparedStatement.setString(3, mouton.getCouleur());
			 preparedStatement.setInt(4, mouton.getId_proprietaire());
			 preparedStatement.setInt(5, mouton.getId());
			 
			 int proprietaire = mouton.getId_proprietaire();
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
			 preparedStmt.setInt(1, nbMouton + 1);
			 preparedStmt.setInt(2, proprietaire);
				 
			 preparedStmt.executeUpdate();
				 
			 preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
		
	}
	

}
