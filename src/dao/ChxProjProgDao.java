package dao;


import org.hibernate.Session;

import model.ChxProjProg;
import model.HibernateUtils;

public class ChxProjProgDao {

	public void add(ChxProjProg pp) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(pp);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

