package com.capgemini;


public class AppointmentService {

    private AppointmentDAO dao = new AppointmentDAO();

    public void save(Appointment a) { dao.save(a); }
    public Appointment find(Long id) { return dao.find(id); }
    public void update(Appointment a) { dao.update(a); }
}