package beans;

import java.io.Serializable;
//import java.util.List;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Administration;
import model.ChxPCD;
import model.Enseignant;
import model.Etudiant;
import model.Message;
import model.Pcd;
import dao.AdminDao;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.MessageDao;
import dao.PcdDao;

@ManagedBean
@RequestScoped
public class EtudBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250383045637134026L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Etudiant user = (Etudiant) session.getAttribute("user");
	private EnseignantDao ensD = new EnseignantDao();
	private int coEquip1;
	private int coEquip2 = 0;
	private Date date = Calendar.getInstance().getTime();
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	private MessageDao msgD = new MessageDao();
	private List<Message> listMsgNonVu = msgD.MsgNonVu(user);
	private List<Message> listMsg = msgD.listMsg(user);

	public List<Message> getListMsgNonVu() {
		return listMsgNonVu;
	}

	public void setListMsgNonVu(List<Message> listMsgNonVu) {
		this.listMsgNonVu = listMsgNonVu;
	}

	public List<Message> getListMsg() {
		return listMsg;
	}

	public void setListMsg(List<Message> listMsg) {
		this.listMsg = listMsg;
	}

	private PcdDao pcdD = new PcdDao();
	private List<Pcd> listPCD = pcdD.getList();
	private List<Enseignant> listENS;
	private List<ChxPCD> listChx = new ArrayList<ChxPCD>();
	private DepartementDao depD = new DepartementDao();
	private ChxPcdDao chxpcdD = new ChxPcdDao();

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

	public int getCoEquip1() {
		return coEquip1;
	}

	public Administration getAdm() {
		return adm;
	}

	public void setAdm(Administration adm) {
		this.adm = adm;
	}

	public void setCoEquip1(int coEquip1) {
		this.coEquip1 = coEquip1;
	}

	public int getCoEquip2() {
		return coEquip2;
	}

	public void setCoEquip2(int coEquip2) {
		this.coEquip2 = coEquip2;
	}

	public List<?> getListChx() {
		return listChx;
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

	public EtudBean() {
		listChx=chxpcdD.getListChoix(user.getId());
		initListChx(listChx);

	}

	public String lireMsgs() {
		if (listMsgNonVu.size() != 0) {
			for (Message msg : listMsgNonVu) {
				msgD.SetViewed(msg.getId());
			}
		}
		return "Message";
	}

	public String AfficheEnseignant(int id) {

		return ensD.getEnseignant(id).getNom() + " "
				+ ensD.getEnseignant(id).getPrenom();
	}

	public void initListChx(List<ChxPCD> list) {

		
		if (list.isEmpty())
		for (int i = 0; i < adm.getPCD_nbChoix(); i++) {
			list.add(new ChxPCD(0, user.getId(), 0, i + 1, user.getId()));
		}

	}

	public String AfficheDepartement(int id) {

		return depD.getDepartement(id).getNom();
	}

	public void SaisirChoixPCD(ActionEvent event) {
		List<ChxPCD> listCoEquip1 = chxpcdD.getListChoix(coEquip1);
		initListChx(listCoEquip1);
		List<ChxPCD> listCoEquip2 = null;
		if (coEquip2 != 0) {
			listCoEquip2 = chxpcdD.getListChoix(coEquip2);
			initListChx(listCoEquip2);
		}

		int i = 0;

		for (ChxPCD chx : listChx) {

			chxpcdD.add(chx);
			chx.setEtudiant(coEquip1);
			chx.setId(listCoEquip1.get(i).getId());
			chxpcdD.add(chx);
			if (coEquip2 != 0) {
				chx.setEtudiant(coEquip2);
				chx.setId(listCoEquip2.get(i).getId());
				chxpcdD.add(chx);
			}
			i++;
		}

	}

}
