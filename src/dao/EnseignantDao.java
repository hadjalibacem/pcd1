package dao;


import org.hibernate.Session;

import model.Enseignant;
import model.HibernateUtils;

public class EnseignantDao {

	public void add(Enseignant enseignant) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(enseignant);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

