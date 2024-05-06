package forms;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sell extends JInternalFrame {

    static Sell mySell;

    private Sell(){
        super ("Vendedores",true,true,true,true);
        setTitle("Vendedores");
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

        JLabel title = new JLabel("Vendedores del negocio");
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
        addBtt.setText("Agregar Vendedor");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200,20));
        JButton delBtt = new JButton();
        delBtt.setText("Eliminar Vendedor");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200,20));
        JButton edBtt = new JButton("Editar Vendedor");
        edBtt.setPreferredSize(new Dimension(200,20));
        edBtt.setOpaque(false);
        edBtt.setFont(font14);
        edBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));

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
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(30,300,500,700);
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane);

        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();

                model1.addRow(new Object[]{name,lastN,cd});
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                model1.removeRow(num);
            }
        });
        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                String name = namTxt.getText();
                String surName =apetxt.getText();
                String IDE = cedtxt.getText();
                model1.setValueAt(name,row,0);
                model1.setValueAt(surName,row,1);
                model1.setValueAt(IDE,row,2);
            }
        });
        JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(600, 200));
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

        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void InicializarSell(){

    }
    public static Sell getInstancia(){
        return null == mySell ? (new Sell()): mySell;
    }
}
