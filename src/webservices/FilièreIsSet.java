package webservices;

import dao.AffFiliereDao;

public class FilièreIsSet {

	public boolean FilièreIsSet() {
		
		return FilIsSet();
	}
	public boolean FilIsSet()
	{
		AffFiliereDao affD=new AffFiliereDao();
		return affD.isAllAffected();	
	}

	
}
