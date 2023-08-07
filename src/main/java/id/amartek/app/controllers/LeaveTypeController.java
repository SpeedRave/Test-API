package id.amartek.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.entities.LeaveType;
import id.amartek.app.services.LeaveTypeService;

@Controller
@RequestMapping("leave_type")
public class LeaveTypeController {
    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("leave_types", leaveTypeService.Get());
        return "leave_type/index";
    }

    @GetMapping(value={"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id)
    {
        if (id != null)
        {
            model.addAttribute("leave_type", leaveTypeService.Get(id));
        }
        else
        {
            model.addAttribute("leave_type", new LeaveType());
        }

        return "leave_type/form";
    }

    @PostMapping("save")
    public String submit(LeaveType leaveType)
    {
        Boolean result = leaveTypeService.Save(leaveType);
        return result ? "redirect:/leave_type" : "leave_type/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id)
    {
        leaveTypeService.Delete(id);
        return "redirect:/leave_type";
    }
}
