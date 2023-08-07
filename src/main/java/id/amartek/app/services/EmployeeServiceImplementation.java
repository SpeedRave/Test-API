package id.amartek.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.entities.Employee;
import id.amartek.app.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> Get() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee Get(Integer id) {
        return employeeRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Employee model) {
        employeeRepository.save(model);
        return employeeRepository.findById(model.getEmployee_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.findById(id).isPresent();
    }
}
