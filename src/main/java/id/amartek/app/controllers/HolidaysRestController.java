package id.amartek.app.controllers;

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

import id.amartek.app.entities.Holidays;
import id.amartek.app.handler.Response;
import id.amartek.app.services.HolidaysService;

@RestController
@RequestMapping("api")
public class HolidaysRestController {
    @Autowired
    private HolidaysService holidaysService;

    @GetMapping("holidays")
    public ResponseEntity<Object> get()
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", holidaysService.Get());
    }

    @GetMapping("holidays/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id)
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", holidaysService.Get(id));
    }

    @PostMapping("holidays")
    public ResponseEntity<Object> save(@RequestBody Holidays holidays)
    {
        holidaysService.Save(holidays);
        return Response.generate(HttpStatus.OK, "Data Successfully Saved!");
    }

    @DeleteMapping("holidays/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id)
    {
        holidaysService.Delete(id);
        return Response.generate(HttpStatus.OK, "Data Successfully Deleted!");
    }
}
