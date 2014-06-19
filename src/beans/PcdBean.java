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
import model.ChxPCD;
import model.Enseignant;
import model.Etudiant;
import model.Pcd;
import dao.AdminDao;
import dao.AffPcdDao;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.PcdDao;

@ManagedBean
@RequestScoped
public class PcdBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Etudiant user = (Etudiant) session.getAttribute("user");

	private PcdDao pcdD = new PcdDao();
	private List<Pcd> listPCD = pcdD.getList();
	private List<Enseignant> listENS;
	private List<ChxPCD> listChx = new ArrayList<ChxPCD>();
	private DepartementDao depD = new DepartementDao();
	private ChxPcdDao chxpcdD = new ChxPcdDao();
	private EnseignantDao ensD = new EnseignantDao();
	private Date date = Calendar.getInstance().getTime();
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	private EtudiantDao etD=new EtudiantDao();
	private Integer coEquip2 = null;
	private Integer coEquip3 = null;

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

	public void setListChx(List<ChxPCD> listChx) {
		this.listChx = listChx;
	}

	public ChxPcdDao getChxDao() {
		return chxpcdD;
	}

	public void setChxDao(ChxPcdDao chxDao) {
		this.chxpcdD = chxDao;
	}

	public DepartementDao getDepD() {
		return depD;
	}

	public void setDepD(DepartementDao depD) {
		this.depD = depD;
	}

	public PcdDao getPcdD() {
		return pcdD;
	}

	public void setPcdD(PcdDao pcdD) {
		this.pcdD = pcdD;
	}

	public EnseignantDao getEnsD() {
		return ensD;
	}

	public void setEnsD(EnseignantDao ensD) {
		this.ensD = ensD;
	}

	public List<Pcd> getListPCD() {

		return listPCD;
	}

	public void setListPCD(List<Pcd> listPCD) {
		this.listPCD = listPCD;
	}

	public List<Enseignant> getListENS() {
		return listENS;
	}

	public void setListENS(List<Enseignant> listENS) {
		this.listENS = listENS;
	}

	public PcdBean() {
		listChx = chxpcdD.getListChoix(user.getId());
		initListChx(listChx);
		ArrayList<Integer> listCoEquip=getCoEquipiers(user.getId());
		coEquip2 = listCoEquip.get(0);
		coEquip3 = listCoEquip.get(1);
		System.out.print("Constructeur PcdBean");
	}

	public String AfficheEnseignant(int id) {

		return ensD.getEnseignant(id).getNom() + " "
				+ ensD.getEnseignant(id).getPrenom();
	}

	public void initListChx(List<ChxPCD> list) {

		if (list.isEmpty())
			for (int i = 0; i < adm.getPCD_nbChoix(); i++) {
				list.add(new ChxPCD(0, user.getId(), 0, i + 1, null, null));
			}

	}

	public String AfficheDepartement(int id) {

		if (id!=0) return depD.getDepartement(id).getNom();
		else return null;
	}

	public boolean isAffected(int id) {
		if (id == 0)
			return false;
		AffPcdDao affpD = new AffPcdDao();
		if (affpD.getAffect(id) != null) {
			FacesMessage message = new FacesMessage(id + " est déjà affecté !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return true;
		}
		return false;

	}

	public String SaisirChoixPCD(ActionEvent event) {

		if (!isAffected(user.getId()) && !isAffected(coEquip2)
				&& !isAffected(coEquip3)) {
			List<ChxPCD> listChxCoE2 = chxpcdD.getListChoix(coEquip2);

			if ((!listChxCoE2.isEmpty())
					&& (listChxCoE2.get(0).getId() != listChx.get(0).getId())) {
				FacesMessage message = new FacesMessage(coEquip2
						+ " est déjà engagé avec une autre équipe !");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;

			}
			if (coEquip3 != 0) {
				List<ChxPCD> listChxCoE3 = chxpcdD.getListChoix(coEquip3);

				if ((!listChxCoE3.isEmpty())
						&& (listChxCoE3.get(0).getId() != listChx.get(0)
								.getId())) {
					FacesMessage message = new FacesMessage(coEquip3
							+ " est déjà engagé avec une autre équipe !");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				}

			}
			if((user.getDepartement()==etD.getEtudiant(coEquip2).getDepartement()) && (user.getDepartement()==etD.getEtudiant(coEquip3).getDepartement()))
			{
			for (ChxPCD chx : listChx) {
				chx.setCoEquipier1(user.getId());
				chx.setCoEquipier2(coEquip2);
				if (coEquip3 != 0)
					chx.setCoEquipier3(coEquip3);
				else
					chx.setCoEquipier3(null);
				chxpcdD.add(chx);

			}

			FacesMessage message = new FacesMessage(" Enregistré !");
			FacesContext.getCurrentInstance().addMessage(null, message);}
			else 
			{
				FacesMessage message = new FacesMessage(" Vous n'êtes pas de même départements !");
				FacesContext.getCurrentInstance().addMessage(null, message);	
			}
			return "";
		} else
			return null;

	}

	public List<ChxPCD> getListChx() {
		return listChx;
	}
	
	public ArrayList<Integer> getCoEquipiers(int id)
	{
		List<ChxPCD> listChx=chxpcdD.getListChoix(id);
		ArrayList<Integer> listCoEquip=new ArrayList<Integer>();
		if(listChx.isEmpty())
		{
			listCoEquip.add(null);
			listCoEquip.add(null);
		}
		else if(listChx.get(0).getCoEquipier1()==id)
		{
			listCoEquip.add(listChx.get(0).getCoEquipier2());
			listCoEquip.add(listChx.get(0).getCoEquipier3());
		}
		else if(listChx.get(0).getCoEquipier2()==id)
		{
			listCoEquip.add(listChx.get(0).getCoEquipier1());
			listCoEquip.add(listChx.get(0).getCoEquipier3());
		}
		else if(listChx.get(0).getCoEquipier3()==id)
		{
			listCoEquip.add(listChx.get(0).getCoEquipier1());
			listCoEquip.add(listChx.get(0).getCoEquipier2());
		}
		return listCoEquip;
		
	}

}
