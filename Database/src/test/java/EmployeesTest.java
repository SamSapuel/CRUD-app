import Model.Employees;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.*;
import org.mockito.stubbing.OngoingStubbing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;


public class EmployeesTest {

    private int userid;

    @Mock
    EmployeeService service;

    @Spy
    List<Employees> employees = new ArrayList<Employees>();

    @Spy
    Employees employee;

    @Mock
    private static EntityManager em;

    @Mock
    private static EntityManagerFactory emf;

    @Mock
    private static EmployeesDao employeesDao;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EntityTransaction et;

    @BeforeAll
    public void setUp() throws Exception{

        Map<Object, Object> properties = new HashMap<Object, Object>();
        properties.put("openjpa.ConnectionURL",
                "jdbc:postgresql://slon.felk.cvut.cz:5432/db21_shevcdmi");
        properties.put("openjpa.ConnectionUserName", "db21_shevcdmi");
        properties.put("openjpa.ConnectionPassword", "Sk4KW5");
        //set Schema

        //set Driver Name
        emf = Persistence.createEntityManagerFactory("PersistenceUnitName",
                properties);
        em = emf.createEntityManager();
        Mockito.when(emf.createEntityManager()).thenReturn(em);


    }



    @Test
    public void testSave() throws Exception {
        List<Employees> employees;
        MockitoAnnotations.initMocks(this);
        employees = employeeService.findAllEmployees();
        when(employeeService.findAllEmployees()).thenReturn(employees);
        System.out.println(employees.size());
        //Assert.assertEquals(employeeService.findAllEmployees(), []);
        Assert.assertEquals(employeeService.findAllEmployees(), employees);
        //Assert.assertEquals(expected.size(), employeeService.findAllEmployees().size());
        verify(employeeService, atLeastOnce()).findAllEmployees();


    }

    @Test
    public void createTest() {
        //Employees employee = new Employees();
        //when(employeeService.saveEmployee(Mockito.any(Employees.class))).thenReturn(employee);


    }

    @Test
    public void employeeCreateAndUpdateAndDelete() {
        Employees employee = new Employees();
        Random random = new Random();
        int id = random.nextInt(100);
        employee.setId(id);
        employee.setName(" ");
        employee.setSurname(" ");
        employee.setCountry(" ");
        employee.setCity(" ");
        employee.setStreet(" ");

        EmployeeService employeeService1 = new EmployeeService();
        List<Employees> expected = employeeService1.findAllEmployees();
        employeeService1.saveEmployee(employee);

        Assertions.assertEquals(id, employee.getId());

        employee.setName("Dmitrij");
        employee.setSurname("Shevchenko");
        employee.setCountry("Cz");
        employee.setCity("Praha");
        employee.setStreet("Ulice234");
        employeeService1.updateEmployee(employee);

        Assertions.assertEquals("Dmitrij", employee.getName());
        Assertions.assertEquals("Shevchenko", employee.getSurname());
        Assertions.assertEquals("Cz", employee.getCountry());
        Assertions.assertEquals("Praha", employee.getCity());
        Assertions.assertEquals("Ulice234", employee.getStreet());

        employeeService1.deleteEmployee(employee);
        List<Employees> result = employeeService1.findAllEmployees();

        Assertions.assertEquals(expected.size(), result.size());
        //Mockito.doReturn(new Employees()).when(employeesDao).findById(1);

        //Mockito.verify()
    }

    @Test
    public void employee2CreateAndDelete() {
        Employees employee = new Employees();
        Random random = new Random();
        int id = random.nextInt(100);
        employee.setId(id);
        employee.setName(" ");
        employee.setSurname(" ");
        employee.setCountry(" ");
        employee.setCity(" ");
        employee.setStreet(" ");
        employeesDao.save(employee);


        employee.setId(id+1);
        employee.setName("Dimitrij");
        employee.setSurname("Shevchenko");
        employee.setCountry("Cz");
        employee.setCity("Praha");
        employee.setStreet("Ulice234");
        employeesDao.save(employee);

        Employees employees = employeesDao.findById(id);
        employeesDao.delete(employees);

        Assertions.assertEquals(1, employeesDao.findAll().size());

    }

}
