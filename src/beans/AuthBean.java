package beans;


import java.io.Serializable;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




import dao.AuthentificationDao;


@ManagedBean
@RequestScoped
public class AuthBean implements Serializable {

	public AuthBean() {
		super();
		System.out.print("Constructeur AuthBean");
		if(session.getAttribute("connecte") != null)
		{
			connecte=(Boolean) session.getAttribute("connecte");
		}
		
	}

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private String username;
	private String password;
	private int id;
	private String statut = (String) session.getAttribute("statut");
	private boolean connecte =false;
	private Object user=session.getAttribute("user");;

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public AuthentificationDao getAuth() {
		return auth;
	}

	public void setAuth(AuthentificationDao auth) {
		this.auth = auth;
	}

	private AuthentificationDao auth = new AuthentificationDao();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {

		user = auth.authentifier(username, password, statut);

		if (user != null) {

			/*
			 * ExternalContext ec =
			 * FacesContext.getCurrentInstance().getExternalContext(); try {
			 * ec.redirect(ec.getRequestContextPath() + "/Acceuil.xhtml"); }
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * System.out.print(e.getMessage()); e.printStackTrace(); }
			 */
			session.setAttribute("user", user);
			session.setAttribute("statut", statut);
			setConnecte(true);

			session.setAttribute("connecte", connecte);
			return "Acceuil";
			/*
			 * if (statut.equals("etudiant")) {
			 * 
			 * return "AcceuilEt"; } else { return "AcceuilCh"; }
			 */
		} else {
			setConnecte(false);
			FacesMessage message = new FacesMessage(
					"your login  is unsuccessfull !");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

		return "";
	}

	public String SignUp() {

		if (auth.inscription(id, username, password, statut) != null) {
			FacesMessage message = new FacesMessage("Bien Inscrit");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "Acceuil";
		}

		FacesMessage message = new FacesMessage("Invalid Id !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";

	}

	public String logout() {
		setConnecte(false);

		session.setAttribute("connecte", connecte);
		session.invalidate();
		return "Acceuil";
	}

}