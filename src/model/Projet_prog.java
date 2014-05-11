package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projet_prog")
public class Projet_prog {
	@Id
	private int id;
	private String sujet;
	private String description;
	private int encadreur;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEncadrant() {
		return encadreur;
	}
	public void setEncadrant(int encadrant) {
		this.encadreur = encadrant;
	}
	public Boolean getAffecte() {
		return affecte;
	}
	public void setAffecte(Boolean affecte) {
		this.affecte = affecte;
	}
	public Projet_prog(int id, String sujet, String description, int encadrant,
			Boolean affecte) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.encadreur = encadrant;
		this.affecte = affecte;
	}
	public Projet_prog() {
		super();
	}
	
	
}