package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Work")
public class Work implements Serializable{

    @Id
    //@JoinColumn(referencedColumnName = "PersonalID")
    @Column(name = "Employee")
    private int employee;

    @Id
    //@JoinColumn(referencedColumnName = "Department")
    @Column(name = "Department")
    private int department;

    //@JoinColumn(referencedColumnName = "Chair_number")
    @Column(name = "Chair_number")
    private int chairNumber;

    //@JoinColumn(referencedColumnName = "Cabinet_number")
    @Column(name = "Cabinet_number")
    private int cabinetNumber;


    public Work() {

    }

    public Work(int employee, int department, int chairNumber, int cabinetNumber) {
        this.employee = employee;
        this.department = department;
        this.chairNumber = chairNumber;
        this.cabinetNumber = cabinetNumber;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public long getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
