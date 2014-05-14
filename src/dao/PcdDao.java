package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Pcd;
import model.HibernateUtils;

public class PcdDao {
	

	public boolean add(Pcd pcd) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(pcd);
            session.getTransaction().commit();
           session.close();
            System.out.print("bien ajouté");
            return true;
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
            return false;
        }
	}
	
	public Pcd getPcd(String sujet)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Pcd where sujet='"+sujet+"'");
		return (Pcd) query.uniqueResult();
	}
        
		@SuppressWarnings("unchecked")
		public List<Pcd> getList()
        {
        	Session session= HibernateUtils.getSessionFactory().openSession();
        	session.beginTransaction();
        	
        	Query query = session.createQuery(" from Pcd ");
        	
        	
        	
        	return query.list();
        	
        }
		
		public Pcd getPcd(int id)
		{
			Session session=HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			Query query=session.createQuery("from Pcd where id="+id);
			return (Pcd) query.uniqueResult();
		}
		@SuppressWarnings("unchecked")
		public List<Pcd> getListPcdToAffect()
		{
			Session session=HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			Query query=session.createQuery("from Pcd where nbAaffecter > 0");
			return query.list();
		}
		
		
		
		
	

	}

