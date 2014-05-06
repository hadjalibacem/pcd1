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
	private int etudiant;
	private int PCD;
	private Boolean vu;
	private Boolean depotCCharge;
	private Boolean depotRapport;
	private Date dateSoutenance;
	private String Jury;
	private Boolean resultat;
	private Boolean depotConvention;
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
	public int getPCD() {
		return PCD;
	}
	public void setPCD(int pCD) {
		PCD = pCD;
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
	public Boolean getResultat() {
		return resultat;
	}
	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	public Boolean getDepotConvention() {
		return depotConvention;
	}
	public void setDepotConvention(Boolean depotConvention) {
		this.depotConvention = depotConvention;
	}
	public AffPCD(int id, int etudiant, int pCD, Boolean vu,
			Boolean depotCCharge, Boolean depotRapport, Date dateSoutenance,
			String jury, Boolean resultat, Boolean depotConvention) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.PCD = pCD;
		this.vu = vu;
		this.depotCCharge = depotCCharge;
		this.depotRapport = depotRapport;
		this.dateSoutenance = dateSoutenance;
		this.Jury = jury;
		this.resultat = resultat;
		this.depotConvention = depotConvention;
	}
	public AffPCD() {
		super();
	}
	
	

}
