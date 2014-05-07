package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.ChxPCD;
import model.HibernateUtils;

public class ChxPcdDao {

	public void add(ChxPCD pcd) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(pcd);
            //session.save(pcd);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
        
        
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<ChxPCD> getListChoix(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from ChxPCD chx where chx.etudiant="+id+" order by chx.rang ");
		return query.list();
	}

	}

