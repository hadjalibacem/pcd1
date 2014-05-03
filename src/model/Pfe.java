package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pfe")
public class Pfe {
	@Id
	private int id;
	private String sujet;
	private String description;
	private int superviseur;
	private String nom_encad;
	private String email_encad;
	private String tel_encad;
	private String nom_Entrep;
	private float resultat;
	private int departement;
	public float getResultat() {
		return resultat;
	}
	public void setResultat(float resultat) {
		this.resultat = resultat;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
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
	public int getSuperviseur() {
		return superviseur;
	}
	public void setSuperviseur(int superviseur) {
		this.superviseur = superviseur;
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
	public Pfe(int id, String sujet, String description, int superviseur,
			String nom_encad, String email_encad, String tel_encad,
			String nom_Entrep, float resultat, int departement) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.superviseur = superviseur;
		this.nom_encad = nom_encad;
		this.email_encad = email_encad;
		this.tel_encad = tel_encad;
		this.nom_Entrep = nom_Entrep;
		this.resultat = resultat;
		this.departement = departement;
	}

	
	
	
}