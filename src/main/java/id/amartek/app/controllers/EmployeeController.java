package id.amartek.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.entities.Employee;
import id.amartek.app.services.DepartmentService;
import id.amartek.app.services.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("employees", employeeService.Get());
        return "employee/index";
    }

    @GetMapping(value={"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id)
    {
        if (id != null)
        {
            model.addAttribute("departments", departmentService.Get(id));
            model.addAttribute("employee", employeeService.Get(id));
        }
        else
        {
            model.addAttribute("departments", departmentService.Get());
            model.addAttribute("employee", new Employee());
        }

        return "employee/form";
    }

    @PostMapping("save")
    public String submit(Employee employee)
    {
        Boolean result = employeeService.Save(employee);
        return result ? "redirect:/employee" : "employee/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id)
    {
        employeeService.Delete(id);
        return "redirect:/employee";
    }
}
