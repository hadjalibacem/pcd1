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
import model.AffProjProg;
import model.ChefDepart;
import model.ChxProjProg;
import model.Enseignant;
import model.Etudiant;
import model.JuryPp;
import model.Message;
import model.Projet_prog;
import dao.AdminDao;
import dao.AffProjProgDao;
import dao.ChxProjProgDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.JuryPpDao;
import dao.MessageDao;
import dao.Proj_progDao;

@ManagedBean
@RequestScoped
public class ChPpBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer coEquip1 = null;
	private Integer coEquip2 = null;
	private int idPpAaffecter;
	private JuryPpDao jurD = new JuryPpDao();

	public JuryPpDao getJurD() {
		return jurD;
	}

	public void setJurD(JuryPpDao jurD) {
		this.jurD = jurD;
	}

	public ChefDepart getUser() {
		return user;
	}

	public void setUser(ChefDepart user) {
		this.user = user;
	}

	

	private Proj_progDao ppD = new Proj_progDao();
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	

	HttpSession session = request.getSession();
	private ChefDepart user = (ChefDepart) session.getAttribute("user");
	private List<Projet_prog> listPP = ppD.getList();

	private Date date = Calendar.getInstance().getTime();
	private AffProjProgDao affpD = new AffProjProgDao();
	private Integer idppaff;
	private boolean depotRapport;
	private String motsCles;
	private List<JuryPp> listJury = jurD.getList();

	public List<JuryPp> getListJury() {
		return listJury;
	}

	public void setListJury(List<JuryPp> listJury) {
		this.listJury = listJury;
	}

	private boolean validation;
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	private List<AffProjProg> listAff = affpD.getList();
	private List<Integer> listRandomChoice = new ArrayList<Integer>();
	private List<Projet_prog> listPpToAffect = ppD.getListPpToAffect();
	private MessageDao msgD = new MessageDao();
	private Integer idPp = null;
	private EnseignantDao ensD = new EnseignantDao();
	private List<Enseignant> listEnseignants = ensD.getList();
	private Integer jury;
	private Projet_prog ppAajouter = new Projet_prog(0, "", null, 0, 0, null);

	private Integer limit = adm.getPP_nbSujetAjugerParProf();
	private EtudiantDao etD= new EtudiantDao();
	


	public Integer getCoEquip1() {
		return coEquip1;
	}

	public void setCoEquip1(Integer coEquip1) {
		this.coEquip1 = coEquip1;
	}

	public EtudiantDao getEtD() {
		return etD;
	}

	public void setEtD(EtudiantDao etD) {
		this.etD = etD;
	}

	public Integer getCoEquip2() {
		return coEquip2;
	}

	public void setCoEquip2(Integer coEquip2) {
		this.coEquip2 = coEquip2;
	}

	public int getIdPpAaffecter() {
		return idPpAaffecter;
	}

	public void setIdPpAaffecter(int idPpAaffecter) {
		this.idPpAaffecter = idPpAaffecter;
	}

	public Proj_progDao getPpD() {
		return ppD;
	}

	public void setPpD(Proj_progDao ppD) {
		this.ppD = ppD;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<Projet_prog> getListPP() {
		return listPP;
	}

	public void setListPP(List<Projet_prog> listPP) {
		this.listPP = listPP;
	}

	public AffProjProgDao getAffpD() {
		return affpD;
	}

	public void setAffpD(AffProjProgDao affpD) {
		this.affpD = affpD;
	}

	public Integer getIdppaff() {
		return idppaff;
	}

	public void setIdppaff(Integer idppaff) {
		this.idppaff = idppaff;
	}

	public boolean isDepotRapport() {
		return depotRapport;
	}

	public void setDepotRapport(boolean depotRapport) {
		this.depotRapport = depotRapport;
	}

	public String getMotsCles() {
		return motsCles;
	}

	public void setMotsCles(String motsCles) {
		this.motsCles = motsCles;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public AdminDao getAdmD() {
		return admD;
	}

	public void setAdmD(AdminDao admD) {
		this.admD = admD;
	}

	public Administration getAdm() {
		return adm;
	}

	public void setAdm(Administration adm) {
		this.adm = adm;
	}

	public List<AffProjProg> getListAff() {
		return listAff;
	}

	public void setListAff(List<AffProjProg> listAff) {
		this.listAff = listAff;
	}

	public List<Integer> getListRandomChoice() {
		return listRandomChoice;
	}

	public void setListRandomChoice(List<Integer> listRandomChoice) {
		this.listRandomChoice = listRandomChoice;
	}

	public List<Projet_prog> getListPpToAffect() {
		return listPpToAffect;
	}

	public void setListPpToAffect(List<Projet_prog> listPpToAffect) {
		this.listPpToAffect = listPpToAffect;
	}

	public MessageDao getMsgD() {
		return msgD;
	}

	public void setMsgD(MessageDao msgD) {
		this.msgD = msgD;
	}

	public Integer getIdPp() {
		return idPp;
	}

	public void setIdPp(Integer idPp) {
		this.idPp = idPp;
	}

	public EnseignantDao getEnsD() {
		return ensD;
	}

	public void setEnsD(EnseignantDao ensD) {
		this.ensD = ensD;
	}

	public List<Enseignant> getListEnseignants() {
		return listEnseignants;
	}

	public void setListEnseignants(List<Enseignant> listEnseignants) {
		this.listEnseignants = listEnseignants;
	}

	public Integer getJury() {
		return jury;
	}

	public void setJury(Integer jury) {
		this.jury = jury;
	}

	public Projet_prog getPpAajouter() {
		return ppAajouter;
	}

	public void setPpAajouter(Projet_prog ppAajouter) {
		this.ppAajouter = ppAajouter;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/* Forcer l'affectation des etudiants même s'il sont affectés */
	public String affecter() {
		
		
		if (coEquip2 == 0)
			coEquip2 = null;

		affpD.removeCoEquip(coEquip1);
		if (coEquip2 != null)
			affpD.removeCoEquip(coEquip2);
		Projet_prog pp = ppD.getPp(idPpAaffecter);
		if (pp.getNbAaffecter() > 0)
			affect(pp, coEquip1, coEquip2);
		else {
			FacesMessage message = new FacesMessage(
					"Ce sujet a atteint le nombre limite d'affectation !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}
		

		

		FacesMessage message = new FacesMessage("Groupe affecté !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";

	}

	public void affect(Projet_prog pp, int coEquip1, Integer coEquip2) {
		AffProjProg affpp = new AffProjProg(0, coEquip1, pp.getId(), coEquip2, null, null, null, null);
		if (affpD.affect(affpp)) {
			pp.setNbAaffecter(pp.getNbAaffecter() - 1);
			ppD.add(pp);
		}
	}

	public boolean isAffected(int id) {
		if (id == 0)
			return false;
		if (affpD.getAffect(id) != null)

			return true;

		return false;

	}

	public String AddPp() {

		if (ppD.getPp(ppAajouter.getSujet()) != null && ppAajouter.getId()==0) {
			FacesMessage message = new FacesMessage(
					"Ce sujet est déjà enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		}

		if (ppD.add(ppAajouter)) {
			FacesMessage message = new FacesMessage("Sujet ajouté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Erreur d'enregistrement  !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}

	public String updateListPp() {
		for (Projet_prog pp : listPP) {
			ppD.add(pp);
		}
		return "";
	}

	

	public Integer getIdPpaff() {
		return idppaff;
	}

	public void setIdPpaff(Integer idppaff) {
		this.idppaff = idppaff;
	}

	public String updateAffpp() {

		AffProjProg affpp = affpD.getPpAff(idppaff);
		if(affpp!=null)
				{
		affpp.setDepotRapport(depotRapport);
		affpp.setResultat(validation);
		if (affpD.affect(affpp)) {
			FacesMessage message = new FacesMessage("Enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage("Erreur d'enregistrement !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
				}
		else
			
		{
			FacesMessage message = new FacesMessage("Inexistant !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	public void notifyEtud() {
		List<AffProjProg> listAff = affpD.getList();

		Date date = Calendar.getInstance().getTime();
		String message;

		for (AffProjProg affpp : listAff) {
			
				if (affpp.getCoEquipier2() != null)
					message = etD.getEtudiant(affpp.getCoEquipier2()).getNom()
							+ " "
							+ etD.getEtudiant(affpp.getCoEquipier2())
									.getPrenom() ;
				else
					message = "";
				Message msg = new Message(0, affpp.getCoEquipier1(), null,
						date, false, "Résultat Affectation",
						affpp.getCoEquipier1(), "Bonjour, \n"
								+ "Vous êtes affectés avec "
								+ message
								
								+ "\n Id du groupe: "
								+ affpp.getId()
								+ "\nSujet: "
								+ ppD.getPp(affpp.getProj_prog()).getSujet()
								+ "\nDescription: "
								+ ppD.getPp(affpp.getProj_prog())
										.getDescription_PP()
								+ "\nEncadré par "
								+ ensD.getEnseignant(
										ppD.getPp(affpp.getProj_prog())
												.getEncadreur()).getPrenom()
								+ " "
								+ ensD.getEnseignant(
										ppD.getPp(affpp.getProj_prog())
												.getEncadreur()).getNom());
				msgD.add(msg);
				
				if (affpp.getCoEquipier2() != null) {
					msg = new Message(0, affpp.getCoEquipier2(), null, date,
							false, "Résultat Affectation",
							affpp.getCoEquipier2(), "Bonjour, \n"
									+ "Vous êtes affectés avec "
									+ etD.getEtudiant(affpp.getCoEquipier1())
											.getNom()
									+ " "
									+ etD.getEtudiant(affpp.getCoEquipier1())
											.getPrenom()
									
									+ "\n"
									+ "\n Id du groupe: "
									+ affpp.getId()
									+ "Sujet: "
									+ ppD.getPp(affpp.getProj_prog()).getSujet()
									+ "\nDescription: "
									+ ppD.getPp(affpp.getProj_prog())
											.getDescription_PP()
									+ "\n Encadré par "
									+ ensD.getEnseignant(
											ppD.getPp(affpp.getProj_prog())
													.getEncadreur())
											.getPrenom()
									+ " "
									+ ensD.getEnseignant(
											ppD.getPp(affpp.getProj_prog())
													.getEncadreur()).getNom());
					msgD.add(msg);
				}

			
		}
	}

	public void affectAll() {
		List<Etudiant> listEt = etD.getListEtudiant2();
		ChxProjProgDao chxppD = new ChxProjProgDao();
		List<ChxProjProg> listChx;
		for (Etudiant etudiant : listEt) {
			if (!isAffected(etudiant.getId())) {
				listChx = chxppD.getListChoix(etudiant.getId());
				if (!listChx.isEmpty())
					affectByChoice(etudiant.getId(), listChx);
				else
					listRandomChoice.add(etudiant.getId());
			}
		}
		if (listRandomChoice.size() != 1)
			affectRandomChoice(listRandomChoice);
		else {
			AffProjProg randPp = affpD.getAffof1Et().get(0);
			randPp.setCoEquipier2(listRandomChoice.get(0));
			affpD.affect(randPp);
		}
	}

	public String affectRandomChoice(List<Integer> listEt) {
		if (listEt.isEmpty())
			return null;
		int i = 0;
		int j = 0;
		if (listEt.size() % 2 == 1) {
			int alea = (int) (Math.random() * (listPpToAffect.size()));
			affect(listPpToAffect.get(alea), listEt.get(listEt.size() - 1), null);
			j += 1;
			listPpToAffect = ppD.getListPpToAffect();
		} 
		for (i = 0; i < listEt.size() && !listPpToAffect.isEmpty(); i += 2) {

			int alea = (int) (Math.random() * (listPpToAffect.size()));
			affect(listPpToAffect.get(alea), listEt.get(i), listEt.get(i + 1));

			listPpToAffect = ppD.getListPpToAffect();
		}
		if (i < listEt.size()) {
			FacesMessage message = new FacesMessage(
					"Il ne reste plus des sujets à affecter, Il reste "
							+ (listEt.size() - i - j)
							+ " étudiants non affectés");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Tous les étudiants sont affectés !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";

	}

	public void affectByChoice(int id, List<ChxProjProg> listChx) {
		boolean affected = false;
		Projet_prog pp;
		for (int i = 0; i < adm.getPP_nbChoix() && !affected; i++) {
			pp = ppD.getPp(listChx.get(i).getProj_prog());
			if (pp.getNbAaffecter() != 0) {
				affect(pp, listChx.get(i).getCoEquipier1(), listChx.get(i)
						.getCoEquipier2());
				affected = true;

			}

		}
		if (!affected) {
			listRandomChoice.add(id);
		}
	}

	public String publishListPp(boolean b) {
		adm.setPP_choix(b);
		FacesMessage message;
		if (admD.add(adm))
			message = new FacesMessage("Liste Publié !");
		else
			message = new FacesMessage("Erreur d'enregistrement !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}



	public void removeJury(Integer jury) {
		List<AffProjProg> listPpJury = affpD.getListPpOfJury(jury);
		for (AffProjProg pp : listPpJury) {
			pp.setJury(null);
			affpD.affect(pp);
		}

	}

	public String affectJury() {
		Long nbaffJ = jurD.getNbAffJury(jury);
		List<AffProjProg> listAffp = affpD.getAffOfPp(idPp);
		if ((limit - nbaffJ) < listAffp.size())
			removeJury(jury);

		for (AffProjProg ppaff : listAffp) {
			if(jury==0) jury=null;
			if (jurD.getNbAffJury(jury) < limit) {

				ppaff.setJury(jury);
				affpD.affect(ppaff);
			}
		}

		if (!affpD.getListPpOfJury(null).isEmpty()) {
			FacesMessage message = new FacesMessage(" Il reste "
					+ affpD.getListPpOfJury(null).size()
					+ " groupes non affectés aux jurys");
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
		List<AffProjProg> listNotAffectedJury = affpD.getListPpOfJury(null);
		Projet_prog pp;
		for (AffProjProg ppaff : listNotAffectedJury) {
			
			int idpp = ppaff.getId();
			pp = ppD.getPp(ppaff.getProj_prog());
			
			if (pp.getMotsCles() == null) {
				listRandom.add(idpp);
				listRandom.add(0);
				listRandom.add(0);
			} else {
				List<Enseignant> listEns = ensD.getListByKeyWords(pp
						.getMotsCles().split(","));
				if (listEns.isEmpty()) {
					listRandom.add(idpp);
					listRandom.add(0);
					listRandom.add(0);
				} else {
					JuryPp jury = null;
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
						if (listEns.size() == 1) {
							listRandom.add(idpp);
							listRandom.add(listEns.get(0).getId());
							listRandom.add(0);
						
						} else {
							JuryPp juryA = new JuryPp(0, listEns.get(0)
									.getId(), listEns.get(1).getId());
							jurD.add(juryA);
							ppaff.setJury(jurD.getJury(juryA.getMembre1())
									.getId());
							affpD.affect(ppaff);

						}
					} else {
						ppaff.setJury(jury.getId());
						affpD.affect(ppaff);
					}

				}
			}

		}
		
		RandomAffectJury(listRandom);
		if (!affpD.getListPpOfJury(null).isEmpty()) {
			FacesMessage message = new FacesMessage(" Il reste "
					+ affpD.getListPpOfJury(null).size()
					+ " groupes non affectés aux jurys");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					"Tous les groupes sont affectés aux jurys !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";

	}

	public String RandomAffectJury(List<Integer> listRand) {
		for (int i = 0; i < listRand.size(); i += 3) {
			AffProjProg ppaff = affpD.getPpAff(listRand.get(i));
			List<Enseignant> listNotAffToJury = jurD.getListNotAffToJury();
			if (listRand.get(i + 1).equals(0)) {
				if (listNotAffToJury.size() >= 2) {
					JuryPp jury = new JuryPp(0, listNotAffToJury.get(0)
							.getId(), listNotAffToJury.get(1).getId());
					jurD.add(jury);
					ppaff.setJury(jurD.getJury(jury.getMembre1()).getId());
					affpD.affect(ppaff);
				} else {
					int j = 0;
					List<JuryPp> list = jurD.getList();

					while (jurD.getNbAffJury(list.get(j).getId()).toString()
							.equals(limit.toString()))
						j++;
					ppaff.setJury(list.get(j).getId());
					affpD.affect(ppaff);

				}
			} else {
				JuryPp jury = jurD.getJury(listRand.get(i + 1));
				if (jury == null) {
					if (listRand.get(i + 2).equals(0)) {
						listNotAffToJury = jurD.getListNotAffToJury();
						if (listNotAffToJury.size() >= 1) {
							JuryPp juryN = new JuryPp(0, listRand.get(i + 1),
									listNotAffToJury.get(0).getId());
							jurD.add(juryN);
							ppaff.setJury(jurD.getJury(juryN.getMembre1())
									.getId());
							affpD.affect(ppaff);
						} else {
							int j = 0;
							List<JuryPp> list = jurD.getList();
							while (jurD.getNbAffJury(list.get(j).getId())
									.equals(limit))

								j++;
							ppaff.setJury(list.get(j).getId());
							affpD.affect(ppaff);
						}
					} else {
						JuryPp jury2 = jurD.getJury(listRand.get(i + 2));
						if (jury2 == null) {
							if (listRand.get(i + 2).equals(0)) {
								listNotAffToJury = jurD.getListNotAffToJury();
								if (listNotAffToJury.size() >= 0) {
									JuryPp juryN = new JuryPp(0,
											listRand.get(i + 1),
											listRand.get(i + 2));
									jurD.add(juryN);
									ppaff.setJury(jurD.getJury(
											juryN.getMembre1()).getId());
									affpD.affect(ppaff);
								} else {
									int j = 0;
									List<JuryPp> list = jurD.getList();
									while (jurD.getNbAffJury(
											list.get(j).getId()).equals(limit))

										j++;
									ppaff.setJury(list.get(j).getId());
									affpD.affect(ppaff);
								}
							} else {
								JuryPp jury3 = jurD.getJury(listRand
										.get(i + 3));
								if (jury3 == null) {
									if (listRand.get(i + 3).equals(0)) {
										listNotAffToJury = jurD
												.getListNotAffToJury();
										if (listNotAffToJury.size() >= 1) {
											JuryPp juryN = new JuryPp(0,
													listRand.get(i + 1),
													listRand.get(i + 2));
											jurD.add(juryN);
											ppaff.setJury(jurD.getJury(
													juryN.getMembre1()).getId());
											affpD.affect(ppaff);
										} else {
											int j = 0;
											List<JuryPp> list = jurD.getList();
											while (jurD.getNbAffJury(
													list.get(j).getId())
													.equals(limit))

												j++;
											ppaff.setJury(list.get(j).getId());
											affpD.affect(ppaff);
										}
									} else {
										JuryPp juryNN = new JuryPp(0,
												listRand.get(i + 1),
												listRand.get(i + 2));
										jurD.add(juryNN);
										ppaff.setJury(jurD.getJury(
												juryNN.getMembre1()).getId());
										affpD.affect(ppaff);
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
										ppaff.setJury(jury3.getId());
										affpD.affect(ppaff);
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
								ppaff.setJury(jury2.getId());
								affpD.affect(ppaff);
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
						ppaff.setJury(jury.getId());
						affpD.affect(ppaff);
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
	public String AfficheEtudiant(Integer id)
	{
		if(id==0 || id==null) return null;
		Etudiant et=etD.getEtudiant(id);
		return et.getNom()+" "+et.getPrenom();
	}

	

	public String getPp() {
		ppAajouter = ppD.getPp(ppAajouter.getId());
		return "";
	}

	
	public String AfficheEncadrant(int ppaff)
	{
		Projet_prog pp=ppD.getPp(ppaff);
	return AfficheEnseignant(pp.getEncadreur());
	
	}
	public String AfficheJury(Integer jury)
	{
		if (jury==0 ||jury==null)
			return null;
		JuryPp jur=jurD.getJuryById(jury);
		return AfficheEnseignant(jur.getMembre1())+", "+AfficheEnseignant(jur.getMembre2())+" et "+AfficheEnseignant(jur.getMembre3());
	}
}
