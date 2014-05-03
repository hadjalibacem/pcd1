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
		
         Etudiant et=new Etudiant(0, "amira", "drihmi", "amira", "amira", 3, "A", "avenue hjkhjkh", "kjkj@y.com", 200, 1);
        EtudiantDao etD=new EtudiantDao();
        etD.add(et);
         
         /*AuthentificationDao auth= new AuthentificationDao();
         
         String user=auth.authentifier(username,password);
        
 	    if(user!=null) { 
 	    	//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
       /* try {
			ec.redirect(ec.getRequestContextPath() + "/Acceuil.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
			e.printStackTrace();
		}*/
 	    /*	if (user.equals("[etudiant]"))
 	     return "AcceuilEt";
 	    	else if (user.equals("[chefdepart]"))
 	    	return "AcceuilCh";
 	    	else return "AcceuilEn";
 	    }
 	    else {FacesMessage message = new FacesMessage( "your login  is unsuccessfull !" );
 	    FacesContext.getCurrentInstance().addMessage( null, message );}
 	 */
         return "";
	}

    
}