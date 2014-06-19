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
import model.JuryPcd;
import model.Message;
import model.Pcd;
import dao.AdminDao;
import dao.AffPcdDao;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.JuryPcdDao;
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
	private JuryPcdDao jurD = new JuryPcdDao();

	// private int idPcd=0;
	public ChefDepart getUser() {
		return user;
	}

	public void setUser(ChefDepart user) {
		this.user = user;
	}

	/*
	 * public int getIdPcd() { return idPcd; }
	 * 
	 * public void setIdPcd(int idPcd) { this.idPcd = idPcd; }
	 */

	private PcdDao pcdD = new PcdDao();
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private ChefDepart user = (ChefDepart) session.getAttribute("user");
	private List<Pcd> listPCD = pcdD.getList();
	private List<Pcd> listPCDbyDep = pcdD
			.getListPCDbyDep(user.getDepartement());

	/*
	 * private String sujet; private String description; private int encadreur;
	 * private Integer departement; private int NbAaffecter;
	 */
	private DepartementDao depD = new DepartementDao();
	private List<Departement> listDep = depD.getListDepartement();
	private AffPcdDao affpD = new AffPcdDao();
	private Integer idpcdaff;
	private boolean depotRapport;
	private boolean depotCcharge;
	private String motsCles;
	private List<JuryPcd> listJury = jurD.getList();

	public List<JuryPcd> getListJury() {
		return listJury;
	}

	public void setListJury(List<JuryPcd> listJury) {
		this.listJury = listJury;
	}

	private boolean validation;
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	private List<AffPCD> listAff = affpD.getList();
	private List<Integer> listRandomChoice = new ArrayList<Integer>();
	private List<Pcd> listPcdToAffect = pcdD.getListPcdToAffect();
	private MessageDao msgD = new MessageDao();
	private Integer idPcd = null;
	private EnseignantDao ensD = new EnseignantDao();
	private List<Enseignant> listEnseignants = ensD.getList();
	private Integer jury;
	private Pcd pcdAajouter = new Pcd(0, "", null, 0, null, 0, null);

	private Integer limit = adm.getPCD_nbSujetAjugerParProf();

	public Pcd getPcdAajouter() {
		return pcdAajouter;
	}

	public void setPcdAajouter(Pcd pcdAajouter) {
		this.pcdAajouter = pcdAajouter;
	}

	public Integer getJury() {
		return jury;
	}

	public void setJury(Integer jury) {
		this.jury = jury;
	}

	public List<Enseignant> getListEnseignants() {
		return listEnseignants;
	}

	public void setListEnseignants(List<Enseignant> listEnseignants) {
		this.listEnseignants = listEnseignants;
	}

	public List<AffPCD> getListAff() {
		return listAff;
	}

	public void setListAff(List<AffPCD> listAff) {
		this.listAff = listAff;
	}

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

	/*
	 * public String getSujet() { return sujet; }
	 * 
	 * public void setSujet(String sujet) { this.sujet = sujet; }
	 * 
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 * 
	 * public int getEncadreur() { return encadreur; }
	 * 
	 * public void setEncadreur(int encadreur) { this.encadreur = encadreur; }
	 * 
	 * public Integer getDepartement() { return departement; }
	 * 
	 * public void setDepartement(Integer departement) { this.departement =
	 * departement; }
	 * 
	 * public int getNbAaffecter() { return NbAaffecter; }
	 * 
	 * public void setNbAaffecter(int nbAaffecter) { NbAaffecter = nbAaffecter;
	 * }
	 */

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

		if (pcdD.getPcd(pcdAajouter.getSujet()) != null) {
			FacesMessage message = new FacesMessage(
					"Ce sujet est déjà enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		if (pcdAajouter.getDepartement() == 0)
			pcdAajouter.setDepartement(null);

		if (pcdD.add(pcdAajouter)) {
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

	public void notifyEtud() {
		List<AffPCD> listAff = affpD.getList();

		Date date = Calendar.getInstance().getTime();
		String message;

		for (AffPCD affpcd : listAff) {
			if(pcdD.getPcd(affpcd.getPCD()).getDepartement()==user.getDepartement())
			{
			if (affpcd.getCoEquipier3() != null)
				message = etD.getEtudiant(affpcd.getCoEquipier3()).getNom()
						+ " "
						+ etD.getEtudiant(affpcd.getCoEquipier3()).getPrenom()
						+ " et ";
			else
				message = "";
			Message msg = new Message(
					0,
					affpcd.getCoEquipier1(),
					null,
					date,
					false,
					"Résultat Affectation",
					affpcd.getCoEquipier1(),
					"Bonjour, \n"
							+ "Vous êtes affectés avec "
							+ message
							+ etD.getEtudiant(affpcd.getCoEquipier2()).getNom()
							+ " "
							+ etD.getEtudiant(affpcd.getCoEquipier2())
									.getPrenom()
							+ "\n Id du groupe: "
							+ affpcd.getId()
							+ "\nSujet: "
							+ pcdD.getPcd(affpcd.getPCD()).getSujet()
							+ "\nDescription: "
							+ pcdD.getPcd(affpcd.getPCD()).getDescription_PCD()
							+ "\nEncadré par "
							+ ensD.getEnseignant(
									pcdD.getPcd(affpcd.getPCD()).getEncadreur())
									.getPrenom()
							+ " "
							+ ensD.getEnseignant(
									pcdD.getPcd(affpcd.getPCD()).getEncadreur())
									.getNom());
			msgD.add(msg);
			msg = new Message(
					0,
					affpcd.getCoEquipier2(),
					null,
					date,
					false,
					"Résultat Affectation",
					affpcd.getCoEquipier2(),
					"Bonjour, \n"
							+ "Vous êtes affectés avec "
							+ message
							+ etD.getEtudiant(affpcd.getCoEquipier1()).getNom()
							+ " "
							+ etD.getEtudiant(affpcd.getCoEquipier1())
									.getPrenom()
							+ "\n Id du groupe: "
							+ affpcd.getId()
							+ "\nSujet: "
							+ pcdD.getPcd(affpcd.getPCD()).getSujet()
							+ "\nDescription: "
							+ pcdD.getPcd(affpcd.getPCD()).getDescription_PCD()
							+ "\nEncadré par "
							+ ensD.getEnseignant(
									pcdD.getPcd(affpcd.getPCD()).getEncadreur())
									.getPrenom()
							+ " "
							+ ensD.getEnseignant(
									pcdD.getPcd(affpcd.getPCD()).getEncadreur())
									.getNom());
			msgD.add(msg);
			if (affpcd.getCoEquipier3() != null) {
				msg = new Message(0, affpcd.getCoEquipier3(), null, date,
						false, "Résultat Affectation", affpcd.getCoEquipier3(),
						"Bonjour, \n"
								+ "Vous êtes affectés avec "
								+ etD.getEtudiant(affpcd.getCoEquipier1())
										.getNom()
								+ " "
								+ etD.getEtudiant(affpcd.getCoEquipier1())
										.getPrenom()
								+ " et "
								+ etD.getEtudiant(affpcd.getCoEquipier2())
										.getNom()
								+ " "
								+ etD.getEtudiant(affpcd.getCoEquipier2())
										.getPrenom()
								+ "\n"
								+ "\n Id du groupe: "
								+ affpcd.getId()
								+ "Sujet: "
								+ pcdD.getPcd(affpcd.getPCD()).getSujet()
								+ "\nDescription: "
								+ pcdD.getPcd(affpcd.getPCD())
										.getDescription_PCD()
								+ "\n Encadré par "
								+ ensD.getEnseignant(
										pcdD.getPcd(affpcd.getPCD())
												.getEncadreur()).getPrenom()
								+ " "
								+ ensD.getEnseignant(
										pcdD.getPcd(affpcd.getPCD())
												.getEncadreur()).getNom());
				msgD.add(msg);
			}

		}}
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
		if (listRandomChoice.size() != 1)
			affectRandomChoice(listRandomChoice);
		else {
			AffPCD randPcd = affpD.getAffof2Et().get(0);
			randPcd.setCoEquipier3(listRandomChoice.get(0));
			affpD.affect(randPcd);
		}
	}

	public String affectRandomChoice(List<Integer> listEt) {
		if (listEt.isEmpty())
			return null;
		int i = 0;
		int j = 0;
		if (listEt.size() % 3 == 2) {
			int alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 1),
					listEt.get(listEt.size() - 2), null);
			j += 2;
			listPcdToAffect = pcdD.getListPcdToAffect();
		} else if (listEt.size() % 3 == 1) {
			int alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 1),
					listEt.get(listEt.size() - 2), null);
			listPcdToAffect = pcdD.getListPcdToAffect();
			alea = (int) (Math.random() * (listPcdToAffect.size()));
			affect(listPcdToAffect.get(alea), listEt.get(listEt.size() - 3),
					listEt.get(listEt.size() - 4), null);
			j += 4;
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
							+ (listEt.size() - i-j) + " étudiants non affectés");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
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

	public String publishListPcd(boolean b) {
		adm.setPCD_choix(b);
		FacesMessage message;
		if (admD.add(adm))
			message = new FacesMessage("Liste Publié !");
		else
			message = new FacesMessage("Erreur d'enregistrement !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}

	/*
	 * public String getListEnseignantByKeyWords() { if(idPcd==null) {
	 * FacesMessage message = new
	 * FacesMessage("Selectionner un groupe valide !");
	 * FacesContext.getCurrentInstance().addMessage(null, message); return null;
	 * } listEnseignants=ensD.getList(); Pcd
	 * pcd=pcdD.getPcd(affpD.getPcdAff(idPcd).getPCD());
	 * if(!pcd.getMotsCles().isEmpty())
	 * listEnseignants=ensD.getListByKeyWords(pcd.getMotsCles().split(","));
	 * return "";
	 * 
	 * }
	 */

	public void removeJury(Integer jury) {
		List<AffPCD> listPcdJury = affpD.getListPcdOfJury(jury);
		for (AffPCD pcd : listPcdJury) {
			pcd.setJury(null);
			affpD.affect(pcd);
		}

	}

	public String affectJury() {
		Long nbaffJ = jurD.getNbAffJury(jury);
		List<AffPCD> listAffp = affpD.getAffOfPcd(idPcd);
		if ((limit - nbaffJ) < listAffp.size())
			removeJury(jury);

		for (AffPCD pcdaff : listAffp) {
			if(jurD.getNbAffJury(jury)<limit)
			{pcdaff.setJury(jury);
			affpD.affect(pcdaff);}
		}
		
		if (!jurD.getListNotAffToJury().isEmpty()) {
			FacesMessage message = new FacesMessage(
					" Il reste "
							+ jurD.getListNotAffToJury().size() + " groupes non affectés aux jurys");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Tous les groupes sont affectés aux jurys !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
		
	}

	public String affectJury4All() {
		List<Integer> listRandom = new ArrayList<Integer>();
		List<AffPCD> listNotAffectedJury=affpD.getListPcdOfJury(null);
		Pcd pcd;
		for (AffPCD pcdaff : listNotAffectedJury) {

			int idpcd = pcdaff.getId();
			pcd = pcdD.getPcd(pcdaff.getPCD());
			if (pcd.getMotsCles() == null) {
				listRandom.add(idpcd);
				listRandom.add(0);
				listRandom.add(0);
				listRandom.add(0);
			} else {
				List<Enseignant> listEns = ensD.getListByKeyWords(pcd
						.getMotsCles().split(","));
				if (listEns.isEmpty()) {
					listRandom.add(idpcd);
					listRandom.add(0);
					listRandom.add(0);
					listRandom.add(0);
				} else {
					JuryPcd jury = null;
					int i = 0;
					while (i < listEns.size() && jury == null) {
						jury = jurD.getJury(listEns.get(i).getId());
						if (jury != null
								&& jurD.getNbAffJury(jury.getId())
										.equals(limit))

						{
							listEns.remove(i);
							jury = null;
							i--;
						}

						i++;
					}
					if (jury == null) {
						if (listEns.size() == 2) {
							listRandom.add(idpcd);
							listRandom.add(listEns.get(0).getId());
							listRandom.add(listEns.get(1).getId());
							listRandom.add(0);
						} else if (listEns.size() == 1) {
							listRandom.add(idpcd);
							listRandom.add(listEns.get(0).getId());
							listRandom.add(0);
							listRandom.add(0);
						} else {
							JuryPcd juryA = new JuryPcd(0, listEns.get(0)
									.getId(), listEns.get(1).getId(), listEns
									.get(2).getId());
							jurD.add(juryA);
							pcdaff.setJury(jurD.getJury(juryA.getMembre1())
									.getId());
							affpD.affect(pcdaff);

						}
					} else {
						pcdaff.setJury(jury.getId());
						affpD.affect(pcdaff);
					}

				}
			}

		}
		RandomAffectJury(listRandom);
		if (!jurD.getListNotAffToJury().isEmpty()) {
			FacesMessage message = new FacesMessage(
					" Il reste "
							+ jurD.getListNotAffToJury().size() + " groupes non affectés aux jurys");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Tous les groupes sont affectés aux jurys !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";

	}

	public String RandomAffectJury(List<Integer> listRand) {
		for (int i = 0; i < listRand.size(); i += 4) {
			AffPCD pcdaff = affpD.getPcdAff(listRand.get(i));
			List<Enseignant> listNotAffToJury = jurD.getListNotAffToJury();
			if (listRand.get(i + 1).equals(0)) {
				if (listNotAffToJury.size() >= 3) {
					JuryPcd jury = new JuryPcd(0, listNotAffToJury.get(0)
							.getId(), listNotAffToJury.get(1).getId(),
							listNotAffToJury.get(2).getId());
					jurD.add(jury);
					pcdaff.setJury(jurD.getJury(jury.getMembre1()).getId());
					affpD.affect(pcdaff);
				} else {
					int j = 0;
					List<JuryPcd> list = jurD.getList();
					
					while (jurD.getNbAffJury(list.get(j).getId()).toString().equals(limit.toString()))
						j++;
					pcdaff.setJury(list.get(j).getId());
					affpD.affect(pcdaff);

				}
			} else {
				JuryPcd jury = jurD.getJury(listRand.get(i + 1));
				if (jury == null) {
					if (listRand.get(i + 2).equals(0)) {
						listNotAffToJury = jurD.getListNotAffToJury();
						if (listNotAffToJury.size() >= 2) {
							JuryPcd juryN = new JuryPcd(0, listRand.get(i + 1),
									listNotAffToJury.get(0).getId(),
									listNotAffToJury.get(1).getId());
							jurD.add(juryN);
							pcdaff.setJury(jurD.getJury(juryN.getMembre1())
									.getId());
							affpD.affect(pcdaff);
						} else {
							int j = 0;
							List<JuryPcd> list = jurD.getList();
							while (jurD.getNbAffJury(list.get(j).getId())
									.equals(limit))

								j++;
							pcdaff.setJury(list.get(j).getId());
							affpD.affect(pcdaff);
						}
					} else {
						JuryPcd jury2 = jurD.getJury(listRand.get(i + 2));
						if (jury2 == null) {
							if (listRand.get(i + 2).equals(0)) {
								listNotAffToJury = jurD.getListNotAffToJury();
								if (listNotAffToJury.size() >= 1) {
									JuryPcd juryN = new JuryPcd(0,
											listRand.get(i + 1),
											listRand.get(i + 2),
											listNotAffToJury.get(0).getId());
									jurD.add(juryN);
									pcdaff.setJury(jurD.getJury(
											juryN.getMembre1()).getId());
									affpD.affect(pcdaff);
								} else {
									int j = 0;
									List<JuryPcd> list = jurD.getList();
									while (jurD.getNbAffJury(
											list.get(j).getId()).equals(limit))

										j++;
									pcdaff.setJury(list.get(j).getId());
									affpD.affect(pcdaff);
								}
							} else {
								JuryPcd jury3 = jurD.getJury(listRand
										.get(i + 3));
								if (jury3 == null) {
									if (listRand.get(i + 3).equals(0)) {
										listNotAffToJury = jurD
												.getListNotAffToJury();
										if (listNotAffToJury.size() >= 1) {
											JuryPcd juryN = new JuryPcd(0,
													listRand.get(i + 1),
													listRand.get(i + 2),
													listNotAffToJury.get(0)
															.getId());
											jurD.add(juryN);
											pcdaff.setJury(jurD.getJury(
													juryN.getMembre1()).getId());
											affpD.affect(pcdaff);
										} else {
											int j = 0;
											List<JuryPcd> list = jurD.getList();
											while (jurD.getNbAffJury(
													list.get(j).getId())
													.equals(limit))

												j++;
											pcdaff.setJury(list.get(j).getId());
											affpD.affect(pcdaff);
										}
									} else {
										JuryPcd juryNN = new JuryPcd(0,
												listRand.get(i + 1),
												listRand.get(i + 2),
												listRand.get(i + 3));
										jurD.add(juryNN);
										pcdaff.setJury(jurD.getJury(
												juryNN.getMembre1()).getId());
										affpD.affect(pcdaff);
									}
								}
								{
									if (jurD.getNbAffJury(jury3.getId())
											.equals(limit)) {
										listRand.add(listRand.get(i));
										listRand.add(listRand.get(i + 1));
										listRand.add(listRand.get(i + 2));
										listRand.add(0);
									} else {
										pcdaff.setJury(jury3.getId());
										affpD.affect(pcdaff);
									}
								}
							}
						} else {
							if (jurD.getNbAffJury(jury2.getId()).equals(limit)) {
								listRand.add(listRand.get(i));
								listRand.add(listRand.get(i + 1));
								listRand.add(listRand.get(i + 3));
								listRand.add(0);
							} else {
								pcdaff.setJury(jury2.getId());
								affpD.affect(pcdaff);
							}
						}
					}
				} else {
					if (jurD.getNbAffJury(jury.getId()).equals(limit)) {
						listRand.add(listRand.get(i));
						listRand.add(listRand.get(i + 2));
						listRand.add(listRand.get(i + 3));
						listRand.add(0);
					} else {
						pcdaff.setJury(jury.getId());
						affpD.affect(pcdaff);
					}

				}
			}
		}
		return "";
	}

	public String AfficheEnseignant(int id) {

		return ensD.getEnseignant(id).getNom() + " "
				+ ensD.getEnseignant(id).getPrenom();
	}

	public List<Pcd> getListPCDbyDep() {
		return listPCDbyDep;
	}

	public void setListPCDbyDep(List<Pcd> listPCDbyDep) {
		this.listPCDbyDep = listPCDbyDep;
	}

	public String getPcd() {
		pcdAajouter = pcdD.getPcd(pcdAajouter.getId());
		return "";
	}

	public Integer getIdPcd() {
		return idPcd;
	}

	public void setIdPcd(Integer idPcd) {
		this.idPcd = idPcd;
	}
}
