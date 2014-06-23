package dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import model.ChefDepart;
import model.Pcd;
import model.HibernateUtils;

public class PcdDao {
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	

	HttpSession session = request.getSession();
	private Object user =  session.getAttribute("user");

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

	public Pcd getPcdbysujet(String sujet) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Pcd where sujet='" + sujet
				+ "'");
		return (Pcd) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Pcd> getListPCDbyDep(int dep) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Pcd where departement="+dep+" or departement is null");

		return query.list();

	}
	@SuppressWarnings("unchecked")
	public List<Pcd> getList()
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Pcd order by departement");

		return query.list();
	}

	public Pcd getPcd(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Pcd where id=" + id);
		return (Pcd) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Pcd> getListPcdToAffect() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Pcd where nbAaffecter > 0 and (departement is null or departement="+((ChefDepart)user).getDepartement()+")");
		return query.list();
	}

}
