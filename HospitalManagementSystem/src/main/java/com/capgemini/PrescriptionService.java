package com.capgemini;


public class PrescriptionService {

    private PrescriptionDAO dao = new PrescriptionDAO();

    public Prescription find(Long id) { return dao.find(id); }
}