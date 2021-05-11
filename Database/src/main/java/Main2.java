import Model.Employees;
import Model.Office;

import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        OfficeService officeService = new OfficeService();
        Employees employee = new Employees(1,"Dmitrij", "Shevchenko", "CZ", "Praha", "Ulice13");
        employeeService.saveEmployee(employee);
        //Office office = new Office(0, 34, 56,  "CZ", "Praha", "Ulice123");
        //officeService.saveOffice(office);
    }
}
