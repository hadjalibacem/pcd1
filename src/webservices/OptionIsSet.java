package webservices;


import dao.AffModOptDao;

public class OptionIsSet {
	
public boolean OptionIsSet() {
		
		return OptIsSet();
	}
	public boolean OptIsSet()
	{
		AffModOptDao affD=new AffModOptDao();
		return affD.isAllAffected();	
	}

}
