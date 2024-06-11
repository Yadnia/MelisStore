package forms;

import org.Yaed.entity.Cliente;
import org.Yaed.entity.User;
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
import java.util.List;

public class Client extends JInternalFrame {

    static Client myClient;

    private Client(){
        super("Clientes",true,true,true,true);
        InicializarClient();
        myClient =this;
    }

    private void InicializarClient(){
        setSize(new Dimension(750,600));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());


        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20= new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255,179,2);
        Color dk = new Color(46, 21, 59);
        Color azulBonito = new Color(106, 106, 206);

        JLabel title = new JLabel("Clientes del negocio");
        title.setForeground(yell);
        title.setFont(font20);
        title.setBounds(30,20,400,40);

        JLabel nameA = new JLabel("Nombre:");
        nameA.setForeground(yell);
        nameA.setFont(font12);
        nameA.setBounds(30,90,100,30);

        JLabel apeA = new JLabel("Apellido:");
        apeA.setForeground(yell);
        apeA.setFont(font12);
        apeA.setBounds(30,150,100,30);

        JLabel cedA = new JLabel("Cedula:");
        cedA.setForeground(yell);
        cedA.setFont(font12);
        cedA.setBounds(30,200,100,30);

        JTextField namTxt = new JTextField();
        namTxt.setOpaque(false);
        namTxt.setBorder(new MatteBorder(0,0,1,0,yell));
        namTxt.setBounds(90,90, 200,30);
        namTxt.setForeground(yell);
        namTxt.setFont(font12);
        namTxt.setColumns(20);

        JTextField apetxt = new JTextField();
        apetxt.setOpaque(false);
        apetxt.setBorder(new MatteBorder(0,0,1,0,yell));
        apetxt.setBounds(90,150, 200,30);
        apetxt.setForeground(yell);
        apetxt.setFont(font12);
        apetxt.setColumns(20);
        JTextField cedtxt = new JTextField();
        cedtxt.setOpaque(false);
        cedtxt.setBorder(new MatteBorder(0,0,1,0,yell));
        cedtxt.setBounds(90,200, 200,30);
        cedtxt.setForeground(yell);
        cedtxt.setFont(font12);
        cedtxt.setColumns(20);

        JButton addBtt = new JButton();
        addBtt.setText("Agregar Cliente");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200,20));
        JButton delBtt = new JButton();
        delBtt.setText("Eliminar Cliente");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200,20));
        JButton edBtt = new JButton("Editar Cliente");
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
        tablePanel.setPreferredSize(new Dimension(600, 200));
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        addRows(model1);

        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namTxt.getText().trim();
                String lastN = apetxt.getText().trim();
                String cd = cedtxt.getText().trim();
                boolean validEntry = true;
             if (name.isEmpty()|| lastN.isEmpty()||cd.isEmpty()){
                 JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                 validEntry = false;
             } else if (numeros(namTxt) || numeros(apetxt)) {
                 JOptionPane.showMessageDialog(null, "Solo se admiten letras");
                 validEntry = false;
             } else if (existentClient(cd)) {
                 JOptionPane.showMessageDialog(null, "El cliente ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                 validEntry = false;
             }
             if (validEntry){
                 Cliente cliente = new Cliente(name,lastN,cd);
                 saveClient(cliente);
                 addRows(model1);
                 cleanFields(namTxt,apetxt,cedtxt);

             }
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clients = getClients();
                int num = table1.getSelectedRow();
                if (num <0){
                    JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                } else{
                String cedDel = (String) table1.getValueAt(num, 2);
                for (Cliente client : clients){
                    if (client.getIDE().equalsIgnoreCase(cedDel)){
                        int resp = JOptionPane.showConfirmDialog(null,"Eliminar registro?","Confirmar", JOptionPane.YES_NO_OPTION);
                        if (resp == JOptionPane.YES_OPTION){
                            deleteClient(client);
                            addRows(model1);
                            cleanFields(namTxt, apetxt, cedtxt);
                        }

                    }
                }

            }}
        });

        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clients = getClients();
                int row = table1.getSelectedRow();
                boolean validEntry = true;
                if (row <0 ){
                    JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                } else  {
                    String name = namTxt.getText().trim();
                    String surName =apetxt.getText().trim();
                    String IDE = cedtxt.getText().trim();
                    String nameed = (String) table1.getValueAt(row, 0);
                    if (name.isEmpty()|| surName.isEmpty()||IDE.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                        validEntry = false;
                    }
                    if (validEntry){
                    for (Cliente client :clients){
                        if (client.getNames().equalsIgnoreCase(nameed)){
                            client.setNames(name);
                            client.setSurnames(surName);
                            client.setIDE(IDE);
                            updateClient(client);
                            addRows(model1);
                            cleanFields(namTxt,apetxt,cedtxt);
                        }
                    }

                }}

            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRows(model1);
            }
        });
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 210));
        panel.setBackground(dk);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,10,5,5);
        gbc.gridwidth =3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);
        gbc.gridwidth =1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameA, gbc);
        gbc.gridx = 1;
        panel.add(namTxt, gbc);
        gbc.gridx = 2;
        panel.add(addBtt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(apeA, gbc);
        gbc.gridx = 1;
        panel.add(apetxt, gbc);
        gbc.gridx = 2;
        panel.add(delBtt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cedA, gbc);
        gbc.gridx = 1;
        panel.add(cedtxt, gbc);
        gbc.gridx = 2;
        panel.add(edBtt, gbc);

// Refresh Button
        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(refresh, gbc);

        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        pack();

    }

    public static Client getInstancia (){
        return null == myClient ? (new Client()) : myClient;
    }
    private static void saveClient (Cliente cliente){
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientService.save(cliente);
    }
    private void updateClient (Cliente cliente){
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientService.update(cliente);

    }
    private static void deleteClient (Cliente cliente){
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientService.delete(cliente);
    }
    private static List<Cliente> getClients(){
        List<Cliente> clientes = new ArrayList<>();
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes = clientService.getAll();
        return clientes;

    }
    private static List <User> getUsers(){
        List<User> users = new ArrayList<>();
        IGenericService<User> userService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        users = userService.getAll();
        return users;
    }
    private static void addRows(DefaultTableModel model){
        model.setRowCount(0);
        List<Cliente> clientes = getClients();
        for (Cliente cliente : clientes   ){
            String name = cliente.getNames();
            String surName = cliente.getSurnames();
            String IDE = cliente.getIDE();
            model.addRow(new Object[]{name,surName,IDE});
        }

    }
    private static boolean existentClient(String cedula){
        List<Cliente> clients = getClients();
        for (Cliente cliente: clients){
            if (cliente.getIDE().equalsIgnoreCase(cedula)){
                return true;
            }
        }
        return false;
    }
    private static void cleanFields(JTextField namTxt, JTextField apetxt, JTextField cedtxt) {
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
