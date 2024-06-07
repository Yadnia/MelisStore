package forms;

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
                String pass = Arrays.toString(passTxt.getPassword());
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();
                Vendedor sell = new Vendedor(email,pass,name,lastN,cd);
                saveSeller(sell);
                model1.setRowCount(0);
                addRows(model1);
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                String emailDel = (String) table1.getValueAt(num, 0);
                List<User> sellers = getUsers();
                for (User ses : sellers){
                    if (ses.getUserEmail().equals(emailDel)){
                        deleteUser(ses);
                        model1.setRowCount(0);
                        addRows(model1);
                    }
                }

            }
        });
        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                String emaDel = (String) table1.getValueAt(row, 0);
                List<Vendedor> sellers = getSellers();
                String email = emailtxt.getText();
                String pass = Arrays.toString(passTxt.getPassword());
                String name = namTxt.getText();
                String surName =apetxt.getText();
                String IDE = cedtxt.getText();
                for (Vendedor ses : sellers){
                    if (ses.getUserEmail().equals(emaDel)){
                        ses.setUserEmail(email);
                        ses.setUserPassword(pass);
                        ses.setNames(name);
                        ses.setSurnames(surName);
                        ses.setIDE(IDE);
                        updateSeller(ses);
                     model1.setRowCount(0);
                     addRows(model1);
                    }
                }
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
        List <Vendedor> vendedores = getSellers();
        for (Vendedor vend : vendedores){
            String email = vend.getUserEmail();
            String name = vend.getNames();
            String lastN = vend.getSurnames();
            String cd = vend.getIDE();
            model.addRow(new Object[]{email,name,lastN,cd});
        }
    }
    }

