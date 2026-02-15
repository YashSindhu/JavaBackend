package com.university;

import javax.persistence.*;
import java.util.List;

public class CourseDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(course);
        et.commit();
        em.close();
    }

    public Course findCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, id);
        em.close();
        return course;
    }

	
}
