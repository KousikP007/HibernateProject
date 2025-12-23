package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setRollNo(3);
        s1.setsName("sumit");
        s1.setsAge(15);
        //update/fetch data -create new obj
        Student s2=null;
//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
        SessionFactory sf=new Configuration().addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session=sf.openSession();
        //create or manupulate data
       /* Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();
        System.out.println(s1);
*/
        //update/fetch data

        s2=session.find(Student.class,1);

        System.out.println(s2.getsAge());
        session.close();
        sf.close();
        }
    }
