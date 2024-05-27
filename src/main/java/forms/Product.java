package forms;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product extends JInternalFrame {

    static Product myProduct;

    private Product() {
        super("Productos", true, true, true, true);
        InicializarProduct();
        myProduct = this;

    }

    private void InicializarProduct() {
        setTitle("Productos Melis");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(750, 600));
        //setResizable(true);
        //Propiedades del frame
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255, 179, 2);
        Color dk = new Color(46, 21, 59);

        JLabel title = new JLabel("Productos en almacen");
        title.setForeground(yell);
        title.setFont(font20);
        title.setBounds(30, 20, 400, 40);
        JLabel nameA = new JLabel("Descripcion:");
        nameA.setForeground(yell);
        nameA.setFont(font12);
        nameA.setBounds(30, 90, 100, 30);
        JLabel apeA = new JLabel("Color:");
        apeA.setForeground(yell);
        apeA.setFont(font12);
        apeA.setBounds(30, 150, 100, 30);
        JLabel cedA = new JLabel("Codigo:");
        cedA.setForeground(yell);
        cedA.setFont(font12);
        cedA.setBounds(30, 200, 100, 30);
        JLabel catA = new JLabel("Categoria:");
        catA.setForeground(yell);
        catA.setFont(font12);
        catA.setBounds(30, 200, 100, 30);
        JLabel sizeA = new JLabel("Talla:");
        sizeA.setForeground(yell);
        sizeA.setFont(font12);
        sizeA.setBounds(30, 200, 100, 30);
        JLabel cuantity = new JLabel("Stock:");
        cuantity.setForeground(yell);
        cuantity.setFont(font12);
        cuantity.setBounds(30, 200, 100, 30);
        //TEXTFIELDS ---------------------------------
        JTextField namTxt = new JTextField();
        namTxt.setOpaque(false);
        namTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        namTxt.setBounds(100, 90, 200, 30);
        namTxt.setForeground(yell);
        namTxt.setFont(font12);
        namTxt.setColumns(20);
        JTextField apetxt = new JTextField();
        apetxt.setOpaque(false);
        apetxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        apetxt.setBounds(100, 150, 200, 30);
        apetxt.setForeground(yell);
        apetxt.setFont(font12);
        apetxt.setColumns(20);
        JTextField cedtxt = new JTextField();
        cedtxt.setOpaque(false);
        cedtxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        cedtxt.setBounds(100, 200, 200, 30);
        cedtxt.setForeground(yell);
        cedtxt.setFont(font12);
        cedtxt.setColumns(20);
        JTextField catTxt = new JTextField();
        catTxt.setOpaque(false);
        catTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        catTxt.setBounds(100, 200, 200, 30);
        catTxt.setForeground(yell);
        catTxt.setFont(font12);
        catTxt.setColumns(20);
        JTextField taTxt = new JTextField();
        taTxt.setOpaque(false);
        taTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        taTxt.setBounds(100, 200, 200, 30);
        taTxt.setForeground(yell);
        taTxt.setFont(font12);
        taTxt.setColumns(20);
        JTextField cuanTxt = new JTextField();
        cuanTxt.setOpaque(false);
        cuanTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        cuanTxt.setBounds(100, 200, 200, 30);
        cuanTxt.setForeground(yell);
        cuanTxt.setFont(font12);
        cuanTxt.setColumns(20);
                                // BOTONES
        JButton addBtt = new JButton();
        addBtt.setText("Agregar Producto");
        addBtt.setOpaque(false);
        addBtt.setFont(font14);
        addBtt.setForeground(yell);
        addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        addBtt.setPreferredSize(new Dimension(200, 20));
        JButton delBtt = new JButton();
        delBtt.setText("Restar Producto");
        delBtt.setOpaque(false);
        delBtt.setFont(font14);
        delBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        delBtt.setPreferredSize(new Dimension(200, 20));
        JButton edBtt = new JButton("Editar Producto");
        edBtt.setPreferredSize(new Dimension(200, 20));
        edBtt.setOpaque(false);
        edBtt.setFont(font14);
        edBtt.setForeground(yell);
        delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

        //TABLA
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Descripcion");
        model1.addColumn("Color");
        model1.addColumn("Codigo");
        model1.addColumn("Categoria");
        model1.addColumn("Talla");
        model1.addColumn("Stock");
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
        tablePanel.setPreferredSize(new Dimension(600, 200));
        tablePanel.setBackground(yell);
        tablePanel.add(scrollPane);
        //ACTION LISTENERS

        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namTxt.getText();
                String lastN = apetxt.getText();
                String cd = cedtxt.getText();
                String categ = catTxt.getText();
                String size = taTxt.getText();
                String cuant = cuanTxt.getText();
                model1.addRow(new Object[]{name, lastN, cd,categ,size,cuant});
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table1.getSelectedRow();
                    model1.removeRow(num);}
        });
        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                String desc = namTxt.getText();
                String color = apetxt.getText();
                String code = cedtxt.getText();
                String cat = catTxt.getText();
                String size = taTxt.getText();
                String cuant = cuanTxt.getText();

                model1.setValueAt(desc, row, 0);
                model1.setValueAt(color, row, 1);
                model1.setValueAt(code, row, 2);
                model1.setValueAt(cat, row, 3);
                model1.setValueAt(size, row, 4);
                model1.setValueAt(cuant,row,5);
            }
        });
        //PANEL PRINCIPAL
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 210));
        panel.setBackground(dk);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
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

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(catA, gbc);
        gbc.gridx = 1;
        panel.add(catTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(sizeA, gbc);
        gbc.gridx = 1;
        panel.add(taTxt, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(cuantity, gbc);
        gbc.gridx = 1;
        panel.add(cuanTxt, gbc);

        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    public static Product getInstancia() {
        return null == myProduct ? (new Product()) : myProduct;
    }
}
