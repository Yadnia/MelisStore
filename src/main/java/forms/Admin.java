
package forms;

import org.Yaed.entity.Administrador;
import org.Yaed.entity.User;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends JInternalFrame {
    static Admin myAdmin;

    private Admin() {
        super("Administradores", true, true, true, true);
        InicializarAdmin();
        myAdmin = this;
    }

    private void InicializarAdmin() {
        //THE BASICS
        setLayout(new BorderLayout());
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(new Dimension(screen.width - 800, screen.height - 100));
        setSize(new Dimension(750, 600));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255, 179, 2);
        Color dk = new Color(46, 21, 59);
        this.setBackground(dk);
        //JLABELS
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
        //JTEXTFIELDS
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
        cedtxt.setPreferredSize(new Dimension(300, 20));
        //BOTONES
        JButton addBtt = new JButton();
        addBtt.setText("Agregar Administrador");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200, 20));
        JButton delBtt = new JButton();
        delBtt.setText("Eliminar Administrador");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200, 20));
        JButton edBtt = new JButton("Editar Administrador");
        edBtt.setPreferredSize(new Dimension(200, 20));
        edBtt.setOpaque(false);
        edBtt.setFont(font14);
        edBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        JButton refresh = new JButton("Refrescar");
        refresh.setPreferredSize(new Dimension(200, 20));
        refresh.setOpaque(false);
        refresh.setFont(font14);
        refresh.setForeground(yell);
        refresh.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        //TABLA
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
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(500, 200));
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        //llamar al metodo de pintar tabla
        addRows(model1);
        //ACTION LISTENERS
        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailtxt.getText().trim();
                String password = String.valueOf( passTxt.getPassword());
                String name = namTxt.getText().trim();
                String lastN = apetxt.getText().trim();
                String cd = cedtxt.getText().trim();
                List<Administrador> admins = getAdmins();
                boolean validEntry = true;
                if (email.isEmpty() || password.isEmpty() || name.isEmpty() || lastN.isEmpty() || cd.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    validEntry = false;
                } else if (numeros(namTxt) || numeros(apetxt)) {
                    JOptionPane.showMessageDialog(null, "Solo se admiten letras");
                    validEntry = false;
                } else
                {
                    for (Administrador admin : admins) {
                        if (existentAdmin(cd, email)) {
                            JOptionPane.showMessageDialog(null, "Administrador ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            validEntry = false;
                            break;
                        } else if (email.equalsIgnoreCase(admin.getUserEmail())) {
                            JOptionPane.showMessageDialog(null, "Ese correo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            validEntry = false;
                            break;
                        } else if (!ValidUser(email, password)) {
                            JOptionPane.showMessageDialog(null, "Por favor asegúrese de ingresar un correo y contraseña válidos.", "error", JOptionPane.ERROR_MESSAGE);
                            validEntry =false;
                            break;
                        }
                    }
                }

                if (validEntry) {
                    Administrador administrador = new Administrador(email, password, name, lastN, cd);
                    saveAdmin(administrador);
                    addRows(model1); //agregarlas nuevamente
                    cleanFields(emailtxt,passTxt,namTxt,apetxt,cedtxt);
                }
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                if (model1.getRowCount() == 1){
                    JOptionPane.showMessageDialog(null, "debe existir al menos un administrador.", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                if (num < 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String email = (String) table1.getValueAt(num, 0);
                    List<Administrador> admins = getAdmins();
                    for (Administrador admin : admins) {
                        if (admin.getUserEmail().equalsIgnoreCase(email)) {
                            int resp = JOptionPane.showConfirmDialog(null, "Eliminar registro?", "Confirmar borrar", JOptionPane.YES_NO_OPTION);
                            if (resp == JOptionPane.YES_OPTION) {
                                deleteUser(admin);
                                addRows(model1);
                                cleanFields(emailtxt,passTxt,namTxt,apetxt,cedtxt);
                            }
                            break;
                        }
                    }
                }
            }}
        });
        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Administrador> admins = getAdmins();
                    int row = table1.getSelectedRow();
                    if (row < 0) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String email = emailtxt.getText().trim();
                        String pass = String.valueOf(passTxt.getPassword());
                        String name = namTxt.getText().trim();
                        String surName = apetxt.getText().trim();
                        String IDE = cedtxt.getText().trim();
                        String nameUp = (String) table1.getValueAt(row, 1);
                        if (!email.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No se puede editar el email.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (existentAdmin(IDE, email)) {
                            JOptionPane.showMessageDialog(null, "Ese administrador ya existe.", "error", JOptionPane.ERROR_MESSAGE);
                        } else if (!numeros(namTxt) || !numeros(apetxt)) {
                            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
                        } else{
                            for (Administrador admin : admins) {
                                if (admin.getNames().equalsIgnoreCase(nameUp)) {
                                    admin.setUserEmail(email);
                                    admin.setUserPassword(pass);
                                    admin.setNames(name);
                                    admin.setSurnames(surName);
                                    admin.setIDE(IDE);
                                    updateUser(admin);
                                    addRows(model1);
                                    cleanFields(emailtxt, passTxt, namTxt, apetxt, cedtxt);
                                }
                            }
                        }
                    }

            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRows(model1);
                cleanFields(emailtxt, passTxt, namTxt, apetxt, cedtxt);
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
        gbc.gridwidth = 1;
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
        panel.add(apetxt, gbc);

// ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(cedA, gbc);
        gbc.gridx = 1;
        panel.add(cedtxt, gbc);

// Refresh Button
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(refresh, gbc);


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

    private static void saveAdmin(User user) {
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.save(user);
    }

    //mostrar admins
    private static List<Administrador> getAdmins() {
        List<Administrador> admins = new ArrayList<>();
        IGenericService<Administrador> adminService = new GenericServiceImpl<>(Administrador.class, HibernateUtil.getSessionFactory());
        admins = adminService.getAll();
        return admins;
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        users = userService.getAll();
        return users;
    }

    //update admins
    private static void updateUser(User user) {
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.update(user);
    }
    //Eliminar admins

    private static void deleteUser(User user) {
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.delete(user);
    }

    private static void addRows(DefaultTableModel model) {
        model.setRowCount(0);
        List<Administrador> administradores = getAdmins();
        for (Administrador admin : administradores) {
            String email = admin.getUserEmail();
            String name = admin.getNames();
            String surName = admin.getSurnames();
            String IDE = admin.getIDE();
            model.addRow(new Object[]{email, name, surName, IDE});
        }

    }
    private static void cleanFields(JTextField emailtxt, JPasswordField passTxt, JTextField namTxt, JTextField apetxt, JTextField cedtxt) {
        emailtxt.setText("");
        passTxt.setText("");
        namTxt.setText("");
        apetxt.setText("");
        cedtxt.setText("");
    }
    private static boolean ValidUser (String email, String password){
        String emPtrn =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern ptrn = Pattern.compile(emPtrn);
        Matcher mtch = ptrn.matcher(email);
        String passPtrn =
                "^.{8,}$";
        Pattern pttn = Pattern.compile(passPtrn);
        Matcher match = pttn.matcher(password);
        if (mtch.matches() && match.matches()){
            return true;
        }
        return false;
    }
    private static boolean existentAdmin(String cedula, String email){
        List<Administrador> admins = getAdmins();
        for (Administrador admin: admins){
            if (admin.getIDE().equalsIgnoreCase(cedula) || admin.getUserEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    private static boolean numeros(JTextField textField){
        String input = textField.getText();
        if (input.matches(".*\\d.*")) {
            textField.setText("");
            return true;
        }
        return false;
    }
}