package jdbc.proprietaire;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Proprietaire;
import jdbc.mouton.DatabaseConnectionManager;

public class ListerProprietaire {
	

	Connection con = null;
	Statement stmt = null;
	ResultSet resultat = null;

	
	public void acceAlabase() {
		DatabaseConnectionManager dbManager = DatabaseConnectionManager.getInstance();
        con = dbManager.getConnection();
	}
	
	
	public List<Proprietaire> lister(){
		List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
		
		acceAlabase();
		try {	
			stmt = con.createStatement();
			resultat = stmt.executeQuery("SELECT * FROM `proprietaires`;");
			
			while (resultat.next()) {
				int id = resultat.getInt("id");
				String nom = resultat.getString("nomComplet");
				Long telephone = resultat.getLong("telephone");
				Date dateAjout = resultat.getDate("dateAjout");
				String daral = resultat.getString("daral");
				Integer nbMouton = resultat.getInt("nombreMouton");
				
				Proprietaire propritaire = new Proprietaire();
		
				propritaire.setId(id);
				propritaire.setNomComplet(nom);
				propritaire.setTelephone(telephone);
				propritaire.setDateAjout(dateAjout);
				propritaire.setDaral(daral);
				propritaire.setNombre(nbMouton);
				
				proprietaires.add(propritaire);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return proprietaires;
	}

}
