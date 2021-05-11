import Model.Employees;
import Model.Office;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeesDao {
    public static Employees findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employees.class, id);

    }

    public static void save(Employees employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        tx1.commit();
        session.close();
    }
    public static void update(Employees employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        tx1.commit();
        session.close();
    }
    public static void delete(Employees employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        tx1.commit();
        session.close();
    }
    /**
    public static Office findOfficeById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Office.class, id);

    }*/
    public static List<Employees> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Employees> employees = (List<Employees>) session.createQuery("FROM Employees").list();
        session.close();
        return employees;

    }
}
