package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Administration;
import model.HibernateUtils;

public class AdminDao {

	public boolean add(Administration ad) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(ad);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
            return true;
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
            return false;
        }}
		
        public Administration getAdministration(int annee)
        {
        	Session session=HibernateUtils.getSessionFactory().openSession();
        	session.beginTransaction();
        	Query query=session.createQuery("from Administration where annee="+annee);
        	return (Administration) query.uniqueResult();
        }
		
        @SuppressWarnings("unchecked")
		public Administration getAdministration()
        {
        	Session session=HibernateUtils.getSessionFactory().openSession();
        	session.beginTransaction();
        	Query query=session.createQuery("from Administration");
        	List<Administration> list=query.list();
        	return list.get(list.size()-1);
        }
		
		
	}

	

