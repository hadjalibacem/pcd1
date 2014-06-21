package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.ChxProjProg;
import model.HibernateUtils;

public class ChxProjProgDao {

	public void add(ChxProjProg pp) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(pp);
			// session.save(pcd);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}

	}

	public List<ChxProjProg> removeCoEquip(int id) {
		List<ChxProjProg> listchx = getListChoix(id);

		if (!listchx.isEmpty()) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			if (listchx.get(0).getCoEquipier2() == null)
				for (ChxProjProg chx : listchx)
					session.delete(chx);
			else {
				if (listchx.get(0).getCoEquipier2().equals(id)) {
					for (ChxProjProg chx : listchx)
						chx.setCoEquipier2(null);
				} else  {
					for (ChxProjProg chx : listchx) {
						chx.setCoEquipier1(chx.getCoEquipier2());
						chx.setCoEquipier2(null);
					}
				} 

			}
			for (ChxProjProg chx : listchx)
				add(chx);
			session.getTransaction().commit();
			session.close();
		}

		return listchx;

	}

	@SuppressWarnings("unchecked")
	public List<ChxProjProg> getListChoix(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from ChxProjProg chx where chx.coEquipier1=" + id
						+ " or chx.coEquipier2=" + id + " order by chx.rang ");
		return query.list();
	}

	

}
