package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectmodop")
public class AffModOpt {
	@Id
	private int id;
	private int etudiant;
	private int mod_opt;
	private Boolean vu;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(int etudiant) {
		this.etudiant = etudiant;
	}


	public int getMod_opt() {
		return mod_opt;
	}


	public void setMod_opt(int mod_opt) {
		this.mod_opt = mod_opt;
	}


	public Boolean getVu() {
		return vu;
	}


	public void setVu(Boolean vu) {
		this.vu = vu;
	}


	public AffModOpt(int id, int etudiant, int mod_opt, Boolean vu) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.mod_opt = mod_opt;
		this.vu = vu;
	}


	public AffModOpt() {
		super();
	}
	
	
	

}
