package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
























import model.Administration;
import model.Departement;
import model.Enseignant;
import model.Etudiant;
import model.Filiere;
import model.Pcd;
import model.Pfe;
import model.Projet_prog;
import model.Stage_ete;
import model.Mod_opt;
import dao.AdminDao;
import dao.AuthentificationDao;
import dao.DepartementDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.FiliereDao;
import dao.PcdDao;
import dao.PfeDao;
import dao.Proj_progDao;
import dao.Stage_eteDao;
import dao.Mod_optDao;

@ManagedBean 
@RequestScoped
public class AuthBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private int id;
    private String statut;
    private boolean connecte=false;
	public boolean isConnecte() {
		return connecte;
	}
	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	private Object user;
    
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

	private AuthentificationDao auth=new AuthentificationDao();
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
		
	public String login()
	{
		
        
         
         Object user=auth.authentifier(username,password,statut);
        
 	    if(user!=null) { 
 	    	/*ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
			ec.redirect(ec.getRequestContextPath() + "/Acceuil.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			e.printStackTrace();
		}*/
 	    	setConnecte(true);
 	    /*	if (statut.equals("etudiant"))
 	    	{
 	    		
 	    		return "AcceuilEt";
 	    	}
 	    	else {
 	    		return "AcceuilCh";
 	    	}*/
 	    }
 	    else {
 	    	setConnecte(false);
 	    	FacesMessage message = new FacesMessage( "your login  is unsuccessfull !" );
 	    FacesContext.getCurrentInstance().addMessage( null, message );}
 	 
         return "";
	}
	
	public String SignUp()
	{
		user=auth.inscription(id, username, password, statut);
		if (user!=null)
		{
			FacesMessage message = new FacesMessage( "Bien Inscrit" );
	 	    FacesContext.getCurrentInstance().addMessage( null, message );
	 	    return "login";
		}
		
		
		FacesMessage message = new FacesMessage( "Invalid Id !" );
 	    FacesContext.getCurrentInstance().addMessage( null, message );
 	    return "";
		
	}
public void logout()
{
	setConnecte(false);
	
	//return "login";
}
    
}