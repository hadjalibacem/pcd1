package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixpcd")
public class ChxPCD {
	@Id
	private int id;
	private int etudiant;
	private int pcd;
	private int rang;
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
	public ChxPCD(int id, int etudiant, int pcd, int rang) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.pcd = pcd;
		this.rang = rang;
	}

	
}
