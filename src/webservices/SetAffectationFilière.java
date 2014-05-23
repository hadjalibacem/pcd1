package webservices;

import model.AffFiliere;
import dao.AffFiliereDao;

public class SetAffectationFilière {
	
	
	public AffFiliere[] SetAffectationFilière() {
		return SetAffectation();
	}

	public AffFiliere[] SetAffectation()
	{
		AffFiliereDao affD=new AffFiliereDao();
		return affD.getArray();
	}

}
