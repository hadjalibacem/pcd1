package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.ChefDepart;
import model.Etudiant;
import model.Message;
import model.HibernateUtils;

public class MessageDao {

	public void add(Message msg) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(msg);
            session.getTransaction().commit();
            session.close();
            System.out.print("bien ajouté");
        } catch (Exception e) {
            System.out.print("erreur insertion" + e.getMessage());
        }
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Message> MsgNonVu(Object user)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query;
		Etudiant et=new Etudiant();
		if(user.getClass()==et.getClass())
		{query=session.createQuery("from Message where etudiant="+((Etudiant) user).getId()+" and destinataire="+((Etudiant) user).getId()+" and vu=0");}
		else query=session.createQuery("from Message where chefDepart="+((ChefDepart) user).getId()+" and destinataire="+((ChefDepart) user).getId()+" and vu=0");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> listMsg(Object user)
	{
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Query query;
		Etudiant et=new Etudiant();
		if(user.getClass()==et.getClass())
		{query=session.createQuery("from Message where etudiant="+((Etudiant) user).getId()+" and destinataire="+((Etudiant) user).getId());}
		else query=session.createQuery("from Message where chefDepart="+((ChefDepart) user).getId()+" and destinataire="+((ChefDepart) user).getId());
		return query.list();
	}
public int SetViewed(int id)
{
	Session session=HibernateUtils.getSessionFactory().openSession();
	session.beginTransaction();
	Query query = session.createQuery("update Message set vu = 1" +
			" where id ="+id);
int result = query.executeUpdate();
	session.getTransaction().commit();
	return result;
}
	}

