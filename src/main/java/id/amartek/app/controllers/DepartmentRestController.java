package id.amartek.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.entities.Department;
import id.amartek.app.handler.Response;
import id.amartek.app.services.DepartmentService;

@RestController
@RequestMapping("api")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;
    
    // @GetMapping("department") // http://localhost:8088/api/department
    // public List<Department> get()
    // {
    //     return departmentService.Get();
    // }

    @GetMapping("department") // http://localhost:8088/api/department
    public ResponseEntity<Object> get()
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", departmentService.Get());
    }

    // @GetMapping("department/{id}")
    // public Department get(@PathVariable(required = true) Integer id)
    // {
    //     return departmentService.Get(id);
    // }

    @GetMapping("department/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id)
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", departmentService.Get(id));
    }

    // @PostMapping("department")
    // public Boolean save(@RequestBody Department department)
    // {
    //     return departmentService.Save(department);
    // }

    @PostMapping("department")
    public ResponseEntity<Object> save(@RequestBody Department department)
    {
        departmentService.Save(department);
        return Response.generate(HttpStatus.OK, "Data Successfully Saved!");
    }

    // @DeleteMapping("department/{id}")
    // public Boolean delete(@PathVariable(required = true) Integer id)
    // {
    //     return departmentService.Delete(id);
    // }

    @DeleteMapping("department/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id)
    {
        departmentService.Delete(id);
        return Response.generate(HttpStatus.OK, "Data Successfully Deleted!");
    }
}
