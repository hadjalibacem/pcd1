package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectprojprog")
public class AffProjProg {
	@Id
	private int id;
	private int coEquipier1;
	private int proj_prog;
	private Integer coEquipier2;
	private Boolean depotRapport;
	private String dateSoutenance;
	


	private Integer Jury;
	private Boolean resultat;
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
	public Integer getCoEquipier2() {
		return coEquipier2;
	}
	public void setCoEquipier2(Integer coEquipier2) {
		this.coEquipier2 = coEquipier2;
	}
	public Boolean getDepotRapport() {
		return depotRapport;
	}
	public void setDepotRapport(Boolean depotRapport) {
		this.depotRapport = depotRapport;
	}
	public String getDateSoutenance() {
		return dateSoutenance;
	}
	public void setDateSoutenance(String dateSoutenance) {
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
	public AffProjProg(int id, int coEquipier1, int pP, Integer coEquipier2,
			Boolean depotRapport, String dateSoutenance, Integer jury,
			Boolean resultat) {
		super();
		this.id = id;
		this.coEquipier1 = coEquipier1;
		proj_prog = pP;
		this.coEquipier2 = coEquipier2;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		Jury = jury;
		this.resultat = resultat;
	}
	public AffProjProg() {
		super();
	}
	
}
