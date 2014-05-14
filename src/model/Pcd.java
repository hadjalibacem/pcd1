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
	private int encadreur;
	private Integer departement;
	private int nbAaffecter;
	private String MotsCles;
	
	public String getMotsCles() {
		return MotsCles;
	}
	public void setMotsCles(String motsCles) {
		MotsCles = motsCles;
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
	public String getDescription_PCD() {
		return description_PCD;
	}
	public void setDescription_PCD(String description_PCD) {
		this.description_PCD = description_PCD;
	}
	
	public int getEncadreur() {
		return encadreur;
	}
	public void setEncadreur(int encadreur) {
		this.encadreur = encadreur;
	}
	public Integer getDepartement() {
		return departement;
	}
	public void setDepartement(Integer departement) {
		this.departement = departement;
	}
	public int getNbAaffecter() {
		return nbAaffecter;
	}
	public void setNbAaffecter(int nbAaffecter) {
		this.nbAaffecter = nbAaffecter;
	}
	
	
	public Pcd(int id, String sujet, String description_PCD, int encadreur,
			Integer departement, int nbAaffecter, String motsCles) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description_PCD = description_PCD;
		this.encadreur = encadreur;
		this.departement = departement;
		this.nbAaffecter = nbAaffecter;
		MotsCles = motsCles;
	}
	public Pcd() {
		super();
	}
	
	
	
}