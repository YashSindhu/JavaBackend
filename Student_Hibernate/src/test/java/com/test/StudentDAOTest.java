package com.test;

import org.junit.jupiter.api.*;

import com.student.Student;
import com.student.StudentDAO;

import javax.persistence.*;
import java.util.List;

public class StudentDAOTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private StudentDAO dao;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    static void closeFactory() {
        emf.close();
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        dao = new StudentDAO(em);
    }

    @AfterEach
    void close() {
        em.close();
    }

    @Test
    void testSaveStudent() {
        Student s = new Student("Yash", "yash@gmail.com", 80);
        dao.saveStudent(s);
        Assertions.assertNotNull(s.getId());
    }

    @Test
    void testFindStudentById() {
        Student s = new Student("Ram", "ram@gmail.com", 70);
        dao.saveStudent(s);

        Student found = dao.findStudentById(s.getId());
        Assertions.assertEquals("Ram", found.getName());
    }

    @Test
    void testFindAllStudents() {
        dao.saveStudent(new Student("A", "a@gmail.com", 60));
        dao.saveStudent(new Student("B", "b@gmail.com", 65));

        List<Student> list = dao.findAllStudents();
        Assertions.assertTrue(list.size() >= 2);
    }

    @Test
    void testUpdateStudent() {
        Student s = new Student("Test", "test@gmail.com", 50);
        dao.saveStudent(s);

        s.setMarks(95);
        dao.updateStudent(s);

        Student updated = dao.findStudentById(s.getId());
        Assertions.assertEquals(95, updated.getMarks());
    }

    @Test
    void testDeleteStudent() {
        Student s = new Student("Delete", "delete@gmail.com", 55);
        dao.saveStudent(s);

        dao.deleteStudent(s.getId());
        Assertions.assertNull(dao.findStudentById(s.getId()));
    }

    @Test
    void testStudentCount() {
        long count = dao.getStudentCount();
        Assertions.assertTrue(count >= 0);
    }
}
