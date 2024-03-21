package bean;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class Proprietaire {
	
	private Integer id;
	private String nomComplet;
	private Long telephone;
	private Date dateAjout;
	private String daral;
	private Integer nombre;
		
	public Proprietaire(HttpServletRequest request) {
		super();
		String nomComplet = request.getParameter("nomComplet");
		String param_telephone = request.getParameter("telephone");
		String daral = request.getParameter("daral");
		Long telephonne =(long) 0;
	    
		telephonne = Long.parseLong(param_telephone);
	   
		this.nomComplet =nomComplet;
		this.telephone =telephonne;
		this.daral = daral;
		this.nombre =0;
		this.dateAjout = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}

	public Proprietaire() {
		super();
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	
	public String getDaral() {
		return daral;
	}
	
	public void setDaral(String daral) {
		this.daral = daral;
	}
	
	public Integer getNombre() {
		return nombre;
	}
	
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
