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
import model.Administration;
import model.Etudiant;





@ManagedBean
@RequestScoped
public class pfeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Etudiant user = (Etudiant) session.getAttribute("user");
	private AdminDao admD = new AdminDao();
	private Administration adm = admD.getAdministration();
	
	
	public Etudiant getUser() {
		return user;
	}
	public void setUser(Etudiant user) {
		this.user = user;
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

}
