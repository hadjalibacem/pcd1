package webservices;

import dao.AffModOptDao;



public class SetAffectationOption {
	public AffModOptDao[] SetAffectationOption() {
		return SetAffectation();
	}

	public AffModOptDao[] SetAffectation()
	{
		AffModOptDao affD=new AffModOptDao();
		return affD.getArray();
	}
}
