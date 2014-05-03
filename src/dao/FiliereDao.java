package dao;


import org.hibernate.Session;

import model.Filiere;
import model.HibernateUtils;

public class FiliereDao {

	public void add(Filiere fil) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(fil);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

