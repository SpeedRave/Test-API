package id.amartek.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_leave_type")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_type_id;
    private String name;
    private boolean is_special_leave;
    private int days_duration;

    @OneToMany(mappedBy = "leaveType") //Mapped By ke nama atribut yang ada pada Model Leave
    @JsonIgnore
    private List<Leave> leave;

    public LeaveType()
    {
        
    }
    
    public LeaveType(int leave_type_id, String name, boolean is_special_leave, int days_duration) {
        this.leave_type_id = leave_type_id;
        this.name = name;
        this.is_special_leave = is_special_leave;
        this.days_duration = days_duration;
    }

    public int getLeave_type_id() {
        return leave_type_id;
    }

    public void setLeave_type_id(int leave_type_id) {
        this.leave_type_id = leave_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_special_leave() {
        return is_special_leave;
    }

    public void setIs_special_leave(boolean is_special_leave) {
        this.is_special_leave = is_special_leave;
    }

    public int getDays_duration() {
        return days_duration;
    }

    public void setDays_duration(int days_duration) {
        this.days_duration = days_duration;
    }

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }
}
