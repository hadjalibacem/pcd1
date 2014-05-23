package dao;


import org.hibernate.Session;

import model.AffProjProg;
import model.HibernateUtils;

public class AffProjProgDao {

	public void affect(AffProjProg aff) {
		
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

	public AffProjProg[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}
	

	}


