package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.services.LeaveTypeService;

@SpringBootTest
public class LeaveType {
    @Autowired
    private LeaveTypeService leaveTypeService;

    @Test
    public void Save()
    {
        Boolean expected = true;

        id.amartek.app.entities.LeaveType leaveType = new id.amartek.app.entities.LeaveType();
        leaveType.setLeave_type_id(1);
        leaveType.setName("");
        leaveType.setIs_special_leave(true);
        leaveType.setDays_duration(3);

        Boolean result = leaveTypeService.Save(leaveType);

        assertEquals(expected, result);
    }

    @Test
    public void Delete()
    {
        Boolean expected = true;
        Integer id = 1;

        Boolean result = leaveTypeService.Delete(id);

        assertEquals(expected, result);
    }
}
