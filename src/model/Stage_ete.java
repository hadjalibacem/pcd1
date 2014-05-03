package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stage_ete")
public class Stage_ete {
	@Id
	private int id;
	private String sujet;
	private String description;
	private String nom_encad;
	private String email_encad;
	private String tel_encad;
	private String nom_Entrep;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom_encad() {
		return nom_encad;
	}
	public void setNom_encad(String nom_encad) {
		this.nom_encad = nom_encad;
	}
	public String getEmail_encad() {
		return email_encad;
	}
	public void setEmail_encad(String email_encad) {
		this.email_encad = email_encad;
	}
	public String getTel_encad() {
		return tel_encad;
	}
	public void setTel_encad(String tel_encad) {
		this.tel_encad = tel_encad;
	}
	public String getNom_Entrep() {
		return nom_Entrep;
	}
	public void setNom_Entrep(String nom_Entrep) {
		this.nom_Entrep = nom_Entrep;
	}
	
	public Stage_ete(int id, String sujet, String description,
			String nom_encad, String email_encad, String tel_encad,
			String nom_Entrep) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.nom_encad = nom_encad;
		this.email_encad = email_encad;
		this.tel_encad = tel_encad;
		this.nom_Entrep = nom_Entrep;
		
	}
	
	
	
}