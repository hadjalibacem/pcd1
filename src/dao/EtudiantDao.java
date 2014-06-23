package dao;


import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import model.ChefDepart;
import model.Etudiant;
import model.HibernateUtils;

public class EtudiantDao {
	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private Object user =  session.getAttribute("user");

	public void add(Etudiant et) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(et);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Etudiant> getListEtudiant2()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Etudiant where niveau = 2 and (departement is null or departement="+((ChefDepart)user).getDepartement()+") order by rang");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Etudiant> getListEtudiant1()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Etudiant where niveau = 1 order by rang");
		return query.list();
	}

	public Etudiant getEtudiant(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Etudiant where id="+id);
		return (Etudiant) query.uniqueResult();
	}
	}

