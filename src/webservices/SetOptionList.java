package webservices;

import dao.AffModOptDao;
import model.Mod_opt;

public class SetOptionList {
	

	public Mod_opt[] SetOptionList(int IdEtudiant) {
		return SetOptList(IdEtudiant);
	}

	public Mod_opt[] SetOptList(int IdEtud)
	{
		AffModOptDao affD=new AffModOptDao();
		return affD.getOptOfEtud(IdEtud);
	}
}
