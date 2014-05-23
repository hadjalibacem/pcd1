package webservices;

import dao.AffPfeDao;
import model.AffPFE;

public class SetResultPFE {
	

	public AffPFE[] SetResultPFE() {
		return SetResult();
	}

	public AffPFE[] SetResult()
	{
		AffPfeDao affD=new AffPfeDao();
		return affD.getArray();
	}
}
