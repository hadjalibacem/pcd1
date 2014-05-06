package dao;


import org.hibernate.Session;

import model.Projet_prog;
import model.HibernateUtils;

public class Proj_progDao {

	public void add(Projet_prog pp) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pp);
            session.getTransaction().commit();
          //  session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

