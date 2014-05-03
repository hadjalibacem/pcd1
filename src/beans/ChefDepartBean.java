package beans;

import java.io.Serializable;
import java.util.List;

import model.Pcd;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean 
@RequestScoped
public class ChefDepartBean implements Serializable {

	private List<Pcd> sujets;
	
	private String getList()
	{
		Session session=
		this.sujets
	}
}
