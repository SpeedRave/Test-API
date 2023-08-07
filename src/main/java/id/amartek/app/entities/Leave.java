package id.amartek.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_tr_leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date apply_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leave_from;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leave_to;
    private String reason;
    private String approval_by;
    private String approval_status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date approval_date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    public Leave()
    {
        
    }

    public Leave(int leave_id, Date apply_time, Date leave_from, Date leave_to, String reason, String approval_by,
            String approval_status, Date approval_date, Employee employee, LeaveType leaveType) {
        this.leave_id = leave_id;
        this.apply_time = apply_time;
        this.leave_from = leave_from;
        this.leave_to = leave_to;
        this.reason = reason;
        this.approval_by = approval_by;
        this.approval_status = approval_status;
        this.approval_date = approval_date;
        this.employee = employee;
        this.leaveType = leaveType;
    }

    public int getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(int leave_id) {
        this.leave_id = leave_id;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public Date getLeave_from() {
        return leave_from;
    }

    public void setLeave_from(Date leave_from) {
        this.leave_from = leave_from;
    }

    public Date getLeave_to() {
        return leave_to;
    }

    public void setLeave_to(Date leave_to) {
        this.leave_to = leave_to;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApproval_by() {
        return approval_by;
    }

    public void setApproval_by(String approval_by) {
        this.approval_by = approval_by;
    }

    public String getApproval_status() {
        return approval_status;
    }

    public void setApproval_status(String approval_status) {
        this.approval_status = approval_status;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    // public Leave(int leave_id, Date apply_time, Date leave_from, Date leave_to, String reason, String approval_by,
    //         String approval_status, Date approval_date) {
    //     this.leave_id = leave_id;
    //     this.apply_time = apply_time;
    //     this.leave_from = leave_from;
    //     this.leave_to = leave_to;
    //     this.reason = reason;
    //     this.approval_by = approval_by;
    //     this.approval_status = approval_status;
    //     this.approval_date = approval_date;
    // }

    // public int getLeave_id() {
    //     return leave_id;
    // }

    // public void setLeave_id(int leave_id) {
    //     this.leave_id = leave_id;
    // }

    // public Date getApply_time() {
    //     return apply_time;
    // }

    // public void setApply_time(Date apply_time) {
    //     this.apply_time = apply_time;
    // }

    // public Date getLeave_from() {
    //     return leave_from;
    // }

    // public void setLeave_from(Date leave_from) {
    //     this.leave_from = leave_from;
    // }

    // public Date getLeave_to() {
    //     return leave_to;
    // }

    // public void setLeave_to(Date leave_to) {
    //     this.leave_to = leave_to;
    // }

    // public String getReason() {
    //     return reason;
    // }

    // public void setReason(String reason) {
    //     this.reason = reason;
    // }

    // public String getApproval_by() {
    //     return approval_by;
    // }

    // public void setApproval_by(String approval_by) {
    //     this.approval_by = approval_by;
    // }

    // public String getApproval_status() {
    //     return approval_status;
    // }

    // public void setApproval_status(String approval_status) {
    //     this.approval_status = approval_status;
    // }

    // public Date getApproval_date() {
    //     return approval_date;
    // }

    // public void setApproval_date(Date approval_date) {
    //     this.approval_date = approval_date;
    // }

}
