package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Work")
public class Work {
    @Id
    private int employee;

    @Id
    private int office;

    public Work() {

    }

    public Work(int employee, int office) {
        this.employee = employee;
        this.office = office;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public long getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }
}
