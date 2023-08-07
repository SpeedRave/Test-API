package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.services.HolidaysService;

@SpringBootTest
public class Holidays {
    @Autowired
    private HolidaysService holidaysService;

    @Test
    public void Save()
    {
        Boolean expected = true;

        id.amartek.app.entities.Holidays holidays = new id.amartek.app.entities.Holidays();
        holidays.setHolidays_id(1);
        holidays.setName("");
        holidays.setDate(new Date());

        Boolean result = holidaysService.Save(holidays);

        assertEquals(expected, result);
    }

    @Test
    public void Delete()
    {
        Boolean expected = true;
        Integer id = 1;

        Boolean result = holidaysService.Delete(id);

        assertEquals(expected, result);
    }
}
