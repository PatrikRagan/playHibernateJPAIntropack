package controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Menu;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is index."));
    }

//    @javax.persistence.Transactional
    public Result daco(){
        Menu xxx = new Menu();
        xxx.price = 100;
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(xxx);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("update");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(xxx);
        entityManager.getTransaction().commit();
        entityManager.close();

        return ok(index.render("Your new application is DACO."));
    }
}
