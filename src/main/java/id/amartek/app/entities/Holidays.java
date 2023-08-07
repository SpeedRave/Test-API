package id.amartek.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_m_holidays")
public class Holidays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int holidays_id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    public Holidays()
    {
        
    }

    public Holidays(int holidays_id, String name, java.util.Date date) {
        this.holidays_id = holidays_id;
        this.name = name;
        this.date = date;
    }
    public int getHolidays_id() {
        return holidays_id;
    }
    public void setHolidays_id(int holidays_id) {
        this.holidays_id = holidays_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
