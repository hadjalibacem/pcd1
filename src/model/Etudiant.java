package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etudiant")
public class Etudiant {
	@Id
	private int id;
	private String nom;
	private String prenom;
	private int niveau;
	private String groupe;
	private String adresse;
	private String email;
	
	private Integer rang;
	private Integer departement;
	
	
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
	
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRang() {
		return rang;
	}
	public void setRang(Integer rang) {
		this.rang = rang;
	}
	public int getDepartement() {
		return departement;
	}
	public void setDepartement(int departement) {
		this.departement = departement;
	}
	public Etudiant(int id, String nom, String prenom,int niveau, String groupe, String adresse,
			String email, int rang, int departement) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.niveau = niveau;
		this.groupe = groupe;
		this.adresse = adresse;
		this.email = email;
		this.rang = rang;
		this.departement = departement;
	}
	
	
	
	public Etudiant() {
	}
	
	
	
	


	


	
}

