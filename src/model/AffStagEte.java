package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectstagete")
public class AffStagEte {
	@Id
	private int id;
	private int etudiant;
	private int stage_ete;
	private Boolean resultat;
	private Boolean vu;
	private Boolean depotRapport;
	private Date dateSoutenance;
	private String Jury;
	private Boolean Convention;
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
	public int getStage_ete() {
		return stage_ete;
	}
	public void setStage_ete(int stage_ete) {
		this.stage_ete = stage_ete;
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
	public Boolean getConvention() {
		return Convention;
	}
	public void setConvention(Boolean convention) {
		Convention = convention;
	}
	public AffStagEte(int id, int etudiant, int stage_ete, Boolean resultat,
			Boolean vu, Boolean depotRapport, Date dateSoutenance, String jury,
			Boolean convention) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.stage_ete = stage_ete;
		this.resultat = resultat;
		this.vu = vu;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		this.Jury = jury;
		this.Convention = convention;
	}
	
	
}
