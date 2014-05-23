package dao;


import org.hibernate.Session;

import model.AffModOpt;
import model.Etudiant;
import model.HibernateUtils;
import model.Mod_opt;

public class AffModOptDao {

	public void affect(AffModOpt aff) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(aff);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	public boolean isAllAffected() {
		// TODO Auto-generated method stub
		return false;
	}

	public AffModOptDao[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public Etudiant getEtud(int idOption) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mod_opt[] getOptOfEtud(int idEtud) {
		// TODO Auto-generated method stub
		return null;
	}

	}

