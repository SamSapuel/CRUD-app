import Model.Employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.sql.SQLException;

public class Main {
/**
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WorkTable");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        /**Dimension size = new Dimension(800,600);
        JFrame jFrame = new JFrame("DBS App");
        jFrame.setPreferredSize(size);
        jFrame.setMinimumSize(size);
        jFrame.setResizable(false);
        //jFrame.add();
        jFrame.setVisible(true);
        Employees employee = new Employees();
        entityManager.getTransaction().begin();
        employee.setId(1);
        employee.setName("Dmitrij");
        employee.setSurname("Shevchenko");
        employee.setCountry("CZ");
        employee.setCity("Praha");
        employee.setStreet("Ulice123");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {              // it will wait for others operations and just then show us the window
            Window window = new Window();
            try {
                window.start();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
