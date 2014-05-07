package beans;

import java.io.Serializable;
import java.util.List;

import model.Administration;
import model.ChefDepart;
import model.Message;
import model.Pcd;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.MessageDao;

@ManagedBean 
@RequestScoped
public class ChefDepartBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private ChefDepart user=(ChefDepart) session.getAttribute("user");
	private AdminDao admD=new AdminDao();
	private Administration adm=admD.getAdministration();
	private MessageDao msgD=new MessageDao();
	List<Message> listMsgNonVu=msgD.MsgNonVu(user);
	List<Message> listMsg=msgD.listMsg(user);
	public ChefDepart getUser() {
		return user;
	}
	public void setUser(ChefDepart user) {
		this.user = user;
	}
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
	public Administration getAdm() {
		return adm;
	}
	public void setAdm(Administration adm) {
		this.adm = adm;
	}
	public String lireMsgs()
	{
		if(listMsgNonVu.size()!=0)
		{
			for (Message msg : listMsgNonVu) {
				msgD.SetViewed(msg.getId());
			}
		}
		return "Message";
	}
	
}
