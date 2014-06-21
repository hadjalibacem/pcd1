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

import dao.AdminDao;
import dao.AffProjProgDao;
import dao.ChxProjProgDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.Proj_progDao;
import model.Administration;
import model.ChxProjProg;
import model.Enseignant;
import model.Etudiant;
import model.Projet_prog;



@ManagedBean
@RequestScoped
public class PpBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Etudiant user = (Etudiant) session.getAttribute("user");

	private Proj_progDao ppD = new Proj_progDao();
	private List<Projet_prog> listPP = ppD.getList();
	private List<Enseignant> listENS;
	private List<ChxProjProg> listChx = new ArrayList<ChxProjProg>();
	private ChxProjProgDao chxppD = new ChxProjProgDao();
	private EnseignantDao ensD = new EnseignantDao();
	private Date date = Calendar.getInstance().getTime();
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	private EtudiantDao etD=new EtudiantDao();
	private Integer coEquip2 = null;

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

	public Etudiant getUser() {
		return user;
	}

	public void setUser(Etudiant user) {
		this.user = user;
	}

	public Proj_progDao getPpD() {
		return ppD;
	}

	public void setPpD(Proj_progDao ppD) {
		this.ppD = ppD;
	}

	public List<Projet_prog> getListPP() {
		return listPP;
	}

	public void setListPP(List<Projet_prog> listPP) {
		this.listPP = listPP;
	}

	public List<Enseignant> getListENS() {
		return listENS;
	}

	public void setListENS(List<Enseignant> listENS) {
		this.listENS = listENS;
	}

	

	public ChxProjProgDao getChxppD() {
		return chxppD;
	}

	public void setChxppD(ChxProjProgDao chxppD) {
		this.chxppD = chxppD;
	}

	public EnseignantDao getEnsD() {
		return ensD;
	}

	public void setEnsD(EnseignantDao ensD) {
		this.ensD = ensD;
	}

	public EtudiantDao getEtD() {
		return etD;
	}

	public void setEtD(EtudiantDao etD) {
		this.etD = etD;
	}

	public void setListChx(List<ChxProjProg> listChx) {
		this.listChx = listChx;
	}

	public Integer getCoEquip2() {
		return coEquip2;
	}

	public void setCoEquip2(Integer coEquip2) {
		this.coEquip2 = coEquip2;
	}

	

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	

	public PpBean() {
		listChx = chxppD.getListChoix(user.getId());
		initListChx(listChx);
		ArrayList<Integer> listCoEquip=getCoEquipiers(user.getId());
		coEquip2 = listCoEquip.get(0);
	}

	public String AfficheEnseignant(int id) {

		return ensD.getEnseignant(id).getNom() + " "
				+ ensD.getEnseignant(id).getPrenom();
	}

	public void initListChx(List<ChxProjProg> list) {

		if (list.isEmpty())
			for (int i = 0; i < adm.getPP_nbChoix(); i++) {
				list.add(new ChxProjProg(0, user.getId(), 0, i + 1, null));
			}

	}

	

	public boolean isAffected(int id) {
		if (id == 0)
			return false;
		AffProjProgDao affpD = new AffProjProgDao();
		if (affpD.getAffect(id) != null) {
			FacesMessage message = new FacesMessage(id + " est déjà affecté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return true;
		}
		return false;

	}

	public String SaisirChoixPP(ActionEvent event) {

		if (!isAffected(user.getId()) && !isAffected(coEquip2)) {

			
			if (coEquip2 != 0) {
				List<ChxProjProg> listChxCoE2 = chxppD.getListChoix(coEquip2);

				if ((!listChxCoE2.isEmpty())
						&& (listChxCoE2.get(0).getId() != listChx.get(0)
								.getId())) {
					FacesMessage message = new FacesMessage(coEquip2
							+ " est déjà engagé avec une autre équipe !");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				}

			}
			
			for (ChxProjProg chx : listChx) {
				chx.setCoEquipier1(user.getId());
				if (coEquip2 != 0)
					chx.setCoEquipier2(coEquip2);
				else
					chx.setCoEquipier2(null);
				chxppD.add(chx);

			}

			FacesMessage message = new FacesMessage(" Enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);}
			
			return "";
		} 

	

	public List<ChxProjProg> getListChx() {
		return listChx;
	}
	
	public ArrayList<Integer> getCoEquipiers(int id)
	{
		List<ChxProjProg> listChx=chxppD.getListChoix(id);
		ArrayList<Integer> listCoEquip=new ArrayList<Integer>();
		if(listChx.isEmpty())
		{
			listCoEquip.add(null);
		}
		else if(listChx.get(0).getCoEquipier1()==id)
		{
			listCoEquip.add(listChx.get(0).getCoEquipier2());
		}
		else if(listChx.get(0).getCoEquipier2()==id)
		{
			listCoEquip.add(listChx.get(0).getCoEquipier1());
		}
		
		return listCoEquip;
		
	}

}
