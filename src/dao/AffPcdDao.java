package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.AffPCD;
import model.ChxPCD;
import model.HibernateUtils;
import model.Pcd;

public class AffPcdDao {

	public void affect(AffPCD aff) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(aff);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}
	public AffPCD removeCoEquip(int id) {
		AffPCD aff = getAffect(id);

		if (aff!=null) {
			Session session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			if (aff.getCoEquipier3() == null)
				
					{
					PcdDao pcdD=new PcdDao();
					Pcd pcd=pcdD.getPcd(aff.getPCD());
					pcd.setNbAaffecter(pcd.getNbAaffecter()+1);
					pcdD.add(pcd);
					session.delete(aff);
					}
			else {
				if (aff.getCoEquipier3().equals(id)) {
					
						aff.setCoEquipier3(null);
				} else if (aff.getCoEquipier3().equals(id)) {
					
						aff.setCoEquipier2(aff.getCoEquipier3());
						aff.setCoEquipier3(null);
					
				} else {
					
						aff.setCoEquipier1(aff.getCoEquipier3());
						aff.setCoEquipier3(null);
					
				}

			}
			
				affect(aff);
			session.getTransaction().commit();
			session.close();
		}

		return aff;

	}
	
	public AffPCD getAffect(int id)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("from AffPCD where coEquipier1="+id+" or coEquipier2="+id+" or coEquipier3="+id);
		return (AffPCD) query.uniqueResult();
	}

	}

