package com.capgemini;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class CRUDTest4 {
    public static void main(String[] args) {

        AppointmentService service = new AppointmentService();

        // Appointment with prescription
        Prescription p = new Prescription("Paracetamol", "2/day", LocalDate.now());
        Appointment a1 = new Appointment(LocalDateTime.now(), "SCHEDULED", "Migraine");
        a1.setPrescription(p);

        // Appointment without prescription
        Appointment a2 = new Appointment(LocalDateTime.now(), "SCHEDULED", "Chest Pain");

        service.save(a1);
        service.save(a2);

        System.out.println("Appointments saved.");

        Appointment x1 = service.find(a1.getId());
        Appointment x2 = service.find(a2.getId());

        if (x1.getPrescription() != null)
            System.out.println("A1 Prescription: " + x1.getPrescription().getMedicines());
        else
            System.out.println("A1 has no prescription");

        if (x2.getPrescription() != null)
            System.out.println("A2 Prescription: " + x2.getPrescription().getMedicines());
        else
            System.out.println("A2 has no prescription");
    }
}