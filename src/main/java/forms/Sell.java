package forms;

import org.Yaed.entity.Administrador;
import org.Yaed.entity.User;
import org.Yaed.entity.Vendedor;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sell extends JInternalFrame {

    static Sell mySell;

    private Sell() {
        super("Vendedores", true, true, true, true);
        InicializarSell();
        mySell = this;
    }

    private void InicializarSell(){
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

        JLabel title = new JLabel("Vendedores del negocio");
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
        addBtt.setText("Agregar Vendedor");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200,20));
        JButton delBtt = new JButton();
        delBtt.setText("Eliminar Vendedor");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200,20));
        JButton edBtt = new JButton("Editar Vendedor");
        edBtt.setPreferredSize(new Dimension(200,20));
        edBtt.setOpaque(false);
        edBtt.setFont(font14);
        edBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));

        JButton refresh = new JButton("Refrescar");
        refresh.setPreferredSize(new Dimension(200,20));
        refresh.setOpaque(false);
        refresh.setFont(font14);
        refresh.setForeground(yell);
        refresh.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));

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
        int a = 0;
        addRows(model1);
        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailtxt.getText();
                String password = String.valueOf( passTxt.getPassword());
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();
                List<Vendedor> sellers = getSellers();
                boolean validEntry = true;
                if (email.isEmpty() || password.isEmpty() || name.isEmpty() || lastN.isEmpty() || cd.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    validEntry = false;
                } else  if (!numeros(namTxt) || !numeros(apetxt)) {
                    JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
                    validEntry = false;
                } else {
                    for (Vendedor vendedor : sellers) {
                        if (existentSeller(cd, email)) {
                            JOptionPane.showMessageDialog(null, "Vendedor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                            validEntry = false;
                            break;
                        } else if (email.equalsIgnoreCase(vendedor.getUserEmail())) {
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
                    Vendedor vendedor = new Vendedor(email, password, name, lastN, cd);
                    saveSeller(vendedor);
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
                        List<Vendedor> sells = getSellers();
                        for (Vendedor vendedor : sells) {
                            if (vendedor.getUserEmail().equalsIgnoreCase(email)) {
                                int resp = JOptionPane.showConfirmDialog(null, "Eliminar registro?", "Confirmar borrar", JOptionPane.YES_NO_OPTION);
                                if (resp == JOptionPane.YES_OPTION) {
                                    deleteUser(vendedor);
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
                List<Vendedor> vends = getSellers();
                int row = table1.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String email = emailtxt.getText();
                    String pass = String.valueOf(passTxt.getPassword());
                    String name = namTxt.getText();
                    String surName = apetxt.getText();
                    String IDE = cedtxt.getText();
                    String nameUp = (String) table1.getValueAt(row, 1);
                    if (!email.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se puede editar el email.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (existentSeller(IDE, email)) {
                        JOptionPane.showMessageDialog(null, "Ese administrador ya existe.", "error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        for (Vendedor vendedor : vends) {
                            if (vendedor.getNames().equalsIgnoreCase(nameUp)) {
                                vendedor.setUserEmail(email);
                                vendedor.setUserPassword(pass);
                                vendedor.setNames(name);
                                vendedor.setSurnames(surName);
                                vendedor.setIDE(IDE);
                                updateSeller(vendedor);
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

        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(refresh, gbc);

        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    public static Sell getInstancia(){
        return null == mySell ? (new Sell()): mySell;
    }
    private static void saveSeller(User user){
        IGenericService<User> userSeervice = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userSeervice.save(user);
        }

        private static void updateSeller(User user){
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.update(user);
        }
    private static void deleteUser (User user){
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        userService.delete(user);
    }
        private static List<Vendedor> getSellers(){
        List <Vendedor> vendedores = new ArrayList<>();
        IGenericService<Vendedor> sellService = new GenericServiceImpl<>(Vendedor.class, HibernateUtil.getSessionFactory());
        vendedores = sellService.getAll();
        return  vendedores;
        }
    private static List <User> getUsers(){
        List<User> users = new ArrayList<>();
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        users = userService.getAll();
        return users;
    }
    private static void addRows(DefaultTableModel model)
    {
        model.setRowCount(0);
        List <Vendedor> vendedores = getSellers();
        for (Vendedor vend : vendedores){
            String email = vend.getUserEmail();
            String name = vend.getNames();
            String lastN = vend.getSurnames();
            String cd = vend.getIDE();
            model.addRow(new Object[]{email,name,lastN,cd});
        }
    }
    private static boolean existentSeller(String cedula, String email){
        List<Vendedor> vends = getSellers();
        for (Vendedor vendedor: vends){
            if (vendedor.getIDE().equalsIgnoreCase(cedula) || vendedor.getUserEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
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
    private static void cleanFields(JTextField emailtxt, JPasswordField passTxt, JTextField namTxt, JTextField apetxt, JTextField cedtxt) {
        emailtxt.setText("");
        passTxt.setText("");
        namTxt.setText("");
        apetxt.setText("");
        cedtxt.setText("");
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

