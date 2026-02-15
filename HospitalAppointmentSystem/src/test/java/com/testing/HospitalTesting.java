package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mappingAssignment.Appointment;
import com.mappingAssignment.AppointmentDAO;
import com.mappingAssignment.Doctor;
import com.mappingAssignment.DoctorDAO;
import com.mappingAssignment.HospitalService;
import com.mappingAssignment.MedicalRecord;
import com.mappingAssignment.Patient;
import com.mappingAssignment.PatientDAO;

public class HospitalTesting {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;
    private AppointmentDAO appointmentDAO;
    private HospitalService service;

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

        // delete join table FIRST
        em.createNativeQuery("DELETE FROM doctor_appointment").executeUpdate();

        em.createQuery("DELETE FROM Appointment").executeUpdate();
        em.createQuery("DELETE FROM Doctor").executeUpdate();
        em.createQuery("DELETE FROM Patient").executeUpdate();
        em.createQuery("DELETE FROM MedicalRecord").executeUpdate();

        et.commit();
        em.close();
    }


    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        et = em.getTransaction();

        patientDAO = new PatientDAO();
        doctorDAO = new DoctorDAO();
        appointmentDAO = new AppointmentDAO();
        service = new HospitalService();
    }

    @Test
    void oneToOnePersistTest() {

        MedicalRecord record = new MedicalRecord();
        record.setId(1);
        record.setBloodGroup("O+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Yash");
        patient.setAge(22);
        patient.setContact("9999999999");
        patient.setMedicalRecord(record);

        service.registerPatient(patient, record);

        Patient fetched = patientDAO.findPatient(1);

        assertNotNull(fetched);
        assertEquals("O+", fetched.getMedicalRecord().getBloodGroup());
    }

    @Test
    void manyToOnePersistTest() {

    	Patient p = new Patient();
    	p.setId(2);
    	p.setName("Rohit");
    	p.setAge(25);
    	p.setContact("8888888888");

    	patientDAO.savePatient(p);   // SAVE PATIENT FIRST

    	Appointment a = new Appointment();
    	a.setId(10);
    	a.setVisDate("2026-02-15");
    	a.setFee(500);
    	a.setPatient(p);

    	appointmentDAO.saveAppointment(a);  // THEN SAVE APPOINTMENT


        Appointment fetched = em.find(Appointment.class, 10);

        assertEquals(500, fetched.getFee());
        assertEquals("Rohit", fetched.getPatient().getName());
    }

    @Test
    void oneToManyPersistTest() {

        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr Sharma");
        doctor.setSpecialization("Cardiology");

        Appointment a1 = new Appointment();
        a1.setId(20);
        a1.setVisDate("2026-02-16");
        a1.setFee(1000);

        Appointment a2 = new Appointment();
        a2.setId(21);
        a2.setVisDate("2026-02-17");
        a2.setFee(1500);

        // SAVE APPOINTMENTS FIRST
        appointmentDAO.saveAppointment(a1);
        appointmentDAO.saveAppointment(a2);

        List<Appointment> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        doctor.setAppointment(list);

        // NOW SAVE DOCTOR
        doctorDAO.saveDoctor(doctor);

        Doctor fetched = doctorDAO.findDoctor(1);

        assertEquals(2, fetched.getAppointment().size());
    }


    @Test
    void daoUpdateTest() {

    	Patient p = new Patient();
    	p.setId(5);
    	p.setName("Test");
    	p.setAge(22);
    	p.setContact("9999999999");

    	patientDAO.savePatient(p);  // SAVE PARENT FIRST

    	Appointment a = new Appointment();
    	a.setId(30);
    	a.setVisDate("2026-02-18");
    	a.setFee(700);
    	a.setPatient(p);

    	appointmentDAO.saveAppointment(a);

    	appointmentDAO.updateFee(30, 900);


        Appointment updated = em.find(Appointment.class, 30);

        assertEquals(900, updated.getFee());
    }

    @Test
    void daoDeleteTest() {

        Patient p = new Patient();
        p.setId(50);
        p.setName("DeleteTest");
        p.setAge(30);
        p.setContact("7777777777");

        patientDAO.savePatient(p);

        patientDAO.deletePatient(50);

        Patient deleted = em.find(Patient.class, 50);

        assertNull(deleted);
    }

    @Test
    void serviceWorkflowTest() {

        MedicalRecord record = new MedicalRecord();
        record.setId(60);
        record.setBloodGroup("A+");
        record.setAllergies("Dust");

        Patient patient = new Patient();
        patient.setId(60);
        patient.setName("Workflow");
        patient.setAge(28);
        patient.setContact("6666666666");

        service.registerPatient(patient, record);

        Appointment appointment = new Appointment();
        appointment.setId(61);
        appointment.setVisDate("2026-02-20");
        appointment.setFee(1000);

        service.assignAppointmentToPatient(appointment, patient);

        service.updateAppointmentFee(61, 1200);

        Appointment updated = em.find(Appointment.class, 61);

        assertEquals(1200, updated.getFee());
    }
}

