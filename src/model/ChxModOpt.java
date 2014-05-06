package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixmodopt")
public class ChxModOpt {
	@Id
	private int id;
	private int mod_opt;
	private int etudiant;
	private int rang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMod_opt() {
		return mod_opt;
	}
	public void setMod_opt(int mod_opt) {
		this.mod_opt = mod_opt;
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
	public ChxModOpt(int id, int mod_opt, int etudiant, int rang) {
		super();
		this.id = id;
		this.mod_opt = mod_opt;
		this.etudiant = etudiant;
		this.rang = rang;
	}
	public ChxModOpt() {
		super();
	}

	
}
