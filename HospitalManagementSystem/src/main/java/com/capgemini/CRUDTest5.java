package com.capgemini;


import java.time.LocalDate;

public class CRUDTest5 {
    public static void main(String[] args) {

        DoctorService service = new DoctorService();

        Doctor mehta = new Doctor("Dr. Mehta", "Cardiology", "C100");
        Doctor singh = new Doctor("Dr. Singh", "Neurology", "N200");

        Patient ali = new Patient("Ali", LocalDate.of(2000,1,1), "A+", "1111");
        Patient priya = new Patient("Priya", LocalDate.of(2001,4,2), "B+", "2222");
        Patient raj = new Patient("Raj", LocalDate.of(2002,8,9), "O+", "3333");

        mehta.addPatient(ali);
        mehta.addPatient(priya);

        singh.addPatient(ali);
        singh.addPatient(raj);

        service.save(mehta);
        service.save(singh);

        System.out.println("Doctor-patient mappings saved.");

        Doctor d = service.find(mehta.getId());
        System.out.println("Patients of Dr Mehta:");
        d.getPatients().forEach(p -> System.out.println(p.getName()));

        System.out.println("Doctors treating Ali:");
        ali.getDoctors().forEach(doc -> System.out.println(doc.getName()));

        // Discharge
        mehta.removePatient(ali);
        service.update(mehta);

        System.out.println("Ali discharged from Dr Mehta.");
    }
}