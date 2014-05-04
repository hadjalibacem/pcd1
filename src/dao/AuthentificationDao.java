package dao;



import model.HibernateUtils;





import model.InscriChfDp;
import model.InscriEtud;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.mapping.Collection;


public class AuthentificationDao {
	
	public Object inscription (int id, String login, String password, String statut)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		if (statut.equals("etudiant"))
		{Query query=session.createQuery("from Etudiant where id="+id);
		if(!query.list().isEmpty())
			{InscriEtud et=new InscriEtud(0,login,password,id);
			session.save(et);

	        session.getTransaction().commit();
	        return et;}
			else return null;
		}
		else { Query qr=session.createSQLQuery("select * from Chef_Depart where id="+id+" and not exists (select * from connexionchefdep where chefDepart="+id+")");
		if(!qr.list().isEmpty())
			{InscriChfDp chfdp=new InscriChfDp(0,login,password,id);
			session.save(chfdp);

	        session.getTransaction().commit();
	        return chfdp;}
		else return null;
		
		}
		

	}

	public String authentifier (String un, String pwd,String statut)
	{
		
		
		Session session = HibernateUtils.getSessionFactory().openSession();
        
            session.beginTransaction();
            Query query;
            //session.getTransaction().commit();
        	if (statut.equals("etudiant"))
        	query=session.createSQLQuery("select * from connexionetud where login='"+un+"' and password='"+pwd+"'");
        	else query=session.createSQLQuery("select * from connexionchefdep where login='"+un+"' and password='"+pwd+"'");
        	session.
        	if (query.list().isEmpty())   return null;
            
        	else  return statut;
           
        
		
	}
	
	public String logout ()
	{
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.close();
		return null;
	}
}