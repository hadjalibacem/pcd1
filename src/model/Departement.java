package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement {
	@Id
	private int id;
	

	private String nom;
	
	private int chef_departement;
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

	public int getChef_departement() {
		return chef_departement;
	}

	public void setChef_departement(int chef_departement) {
		this.chef_departement = chef_departement;
	}

	public Departement(int id, String nom, int chef_departement) {
		super();
		this.id = id;
		this.nom = nom;
		this.chef_departement = chef_departement;
	}

	
	
	
	
	
	


	


	
}

