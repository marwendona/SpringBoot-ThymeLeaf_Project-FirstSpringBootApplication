package tn.iit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.iit.beans.HelloBean;
import tn.iit.entity.Compte;

import java.util.List;

@SpringBootApplication
public class FirstSpringBootApplication implements CommandLineRunner {

    @Autowired
    private HelloBean bean;
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringBootApplication.class, args);
    }

    @Transactional // pour faire le commit
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hello Spring");
        System.out.println(bean.getMessage(" From IIT Engineer"));
        // Serch: best practices: using setParameter to avoid SQL injection
        TypedQuery<Compte> query = entityManager.createQuery("select c from Compte c where c.nomClient = :nc",
                Compte.class); // :nc --> nc c'est un paramètre à assigner avec setParameter
        query.setParameter("nc", "amina"); // filtrage de l'injection sql
        List<Compte> list = query.getResultList();
        System.out.println(list);

        query.setParameter("nc", "Youssef"); // filtrage de l'injection sql
        list = query.getResultList();
        System.out.println(list);

        //Search with native query
	/*	List<Compte> list = entityManager.createNativeQuery("select * from t_compte c where c.client = 'amina'", Compte.class).getResultList();
		System.out.println(list);
		//Search
	/*	List<Compte> list = entityManager.createQuery("select c from Compte c where c.nomClient = 'amina'", Compte.class).getResultList();
		System.out.println(list);

		//find All
		// It is not SQL, but H-QL or JP-QL  or EJB-QL  = ~ SQL orienté Objet (nom de l'objet + nom de l'attribut
	/*	List<Compte> list = entityManager.createQuery("select c from Compte c", Compte.class).getResultList();
		System.out.println(list);

	/*	Compte c= entityManager.find(Compte.class, 1);
		c.setSolde(c.getSolde()+50);
		entityManager.merge(c);

		//delete

    /*	Compte c= entityManager.find(Compte.class, 3);
		entityManager.remove(c);

		//find by PK

	/*	Compte c= entityManager.find(Compte.class, 4);
		System.out.println(c);

		//save
	/*	Compte c1 = new Compte(100, "amina");
		entityManager.persist(c1);
		Compte c2 = new Compte(200, "Youssef");
		entityManager.persist(c2);
		Compte c3 = new Compte(300, "Mobtassim");
		entityManager.persist(c3);*/
    }
}
