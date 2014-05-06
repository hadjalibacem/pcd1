package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affectpfe")
public class AffPFE {
	@Id
	private int id;
	private int etudiant;
	private int PFE;
	private Boolean resultat;
	private Boolean vu;
	private Boolean depotCCharge;
	private Boolean depotRapport;
	private Date dateSoutenance;
	private String Jury;
	private String CRenduSuperviseur;
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
	public int getPFE() {
		return PFE;
	}
	public void setPFE(int pFE) {
		PFE = pFE;
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
	public String getJury() {
		return Jury;
	}
	public void setJury(String jury) {
		Jury = jury;
	}
	public String getCRenduSuperviseur() {
		return CRenduSuperviseur;
	}
	public void setCRenduSuperviseur(String cRenduSuperviseur) {
		CRenduSuperviseur = cRenduSuperviseur;
	}
	public Boolean getConvention() {
		return Convention;
	}
	public void setConvention(Boolean convention) {
		Convention = convention;
	}
	public AffPFE(int id, int etudiant, int pFE, Boolean resultat, Boolean vu,
			Boolean depotCCharge, Boolean depotRapport, Date dateSoutenance,
			String jury, String cRenduSuperviseur, Boolean convention) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		PFE = pFE;
		this.resultat = resultat;
		this.vu = vu;
		this.depotCCharge = depotCCharge;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		Jury = jury;
		CRenduSuperviseur = cRenduSuperviseur;
		Convention = convention;
	}
	public AffPFE() {
		super();
	}
	
	
}
