package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administration")
public class Administration {
	@Id
	private int annee;
	
	private Date PCD_dateChoix;
	private boolean PCD_choix_dep;
	private Date PCD_dateCCharge;
	private Date PCD_dateRapport;
	private Date PP_dateChoix;
	private Date PP_dateRapport;
	private Date PFE_dateCCharge;
	private Date PFE_dateRapport;
	private Date filiere_dateChoix;
	private Date ModOpt_dateChoix;
	private boolean PCD_choix;
	private int PCD_nbChoix;
	private int PCD_nbJury;
	private int PCD_nbSujetAjugerParProf;
	public int getPCD_nbSujetAjugerParProf() {
		return PCD_nbSujetAjugerParProf;
	}
	public void setPCD_nbSujetAjugerParProf(int pCD_nbSujetAjugerParProf) {
		PCD_nbSujetAjugerParProf = pCD_nbSujetAjugerParProf;
	}
	public int getPCD_nbJury() {
		return PCD_nbJury;
	}
	public void setPCD_nbJury(int pCD_nbJury) {
		PCD_nbJury = pCD_nbJury;
	}
	public int getAnnee() {
		return annee;
	}
	public boolean isPCD_choix() {
		return PCD_choix;
	}
	public void setPCD_choix(boolean pCD_choix) {
		PCD_choix = pCD_choix;
	}
	public int getPCD_nbChoix() {
		return PCD_nbChoix;
	}
	public void setPCD_nbChoix(int pCD_nbChoix) {
		PCD_nbChoix = pCD_nbChoix;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Date getPCD_dateChoix() {
		return PCD_dateChoix;
	}
	public void setPCD_dateChoix(Date pCD_dateChoix) {
		PCD_dateChoix = pCD_dateChoix;
	}
	public boolean getPCD_choix_dep() {
		return PCD_choix_dep;
	}
	public void setPCD_choix_dep(boolean pCD_choix_dep) {
		PCD_choix_dep = pCD_choix_dep;
	}
	public Date getPCD_dateCCharge() {
		return PCD_dateCCharge;
	}
	public void setPCD_dateCCharge(Date pCD_dateCCharge) {
		PCD_dateCCharge = pCD_dateCCharge;
	}
	public Date getPCD_dateRapport() {
		return PCD_dateRapport;
	}
	public void setPCD_dateRapport(Date pCD_dateRapport) {
		PCD_dateRapport = pCD_dateRapport;
	}
	public Date getPP_dateChoix() {
		return PP_dateChoix;
	}
	public void setPP_dateChoix(Date pP_dateChoix) {
		PP_dateChoix = pP_dateChoix;
	}
	public Date getPP_dateRapport() {
		return PP_dateRapport;
	}
	public void setPP_dateRapport(Date pP_dateRapport) {
		PP_dateRapport = pP_dateRapport;
	}
	public Date getPFE_dateCCharge() {
		return PFE_dateCCharge;
	}
	public void setPFE_dateCCharge(Date pFE_dateCCharge) {
		PFE_dateCCharge = pFE_dateCCharge;
	}
	public Administration() {
		super();
	}
	public Date getPFE_dateRapport() {
		return PFE_dateRapport;
	}
	public void setPFE_dateRapport(Date pFE_dateRapport) {
		PFE_dateRapport = pFE_dateRapport;
	}
	public Date getFiliere_dateChoix() {
		return filiere_dateChoix;
	}
	public void setFiliere_dateChoix(Date filiere_dateChoix) {
		this.filiere_dateChoix = filiere_dateChoix;
	}
	public Date getModOpt_dateChoix() {
		return ModOpt_dateChoix;
	}
	public void setModOpt_dateChoix(Date modOpt_dateChoix) {
		ModOpt_dateChoix = modOpt_dateChoix;
	}
	public Administration(int annee, Date pCD_dateChoix, boolean pCD_choix_dep,
			Date pCD_dateCCharge, Date pCD_dateRapport, Date pP_dateChoix,
			Date pP_dateRapport, Date pFE_dateCCharge, Date pFE_dateRapport,
			Date filiere_dateChoix, Date modOpt_dateChoix, boolean pCD_choix,
			int pCD_nbChoix, int pCD_nbJury, int pCD_nbSujetAjugerParProf) {
		super();
		this.annee = annee;
		PCD_dateChoix = pCD_dateChoix;
		PCD_choix_dep = pCD_choix_dep;
		PCD_dateCCharge = pCD_dateCCharge;
		PCD_dateRapport = pCD_dateRapport;
		PP_dateChoix = pP_dateChoix;
		PP_dateRapport = pP_dateRapport;
		PFE_dateCCharge = pFE_dateCCharge;
		PFE_dateRapport = pFE_dateRapport;
		this.filiere_dateChoix = filiere_dateChoix;
		ModOpt_dateChoix = modOpt_dateChoix;
		PCD_choix = pCD_choix;
		PCD_nbChoix = pCD_nbChoix;
		PCD_nbJury = pCD_nbJury;
		PCD_nbSujetAjugerParProf = pCD_nbSujetAjugerParProf;
	}
	
	
	
	
	
	
	
}
