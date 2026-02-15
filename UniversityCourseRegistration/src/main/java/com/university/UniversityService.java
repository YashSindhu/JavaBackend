package com.university;

import java.util.List;

public class UniversityService {

    private InstructorDAO instructorDAO = new InstructorDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void createInstructorWithProfile(Instructor instructor, InstructorProfile profile) {
        InstructorProfileDAO profileDAO = new InstructorProfileDAO();
        profileDAO.saveProfile(profile);
        instructor.setInstructorProfile(profile);
        instructorDAO.saveInstructor(instructor);
    }

    public void addCoursesToInstructor(Instructor instructor, List<Course> courses) {
        for (Course c : courses) {
            courseDAO.saveCourse(c);
        }
        instructor.setCourses(courses);
        instructorDAO.saveInstructor(instructor);
    }

    public void addEnrollmentToCourse(Enrollment enrollment, Course course) {
        enrollment.setCourse(course);
        enrollmentDAO.saveEnrollment(enrollment);
    }

    public void updateEnrollmentGrade(int id, String grade) {
        enrollmentDAO.updateGrade(id, grade);
    }

    public Instructor fetchInstructor(int id) {
        return instructorDAO.findInstructor(id);
    }

    public void deleteInstructor(int id) {
        instructorDAO.deleteInstructor(id);
    }
}
