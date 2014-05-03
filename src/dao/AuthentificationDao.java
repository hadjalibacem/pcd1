package dao;



import model.HibernateUtils;





import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.mapping.Collection;


public class AuthentificationDao {

	public String authentifier (String un, String pwd)
	{
		
		
		Session session = HibernateUtils.getSessionFactory().openSession();
        
            session.beginTransaction();
            
            //session.getTransaction().commit();
        	
        	Query query=session.createSQLQuery("select statut from User where username='"+un+"' and password='"+pwd+"'");
        	//Query query=null;
        	String stat=query.list().toString();
        	//session.close();
        	if (query.list().isEmpty())   return null;
            
        	else  return stat;
           
        
		
	}
}