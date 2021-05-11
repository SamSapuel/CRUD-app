import Model.Employees;
import Model.Office;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OfficeDao {
    public static Office findOfficeById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Office.class, id);

    }

    public static void save(Office office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(office);
        tx1.commit();
        session.close();
    }
    public static void update(Office office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(office);
        tx1.commit();
        session.close();
    }
    public static void delete(Office office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(office);
        tx1.commit();
        session.close();
    }

    public static List<Office> findAll() {
        List<Office> offices = (List<Office>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Office ").list();
        return offices;

    }


}
