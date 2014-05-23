package webservices;

import dao.AffStagEteDao;
import model.AffStagEte;


public class SetResultSE {

	public AffStagEte[] SetResultSE() {
		return SetResult();
	}

	public AffStagEte[] SetResult()
	{
		AffStagEteDao affD=new AffStagEteDao();
				return affD.getArray();
	}
}
