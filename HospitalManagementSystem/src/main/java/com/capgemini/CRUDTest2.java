package com.capgemini;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CRUDTest2 {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // 1. Create Departments
        Department cardio = new Department("Cardiology", "Block A", "Dr. Rao");
        Department neuro  = new Department("Neurology", "Block B", "Dr. Kapoor");

        // 2. Create Doctors
        Doctor d1 = new Doctor("Dr. Smith", "Heart", "LIC100");
        Doctor d2 = new Doctor("Dr. Patel", "Heart", "LIC101");
        Doctor d3 = new Doctor("Dr. Sharma", "Brain", "LIC200");
        Doctor d4 = new Doctor("Dr. Mehta", "Brain", "LIC201");

        // 3. Add Doctors via helper method
        cardio.addDoctor(d1);
        cardio.addDoctor(d2);
        neuro.addDoctor(d3);
        neuro.addDoctor(d4);

        // 4. Persist
        em.persist(cardio);
        em.persist(neuro);

        tx.commit();

        System.out.println("==== DOCTORS SAVED ====");

        // 5. Navigation
        Department d = em.find(Department.class, cardio.getId());
        System.out.println("Cardiology Doctors: ");
        d.getDoctors().forEach(doc -> System.out.println(doc.getName()));

        // 6. Transfer Doctor
        tx.begin();
        cardio.removeDoctor(d1);
        neuro.addDoctor(d1);
        tx.commit();

        System.out.println("==== TRANSFER DONE ====");

        // 7. JPQL Query
        System.out.println("==== All Cardiology Doctors ====");
        em.createQuery("SELECT d FROM Doctor d WHERE d.department.name = :dn", Doctor.class)
                .setParameter("dn", "Cardiology")
                .getResultList()
                .forEach(doc -> System.out.println(doc.getName()));

        em.close();
    }
}
