package forms;

import jakarta.persistence.JoinColumn;
import org.Yaed.entity.Producto;
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
        JLabel precio = new JLabel("Precio:");
        precio.setForeground(yell);
        precio.setFont(font12);
        precio.setBounds(30, 200, 100, 30);
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
        JTextField preciotxt = new JTextField();
        preciotxt.setOpaque(false);
        preciotxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
        preciotxt.setBounds(100, 200, 200, 30);
        preciotxt.setForeground(yell);
        preciotxt.setFont(font12);
        preciotxt.setColumns(20);

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
        JButton refresh = new JButton("Refrescar");
        refresh.setPreferredSize(new Dimension(200, 20));
        refresh.setOpaque(false);
        refresh.setFont(font14);
        refresh.setForeground(yell);
        refresh.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

        //TABLA
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("Descripcion");
        model1.addColumn("Color");
        model1.addColumn("Codigo");
        model1.addColumn("Categoria");
        model1.addColumn("Talla");
        model1.addColumn("Stock");
        model1.addColumn("Precio");
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
        //ACTION LISTENERS

        addBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desc = namTxt.getText().trim();
                String color = apetxt.getText().trim();
                String code = cedtxt.getText().trim();
                String cat = catTxt.getText().trim();
                String size = taTxt.getText().trim();
                int cuant = 0;
                int precio = 0;
                boolean validEntry = true;
                try {
                    precio = Integer.parseInt(preciotxt.getText());
                    cuant = Integer.parseInt(cuanTxt.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Los campos de precio y cantidad deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                    validEntry = false;
                }

                if (desc.isEmpty() || color.isEmpty() || code.isEmpty() || cat.isEmpty() || size.isEmpty() || precio < 0 || cuant < 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    validEntry = false;
                } else {
                    List<Producto> prods = getProducts();
                    for (Producto producto : prods) {
                        if (producto.getCode().equalsIgnoreCase(code)) {
                            JOptionPane.showMessageDialog(null, "Ese producto ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                            validEntry = false;
                        }
                    }

                }
                if (validEntry) {
                    Producto product = new Producto(desc, color, code, cat, size, cuant, precio);
                    saveProduct(product);
                    addRows(model1);
                    cleanFields(namTxt, apetxt, cedtxt, catTxt, taTxt, preciotxt, cuanTxt);
                }
            }
        });
        delBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Producto> products = getProducts(); // Obtener la lista actualizada de productos
                int num = table1.getSelectedRow();
                if (num < 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String codeDeL = (String) table1.getValueAt(num, 2);
                    for (Producto product : products) {
                        if (product.getCode().equalsIgnoreCase(codeDeL)) {
                            String[] eliminar = {"Restar", "Eliminar definitivamente"};
                            int resp = JOptionPane.showOptionDialog(null, "Restar cantidad o eliminar definitivamente?", "Confirmar", 0, 3, null, eliminar, null);
                            if (resp == 0) {
                                int stockActual = product.getStock();
                                if (stockActual <= 0){
                                    JOptionPane.showMessageDialog(null,"Cantidad minima alcanzada.");
                                } else {
                                product.setStock(stockActual -1);
                                updateProduct(product);
                                addRows(model1);}
                            } else if (resp == 1) { // Eliminar definitivamente
                                deleteProduct(product);
                                addRows(model1); // Actualizar tabla después de eliminar producto
                                cleanFields(namTxt, apetxt, cedtxt, catTxt, taTxt, preciotxt, cuanTxt);
                            }
                            break;
                        }
                    }
                }
            }
        });

        edBtt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                if (row <0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                String codeEd = (String) table1.getValueAt(row, 2);
                String desc = namTxt.getText().trim();
                String color = apetxt.getText().trim();
                String code = cedtxt.getText().trim();
                String cat = catTxt.getText().trim();
                String size = taTxt.getText().trim();
                int cuant = Integer.parseInt(cuanTxt.getText());
                int precio = Integer.parseInt(preciotxt.getText());

                List<Producto> products = getProducts();
                for (Producto product : products) {
                    if (product.getCode().equalsIgnoreCase(codeEd)) {
                        product.setDescription(desc);
                        product.setColor(color);
                        product.setCode(code);
                        product.setCate(cat);
                        product.setSize(size);
                        product.setStock(cuant);
                        product.setPrecio(precio);
                        updateProduct(product);
                        addRows(model1);
                        cleanFields(namTxt, apetxt, cedtxt, catTxt, taTxt, preciotxt, cuanTxt);
                    }
                }}
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRows(model1);
                cleanFields(namTxt, apetxt, cedtxt, catTxt, taTxt, preciotxt, cuanTxt);
            }
        });
        //PANEL PRINCIPAL
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 250));
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

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(precio, gbc);
        gbc.gridx = 1;
        panel.add(preciotxt, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        panel.add(refresh, gbc);
        add(panel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    public static Product getInstancia() {
        return null == myProduct ? (new Product()) : myProduct;
    }

    private static List<Producto> getProducts() {
        List<Producto> productos = new ArrayList<>();
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productos = productService.getAll();
        return productos;
    }

    private static void saveProduct(Producto producto) {
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productService.save(producto);
    }

    private static void updateProduct(Producto producto) {
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productService.update(producto);
    }

    private static void deleteProduct(Producto product) {
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productService.delete(product);
    }

    private static void addRows(DefaultTableModel model) {
        model.setRowCount(0);
        List<Producto> productos = getProducts();
        for (Producto producto : productos) {
            String desc = producto.getDescription();
            String color = producto.getColor();
            String code = producto.getCode();
            String cat = producto.getCate();
            String size = producto.getSize();
            int cuant = producto.getStock();
            int precio = producto.getPrecio();
            model.addRow(new Object[]{desc, color, code, cat, size, cuant, precio});
        }
    }

    private static void cleanFields(JTextField emailtxt, JTextField passTxt, JTextField namTxt, JTextField apetxt, JTextField cedtxt, JTextField num6, JTextField num7) {
        emailtxt.setText("");
        passTxt.setText("");
        namTxt.setText("");
        apetxt.setText("");
        cedtxt.setText("");
        num6.setText("");
        num7.setText("");
    }
}
