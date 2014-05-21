package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Enseignant;
import model.HibernateUtils;

public class EnseignantDao {

	public void add(Enseignant enseignant) {

		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(enseignant);
			session.getTransaction().commit();
			session.close();
			System.out.print("bien ajouté");
		} catch (Exception e) {
			System.out.print("erreur insertion" + e.getMessage());
		}

	}

	public Enseignant getEnseignant(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Enseignant where id=" + id);

		return (Enseignant) query.uniqueResult();
	}

	public List<Enseignant> getListByKeyWords(String[] motsCles) {
		List<Enseignant> list = new ArrayList<Enseignant>();
		List<Enseignant> listAll = getList();

		for (Enseignant ens : listAll) {
			if (ens.getMotsCles() != null) {
				boolean exist = false;
				String[] keywords = ens.getMotsCles().split(",");

				for (int i = 0; i < motsCles.length && !exist; i++) {
					for (String kw : keywords) {
						if (motsCles[i].equals(kw))
							exist = true;
					}
				}
				if (exist)

					list.add(ens);

			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Enseignant> getList() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Enseignant");
		return query.list();
	}

}
