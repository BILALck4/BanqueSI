package org.lsi.services;

import java.util.List;
import org.lsi.entities.Employe;
import org.lsi.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> getAllEmployees() {
        return employeRepository.findAll();
    }

    public void addEmployee(Employe employe) {
        employeRepository.save(employe);
    }

    // Other methods for employee-group assignment, etc.
}
