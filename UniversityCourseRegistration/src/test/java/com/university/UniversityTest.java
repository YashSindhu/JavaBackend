package com.university;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.junit.jupiter.api.*;

public class UniversityTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    private InstructorDAO instructorDAO;
    private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;
    private UniversityService service;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    static void closeFactory() {
        emf.close();
    }

    @BeforeEach
    void clearDatabase() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        // delete join table for Instructor-Course
        em.createNativeQuery("DELETE FROM instructor_course").executeUpdate();

        em.createQuery("DELETE FROM Enrollment").executeUpdate();
        em.createQuery("DELETE FROM Course").executeUpdate();
        em.createQuery("DELETE FROM Instructor").executeUpdate();
        em.createQuery("DELETE FROM InstructorProfile").executeUpdate();

        et.commit();
        em.close();
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        instructorDAO = new InstructorDAO();
        courseDAO = new CourseDAO();
        enrollmentDAO = new EnrollmentDAO();
        service = new UniversityService();
    }

    @Test
    void oneToOneMappingTest() {

        InstructorProfile profile = new InstructorProfile();
        profile.setId(1);
        profile.setOfficeRoom("A-101");
        profile.setPhone("9999999999");

        Instructor instructor = new Instructor();
        instructor.setId(1);
        instructor.setName("Dr Rao");
        instructor.setDepartment("Computer Science");

        service.createInstructorWithProfile(instructor, profile);

        Instructor fetched = instructorDAO.findInstructor(1);

        assertNotNull(fetched);
        assertEquals("A-101",
                fetched.getInstructorProfile().getOfficeRoom());
    }

    @Test
    void oneToManyMappingTest() {

        Instructor instructor = new Instructor();
        instructor.setId(2);
        instructor.setName("Dr Mehta");
        instructor.setDepartment("Physics");

        Course c1 = new Course();
        c1.setId(10);
        c1.setTitle("Quantum Mechanics");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setId(11);
        c2.setTitle("Thermodynamics");
        c2.setCredits(3);

        courseDAO.saveCourse(c1);
        courseDAO.saveCourse(c2);

        List<Course> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        instructor.setCourses(list);
        instructorDAO.saveInstructor(instructor);

        Instructor fetched = instructorDAO.findInstructor(2);

        assertEquals(2, fetched.getCourses().size());
    }

    @Test
    void manyToOneMappingTest() {

        Course course = new Course();
        course.setId(20);
        course.setTitle("Data Structures");
        course.setCredits(4);

        courseDAO.saveCourse(course);

        Enrollment enrollment = new Enrollment();
        enrollment.setId(100);
        enrollment.setSemester("Fall 2026");
        enrollment.setGrade("A");
        enrollment.setCourse(course);

        enrollmentDAO.saveEnrollment(enrollment);

        Enrollment fetched = em.find(Enrollment.class, 100);

        assertEquals("A", fetched.getGrade());
        assertEquals("Data Structures",
                fetched.getCourse().getTitle());
    }

    @Test
    void daoUpdateTest() {

        Course course = new Course();
        course.setId(30);
        course.setTitle("Algorithms");
        course.setCredits(4);

        courseDAO.saveCourse(course);

        Enrollment enrollment = new Enrollment();
        enrollment.setId(200);
        enrollment.setSemester("Spring 2026");
        enrollment.setGrade("B");
        enrollment.setCourse(course);

        enrollmentDAO.saveEnrollment(enrollment);

        enrollmentDAO.updateGrade(200, "A");

        Enrollment updated = em.find(Enrollment.class, 200);

        assertEquals("A", updated.getGrade());
    }

    @Test
    void daoDeleteTest() {

        InstructorProfile profile = new InstructorProfile();
        profile.setId(5);
        profile.setOfficeRoom("B-201");
        profile.setPhone("8888888888");

        Instructor instructor = new Instructor();
        instructor.setId(5);
        instructor.setName("Dr Sharma");
        instructor.setDepartment("Math");

        service.createInstructorWithProfile(instructor, profile);

        instructorDAO.deleteInstructor(5);

        Instructor deleted = instructorDAO.findInstructor(5);

        assertNull(deleted);
    }

    @Test
    void fullServiceIntegrationTest() {

        InstructorProfile profile = new InstructorProfile();
        profile.setId(50);
        profile.setOfficeRoom("C-301");
        profile.setPhone("7777777777");

        Instructor instructor = new Instructor();
        instructor.setId(50);
        instructor.setName("Dr Singh");
        instructor.setDepartment("IT");

        service.createInstructorWithProfile(instructor, profile);

        Course course = new Course();
        course.setId(60);
        course.setTitle("Operating Systems");
        course.setCredits(4);

        courseDAO.saveCourse(course);

        List<Course> list = new ArrayList<>();
        list.add(course);

        instructor.setCourses(list);

        Enrollment enrollment = new Enrollment();
        enrollment.setId(500);
        enrollment.setSemester("Winter 2026");
        enrollment.setGrade("B");

        service.addEnrollmentToCourse(enrollment, course);
        service.updateEnrollmentGrade(500, "A");

        Enrollment fetched = em.find(Enrollment.class, 500);

        assertEquals("A", fetched.getGrade());
    }
}
