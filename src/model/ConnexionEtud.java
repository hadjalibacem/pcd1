package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ConnexionEtud")
public class ConnexionEtud {
	@Id
	private int id;
	
	private String login;
	private String password;
	private int etudiant;
	
	
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


	public int getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(int etudiant) {
		this.etudiant = etudiant;
	}


	public ConnexionEtud(int id, String login, String password, int etudiant) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.etudiant = etudiant;
	}


	public ConnexionEtud() {
		super();
	}
	

}
