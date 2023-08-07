package id.amartek.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.entities.Holidays;
import id.amartek.app.services.HolidaysService;

@Controller
@RequestMapping("holidays")
public class HolidaysController {
    @Autowired
    private HolidaysService holidaysService;
    
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("holidayses", holidaysService.Get());
        return "holidays/index";
    }

    @GetMapping(value={"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id)
    {
        if (id != null)
        {
            model.addAttribute("holidays", holidaysService.Get(id));
        }
        else
        {
            model.addAttribute("holidays", new Holidays());
        }

        return "holidays/form";
    }

    @PostMapping("save")
    public String submit(Holidays holidays)
    {
        Boolean result = holidaysService.Save(holidays);
        return result ? "redirect:/holidays" : "holidays/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id)
    {
        holidaysService.Delete(id);
        return "redirect:/holidays";
    }
}
