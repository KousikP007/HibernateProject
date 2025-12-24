package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateDataInTable {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setsAge(22);
        s1.setsName("Abhi");
        s1.setRollNo(4);

        SessionFactory sf=new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session=sf.openSession();

        Transaction tr=session.beginTransaction();

        session.merge(s1);

        tr.commit();

    }
}
