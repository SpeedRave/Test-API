package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.services.DepartmentService;
import id.amartek.app.entities.Department;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void Save()
    {
        Boolean expected = true;

        Department department = new Department();
        department.setDepartment_id(2);
        department.setName("Test Department");
        department.setAddress("Jln. Testing");

        Boolean result = departmentService.Save(department);

        assertEquals(expected, result);
    }

    @Test
    public void Delete()
    {
        Boolean expected = true;
        Integer id = 2;

        Boolean result = departmentService.Delete(id);

        assertEquals(expected, result);
    }
}
