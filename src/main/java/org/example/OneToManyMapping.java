package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyMapping {
    public static void main(String[] args) {
        Laptop l1=new Laptop();
        l1.setLid(1);
        l1.setBrand("Apple");
        l1.setModel("Mac air m1");
        l1.setRam(8);
        Laptop l2=new Laptop();
        l2.setLid(2);
        l2.setBrand("HP");
        l2.setModel("n0051");
        l2.setRam(4);
        AlienCopied a1=new AlienCopied();
        a1.setAid(1);
        a1.setAname("kousik");
        a1.setTech("hibernate");
        a1.setLaptop(Arrays.asList(l1,l2));
        SessionFactory sf= new Configuration().addAnnotatedClass(org.example.AlienCopied.class)
                                              .addAnnotatedClass(org.example.Laptop.class)
                                              .configure()
                                              .buildSessionFactory();
        Session session=sf.openSession();

        Transaction tr=session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        tr.commit();
        AlienCopied a2=session.find(AlienCopied.class,1);
        System.out.println(a2);
        session.close();
        sf.close();
    }
}
