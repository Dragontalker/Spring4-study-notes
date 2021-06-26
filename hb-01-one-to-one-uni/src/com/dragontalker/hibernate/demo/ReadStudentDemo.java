package com.dragontalker.hibernate.demo;

import com.dragontalker.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object...");

            // create a student object
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit the transaction
            session.getTransaction().commit();

            // find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());
            
            // now get a session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());
            
            Student myStudent = session.get(Student.class, tempStudent.getId());
            
            System.out.println("Get complete: " + myStudent);
            
            // commit the transaction
            session.getTransaction().commit();
            
            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}