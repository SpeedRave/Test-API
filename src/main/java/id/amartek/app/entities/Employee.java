package id.amartek.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String full_name;
    private String email;
    private String address;
    private String phone_number;
    private int leave_quota;
    private Integer manager_id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Leave> leaves;
    
    public Employee()
    {
        
    }

    public Employee(int employee_id, String full_name, String email, String address, String phone_number,
            int leave_quota, Integer manager_id, Department department) {
        this.employee_id = employee_id;
        this.full_name = full_name;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.leave_quota = leave_quota;
        this.manager_id = manager_id;
        this.department = department;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getLeave_quota() {
        return leave_quota;
    }

    public void setLeave_quota(int leave_quota) {
        this.leave_quota = leave_quota;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // public Employee(int employee_id, String full_name, String email, String address, String phone_number,
    //         int leave_quota, int manager_id) {
    //     this.employee_id = employee_id;
    //     this.full_name = full_name;
    //     this.email = email;
    //     this.address = address;
    //     this.phone_number = phone_number;
    //     this.leave_quota = leave_quota;
    //     this.manager_id = manager_id;
    // }

    // public int getEmployee_id() {
    //     return employee_id;
    // }

    // public void setEmployee_id(int employee_id) {
    //     this.employee_id = employee_id;
    // }

    // public String getFull_name() {
    //     return full_name;
    // }

    // public void setFull_name(String full_name) {
    //     this.full_name = full_name;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public String getPhone_number() {
    //     return phone_number;
    // }

    // public void setPhone_number(String phone_number) {
    //     this.phone_number = phone_number;
    // }

    // public int getLeave_quota() {
    //     return leave_quota;
    // }

    // public void setLeave_quota(int leave_quota) {
    //     this.leave_quota = leave_quota;
    // }

    // public Integer getManager_id() {
    //     return manager_id;
    // }

    // public void setManager_id(Integer manager_id) {
    //     this.manager_id = manager_id;
    // }

    // public Department getDepartment() {
    //     return department;
    // }

    // public void setDepartment(Department department) {
    //     this.department = department;
    // }
}
