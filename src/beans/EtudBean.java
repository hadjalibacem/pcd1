package beans;

import java.io.Serializable;
//import java.util.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.ChxPCD;
import model.Enseignant;
import model.Etudiant;
import model.Pcd;
import dao.ChxPcdDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.PcdDao;
@ManagedBean 
@RequestScoped
public class EtudBean implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250383045637134026L;
	private List<Pcd> listPCD;
	private List<Enseignant> listENS;
	private List<Integer> listChx=new ArrayList<Integer>() ;
	
	public List<?> getListChx() {
		return listChx;
	}
	public void setListChx(List<Integer> listChx) {
		this.listChx = listChx;
	}
	private DepartementDao depD=new DepartementDao();
	private ChxPcdDao chxpcdD=new ChxPcdDao();
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
 	HttpSession session = request.getSession();
 	private Etudiant user=(Etudiant) session.getAttribute("user");
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
	private PcdDao pcdD=new PcdDao();

	private EnseignantDao ensD=new EnseignantDao();
	
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
		super();
		this.listPCD=pcdD.getList();
		
	}
	public String AfficheEnseignant(int id)
	{

		
		return ensD.getEnseignant(id).getNom()+" "+ensD.getEnseignant(id).getPrenom();
	}
	public String AfficheDepartement(int id)
	{

		
		return depD.getDepartement(id).getNom();
	}
	
	public String SaisirChoixPCD()
	{
		ChxPCD pcd;
		for (int i=0; i<listChx.size();i++)
		{
			pcd=new ChxPCD(0, user.getId(), listChx.get(i), i+1);
			chxpcdD.add(pcd);
		}
		
		/*
		ChxPCD pcd=new ChxPCD();
		chxpcdD.add(pcd);*/
		return "";
	}
	

}
