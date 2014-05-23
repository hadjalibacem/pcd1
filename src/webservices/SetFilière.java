package webservices;

import dao.AffFiliereDao;
import model.Filiere;

public class SetFilière {
	

	public Filiere SetFilière(int IdEtudiant) {
		return SetFil(IdEtudiant);
	}

	public Filiere SetFil(int IdEtudiant)
	{
		AffFiliereDao affD=new AffFiliereDao();
		return affD.getFilOfEtud(IdEtudiant);
	}
}
