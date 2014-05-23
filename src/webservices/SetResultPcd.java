package webservices;

import dao.AffPcdDao;
import model.AffPCD;


public class SetResultPcd {
	public AffPCD[] SetResultPcd() {
		return SetResult();
	}

	public AffPCD [] SetResult()
	{
		AffPcdDao affD=new AffPcdDao();
		return affD.getArray();
	}
}
