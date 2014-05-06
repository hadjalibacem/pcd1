package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module_optionnel")
public class Mod_opt {
	@Id
	private int id;
	private String nom;
	private int nb_max;
	private int nb_min;
	private int filiere;
	
	
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
	public int getNb_max() {
		return nb_max;
	}
	public void setNb_max(int nb_max) {
		this.nb_max = nb_max;
	}
	public int getNb_min() {
		return nb_min;
	}
	public void setNb_min(int nb_min) {
		this.nb_min = nb_min;
	}
	public int getFiliere() {
		return filiere;
	}
	public void setFiliere(int filiere) {
		this.filiere = filiere;
	}
	public Mod_opt(int id, String nom, int nb_max, int nb_min,
			int filiere) {
		super();
		this.id = id;
		this.nom = nom;
		this.nb_max = nb_max;
		this.nb_min = nb_min;
		this.filiere = filiere;
	}
	public Mod_opt() {
		super();
	}
	
	
	
	
}