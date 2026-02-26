package com.capgemini;

public class PatientService {

    private PatientDAO dao = new PatientDAO();

    public void save(Patient p) {
        dao.save(p);
    }

    public Patient find(Long id) {
        return dao.find(id);
    }

    public void update(Patient p) {
        dao.update(p);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}