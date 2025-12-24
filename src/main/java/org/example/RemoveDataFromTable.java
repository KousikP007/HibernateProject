package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemoveDataFromTable {
    public static void main(String[] args) {
        Student s1;
        SessionFactory sf= new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session=sf.openSession();
        s1=session.find(Student.class,2);
        Transaction tr=session.beginTransaction();
        session.remove(s1);
        tr.commit();
    }
}
