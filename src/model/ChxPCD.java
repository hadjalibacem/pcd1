package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixpcd")
public class ChxPCD {
	@Id
	private int id;
	private int idgroupe;
	
	private int pcd;
	private int rang;
	private int etudiant;

	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
	}
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
	public int getPcd() {
		return pcd;
	}
	public void setPcd(int pcd) {
		this.pcd = pcd;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	
	public ChxPCD() {
		super();
	}

	public ChxPCD(int id, int idgroupe, int pcd, int rang, int etudiant) {
		super();
		this.id = id;
		this.idgroupe = idgroupe;
		this.pcd = pcd;
		this.rang = rang;
		this.etudiant = etudiant;
	}
}
