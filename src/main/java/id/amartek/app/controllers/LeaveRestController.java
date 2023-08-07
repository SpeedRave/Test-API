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

import id.amartek.app.entities.Leave;
import id.amartek.app.handler.Response;
import id.amartek.app.services.LeaveService;

@RestController
@RequestMapping("api")
public class LeaveRestController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("leave")
    public ResponseEntity<Object> get()
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", leaveService.Get());
    }

    @GetMapping("leave/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id)
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", leaveService.Get(id));
    }

    @PostMapping("leave")
    public ResponseEntity<Object> save(@RequestBody Leave leave)
    {
        leaveService.Save(leave);
        return Response.generate(HttpStatus.OK, "Data Successfully Saved!");
    }

    @DeleteMapping("leave/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id)
    {
        leaveService.Delete(id);
        return Response.generate(HttpStatus.OK, "Data Successfully Deleted!");
    }
}
