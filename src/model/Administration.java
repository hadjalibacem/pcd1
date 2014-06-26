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
	private Date PCD_dateCCharge;
	private Date PCD_dateRapport;
	private Date PP_dateChoix;
	private Date PP_dateRapport;
	private Date PFE_dateCCharge;
	private Date PFE_dateRapport;
	private Date filiere_dateChoix;
	private Date ModOpt_dateChoix;
	private boolean PCD_choix;
	private boolean PP_choix;
	private int PCD_nbChoix;
	private int PCD_nbSujetAjugerParProf;
	private int PP_nbChoix;
	private int PP_nbSujetAjugerParProf;
	
	
	public int getPP_nbChoix() {
		return PP_nbChoix;
	}
	public void setPP_nbChoix(int pP_nbChoix) {
		PP_nbChoix = pP_nbChoix;
	}
	public int getPP_nbSujetAjugerParProf() {
		return PP_nbSujetAjugerParProf;
	}
	public void setPP_nbSujetAjugerParProf(int pP_nbSujetAjugerParProf) {
		PP_nbSujetAjugerParProf = pP_nbSujetAjugerParProf;
	}
	public int getPCD_nbSujetAjugerParProf() {
		return PCD_nbSujetAjugerParProf;
	}
	public boolean isPP_choix() {
		return PP_choix;
	}
	public void setPP_choix(boolean pP_choix) {
		PP_choix = pP_choix;
	}
	public void setPCD_nbSujetAjugerParProf(int pCD_nbSujetAjugerParProf) {
		PCD_nbSujetAjugerParProf = pCD_nbSujetAjugerParProf;
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
	
	public Date getPCD_dateCCharge() {
		return PCD_dateCCharge;
	}
	public void setPCD_dateCCharge(Date date) {
		PCD_dateCCharge = date;
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
	public Administration(int annee, Date pCD_dateChoix, Date pCD_dateCCharge,
			Date pCD_dateRapport, Date pP_dateChoix, Date pP_dateRapport,
			Date pFE_dateCCharge, Date pFE_dateRapport, Date filiere_dateChoix,
			Date modOpt_dateChoix, boolean pCD_choix, boolean pP_choix,
			int pCD_nbChoix, int pCD_nbSujetAjugerParProf, int pP_nbChoix,
			int pP_nbSujetAjugerParProf) {
		super();
		this.annee = annee;
		PCD_dateChoix = pCD_dateChoix;
		PCD_dateCCharge = pCD_dateCCharge;
		PCD_dateRapport = pCD_dateRapport;
		PP_dateChoix = pP_dateChoix;
		PP_dateRapport = pP_dateRapport;
		PFE_dateCCharge = pFE_dateCCharge;
		PFE_dateRapport = pFE_dateRapport;
		this.filiere_dateChoix = filiere_dateChoix;
		ModOpt_dateChoix = modOpt_dateChoix;
		PCD_choix = pCD_choix;
		PP_choix = pP_choix;
		PCD_nbChoix = pCD_nbChoix;
		PCD_nbSujetAjugerParProf = pCD_nbSujetAjugerParProf;
		PP_nbChoix = pP_nbChoix;
		PP_nbSujetAjugerParProf = pP_nbSujetAjugerParProf;
	}

	
	
	
	
	
	
	
	
	
}
