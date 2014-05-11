package dao;


import org.hibernate.Query;
import org.hibernate.Session;

import model.AffPCD;
import model.HibernateUtils;

public class AffPcdDao {

	public void affect(AffPCD aff) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(aff);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}
	
	public AffPCD getAffect(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from AffPCD where coEquipier1="+id+" or coEquipier2="+id+" or coEquipier3="+id);
		return (AffPCD) query.uniqueResult();
	}

	}

