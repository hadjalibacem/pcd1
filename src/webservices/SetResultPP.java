package webservices;

import dao.AffProjProgDao;
import model.AffProjProg;

public class SetResultPP {
	public AffProjProg[] SetResultPP() {
		return SetResult();
	}

	public AffProjProg[] SetResult()
	{
		AffProjProgDao affD=new AffProjProgDao();
		return affD.getArray();
	}

}
