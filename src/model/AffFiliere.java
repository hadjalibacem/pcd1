package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectfiliere")
public class AffFiliere {
	@Id
	private int id;
	

	private int filiere;
	
	private int etudiant;
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
	public AffFiliere(int id, int filiere, int etudiant, Boolean vu) {
		super();
		this.id = id;
		this.filiere = filiere;
		this.etudiant = etudiant;
	}
	public AffFiliere() {
		super();
	}
	
	

}
