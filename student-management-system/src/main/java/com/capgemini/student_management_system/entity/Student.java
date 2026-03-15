package com.capgemini.student_management_system.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String course;

    private Integer marks;

    private byte[] profileImage;

    private byte[] assignmentFile;
}