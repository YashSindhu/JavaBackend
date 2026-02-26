package com.capgemini;

public class DepartmentService {

    private DepartmentDAO dao = new DepartmentDAO();

    public void save(Department d) { dao.save(d); }
    public Department find(Long id) { return dao.find(id); }
    public void update(Department d) { dao.update(d); }
}