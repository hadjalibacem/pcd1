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
	public int getJury() {
		return Jury;
	}
	public void setJury(int jury) {
		Jury = jury;
	}
	private int coEquipier1;
	private int proj_prog;

	private int coEquipier2;
	private Boolean resultat;
	private Boolean depotRapport;
	private String dateSoutenance;
	public String getDateSoutenance() {
		return dateSoutenance;
	}
	public void setDateSoutenance(String dateSoutenance) {
		this.dateSoutenance = dateSoutenance;
	}
	private int Jury;
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
	public int getCoEquipier2() {
		return coEquipier2;
	}
	public void setCoEquipier2(int coEquipier2) {
		this.coEquipier2 = coEquipier2;
	}
	public Boolean getResultat() {
		return resultat;
	}
	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	
	public Boolean getDepotRapport() {
		return depotRapport;
	}
	public void setDepotRapport(Boolean depotRapport) {
		this.depotRapport = depotRapport;
	}

	public AffProjProg(int id, int coEquipier1, int proj_prog, int coEquipier2,
			Boolean resultat, Boolean depotRapport, String dateSoutenance,
			int jury) {
		super();
		this.id = id;
		this.coEquipier1 = coEquipier1;
		this.proj_prog = proj_prog;
		this.coEquipier2 = coEquipier2;
		this.resultat = resultat;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		Jury = jury;
	}
	public AffProjProg() {
		super();
	}
	
	
	
}
