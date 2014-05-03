package dao;


import org.hibernate.Session;

import model.ChxPCD;
import model.HibernateUtils;

public class ChxPcdDao {

	public void add(ChxPCD pcd) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(pcd);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

