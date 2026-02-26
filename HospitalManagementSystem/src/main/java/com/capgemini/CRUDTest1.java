package com.capgemini;


public class CRUDTest1 {
    public static void main(String[] args) {

        DepartmentService deptService = new DepartmentService();
        DoctorService docService = new DoctorService();

        // 1. Departments
        Department cardio = new Department("Cardiology", "Block A", "Dr. Rao");
        Department neuro = new Department("Neurology", "Block B", "Dr. Meena");

        // 2. Doctors
        Doctor d1 = new Doctor("Dr. Smith", "Heart", "LIC101");
        Doctor d2 = new Doctor("Dr. Patel", "Heart", "LIC102");
        Doctor d3 = new Doctor("Dr. Sharma", "Brain", "LIC201");
        Doctor d4 = new Doctor("Dr. Mehta", "Brain", "LIC202");

        // Add doctors to departments
        cardio.addDoctor(d1);
        cardio.addDoctor(d2);
        neuro.addDoctor(d3);
        neuro.addDoctor(d4);

        deptService.save(cardio);
        deptService.save(neuro);

        System.out.println("Departments saved");

        // Fetch department
        Department d = deptService.find(cardio.getId());
        System.out.println("Doctors in Cardiology:");
        d.getDoctors().forEach(doc -> System.out.println(doc.getName()));

        // Transfer doctor
        cardio.removeDoctor(d1);
        neuro.addDoctor(d1);
        deptService.update(cardio);
        deptService.update(neuro);

        System.out.println("Doctor transferred");

        // JPQL-like manual behavior
        System.out.println("Updated Cardiology Doctors:");
        deptService.find(cardio.getId())
                .getDoctors()
                .forEach(doc -> System.out.println(doc.getName()));
    }
}