package bean;

public class ListeMouton {
	
	private Integer id;
	private String nom;
	private String race;
	private String couleur;
	private String id_proprietaire;
	
	
	public ListeMouton(Integer id, String nom, String race, String couleur, String id_proprietaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.race = race;
		this.couleur = couleur;
		this.id_proprietaire = id_proprietaire;
	}


	public ListeMouton() {
		super();
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


	public String getId_proprietaire() {
		return id_proprietaire;
	}


	public void setId_proprietaire(String id_proprietaire) {
		this.id_proprietaire = id_proprietaire;
	}
	
	
	
	
	

}
