package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Etudiant;
import model.HibernateUtils;

public class EtudiantDao {

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
		Query query=session.createQuery("from Etudiant where niveau = 2 order by rang");
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

