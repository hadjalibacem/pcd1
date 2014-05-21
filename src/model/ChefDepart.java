package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Chef_Depart")
public class ChefDepart {
	@Id
	private int id;
	

	private String nom;
	
	private String prenom;
	private int departement;
	
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	
	
	public ChefDepart(int id, String nom, String prenom, int departement) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
	}

	public ChefDepart() {
		super();
	}

	

}
