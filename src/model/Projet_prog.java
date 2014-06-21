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
	private String description_PP;
	private int encadreur;
	private int nbAaffecter;
	private String MotsCles;
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
	
	public String getDescription_PP() {
		return description_PP;
	}
	public void setDescription_PP(String description_PP) {
		this.description_PP = description_PP;
	}
	public int getEncadreur() {
		return encadreur;
	}
	public void setEncadreur(int encadreur) {
		this.encadreur = encadreur;
	}
	
	public int getNbAaffecter() {
		return nbAaffecter;
	}
	public void setNbAaffecter(int nbAaffecter) {
		this.nbAaffecter = nbAaffecter;
	}
	public String getMotsCles() {
		return MotsCles;
	}
	public void setMotsCles(String motsCles) {
		MotsCles = motsCles;
	}
	public Projet_prog(int id, String sujet, String description_PCD,
			int encadreur, int nbAaffecter, String motsCles) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description_PP = description_PCD;
		this.encadreur = encadreur;
		this.nbAaffecter = nbAaffecter;
		MotsCles = motsCles;
	}
	public Projet_prog() {
		super();
	}
	

}