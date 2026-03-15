package com.capgemini.student_management_system.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.student_management_system.entity.Student;
import com.capgemini.student_management_system.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // GET BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // GET ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setCourse(student.getCourse());
            existing.setMarks(student.getMarks());
            return studentRepository.save(existing);
        }

        return null;
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
 // GET STUDENTS WITH PAGINATION
    public Page<Student> getStudentsWithPagination(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}