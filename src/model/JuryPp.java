package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JuryPp")

public class JuryPp {
	@Id
private int id;
private int membre1;
private int membre2;
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
public JuryPp(int id, int membre1, int membre2) {
	super();
	this.id = id;
	this.membre1 = membre1;
	this.membre2 = membre2;
}
public JuryPp() {
	super();
}


}