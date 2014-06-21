package beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Administration;
import dao.AdminDao;


@ManagedBean
@RequestScoped
public class AdminBean implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminDao admD=new AdminDao();
	Administration admin=admD.getAdministration();
public Administration getAdmin() {
		return admin;
	}
	public void setAdmin(Administration admin) {
		this.admin = admin;
	}
private int annee=admin.getAnnee();
private String pcd_datechoix;
private String pcd_dateccharge;
private String pcd_daterapport;
private String pp_datechoix;
private String pp_daterapport;
private String pfe_dateccharge;
private String pfe_daterapport;
private String filiere_datechoix;
private String modopt_datechoix;
private boolean pcd_choix=admin.isPCD_choix();
private boolean pp_choix=admin.isPP_choix();
public boolean isPp_choix() {
	return pp_choix;
}
public void setPp_choix(boolean pp_choix) {
	this.pp_choix = pp_choix;
}
private Integer pcd_nbchoix=admin.getPCD_nbChoix();
private Integer nbaffjury =admin.getPCD_nbSujetAjugerParProf();



public Integer getNbaffjury() {
	return nbaffjury;
}
public void setNbaffjury(Integer nbaffjury) {
	this.nbaffjury = nbaffjury;
}

public void setPcd_nbchoix(Integer pcd_nbchoix) {
	this.pcd_nbchoix = pcd_nbchoix;
}
public int getAnnee() {
	return annee;
}
public void setAnnee(int annee) {
	this.annee = annee;
}
public String getPcd_datechoix() {
	return pcd_datechoix;
}
public void setPcd_datechoix(String pcd_datechoix) {
	this.pcd_datechoix = pcd_datechoix;
}


public String getPcd_dateccharge() {
	return pcd_dateccharge;
}
public void setPcd_dateccharge(String pcd_dateccharge) {
	this.pcd_dateccharge = pcd_dateccharge;
}
public String getPcd_daterapport() {
	return pcd_daterapport;
}
public void setPcd_daterapport(String pcd_daterapport) {
	this.pcd_daterapport = pcd_daterapport;
}
public String getPp_datechoix() {
	return pp_datechoix;
}
public void setPp_datechoix(String pp_datechoix) {
	this.pp_datechoix = pp_datechoix;
}
public String getPp_daterapport() {
	return pp_daterapport;
}
public void setPp_daterapport(String pp_daterapport) {
	this.pp_daterapport = pp_daterapport;
}
public String getPfe_dateccharge() {
	return pfe_dateccharge;
}
public void setPfe_dateccharge(String pfe_dateccharge) {
	this.pfe_dateccharge = pfe_dateccharge;
}
public String getPfe_daterapport() {
	return pfe_daterapport;
}
public void setPfe_daterapport(String pfe_daterapport) {
	this.pfe_daterapport = pfe_daterapport;
}
public String getFiliere_datechoix() {
	return filiere_datechoix;
}
public void setFiliere_datechoix(String filiere_datechoix) {
	this.filiere_datechoix = filiere_datechoix;
}
public String getModopt_datechoix() {
	return modopt_datechoix;
}
public void setModopt_datechoix(String modopt_datechoix) {
	this.modopt_datechoix = modopt_datechoix;
}
public boolean isPcd_choix() {
	return pcd_choix;
}
public void setPcd_choix(boolean pcd_choix) {
	this.pcd_choix = pcd_choix;
}
public int getPcd_nbchoix() {
	return pcd_nbchoix;
}
public void setPcd_nbchoix(int pcd_nbchoix) {
	this.pcd_nbchoix = pcd_nbchoix;
}
@SuppressWarnings("deprecation")
public void convertToDate(String dateS,Date date)
{
	date.setYear(Integer.parseInt(dateS.split("-")[0])-1900);
	date.setMonth(Integer.parseInt(dateS.split("-")[1])-1);
	date.setDate(Integer.parseInt(dateS.split("-")[2]));
}
public String save()
{
	if(!pcd_dateccharge.isEmpty())
		convertToDate(pcd_dateccharge,admin.getPCD_dateCCharge());
	else admin.setPCD_dateCCharge(null);
	if(!pcd_datechoix.isEmpty())
	convertToDate(pcd_datechoix,admin.getPCD_dateChoix());
	else admin.setPCD_dateChoix(null);
	if(!pcd_daterapport.isEmpty())
	convertToDate(pcd_daterapport,admin.getPCD_dateRapport());
	else admin.setPCD_dateRapport(null);
	if(!pfe_daterapport.isEmpty())
	convertToDate(pfe_daterapport,admin.getPFE_dateRapport());
	else admin.setPFE_dateRapport(null);
	if(!pfe_dateccharge.isEmpty())
	convertToDate(pfe_dateccharge,admin.getPFE_dateCCharge());
	else admin.setPFE_dateCCharge(null);
	if(!pp_datechoix.isEmpty())
	convertToDate(pp_datechoix,admin.getPP_dateChoix());
	else admin.setPP_dateChoix(null);
	if(!pp_daterapport.isEmpty())
	convertToDate(pp_daterapport,admin.getPP_dateRapport());
	else admin.setPP_dateRapport(null);
	if(!filiere_datechoix.isEmpty())
	convertToDate(filiere_datechoix,admin.getFiliere_dateChoix());
	else admin.setFiliere_dateChoix(null);
	if(!modopt_datechoix.isEmpty())
	convertToDate(modopt_datechoix,admin.getModOpt_dateChoix());
	else admin.setModOpt_dateChoix(null);

	admin.setAnnee(annee);
	admin.setPCD_choix(pcd_choix);
	admin.setPP_choix(pp_choix);
	admin.setPCD_nbChoix(pcd_nbchoix);
	admD.add(admin);
	return "";
}
public AdminBean() {
	super();
	if(admin.getPCD_dateChoix()!=null) pcd_datechoix=admin.getPCD_dateChoix().toString();
	if(admin.getPCD_dateCCharge()!=null)  pcd_dateccharge=admin.getPCD_dateCCharge().toString();
	if(admin.getPCD_dateRapport()!=null)  pcd_daterapport=admin.getPCD_dateRapport().toString();
	if(admin.getPP_dateChoix()!=null)  pp_datechoix=admin.getPP_dateChoix().toString();
	if(admin.getPP_dateRapport()!=null)  pp_daterapport=admin.getPP_dateRapport().toString();
	if(admin.getPFE_dateCCharge()!=null)  pfe_dateccharge=admin.getPFE_dateCCharge().toString();
	if(admin.getPFE_dateRapport()!=null)  pfe_daterapport=admin.getPFE_dateRapport().toString();
	if(admin.getFiliere_dateChoix()!=null)  filiere_datechoix=admin.getFiliere_dateChoix().toString();
	if(admin.getModOpt_dateChoix()!=null)  modopt_datechoix=admin.getModOpt_dateChoix().toString();
	
}

}
