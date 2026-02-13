package com.student;

import javax.persistence.*;
import java.util.List;

public class StudentDAO {

    private EntityManager em;

    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveStudent(Student s) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(s);
        tx.commit();
    }

    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                 .getResultList();
    }

    public void updateStudent(Student s) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(s);
        tx.commit();
    }

    public void deleteStudent(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, id);
        if (s != null) {
            em.remove(s);
        }
        tx.commit();
    }

    public long getStudentCount() {
        return em.createQuery("SELECT COUNT(s) FROM Student s", Long.class)
                 .getSingleResult();
    }
}
