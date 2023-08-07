package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.services.EmployeeService;

@SpringBootTest
public class Employee {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void Save()
    {
        Boolean expected = true;

        id.amartek.app.entities.Employee employee = new id.amartek.app.entities.Employee();
        employee.setEmployee_id(1);
        employee.setAddress("");
        employee.setEmail("");
        employee.setAddress("");
        employee.setPhone_number("");
        employee.setLeave_quota(12);
        employee.setManager_id(1);

        Boolean result = employeeService.Save(employee);

        assertEquals(expected, result);
    }

    @Test
    public void Delete()
    {
        Boolean expected = true;
        Integer id = 1;

        Boolean result = employeeService.Delete(id);

        assertEquals(expected, result);
    }
}
