package dao;



import model.ChefDepart;
import model.Etudiant;
import model.HibernateUtils;





import model.ConnexionChfDp;
import model.ConnexionEtud;

import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.mapping.Collection;


public class AuthentificationDao {
	
	public Object inscription (int id, String login, String password, String statut)
	{
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		if (statut.equals("etudiant"))
		{Query query=session.createQuery("from Etudiant where id="+id+" and not exists (from ConnexionEtud where etudiant="+id+")");
		Etudiant user=(Etudiant) query.uniqueResult();
		if(user!=null)
			{ConnexionEtud et=new ConnexionEtud(0,login,password,id);
			session.save(et);

	        session.getTransaction().commit();
			}
	        return user;
		}
		else { Query qr=session.createQuery("from ChefDepart where id="+id+" and not exists (from ConnexionChfDp where chefDepart="+id+")");
		ChefDepart user=(ChefDepart) qr.uniqueResult();
		if(user!=null)
			{ConnexionChfDp chfdp=new ConnexionChfDp(0,login,password,id);
			session.save(chfdp);

	        session.getTransaction().commit();}
	        return user;
		
		}
		

	}

	public Object authentifier (String un, String pwd,String statut)
	{
		
		
		Session session = HibernateUtils.getSessionFactory().openSession();
        
            session.beginTransaction();
            Query query;
            //session.getTransaction().commit();
        	if (statut.equals("etudiant"))
        	{query=session.createQuery("from Etudiant where id=(select etudiant from ConnexionEtud where login='"+un+"' and password='"+pwd+"')");
        	
        	Etudiant user=(Etudiant) query.uniqueResult();
        	return user;
        	}
        	else {query=session.createQuery("from ChefDepart where id=(select chefDepart from ConnexionChfDp where login='"+un+"' and password='"+pwd+"')");
        	ChefDepart user=(ChefDepart) query.uniqueResult();
        	return user;
        	
        	}
        	
           
        
		
	}
	
	public String logout ()
	{
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.close();
		return null;
	}
}