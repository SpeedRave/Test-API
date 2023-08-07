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

import id.amartek.app.entities.LeaveType;
import id.amartek.app.handler.Response;
import id.amartek.app.services.LeaveTypeService;

@RestController
@RequestMapping("api")
public class LeaveTypeRestController {
    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping("leave_type")
    public ResponseEntity<Object> get()
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", leaveTypeService.Get());
    }

    @GetMapping("leave_type/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id)
    {
        return Response.generate(HttpStatus.OK, "Data Successfully Retreived!", leaveTypeService.Get(id));
    }

    @PostMapping("leave_type")
    public ResponseEntity<Object> save(@RequestBody LeaveType leaveType)
    {
        leaveTypeService.Save(leaveType);
        return Response.generate(HttpStatus.OK, "Data Successfully Saved!");
    }

    @DeleteMapping("leave_type/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id)
    {
        leaveTypeService.Delete(id);
        return Response.generate(HttpStatus.OK, "Data Successfully Deleted!");
    }
}
