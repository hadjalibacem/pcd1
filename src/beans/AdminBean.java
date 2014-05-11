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
private int annee=admin.getAnnee();
private String pcd_datechoix=admin.getPCD_dateChoix().toString();
private boolean pcd_choix_dep=admin.getPCD_choix_dep();
private String pcd_dateccharge=admin.getPCD_dateCCharge().toString();
private String pcd_daterapport=admin.getPCD_dateRapport().toString();
private String pp_datechoix=admin.getPP_dateChoix().toString();
private String pp_daterapport=admin.getPP_dateRapport().toString();
private String pfe_dateccharge=admin.getPFE_dateCCharge().toString();
private String pfe_daterapport=admin.getPFE_dateRapport().toString();
private String filiere_datechoix=admin.getFiliere_dateChoix().toString();
private String modopt_datechoix=admin.getModOpt_dateChoix().toString();
private boolean pcd_choix=admin.isPCD_choix();
private int pcd_nbchoix=admin.getPCD_nbChoix();




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
public boolean isPcd_choix_dep() {
	return pcd_choix_dep;
}
public void setPcd_choix_dep(boolean pcd_choix_dep) {
	this.pcd_choix_dep = pcd_choix_dep;
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
	convertToDate(pcd_dateccharge,admin.getPCD_dateCCharge());
	convertToDate(pcd_datechoix,admin.getPCD_dateChoix());
	convertToDate(pcd_daterapport,admin.getPCD_dateRapport());
	convertToDate(pfe_daterapport,admin.getPFE_dateRapport());
	convertToDate(pfe_dateccharge,admin.getPFE_dateCCharge());
	convertToDate(pp_datechoix,admin.getPP_dateChoix());
	convertToDate(pp_daterapport,admin.getPP_dateRapport());
	convertToDate(filiere_datechoix,admin.getFiliere_dateChoix());
	convertToDate(modopt_datechoix,admin.getModOpt_dateChoix());

	admin.setAnnee(annee);
	admin.setPCD_choix(pcd_choix);
	admin.setPCD_choix_dep(pcd_choix_dep);
	admin.setPCD_nbChoix(pcd_nbchoix);
	admD.add(admin);
	return "";
}

}
