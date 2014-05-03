package dao;


import org.hibernate.Session;

import model.AffPCD;
import model.HibernateUtils;

public class AffPcdDao {

	public void affect(AffPCD aff) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(aff);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

