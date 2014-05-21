package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JuryPcd")

public class JuryPcd {
	@Id
private int id;
private int membre1;
private int membre2;
private Integer membre3;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMembre1() {
	return membre1;
}
public void setMembre1(int membre1) {
	this.membre1 = membre1;
}
public int getMembre2() {
	return membre2;
}
public void setMembre2(int membre2) {
	this.membre2 = membre2;
}
public Integer getMembre3() {
	return membre3;
}
public void setMembre3(Integer membre3) {
	this.membre3 = membre3;}
public JuryPcd(int id, int membre1, int membre2, Integer membre3) {
	super();
	this.id = id;
	this.membre1 = membre1;
	this.membre2 = membre2;
	this.membre3 = membre3;
}
public JuryPcd() {
	super();
}

}
