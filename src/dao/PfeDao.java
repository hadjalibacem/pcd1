package dao;


import org.hibernate.Session;

import model.Pfe;
import model.HibernateUtils;

public class PfeDao {

	public void add(Pfe pfe) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pfe);
            session.getTransaction().commit();
           // session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

