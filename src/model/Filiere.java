package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filiere")
public class Filiere {
	@Id
	private int id;
	private String nom;
	private int nombre_max;
	private int nombre_min;
	private int departement;
	
	
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
	public int getNombre_max() {
		return nombre_max;
	}
	public void setNombre_max(int nombre_max) {
		this.nombre_max = nombre_max;
	}
	public int getNombre_min() {
		return nombre_min;
	}
	public void setNombre_min(int nombre_min) {
		this.nombre_min = nombre_min;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	public Filiere(int id, String nom, int nombre_max, int nombre_min,
			int departement) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombre_max = nombre_max;
		this.nombre_min = nombre_min;
		this.departement = departement;
	}


	
	
	
	


	
}

