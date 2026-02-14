package com.mappingAssignment;

import java.util.List;

public class HospitalService {

    private PatientDAO patientDAO = new PatientDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    public void registerPatient(Patient patient, MedicalRecord record) {
    	// Save record first
        medicalRecordDAO.saveMedicalRecord(record);

        // Now set relationship
        patient.setMedicalRecord(record);

        // Now save patient
        patientDAO.savePatient(patient);
    }

    public void addAppointmentsToDoctor(Doctor doctor, List<Appointment> list) {
        doctor.setAppointment(list);
        doctorDAO.saveDoctor(doctor);
    }

    public void assignAppointmentToPatient(Appointment appointment, Patient patient) {
        appointment.setPatient(patient);
        appointmentDAO.saveAppointment(appointment);
    }

    public void updateAppointmentFee(int id, double fee) {
        appointmentDAO.updateFee(id, fee);
    }

    public Doctor fetchDoctor(int id) {
        return doctorDAO.findDoctor(id);
    }

    public void deletePatient(int id) {
        patientDAO.deletePatient(id);
    }
}
