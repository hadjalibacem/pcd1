package dao;


import org.hibernate.Session;

import model.Etudiant;
import model.HibernateUtils;

public class EtudiantDao {

	public void add(Etudiant et) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(et);
            session.getTransaction().commit();
            //session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}

	}

