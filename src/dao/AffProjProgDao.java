package dao;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;

import model.AffProjProg;
import model.ChefDepart;
import model.ChxProjProg;
import model.HibernateUtils;
import model.Projet_prog;

public class AffProjProgDao {
	
	

	public boolean affect(AffProjProg aff) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(aff);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
			return true;
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
			return false;
		}

	}

	public AffProjProg removeCoEquip(int id) {
		AffProjProg aff = getAffect(id);

		if (aff != null) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			if (aff.getCoEquipier2() == null)

			{
				Proj_progDao ppD = new Proj_progDao();
				Projet_prog pp = ppD.getPp(aff.getProj_prog());
				pp.setNbAaffecter(pp.getNbAaffecter() + 1);
				ppD.add(pp);
				session.delete(aff);
			} else {
				if (aff.getCoEquipier2().equals(id)) {

					aff.setCoEquipier2(null);
				} else  {

					aff.setCoEquipier1(aff.getCoEquipier2());
					aff.setCoEquipier2(null);

				}

			}

			affect(aff);
			session.getTransaction().commit();
			session.close();
		}

		return aff;

	}

	public AffProjProg getAffect(Integer id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query;
		if (id == null)
			return null;
		query = session.createQuery("from AffProjProg where coEquipier1=" + id
				+ " or coEquipier2=" + id);
		return (AffProjProg) query.uniqueResult();
	}

	public AffProjProg getPpAff(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from AffProjProg where id=" + id);
		return (AffProjProg) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<AffProjProg> getList() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from AffProjProg order by proj_prog");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<AffProjProg> getAffOfPp(int pp)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from AffProjProg where proj_prog="+pp);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<AffProjProg> getAffof1Et()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from AffProjProg where coEquipier2=null");
		return  query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Integer> getIdPpAffected()
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query =session.createQuery("select distinct(proj_prog) from AffProjProg ");
		return query.list();
	}

	public AffProjProg[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<AffProjProg> getListPpOfJury(Integer id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from AffProjProg where jury="+id);
		return query.list();
	}

	

}
