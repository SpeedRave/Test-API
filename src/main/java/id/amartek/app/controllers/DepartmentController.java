package id.amartek.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.entities.Department;
import id.amartek.app.services.DepartmentService;

@Controller
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("departments", departmentService.Get());
        return "department/index";
    }

    @GetMapping(value={"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id)
    {
        if (id != null)
        {
            model.addAttribute("department", departmentService.Get(id));
        }
        else
        {
            model.addAttribute("department", new Department());
        }

        return "department/form";
    }

    @PostMapping("save")
    public String submit(Department department)
    {
        Boolean result = departmentService.Save(department);
        return result ? "redirect:/department" : "department/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id)
    {
        departmentService.Delete(id);
        return "redirect:/department";
    }
}
