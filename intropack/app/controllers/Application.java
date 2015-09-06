package controllers;

import model.Menu;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

  public Result index() {
    return ok(index.render("Your new application is index."));
  }

  //    @javax.persistence.Transactional
  @Transactional
  public Result daco() {
    Menu xxx = new Menu();
    xxx.price = 100;
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(xxx);
    if (JPA.em().getTransaction().isActive()) {
      JPA.em().flush();
      JPA.em().getTransaction().begin();
      JPA.em().persist(xxx);
      JPA.em().getTransaction().commit();
      JPA.em().close();
    }
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lakers");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(xxx);
//        entityManager.getTransaction().commit();
//        entityManager.close();

    return ok(index.render("Your new application is DACO."));
  }
}
