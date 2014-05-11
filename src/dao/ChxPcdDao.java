package dao;

import java.util.ArrayList;
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
			// session.save(pcd);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public List<ChxPCD> removeCoEquip(int id) {
		if (!getListChoix(id).isEmpty()) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("from ChxPCD where coEquipier1="
					+ id + " or coEquipier2=" + id + " or coEquipier3=" + id);
			List<ChxPCD> listchx = query.list();
			if ( !listchx.isEmpty()) {
				if (listchx.get(0).getCoEquipier3() == null)
					for (ChxPCD chx :listchx)
					session.delete(chx);
				else {
					if (listchx.get(0).getCoEquipier3().equals(id)) {
						for (ChxPCD chx :listchx)
						chx.setCoEquipier3(null);
					} else if (listchx.get(0).getCoEquipier2().equals(id)) {
						for (ChxPCD chx :listchx)
						{
						chx.setCoEquipier2(chx.getCoEquipier3());
						chx.setCoEquipier3(null);
						}
					} else {
						for (ChxPCD chx :listchx)
						{
						chx.setCoEquipier1(chx.getCoEquipier3());
						chx.setCoEquipier3(null);
						}
					}

				}
				for (ChxPCD chx :listchx)
				add(chx);
				session.getTransaction().commit();
				session.close();
			}

			return listchx;
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<ChxPCD> getListChoix(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from ChxPCD chx where chx.coEquipier1=" + id
						+ " or chx.coEquipier2=" + id + " or chx.coEquipier3 ="
						+ id + " order by chx.rang ");
		return query.list();
	}
	
	

}
