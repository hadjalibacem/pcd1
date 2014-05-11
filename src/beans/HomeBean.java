package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
//import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import model.Etudiant;
import model.Message;

@ManagedBean
@RequestScoped
public class HomeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250383045637134026L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Object user = session.getAttribute("user");

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

	public HomeBean() {

	}

	public String lireMsgs() {
		if (listMsgNonVu.size() != 0) {
			for (Message msg : listMsgNonVu) {
				msgD.SetViewed(msg.getId());
			}
		}
		return "Message";
	}

}
