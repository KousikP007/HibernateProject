package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ChangeTableAndColoumnNames {
    public static void main(String[] args) {
        Laptop l1=new Laptop();
        l1.setBrand("Apple");
        l1.setModel("Mac air m1");
        l1.setRam(8);
        Alien a1=new Alien();
        a1.setAid(1);
        a1.setAname("kousik");
        a1.setTech("hibernate");
        a1.setLaptop(l1);
        SessionFactory sf=new Configuration().addAnnotatedClass(org.example.Alien.class).configure().buildSessionFactory();
        Session session=sf.openSession();

        Transaction tr=session.beginTransaction();
        session.persist(a1);
        tr.commit();
    }
}
