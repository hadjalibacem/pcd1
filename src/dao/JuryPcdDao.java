package dao;

import java.util.List;

import model.AffPCD;
import model.Enseignant;
import model.HibernateUtils;
import model.JuryPcd;

import org.hibernate.Query;
import org.hibernate.Session;

public class JuryPcdDao {
	public boolean add(JuryPcd jury) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(jury);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
			return true;
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
			return false;
		}

	}
	
	public JuryPcd getJury(int id)
	{
		if(id==0 )return null;
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from JuryPcd where membre1="+id+" or membre2="+id+" or membre3="+id);
		return (JuryPcd) query.uniqueResult();
	}
	
	public Long getNbAffJury(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery(" select count(*) from AffPCD where jury="+id);
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getListNotAffToJury() {
		
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Enseignant e where not exists (from JuryPcd where membre1=e.id or membre2=e.id or membre3=e.id)");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JuryPcd> getList()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from JuryPcd");
		return query.list();
	}
	
	
	
	

}
