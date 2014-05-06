package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixfiliere")
public class ChxFiliere {
	@Id
	private int id;
	private int filiere;
	private int etudiant;
	private int rang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFiliere() {
		return filiere;
	}
	public void setFiliere(int filiere) {
		this.filiere = filiere;
	}
	public int getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(int etudiant) {
		this.etudiant = etudiant;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public ChxFiliere(int id, int filiere, int etudiant, int rang) {
		super();
		this.id = id;
		this.filiere = filiere;
		this.etudiant = etudiant;
		this.rang = rang;
	}
	public ChxFiliere() {
		super();
	}
	
	

}
