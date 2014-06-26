package dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AffProjProg;
import model.ChefDepart;
import model.Enseignant;
import model.HibernateUtils;
import model.JuryPcd;
import model.JuryPp;

import org.hibernate.Query;
import org.hibernate.Session;

public class JuryPpDao {
	public boolean add(JuryPp jury) {

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
	public JuryPp getJuryById(int id)
	{
		if(id==0 )return null;
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from JuryPp where id="+id);
		return (JuryPp) query.uniqueResult();
	}
	
	public JuryPp getJury(int id)
	{
		if(id==0 )return null;
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from JuryPp where membre1="+id+" or membre2="+id);
		return (JuryPp) query.uniqueResult();
	}
	
	public Long getNbAffJury(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery(" select count(*) from AffProjProg where jury="+id);
		return (Long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getListNotAffToJury() {
		
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Enseignant e where jury=1 and not exists (from JuryPp where membre1=e.id or membre2=e.id)");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<JuryPp> getList()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from JuryPp");
		return query.list();
	}
	
	public boolean delete(JuryPp jur1) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(jur1);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.print("erreur delete" + e.getMessage());
			return false;
		}
		
	}
	
	

}
