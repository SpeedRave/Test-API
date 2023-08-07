package id.amartek.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.entities.Leave;
import id.amartek.app.services.EmployeeService;
import id.amartek.app.services.LeaveService;
import id.amartek.app.services.LeaveTypeService;

@Controller
@RequestMapping("leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("leaves", leaveService.Get());
        return "leave/index";
    }

    @GetMapping(value={"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id)
    {
        if (id != null)
        {
            model.addAttribute("leaveTypes", leaveTypeService.Get());
            model.addAttribute("employees", employeeService.Get());
            model.addAttribute("leave", leaveService.Get(id));
        }
        else
        {
            model.addAttribute("leaveTypes", leaveTypeService.Get());
            model.addAttribute("employees", employeeService.Get());
            model.addAttribute("leave", new Leave());
        }

        return "leave/form";
    }

    @PostMapping("save")
    public String submit(Leave leave)
    {
        if (leave.getApproval_status() == "")
        {
            Date now = new Date(System.currentTimeMillis());
            leave.setApply_time(now);
            leave.setApproval_status("Pending");
        }
        
        String name = employeeService.Get(leave.getEmployee().getManager_id()).getFull_name();
        leave.setApproval_by(name);
        Boolean result = leaveService.Save(leave);
        return result ? "redirect:/leave" : "leave/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id)
    {
        leaveService.Delete(id);
        return "redirect:/leave";
    }
}
