package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixprojprog")
public class ChxProjProg {
	@Id
	private int id;
	private int idgroupe;
	private int proj_prog;
	private int rang;
	private int etudiant;
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
	public int getProj_prog() {
		return proj_prog;
	}
	public void setProj_prog(int proj_prog) {
		this.proj_prog = proj_prog;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
	
	public ChxProjProg() {
		super();
	}
	public ChxProjProg(int id, int idgroupe, int proj_prog, int rang,
			int etudiant) {
		super();
		this.id = id;
		this.idgroupe = idgroupe;
		this.proj_prog = proj_prog;
		this.rang = rang;
		this.etudiant = etudiant;
	}

	
}
