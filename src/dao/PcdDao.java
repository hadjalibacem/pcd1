package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Enseignant;
import model.Pcd;
import model.HibernateUtils;

public class PcdDao {
	

	public void add(Pcd pcd) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pcd);
            session.getTransaction().commit();
           session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
	}
        
		@SuppressWarnings("unchecked")
		public List<Pcd> getList()
        {
        	Session session= HibernateUtils.getSessionFactory().openSession();
        	session.beginTransaction();
        	
        	Query query = session.createQuery(" from Pcd ");
        	
        	
        	
        	return query.list();
        	
        }
		
		
		
		
	

	}

