package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixprojprog")
public class ChxProjProg {
	@Id
	private int id;
	private int coEquipier1;
	private int proj_prog;
	private int rang;
	private int coEquipier2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoEquipier1() {
		return coEquipier1;
	}
	public void setCoEquipier1(int coEquipier1) {
		this.coEquipier1 = coEquipier1;
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
	public int getCoEquipier2() {
		return coEquipier2;
	}
	public void setCoEquipier2(int coEquipier2) {
		this.coEquipier2 = coEquipier2;
	}
	public ChxProjProg(int id, int coEquipier1, int proj_prog, int rang,
			int coEquipier2) {
		super();
		this.id = id;
		this.coEquipier1 = coEquipier1;
		this.proj_prog = proj_prog;
		this.rang = rang;
		this.coEquipier2 = coEquipier2;
	}
	public ChxProjProg() {
		super();
	}

	
}
