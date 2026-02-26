package com.capgemini;


public class DoctorService {

    private DoctorDAO dao = new DoctorDAO();

    public void save(Doctor d) { dao.save(d); }
    public Doctor find(Long id) { return dao.find(id); }
    public void update(Doctor d) { dao.update(d); }
}