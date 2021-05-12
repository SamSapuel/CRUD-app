import Model.Office;
import Model.Work;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WorkDao {
    public static Work findWorkById(int employee) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Work.class, employee);

    }

    public static void save(Work work) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(work);
        tx1.commit();
        session.close();
    }
    public static void update(Work work) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(work);
        tx1.commit();
        session.close();
    }
    public static void delete(Work work) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(work);
        tx1.commit();
        session.close();
    }

    public static List<Work> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Work> works = (List<Work>) session.createQuery("SELECT w FROM Work w ").list();
        return works;

    }
}
