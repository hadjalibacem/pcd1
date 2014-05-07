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
	private int idgroupe;
	private int proj_prog;

	private int etudiant;
	private Boolean resultat;
	private Boolean vu;
	private Boolean depotRapport;
	private Date dateSoutenance;
	private String Jury;
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
	public Boolean getResultat() {
		return resultat;
	}
	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	public Boolean getVu() {
		return vu;
	}
	public void setVu(Boolean vu) {
		this.vu = vu;
	}
	public int getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(int idgroupe) {
		this.idgroupe = idgroupe;
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
	public String getJury() {
		return Jury;
	}
	public void setJury(String jury) {
		Jury = jury;
	}
	
	public AffProjProg() {
		super();
	}
	public AffProjProg(int id, int idgroupe, int proj_prog, int etudiant,
			Boolean resultat, Boolean vu, Boolean depotRapport,
			Date dateSoutenance, String jury) {
		super();
		this.id = id;
		this.idgroupe = idgroupe;
		this.proj_prog = proj_prog;
		this.etudiant = etudiant;
		this.resultat = resultat;
		this.vu = vu;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		Jury = jury;
	}
	
	
}
