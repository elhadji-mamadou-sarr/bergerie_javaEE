package jdbc.mouton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ListeMouton;

public class Lister {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	
	public List<ListeMouton> lister(){
		List<ListeMouton> moutons = new ArrayList<ListeMouton>();
		
		acceAlabase();
		try {	
			stmt = con.createStatement();
			resultat = stmt.executeQuery("SELECT c.*, cc.* FROM moutons c INNER JOIN proprietaires cc ON c.id_proprietaire = cc.id");
			
			while (resultat.next()) {
				int id = resultat.getInt("id_mouton");
				String nom = resultat.getString("nom");
				String race = resultat.getString("race");
				String couleur = resultat.getString("couleur");
				String id_proprietaire = resultat.getString("nomComplet");
				
				ListeMouton mouton = new ListeMouton();
		
				mouton.setId(id);
				mouton.setNom(nom);
				mouton.setRace(race);
				mouton.setCouleur(couleur);
				mouton.setId_proprietaire(id_proprietaire);
				
				moutons.add(mouton);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return moutons;
	}

}
