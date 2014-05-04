package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConnexionChefDep")
public class ConnexionChfDp {
	@Id
	private int id;
	
	private String login;
	private String password;
	private int chefDepart;
	
	
	public int getChefDepart() {
		return chefDepart;
	}


	public void setChefDepart(int chefDepart) {
		this.chefDepart = chefDepart;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	public ConnexionChfDp(int id, String login, String password, int chefDepart) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.chefDepart = chefDepart;
	}


	public ConnexionChfDp() {
		super();
	}
	

}
