package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="choixpcd")
public class ChxPCD {
	@Id
	private int id;
	private int coEquipier1;
	
	private int pcd;
	private int rang;
	private Integer coEquipier2;
	private Integer coEquipier3;
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
	public Integer getCoEquipier2() {
		return coEquipier2;
	}
	public void setCoEquipier2(Integer coEquipier2) {
		this.coEquipier2 = coEquipier2;
	}
	public Integer getCoEquipier3() {
		return coEquipier3;
	}
	public void setCoEquipier3(Integer coEquipier3) {
		this.coEquipier3 = coEquipier3;
	}
	
	public ChxPCD(int id, int coEquipier1, int pcd, int rang,
			Integer coEquipier2, Integer coEquipier3) {
		super();
		this.id = id;
		this.coEquipier1 = coEquipier1;
		this.pcd = pcd;
		this.rang = rang;
		this.coEquipier2 = coEquipier2;
		this.coEquipier3 = coEquipier3;
	}
	public ChxPCD() {
		super();
	}

	
}
