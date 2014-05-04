package beans;

import java.io.Serializable;
//import java.util.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Pcd;
import dao.PcdDao;
@ManagedBean 
@RequestScoped
public class EtudBean implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250383045637134026L;
	protected List<Pcd> listA=new ArrayList<Pcd>();
	public List<Pcd> CheckListPcd()
	{
		PcdDao pcdD=new PcdDao();
		//listA.add(pcdD);
		//listA= pcdD.getList();
		listA.addAll((Collection<Pcd>) pcdD.getList());
		return listA;
		
	}

}
