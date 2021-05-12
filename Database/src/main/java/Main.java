import Model.Employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main implements ActionListener {
    private JFrame jFrame;
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

        /**
        SwingUtilities.invokeLater(() -> {              // it will wait for others operations and just then show us the window
            Window window = new Window();
            try {
                window.start();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });*/
        Main main = new Main();
        main.run();

    }

    public void run() {
        jFrame = new JFrame();
        JPanel panel = new JPanel();
        JButton employees = new JButton("Employees Table");
        JButton offices = new JButton("Offices Table");
        JButton works = new JButton("Works Table");
        employees.addActionListener(this);
        offices.addActionListener(this);
        works.addActionListener(this);

        jFrame.setSize(new Dimension(200, 200));
        jFrame.setMinimumSize(new Dimension(200, 200));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        panel.add(employees);
        panel.add(offices);
        panel.add(works);
        jFrame.add(panel);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Employees Table")) {
            try {
                Window.start();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }

            jFrame.dispose();
        }
        if (action.equals("Offices Table")) {
            Window2.start();
            jFrame.dispose();
        }
        if (action.equals("Works Table")) {
            Window3.start();
            jFrame.dispose();
        }
    }
}
