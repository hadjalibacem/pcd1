package beans;

import java.io.Serializable;
//import java.util.List;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Administration;
import model.AffPCD;
import model.ChxPCD;
import model.Departement;
import model.Enseignant;
import model.Etudiant;
import model.Pcd;
import dao.AdminDao;
import dao.AffPcdDao;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.PcdDao;

@ManagedBean
@RequestScoped
public class ChPcdBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer coEquip1=null;
	private Integer coEquip2 = null;
	private Integer coEquip3 = null;
	private int idPcdAaffecter;
	private PcdDao pcdD = new PcdDao();
	private List<Pcd> listPCD = pcdD.getList();
	private String sujet;
	private String description;
	private int encadreur;
	private Integer departement;
	private int NbAaffecter;
	private DepartementDao depD=new DepartementDao();
	private List<Departement> listDep=depD.getListDepartement();
	
	public List<Departement> getListDep() {
		return listDep;
	}

	public void setListDep(List<Departement> listDep) {
		this.listDep = listDep;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public int getEncadreur() {
		return encadreur;
	}

	public void setEncadreur(int encadreur) {
		this.encadreur = encadreur;
	}

	public Integer getDepartement() {
		return departement;
	}

	public void setDepartement(Integer departement) {
		this.departement = departement;
	}

	public int getNbAaffecter() {
		return NbAaffecter;
	}

	public void setNbAaffecter(int nbAaffecter) {
		NbAaffecter = nbAaffecter;
	}

	public int getIdPcdAaffecter() {
		return idPcdAaffecter;
	}

	public void setIdPcdAaffecter(int idPcdAaffecter) {
		this.idPcdAaffecter = idPcdAaffecter;
	}

	public List<Pcd> getListPCD() {
		return listPCD;
	}

	public void setListPCD(List<Pcd> listPCD) {
		this.listPCD = listPCD;
	}

	public Integer getCoEquip1() {
		return coEquip1;
	}

	public void setCoEquip1(Integer coEquip1) {
		this.coEquip1 = coEquip1;
	}

	public Integer getCoEquip2() {
		return coEquip2;
	}

	public void setCoEquip2(Integer coEquip2) {
		this.coEquip2 = coEquip2;
	}

	public Integer getCoEquip3() {
		return coEquip3;
	}

	public void setCoEquip3(Integer coEquip3) {
		this.coEquip3 = coEquip3;
	}
	
	public String affecter()
	{
		
		if(coEquip3==0) coEquip3=null;
		AffPCD affP=new AffPCD(0, coEquip1, idPcdAaffecter, coEquip2,false, false, null, null, false, coEquip3);
		AffPcdDao affpD=new AffPcdDao();
		affpD.removeCoEquip(coEquip1);
		affpD.removeCoEquip(coEquip2);
		if(coEquip3!=null)
		affpD.removeCoEquip(coEquip3);
		Pcd pcd=pcdD.getPcd(idPcdAaffecter);
		if(pcd.getNbAaffecter()>0)
			{pcd.setNbAaffecter(pcd.getNbAaffecter()-1);
		pcdD.add(pcd);}
		affpD.affect(affP);
		
		/*ChxPcdDao chxpcdD=new ChxPcdDao();
		chxpcdD.removeCoEquip(coEquip1);
		chxpcdD.removeCoEquip(coEquip2);
		if(coEquip3!=null)
		chxpcdD.removeCoEquip(coEquip3);*/
		
		FacesMessage message = new FacesMessage( "Groupe affecté !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
		
		
	}


	public boolean isAffected(int id)
	{
		if(id==0)
			return false;
		AffPcdDao affpD=new AffPcdDao();
		if(affpD.getAffect(id)!=null)
		{
			FacesMessage message = new FacesMessage( id+" est déjà affecté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return true;
		}
		return false;
		
	}
	public String AddPcd()
	{
		PcdDao pcdD=new PcdDao();
		if(pcdD.getPcd(sujet)!=null) {
			FacesMessage message = new FacesMessage( "Ce sujet est déjà enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		if(departement==0) departement=null;
		Pcd pcd=new Pcd(0, sujet, description, encadreur, departement, NbAaffecter);
		if(pcdD.add(pcd)) {
			FacesMessage message = new FacesMessage( "Sujet ajouté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else {
			FacesMessage message = new FacesMessage( "Erreur d'enregistrement  !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	public String updateListPcd()
	{
		for (Pcd pcd: listPCD)
		{
			pcdD.add(pcd);
		}
		return "";
	}
	public String AfficheDepartement(int id) {

		if(id!=0) return depD.getDepartement(id).getNom();
		else return null;
	}
}
