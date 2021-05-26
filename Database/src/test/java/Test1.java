import Model.Employees;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class Test1 {
    @Mock
    private static EntityManager em;

    @Mock
    private static EntityManagerFactory emf;

    @Mock
    private static EmployeesDao employeesDao;

    //@InjectMocks
    //private EmployeeService employeeService = new EmployeeService();

    @Mock
    private EntityTransaction et;



    @Mock
    EmployeeService service;

    @Spy
    List<Employees> employees = new ArrayList<Employees>();

    @Spy
    Employees employee;

    @BeforeAll
    public static void setUp() throws Exception{

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
    @BeforeClass
    public void setUp2() {
        MockitoAnnotations.initMocks(this);
        employees = service.findAllEmployees();
    }

    @Test
    public void listEmployees(){
        when(service.findAllEmployees()).thenReturn(employees);
        //Assert.assertEquals(appController.listEmployees(model), "allemployees");
        //Assert.assertEquals(model.get("employees"), employees);
        verify(service, atLeastOnce()).findAllEmployees();
    }
}
