package net.codejava.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	public static void main(String[] args) {
		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry
			= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Person malePerson = new Person("Tom", Gender.MALE);
		session.save(malePerson);
		
		Person femalePerson = new Person("Mary", Gender.FEMALE);
		session.save(femalePerson);
		

                String hql = "FROM Person AS P";
                Query query = session.createQuery(hql);
                List<Person> results =(List<Person>) query.list();                
                
                for ( Person p :   results){
                    System.out.println(p.getId());
                    System.out.println(p.getName());
                    System.out.println(p.getGender());
                }
		
                
                System.out.println("=============================================================");
                
                
		Person2 malePerson2 = new Person2("Tom", Gender.MALE);
		session.save(malePerson2);
		
		Person2 femalePerson2 = new Person2("Mary", Gender.FEMALE);
		session.save(femalePerson2);
                
                
                String hql2 = "FROM Person2 AS P";
                Query query2 = session.createQuery(hql2);
                List<Person2> results2 =(List<Person2>) query2.list();                
                
                for ( Person2 p :   results2){
                    System.out.println(p.getId());
                    System.out.println(p.getName());
                    System.out.println(p.getGender());
                }
                
                session.getTransaction().commit();
                
                session.close();
		
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
		
	}

}
