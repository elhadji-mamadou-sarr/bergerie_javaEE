package bean;

import javax.servlet.http.HttpServletRequest;

public class Mouton {
	
	private Integer id;
	private String nom;
	private String race;
	private String couleur;
	private Integer id_proprietaire;
	
	public Mouton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouton(HttpServletRequest request) {
		super();
		String nom = request.getParameter("nomMouton");
		String race = request.getParameter("race");
		String couleur = request.getParameter("couleur");
		int id_proprietaire = Integer.valueOf(request.getParameter("id_proprietaire"));
		
		this.nom = nom;
		this.race = race;
		this.couleur = couleur;
		this.id_proprietaire = id_proprietaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getId_proprietaire() {
		return id_proprietaire;
	}

	public void setId_proprietaire(Integer id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}
	
	
	
	

}
