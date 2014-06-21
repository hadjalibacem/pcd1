package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Projet_prog;
import model.HibernateUtils;

public class Proj_progDao {

	public boolean add(Projet_prog pp) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(pp);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
			return true;
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
			return false;
		}
	}

	public Projet_prog getPp(String sujet) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Projet_prog where sujet='" + sujet
				+ "'");
		return (Projet_prog) query.uniqueResult();
	}

	
	@SuppressWarnings("unchecked")
	public List<Projet_prog> getList()
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Projet_prog");

		return query.list();
	}

	public Projet_prog getPp(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Projet_prog where id=" + id);
		return (Projet_prog) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Projet_prog> getListPpToAffect() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Projet_prog where nbAaffecter > 0");
		return query.list();
	}

}
