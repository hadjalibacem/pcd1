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
import model.ChefDepart;
import model.ChxPCD;
import model.Departement;
import model.Enseignant;
import model.Etudiant;
import model.Message;
import model.Pcd;
import dao.AdminDao;
import dao.AffPcdDao;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.MessageDao;
import dao.PcdDao;

@ManagedBean
@RequestScoped
public class ChPcdBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer coEquip1 = null;
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
	private DepartementDao depD = new DepartementDao();
	private List<Departement> listDep = depD.getListDepartement();
	private AffPcdDao affpD = new AffPcdDao();
	private Integer idpcdaff;
	private boolean depotRapport;
	private boolean depotCcharge;
	private String motsCles;
	private boolean validation;
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();

	List<Integer> listRandomChoice = new ArrayList<Integer>();
	private List<Pcd> listPcdToAffect = pcdD.getListPcdToAffect();
	private MessageDao msgD=new MessageDao();

	private Date date = Calendar.getInstance().getTime();
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	EtudiantDao etD = new EtudiantDao();
	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public String getMotsCles() {
		return motsCles;
	}

	public void setMotsCles(String motsCles) {
		this.motsCles = motsCles;
	}

	public boolean isDepotRapport() {
		return depotRapport;
	}

	public void setDepotRapport(boolean depotRapport) {
		this.depotRapport = depotRapport;
	}

	public boolean isDepotCcharge() {
		return depotCcharge;
	}

	public void setDepotCcharge(boolean depotCcharge) {
		this.depotCcharge = depotCcharge;
	}

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

	public Administration getAdm() {
		return adm;
	}

	public void setAdm(Administration adm) {
		this.adm = adm;
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

	/* Forcer l'affectation des etudiants même s'il sont affectés */

	public String affecter() {

		if (coEquip3 == 0)
			coEquip3 = null;

		affpD.removeCoEquip(coEquip1);
		affpD.removeCoEquip(coEquip2);
		if (coEquip3 != null)
			affpD.removeCoEquip(coEquip3);
		Pcd pcd = pcdD.getPcd(idPcdAaffecter);
		if (pcd.getNbAaffecter() > 0)
			affect(pcd, coEquip1, coEquip2, coEquip3);
		else {
			FacesMessage message = new FacesMessage(
					"Ce sujet a atteint le nombre limite d'affectation !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;

		}

		/*
		 * ChxPcdDao chxpcdD=new ChxPcdDao(); chxpcdD.removeCoEquip(coEquip1);
		 * chxpcdD.removeCoEquip(coEquip2); if(coEquip3!=null)
		 * chxpcdD.removeCoEquip(coEquip3);
		 */

		FacesMessage message = new FacesMessage("Groupe affecté !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";

	}

	public void affect(Pcd pcd, int coEquip1, int coEquip2, Integer coEquip3) {
		AffPCD affpcd = new AffPCD(0, coEquip1, pcd.getId(), coEquip2, null,
				null, null, null, null, coEquip3);
		if (affpD.affect(affpcd)) {
			pcd.setNbAaffecter(pcd.getNbAaffecter() - 1);
			pcdD.add(pcd);
		}
	}

	public boolean isAffected(int id) {
		if (id == 0)
			return false;
		if (affpD.getAffect(id) != null)

			return true;

		return false;

	}

	public String AddPcd() {
		PcdDao pcdD = new PcdDao();
		if (pcdD.getPcd(sujet) != null) {
			FacesMessage message = new FacesMessage(
					"Ce sujet est déjà enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		if (departement == 0)
			departement = null;
		Pcd pcd = new Pcd(0, sujet, description, encadreur, departement,
				NbAaffecter, motsCles);
		if (pcdD.add(pcd)) {
			FacesMessage message = new FacesMessage("Sujet ajouté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Erreur d'enregistrement  !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}

	public String updateListPcd() {
		for (Pcd pcd : listPCD) {
			pcdD.add(pcd);
		}
		return "";
	}

	public String AfficheDepartement(int id) {

		if (id != 0)
			return depD.getDepartement(id).getNom();
		else
			return null;
	}

	public Integer getIdpcdaff() {
		return idpcdaff;
	}

	public void setIdpcdaff(Integer idpcdaff) {
		this.idpcdaff = idpcdaff;
	}

	public String updateAffpcd() {

		AffPCD affpcd = affpD.getPcdAff(idpcdaff);
		affpcd.setDepotCCharge(depotCcharge);
		affpcd.setDepotRapport(depotRapport);
		affpcd.setResultat(validation);
		if (affpD.affect(affpcd)) {
			FacesMessage message = new FacesMessage("Enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage("Erreur d'enregistrement !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		return null;
	}
	public void notifyEtud ()
	{
		List<AffPCD> listAff=affpD.getList();

		Date date = Calendar.getInstance().getTime();
		String message;
		EnseignantDao ensD=new EnseignantDao();
		for (AffPCD affpcd: listAff)
		{
			
			if(affpcd.getCoEquipier3()!=null)
				message=etD.getEtudiant(affpcd.getCoEquipier3()).getNom()+" "+etD.getEtudiant(affpcd.getCoEquipier3()).getPrenom()+" et ";
			else message="";
			Message msg= new Message(0, affpcd.getCoEquipier1(), null,  date, false, "Résultat Affectation", affpcd.getCoEquipier1(), "Bonjour, \n"
					+ "Vous êtes affectés avec "+message+etD.getEtudiant(affpcd.getCoEquipier2()).getNom()+" "+etD.getEtudiant(affpcd.getCoEquipier2()).getPrenom()
					+"\n Id du groupe: "+affpcd.getId()
					+"\nSujet: "+pcdD.getPcd(affpcd.getPCD()).getSujet()
					+"\nDescription: "+pcdD.getPcd(affpcd.getPCD()).getDescription_PCD()
					+"\nEncadré par "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getPrenom()+" "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getNom());
			msgD.add(msg);
			msg=new Message(0, affpcd.getCoEquipier2(), null,  date, false, "Résultat Affectation", affpcd.getCoEquipier2(), "Bonjour, \n"
					+ "Vous êtes affectés avec "+message+etD.getEtudiant(affpcd.getCoEquipier1()).getNom()+" "+etD.getEtudiant(affpcd.getCoEquipier1()).getPrenom()
					+"\n Id du groupe: "+affpcd.getId()
					+"\nSujet: "+pcdD.getPcd(affpcd.getPCD()).getSujet()
					+"\nDescription: "+pcdD.getPcd(affpcd.getPCD()).getDescription_PCD()
					+"\nEncadré par "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getPrenom()+" "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getNom());
			msgD.add(msg);
			if(affpcd.getCoEquipier3()!=null)
			{
				msg=new Message(0, affpcd.getCoEquipier3(), null,  date, false, "Résultat Affectation", affpcd.getCoEquipier3(), "Bonjour, \n"
						+ "Vous êtes affectés avec "+etD.getEtudiant(affpcd.getCoEquipier1()).getNom()+" "+etD.getEtudiant(affpcd.getCoEquipier1()).getPrenom()+" et "+etD.getEtudiant(affpcd.getCoEquipier2()).getNom()+" "+etD.getEtudiant(affpcd.getCoEquipier2()).getPrenom()+"\n"
						+"\n Id du groupe: "+affpcd.getId()
						+"Sujet: "+pcdD.getPcd(affpcd.getPCD()).getSujet()
						+"\nDescription: "+pcdD.getPcd(affpcd.getPCD()).getDescription_PCD()
						+"\n Encadré par "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getPrenom()+" "+ensD.getEnseignant(pcdD.getPcd(affpcd.getPCD()).getEncadreur()).getNom());
				msgD.add(msg);
			}
			
		}
	}
	

	public void affectAll() {
		List<Etudiant> listEt = etD.getListEtudiant2();
		ChxPcdDao chxpcdD = new ChxPcdDao();
		List<ChxPCD> listChx;
		for (Etudiant etudiant : listEt) {
			if (!isAffected(etudiant.getId())) {
				listChx = chxpcdD.getListChoix(etudiant.getId());
				if (!listChx.isEmpty())
					affectByChoice(etudiant.getId(), listChx);
				else
					listRandomChoice.add(etudiant.getId());
			}
		}
		affectRandomChoice(listRandomChoice);
	}

	public String affectRandomChoice(List<Integer> listEt) {
		if (listEt.isEmpty())
			return null;
		int i = 0;
		if (listEt.size() % 3 == 2) {
			int alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 1),
					listEt.get(listEt.size() - 2), null);
			listPcdToAffect = pcdD.getListPcdToAffect();
		} else if (listEt.size() % 3 == 1) {
			int alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 1),
					listEt.get(listEt.size() - 2), null);
			listPcdToAffect = pcdD.getListPcdToAffect();
			alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 3),
					listEt.get(listEt.size() - 4), null);
			listPcdToAffect = pcdD.getListPcdToAffect();
		}
		for (i = 0; i < listEt.size() && !listPcdToAffect.isEmpty(); i += 3) {

			int alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(i), listEt.get(i + 1),
					listEt.get(i + 2));

			listPcdToAffect = pcdD.getListPcdToAffect();
		}
		if (i < listEt.size()) {
			FacesMessage message = new FacesMessage(
					"Il ne reste plus des sujets à affecter, Il reste "
							+ (listEt.size() - i)+" étudiants non affectés");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else {
			FacesMessage message = new FacesMessage(
					"Tous les étudiants sont affectés !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";

	}

	public void affectByChoice(int id, List<ChxPCD> listChx) {
		boolean affected = false;
		Pcd pcd;
		for (int i = 0; i < adm.getPCD_nbChoix() && !affected; i++) {
			pcd = pcdD.getPcd(listChx.get(i).getPcd());
			if (pcd.getNbAaffecter() != 0) {
				affect(pcd, listChx.get(i).getCoEquipier1(), listChx.get(i)
						.getCoEquipier2(), listChx.get(i).getCoEquipier3());
				affected = true;

			}

		}
		if (!affected) {
			listRandomChoice.add(id);
		}
	}
	
	public String publishListPcd(boolean b)
	{
	adm.setPCD_choix(b);	
	FacesMessage message;
	if(admD.add(adm))
		message = new FacesMessage("Liste Publié !");
	else 
		message = new FacesMessage("Erreur d'enregistrement !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}
}
