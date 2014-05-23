package webservices;

import dao.AffModOptDao;
import model.Etudiant;


public class SetEtudiantbyOption {

	public Etudiant SetEtudiantbyOption(int IdOption) {
		return SetEtud(IdOption);
	}

	public Etudiant SetEtud(int IdOption)
	{
		AffModOptDao affD=new AffModOptDao();
		return affD.getEtud(IdOption);
	}
}
