
package forms;

import org.Yaed.entity.Administrador;
import org.Yaed.entity.User;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;
import org.apache.commons.collections4.ArrayStack;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Admin extends JInternalFrame {
    static Admin myAdmin;

    private Admin() {
        super("Administradores", true, true, true,true);
        InicializarAdmin();
        myAdmin = this;
    }

    private void InicializarAdmin() {
        setLayout(new BorderLayout());
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(new Dimension(screen.width - 800, screen.height - 100));
        setSize(new Dimension(750,600));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255, 179, 2);
        Color dk = new Color(46, 21, 59);
        this.setBackground(dk);

        JLabel title = new JLabel("Administradores del negocio");
        title.setForeground(yell);
        title.setFont(font20);
        title.setBounds(30, 20, 400, 40);

        JLabel emailA = new JLabel("Email:");
        emailA.setForeground(yell);
        emailA.setFont(font12);
        emailA.setBounds(30, 90, 100, 30);

        JLabel passA = new JLabel("Contraseña:");
        passA.setForeground(yell);
        passA.setFont(font12);
        passA.setBounds(30, 90, 100, 30);

        JLabel nameA = new JLabel("Nombre:");
        nameA.setForeground(yell);
        nameA.setFont(font12);
        nameA.setBounds(30, 90, 100, 30);

        JLabel apeA = new JLabel("Apellido:");
        apeA.setForeground(yell);
        apeA.setFont(font12);
        apeA.setBounds(30, 150, 100, 30);

        JLabel cedA = new JLabel("Cedula:");
        cedA.setForeground(yell);
        cedA.setFont(font12);
        cedA.setBounds(30, 200, 100, 30);

        JTextField emailtxt = new JTextField();
        emailtxt.setOpaque(false);
        emailtxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        emailtxt.setForeground(yell);
        emailtxt.setFont(font12);
        emailtxt.setColumns(20);

        JPasswordField passTxt = new JPasswordField();
        passTxt.setOpaque(false);
        passTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//        namTxt.setBounds(90, 90, 200, 30);
        passTxt.setForeground(yell);
        passTxt.setFont(font12);
        passTxt.setColumns(20);

        JTextField namTxt = new JTextField();
        namTxt.setOpaque(false);
        namTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//        namTxt.setBounds(90, 90, 200, 30);
        namTxt.setForeground(yell);
        namTxt.setFont(font12);
        namTxt.setColumns(20);

        JTextField apetxt = new JTextField();
        apetxt.setOpaque(false);
        apetxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//        apetxt.setBounds(90, 150, 200, 30);
        apetxt.setForeground(yell);
        apetxt.setFont(font12);
        apetxt.setColumns(20);

        JTextField cedtxt = new JTextField();
        cedtxt.setOpaque(false);
        cedtxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//        cedtxt.setBounds(90, 200, 200, 30);
        cedtxt.setForeground(yell);
        cedtxt.setFont(font12);
        cedtxt.setColumns(20);
        cedtxt.setPreferredSize(new Dimension(300,20));

        JButton addBtt = new JButton();
        addBtt.setText("Agregar Administrador");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200,20));
        JButton delBtt = new JButton();
        delBtt.setText("Eliminar Administrador");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200,20));
        JButton edBtt = new JButton("Editar Administrador");
        edBtt.setPreferredSize(new Dimension(200,20));
        edBtt.setOpaque(false);
        edBtt.setFont(font14);
        edBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));


        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Email");
        model1.addColumn("Nombre");
        model1.addColumn("Apellido");
        model1.addColumn("N. Cedula");
        JTable table1 = new JTable(model1);
        table1.getTableHeader().setBackground(dk);
        table1.getTableHeader().setForeground(yell);
        table1.getTableHeader().setFont(font14);
        table1.setBackground(yell);
        table1.setForeground(dk);
        table1.setFont(font12);
        table1.setSelectionBackground(new Color(141, 98, 220));

        JScrollPane scrollPane = new JScrollPane(table1);
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(500, 200));
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane);
        int a = 0;
        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailtxt.getText();
                String password = Arrays.toString(passTxt.getPassword());
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();
                Administrador administrador = new Administrador(email, password,name,lastN,cd);
                saveAdmin(administrador);
//                List <Administrador> admins = getAdmins();
                List<User> users = getUsers();
                users.forEach(System.out::println);

               model1.addRow(new Object[] {email, name,lastN,cd});
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                model1.removeRow(num);
                deleteAdmins(num);
                List<Administrador> admins = getAdmins();
                admins.forEach(System.out::println);
            }
        });
        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                String name = namTxt.getText();
                String surName =apetxt.getText();
                String IDE = cedtxt.getText();

                model1.setValueAt(name,row,1);
                model1.setValueAt(surName,row,2);
                model1.setValueAt(IDE,row,3);
                updateAdmins(row,name,surName,IDE);
                List <Administrador> admins = getAdmins();
                admins.forEach(System.out::println);
            }
        });
        JPanel panel = new JPanel();
       panel.setPreferredSize(new Dimension(600, 210));
        panel.setBackground(dk);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 10, 5);

// Title
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

// Email
        gbc.gridwidth = 1; // Reset gridwidth to 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailA, gbc);
        gbc.gridx = 1;
        panel.add(emailtxt, gbc);
        gbc.gridx = 2;
        panel.add(addBtt, gbc);

// Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passA, gbc);
        gbc.gridx = 1;
        panel.add(passTxt, gbc);
        gbc.gridx = 2;
        panel.add(delBtt, gbc);

// Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(nameA, gbc);
        gbc.gridx = 1;
        panel.add(namTxt, gbc);
        gbc.gridx = 2;
        panel.add(edBtt, gbc);

// Surname
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(apeA, gbc);
        gbc.gridx = 1;
        panel.add(apetxt, gbc); // Missing gbc in the original

// ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(cedA, gbc);
        gbc.gridx = 1;
        panel.add(cedtxt, gbc); // Missing gbc in the original

//
//        JPanel panel1 = new JPanel();
//        panel1.setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        pack();
//        add(panel, BorderLayout.NORTH);
//        add(tablePanel, BorderLayout.SOUTH);
//        add(panel1);
        setVisible(true);
    }

    public static Admin getInstancia() {
        return null == myAdmin ? (new Admin()) : myAdmin;
    }

    //Agregar admin
    private static void guardarAdmin (User administrador){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            if (administrador instanceof Administrador){
                session.save(administrador);
            }
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction!= null){
                transaction.rollback();
            }
        }
    }
    private static void saveAdmin(User user){
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.save(user);
    }
    //mostrar admins
    private static List <Administrador> getAdmins(){
       List<Administrador> admins = new ArrayList<>();
        IGenericService<Administrador> adminService = new GenericServiceImpl<>(Administrador.class, HibernateUtil.getSessionFactory());
        admins = adminService.getAll();
        return admins;
    }
    private static List <User> getUsers(){
        List<User> users = new ArrayList<>();
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        users = userService.getAll();
        return users;
    }
    //update admins
    private static void updateAdmins(int index, String name, String surname, String ide){
        Transaction transaction = null;
        List<Administrador> admins = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession();) {
            admins = session.createQuery("from Administrador", Administrador.class).list();
            transaction = session.beginTransaction();
            Administrador admin = admins.get(index);
            admin.setNames(name);
            admin.setSurnames(surname);
            admin.setIDE(ide);
            session.update(admin);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        }
        }

        //Eliminar admins
    private static void deleteAdmins (int index){
        Transaction transaction = null;
        List<Administrador> admins = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            admins = session.createQuery("from Administrador", Administrador.class).list();
            transaction = session.beginTransaction();
            Administrador admin = admins.get(index);
            session.delete(admin);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
    private static Administrador findSpecificAdmin(int index) {
        Transaction transaction = null;
        Administrador admin = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Administrador> admins = session.createQuery("from Administrador", Administrador.class).list();
            admin = admins.get(index);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return admin;
    }


}

