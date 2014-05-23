package dao;


import java.util.List;

import org.hibernate.Session;

import model.AffFiliere;
import model.Filiere;
import model.HibernateUtils;

public class AffFiliereDao {

	public void affect(AffFiliere aff) {
		
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

	public AffFiliere[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public Filiere getFilOfEtud(int idEtudiant) {
		
		return null;
	}

	}

