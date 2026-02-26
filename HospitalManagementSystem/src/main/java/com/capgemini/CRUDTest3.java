package com.capgemini;

import java.time.LocalDateTime;

public class CRUDTest3 {
    public static void main(String[] args) {

        DoctorService service = new DoctorService();

        Doctor d = new Doctor("Dr. Yash", "General", "LIC900");

        Appointment a1 = new Appointment(LocalDateTime.now(), "SCHEDULED", "Fever");
        Appointment a2 = new Appointment(LocalDateTime.now().plusDays(1), "SCHEDULED", "Cold");
        Appointment a3 = new Appointment(LocalDateTime.now().plusDays(2), "CANCELLED", "Headache");

        d.getAppointments().add(a1);
        d.getAppointments().add(a2);
        d.getAppointments().add(a3);

        service.save(d);

        System.out.println("Appointments saved.");

        System.out.println("Doctor from appointment? (expected null): " + a1.getDoctor());

        // Update status
        a1.setStatus("COMPLETED");
        service.update(d);
        System.out.println("Status updated.");
    }
}