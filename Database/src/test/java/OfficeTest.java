import Model.Employees;
import Model.Office;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import javax.persistence.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

public class OfficeTest {

    private int userid;

    private static EmployeesDao employeesDao;

    @Mock
    OfficeService service;

    @Spy
    List<Office> offices = new ArrayList<>();

    @Spy
    Office office;

    @Mock
    private static EntityManager em;

    @Mock
    private static EntityManagerFactory emf;

    @Mock
    private static OfficeDao officeDao;

    @Mock
    private OfficeService  officeService;

    @Mock
    private EntityTransaction et;

    @BeforeEach
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
        when(emf.createEntityManager()).thenReturn(em);

    }

    @Test
    public void testSave() throws Exception {
        List<Office> offices;
        MockitoAnnotations.initMocks(this);
        offices = officeService.findAllOffices();
        when(officeService.findAllOffices()).thenReturn(offices);
        System.out.println(offices.size());
        //Assert.assertEquals(employeeService.findAllEmployees(), []);
        Assert.assertEquals(officeService.findAllOffices(), offices);
        //Assert.assertEquals(expected.size(), employeeService.findAllEmployees().size());
        verify(officeService, atLeastOnce()).findAllOffices();


    }
    /**
    @Test
    public final void callbackTest() {
        List<Office> officeMap = new ArrayList<>();
        OfficeDao dao = mock(OfficeDao.class);
        when(dao.save(Matchers.any(Office.class))).thenAnswer(i -> {
            Office office = i.getArgument(0);
            officeMap.add(office.getDepartment(), office);
            return null;
        });
        when(dao.findOfficeById(any(Integer.class))).thenAnswer(i -> {
            int id = i.getArgument(0);
            return userMap.get(id);
        });

        Office office = new Office();
        office.entityManager =
    }

    @Test
    public void search() {
        //Office created = OfficeDao.save(office);
        Person persisted = PersonTestUtil.createModelObject(PERSON_ID, FIRST_NAME, LAST_NAME);

        when(OfficeDao.save(any(Office.class))).thenReturn(persisted);

        Mockito.when(OfficeDao.findOfficeById(1)).thenReturn(null);
    }*/

    @Test
    public void officeCreateAndDeleteTest() {
        userid = Generator.createEmployee(employeesDao, "Dmitrij", "Shevchenko", "Cz", "Praha", "Ulice2334");
        //System.out.println(userid);
        Office office = new Office();
        int department = officeDao.findAll().size() + 1;
        office.setDepartment(department);
        office.setChairNumber(454);
        office.setCabinetNumber(324);
        office.setCountry("Cz");
        office.setCity("Praha");
        office.setStreet("Ulice2323");
        office.setEmployee(userid);

        officeDao.save(office);

        Assertions.assertEquals(1, officeDao.findAll().size());

        officeDao.delete(office);

        Assertions.assertEquals(0, officeDao.findAll().size());

    }

    @Test
    public void officeCreateAndUpdateAndDelete() {
        userid = Generator.createEmployee(employeesDao, "Dimitrij", "Shevchenko", "Cz", "Praha", "Ulice2334");
        Office office = new Office();
        int department = officeDao.findAll().size() + 1;
        office.setDepartment(department);
        office.setChairNumber(455);
        office.setCabinetNumber(234);
        office.setCountry("Cz");
        office.setCity("Praha");
        office.setStreet("Ulice2323");
        office.setEmployee(userid);

        officeDao.save(office);

        Assertions.assertEquals(1, officeDao.findAll().size());

        office.setCountry("Eng");

        officeDao.update(office);

        Assertions.assertEquals("Eng", office.getCountry());

        officeDao.delete(office);

        Assertions.assertEquals(0, officeDao.findAll().size());

    }

    @Test
    public void officeCreateException() {
        userid = Generator.createEmployee(employeesDao, "Dmitij", "Shevchenko", "Cz", "Praha", "Ulice2334");
        //System.out.println(userid);
        Office office = new Office();
        int department = officeDao.findAll().size() + 1;
        office.setDepartment(department);
        office.setChairNumber(454);
        office.setCabinetNumber(324);
        office.setCountry("Cz");
        office.setCity("Praha");
        office.setStreet("Ulice2323");
        office.setEmployee(userid+1);


        Assertions.assertThrows(PersistenceException.class, () -> {
            officeDao.save(office);

            }

        );

    }









}
