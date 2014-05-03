package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcd")
public class Pcd {
	@Id
	private int id;
	private String sujet;
	private String description_PCD;
	private int encadrant;
	private int departement;
	private Boolean affecte;
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
	public String getDescription_PCD() {
		return description_PCD;
	}
	public void setDescription_PCD(String description_PCD) {
		this.description_PCD = description_PCD;
	}
	public int getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(int encadrant) {
		this.encadrant = encadrant;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	public Boolean getAffecte() {
		return affecte;
	}
	public void setAffecte(Boolean affecte) {
		this.affecte = affecte;
	}
	public Pcd(int id, String sujet, String description_PCD, int encadrant,
			int departement, Boolean affecte) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description_PCD = description_PCD;
		this.encadrant = encadrant;
		this.departement = departement;
		this.affecte = affecte;
	}
	
	
	
	
	
}