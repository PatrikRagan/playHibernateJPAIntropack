package controllers;

import model.Menu;
import model.Person;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is index."));
    }

//    @javax.persistence.Transactional
    @play.db.jpa.Transactional
    public Result daco(){
        Menu xxx = new Menu();
        xxx.price = 100;
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(xxx);

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("update");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(xxx);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        EntityManager em;
//        TODO: Pozor na konfiguraciu factory, pretoze parameter cekuje z nastavenia z application.conf jpa.default
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("defaultPersistenceUnit"); // Here it crashes
        em = fact.createEntityManager();

        final Person person = new Person();
        person.firstname = "Bruce";
        person.surname = "Smith";
//        JPA.em().getTransaction().begin();
//        JPA.em().persist(person);
//        JPA.em().getTransaction().commit();
//        JPA.em().close();

        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        Logger.info("Webservices record " + person + " saved. ");
        em.close();
//        final Person retrievedPerson = personRepository.findOne(savedPerson.id);

        // Deliver the index page with a message showing the id that was generated.

//        return ok(views.html.index.render("Found id: " + retrievedPerson.id + " of person/people"));

        return ok(index.render("Your new application is DACO."));
    }
}
