package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enseignant")
public class Enseignant {
	@Id
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int bureau;
	private String motsCles;
	
	public String getMotsCles() {
		return motsCles;
	}
	public void setMotsCles(String motsCles) {
		this.motsCles = motsCles;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBureau() {
		return bureau;
	}
	public void setBureau(int bureau) {
		this.bureau = bureau;
	}
	
	
	public Enseignant(int id, String nom, String prenom, String email,
			int bureau, String motsCles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.bureau = bureau;
		this.motsCles = motsCles;
	}
	public Enseignant() {
		super();
	}
	
	
	
	
	


	


	
}

