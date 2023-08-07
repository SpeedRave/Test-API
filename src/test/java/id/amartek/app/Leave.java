package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.services.LeaveService;

@SpringBootTest
public class Leave {
    @Autowired
    private LeaveService leaveService;

    @Test
    public void Save()
    {
        Boolean expected = true;

        id.amartek.app.entities.Leave leave = new id.amartek.app.entities.Leave();
        leave.setLeave_id(1);
        leave.setApply_time(new Date());
        leave.setLeave_from(new Date());
        leave.setLeave_to(new Date());
        leave.setReason("");
        leave.setApproval_by("");
        leave.setApproval_status("");
        leave.setApproval_date(new Date());

        Boolean result = leaveService.Save(leave);

        assertEquals(expected, result);
    }

    @Test
    public void Delete()
    {
        Boolean expected = true;
        Integer id = 1;

        Boolean result = leaveService.Delete(id);

        assertEquals(expected, result);
    }
}
