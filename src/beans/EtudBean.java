package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Pcd;
import dao.PcdDao;
@ManagedBean 
@RequestScoped
public class EtudBean implements Serializable  {
	
	public List<Pcd> CheckListPcd()
	{
		PcdDao pcdD=new PcdDao();
		return pcdD.getList();
		
	}

}
