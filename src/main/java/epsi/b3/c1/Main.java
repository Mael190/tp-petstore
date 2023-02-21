package epsi.b3.c1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import epsi.b3.c1.entities.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product p1 = new Product("1111", "chapeau", ProdType.ACCESSORY, 15.00);
        Product p2 = new Product("1112", "granulé", ProdType.FOOD, 18.00);
        Product p3 = new Product("1113", "savon", ProdType.CLEANING, 10.00);

        Address address1 = new Address("12", "rue d'ici", "44000", "Nantes");
        Address address2 = new Address("87", "rue de par là", "44400", "Rezé");
        Address address3 = new Address("82", "rue jesuisperdu", "44200", "Beaulieu");

        PetStore petStore1 = new PetStore("Boucherie", "Jerome", address1);
        PetStore petStore2 = new PetStore("L'art naque", "Momo", address2);
        PetStore petStore3 = new PetStore("Guet appen", "Patrick", address3);

        petStore1.addProduct(p1);
        petStore1.addProduct(p2);
        petStore1.addProduct(p3);
        petStore2.addProduct(p1);
        petStore2.addProduct(p2);
        petStore2.addProduct(p3);
        petStore3.addProduct(p1);
        petStore3.addProduct(p2);
        petStore3.addProduct(p3);

        Animal a1 = new Animal(LocalDate.now(), "blanc", petStore1);
        Cat cat1 = new Cat(LocalDate.now(), "blanc", petStore1, "2842244");
        Fish fish1 = new Fish(LocalDate.now(), "blanc", petStore1, FishLivEnv.SEA_WATER);

        Animal a2 = new Animal(LocalDate.now(), "noir", petStore2);
        Cat cat2 = new Cat(LocalDate.now(), "noir", petStore2, "77329472");
        Fish fish2 = new Fish(LocalDate.now(), "noir", petStore2, FishLivEnv.FRESH_WATER);

        Animal a3 = new Animal(LocalDate.now(), "vert", petStore3);
        Cat cat3 = new Cat(LocalDate.now(), "vert", petStore3, "7843535");
        Fish fish3 = new Fish(LocalDate.now(), "vert", petStore3, FishLivEnv.FRESH_WATER);


        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);

        em.persist(a1);
        em.persist(cat1);
        em.persist(fish1);
        em.persist(a2);
        em.persist(cat2);
        em.persist(fish2);
        em.persist(a3);
        em.persist(cat3);
        em.persist(fish3);


        em.getTransaction().commit();

        Query q = em.createQuery("select id, birth, color from Animal where petStore.id = 2");
        List resultList = q.getResultList();
        System.out.println("Nombre d'animal: :" + resultList.size());

        for (Object animal : resultList) {
            System.out.println("Animal: " + animal);
        }

        em.close();
        emf.close();
    }
}