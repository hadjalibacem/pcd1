package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectpcd")
public class AffPCD {
	@Id
	private int id;
	private int coEquipier1;
	private int PCD;
	private int coEquipier2;
	private Boolean depotCCharge;
	private Boolean depotRapport;
	private Date dateSoutenance;
	private Integer Jury;
	private Boolean resultat;
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


	public int getPCD() {
		return PCD;
	}


	public void setPCD(int pCD) {
		PCD = pCD;
	}


	public int getCoEquipier2() {
		return coEquipier2;
	}


	public void setCoEquipier2(int coEquipier2) {
		this.coEquipier2 = coEquipier2;
	}


	


	public Boolean getDepotCCharge() {
		return depotCCharge;
	}


	public void setDepotCCharge(Boolean depotCCharge) {
		this.depotCCharge = depotCCharge;
	}


	public Boolean getDepotRapport() {
		return depotRapport;
	}


	public void setDepotRapport(Boolean depotRapport) {
		this.depotRapport = depotRapport;
	}


	public Date getDateSoutenance() {
		return dateSoutenance;
	}


	public void setDateSoutenance(Date dateSoutenance) {
		this.dateSoutenance = dateSoutenance;
	}


	public Integer getJury() {
		return Jury;
	}


	public void setJury(Integer jury) {
		Jury = jury;
	}


	public Boolean getResultat() {
		return resultat;
	}


	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}


	

	public Integer getCoEquipier3() {
		return coEquipier3;
	}


	public void setCoEquipier3(Integer coEquipier3) {
		this.coEquipier3 = coEquipier3;
	}


	public AffPCD() {
		super();
	}


	public AffPCD(int id, int coEquipier1, int pCD, int coEquipier2, Boolean depotCCharge, Boolean depotRapport,
			Date dateSoutenance, Integer jury, Boolean resultat,
			 Integer coEquipier3) {
		super();
		this.id = id;
		this.coEquipier1 = coEquipier1;
		PCD = pCD;
		this.coEquipier2 = coEquipier2;
		this.depotCCharge = depotCCharge;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		Jury = jury;
		this.resultat = resultat;
		this.coEquipier3 = coEquipier3;
	}
	
	

}
