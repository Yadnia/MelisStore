package forms;

import org.Yaed.entity.Cliente;
import org.Yaed.entity.Producto;
import org.Yaed.entity.Vendedor;
import org.Yaed.entity.Ventas;
import org.Yaed.services.GenericServiceImpl;
import org.Yaed.services.IGenericService;
import org.Yaed.util.HibernateUtil;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura extends JInternalFrame {

    static Factura myFactura;

    private Factura() {
        super("Factura", true, true, true, true);
        InicializarFac();
        myFactura = this;

    }

    private void InicializarFac() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(750, 550));
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());
        Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
        Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
        Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
        Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
        Color yell = new Color(255, 179, 2);
        Color dk = new Color(46, 21, 59);
        MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.WHITE);


        //PANEL
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(dk);

        //LABELS Y TEXTFIELDS
        JLabel Title = new JLabel("Facturar");
        Title.setFont(font20);
        Title.setForeground(yell);
        JLabel prod = new JLabel("Producto");
        prod.setFont(font14);
        prod.setForeground(yell);
        JLabel sell = new JLabel("Vendedor");
        sell.setFont(font14);
        sell.setForeground(yell);
        JLabel client = new JLabel("Cliente");
        client.setFont(font14);
        client.setForeground(yell);
        JLabel totaltxt = new JLabel("0");
        totaltxt.setFont(font14);
        totaltxt.setForeground(yell);

        //JCOOMBOBOX
        //PRODUCTOS
//        JComboBox<String> prodCombo = new JComboBox<>();
//        prodCombo.setPreferredSize(new Dimension(120, 30));
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
//        updProdCombo(model);
//        prodCombo.setModel(model);

        //
        List<Producto> productos = getProducts();
        JComboBox<Producto> comboBox = new JComboBox<>();
        comboBox.setPreferredSize(new Dimension(120, 30));
        for (Producto producto : productos) {
            comboBox.addItem(producto);
        }

        // Opcionalmente, puedes establecer un rendere personalizado para mostrar la descripción en el JComboBox
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Producto) {
                    Producto producto = (Producto) value;
                    setText(producto.getDescription());
                }
                return this;
            }
        });
        //VENDEDORES
        JComboBox<Vendedor> vendCombo = new JComboBox<>();
        List<Vendedor> vendedores = getSellers();
        vendCombo.setPreferredSize(new Dimension(120, 30));
        for (Vendedor vendedor : vendedores){
            vendCombo.addItem(vendedor);
        }
        vendCombo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Vendedor) {
                    Vendedor vendedor = (Vendedor) value;
                    setText(vendedor.getNames()+" "+vendedor.getSurnames());
                }
                return this;
            }
        });
        //CLIENTES
        JComboBox<Cliente> clienteCombo = new JComboBox<>();
        clienteCombo.setPreferredSize(new Dimension(120, 30));
        List<Cliente> clientes = getClients();
        for (Cliente cliente : clientes){
            clienteCombo.addItem(cliente);
        }
        clienteCombo.setRenderer(new DefaultListCellRenderer(){
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getNames()+" "+cliente.getSurnames());
                }
                return this;
            }
        });

        //BOTONES
        JButton create = new JButton("Agregar");
        create.setPreferredSize(new Dimension(200, 20));
        create.setFont(font14);
        create.setForeground(yell);
        create.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        JButton delete = new JButton("Eliminar");
        delete.setPreferredSize(new Dimension(200, 20));
        delete.setFont(font14);
        delete.setForeground(yell);
        delete.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        JButton off = new JButton("Descuento");
        off.setPreferredSize(new Dimension(200, 20));
        off.setFont(font14);
        off.setForeground(yell);
        off.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        JButton fact = new JButton("Facturar");
        fact.setPreferredSize(new Dimension(200, 20));
        fact.setFont(font14);
        fact.setForeground(yell);
        fact.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        JButton total = new JButton("Total");
        total.setFont(font14);
        total.setForeground(yell);
        JButton refresh = new JButton("Refrescar");
        refresh.setPreferredSize(new Dimension(50, 20));
        refresh.setOpaque(false);
        refresh.setFont(font14);
        refresh.setForeground(yell);
        refresh.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

        //LISTA
        DefaultListModel<Producto> model3 = new DefaultListModel<>();
        JList<Producto> list = new JList<>(model3);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane scrollPane = new JScrollPane(list);
        //Cellrenderer

        //ACTION LISTENERS
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = (Producto) comboBox.getSelectedItem();
                if (producto.getStock()<=0){
                    JOptionPane.showMessageDialog(null, "No hay disponible en inventario");
                } else{
                                producto.setStock(producto.getStock()-1);
                            updateProduct(producto);
                model3.addElement(producto);

            }}
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = comboBox.getSelectedIndex();
                model3.remove(selectedRow);
            }
        });
        total.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> precios = new ArrayList<>();
                // Itera sobre los elementos del modelo de lista
                for (int i = 0; i < model3.size(); i++) {
                    Object el = model3.getElementAt(i);
                    if (model3.getElementAt(i) instanceof Producto){
                        Producto producto = (Producto) el;
                        int precio = producto.getPrecio();
                        precios.add(precio);
                    }
                }
                int total = 0;
                for (Integer precio : precios) {
                    total += precio;
                }
                totaltxt.setText(String.valueOf(total));
            }
        });
        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] Descuentos = {"20%", "40%", "Cancelar"};
                int resp = JOptionPane.showOptionDialog(null, "Aplicar descuento", "Descuento", 0, 3, null, Descuentos, null);
                if (resp == 0) {
                    int SubTotal = Integer.parseInt(totaltxt.getText());
                    int desc = SubTotal * 20 / 100;
                    int total = SubTotal - desc;
                    totaltxt.setText(String.valueOf(total));
                }
                if (resp == 1) {
                    int SubTotal = Integer.parseInt(totaltxt.getText());
                    int desc = SubTotal * 40 / 100;
                    int total = SubTotal - desc;
                    totaltxt.setText(String.valueOf(total));
                }
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               updProdCombo(comboBox);
                upVendCombo(vendCombo);
               upClCombo(clienteCombo);
            }
        });
        fact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clientes = getClients();
                List<Vendedor> vendedores = getSellers();
                List<Producto> productos = getProducts();
                List<Long> productosVenta = new ArrayList<>();
                Ventas venta = new Ventas();
                //Agregar cliente
                Cliente cliente = (Cliente) clienteCombo.getSelectedItem();
                venta.setCliente(cliente);

//                //Agregar los productos
                for (int i = 0; i < model3.size(); i++) {
                    Object el = model3.getElementAt(i);
                    if (model3.getElementAt(i) != null){
                        Producto producto = (Producto) el;
                        int id = producto.getProductId();
                        productosVenta.add((long) id);
                    }
                } venta.setProductos(productosVenta);
                    //reducir stock
                int j = 0;
                List<Producto> producto1s = getProducts();

                for (int i = 0; i < model3.size(); i++) {
                    Object el = model3.getElementAt(i);
                    if (el != null && el instanceof Producto) { // Verifica que el elemento sea un Producto
                        Producto producto = (Producto) el;
                        int id = producto.getProductId();
                        int codeSear = Integer.parseInt(producto.getCode());

                        for (Producto prod : producto1s) {
                            if (prod.getCode().equalsIgnoreCase(String.valueOf(codeSear))) {
                                prod.setStock(prod.getStock() - 1);
                            }
                        }

                        productosVenta.add((long) id);
                    }
                }
                //Agregar vendedor
              Vendedor vendedor = (Vendedor) vendCombo.getSelectedItem();
              venta.setVendedor(vendedor);
                int monto = Integer.parseInt(totaltxt.getText());
                venta.setMonto(monto);
                //Agregar fecha
                LocalDate fechaVenta = LocalDate.now();
                venta.setFecha(fechaVenta);
                saveVenta(venta);
                model3.removeAllElements();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rellenar horizontalmente
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes alrededor de los componentes

// Configuración de peso para las columnas
        gbc.weightx = 0.1; // Peso ligero para las columnas
        gbc.weighty = 0.1; // Peso ligero para las filas

// Agregar título
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel1.add(Title, gbc);

// Resetear gridwidth
        gbc.gridwidth = 1;

// Primera fila de componentes
        gbc.gridy = 1;

        gbc.gridx = 0;
        panel1.add(prod, gbc);

        gbc.gridx = 1;
        panel1.add(comboBox, gbc);

        gbc.gridx = 2;
        panel1.add(create, gbc);

        gbc.gridx = 3;
        panel1.add(delete, gbc);

// Segunda fila de componentes
        gbc.gridy = 2;

        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.BOTH; // Rellenar ambos ejes
        panel1.add(scrollPane, gbc);

// Resetear gridwidth y gridheight
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Volver a rellenar horizontalmente

        gbc.gridx = 3;
        panel1.add(sell, gbc);

        gbc.gridy = 3;
        panel1.add(vendCombo, gbc);

        gbc.gridy = 4;
        panel1.add(client, gbc);

        gbc.gridy = 5;
        panel1.add(clienteCombo, gbc);

// Última fila de componentes
        gbc.gridy = 7;

        gbc.gridx = 0;
        panel1.add(total, gbc);

        gbc.gridx = 1;
        panel1.add(totaltxt, gbc);

        gbc.gridx = 3;
        panel1.add(off, gbc);

        gbc.gridy = 9;
        panel1.add(fact, gbc);

        gbc.gridx = 0;
        panel1.add(refresh, gbc);

// Añadir el panel al contenedor principal
        add(panel1, BorderLayout.CENTER);


    }

    public static Factura getInstancia() {
        return null == myFactura ? (new Factura()) : myFactura;
    }

    private static List<Producto> getProducts() {
        List<Producto> productos = new ArrayList<>();
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productos = productService.getAll();
        return productos;
    }

    private static List<Vendedor> getSellers() {
        List<Vendedor> vendedores = new ArrayList<>();
        IGenericService<Vendedor> sellService = new GenericServiceImpl<>(Vendedor.class, HibernateUtil.getSessionFactory());
        vendedores = sellService.getAll();
        return vendedores;
    }

    private static List<Cliente> getClients() {
        List<Cliente> clientes = new ArrayList<>();
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientes = clientService.getAll();
        return clientes;

    }

    private static void updProdCombo(JComboBox comboBox) {
        comboBox.removeAllItems();
        List<Producto> productos = getProducts();
        for (Producto producto : productos) {
            comboBox.addItem(producto);
        }
    }

    private static void upVendCombo(JComboBox comboBox) {
        comboBox.removeAllItems();
        List<Vendedor> vendedores = getSellers();
        for (Vendedor vendedor : vendedores){
            comboBox.addItem(vendedor);
        }
    }

    private static void upClCombo(JComboBox comboBox) {
        comboBox.removeAllItems();
        List<Cliente> clientes = getClients();
        for (Cliente cliente : clientes){
            comboBox.addItem(cliente);
        }
    }
    private static void saveVenta(Ventas venta) {
        IGenericService<Ventas> productService = new GenericServiceImpl<>(Ventas.class, HibernateUtil.getSessionFactory());
        productService.save(venta);
    }
    private static void updateProduct(Producto producto) {
        IGenericService<Producto> productService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        productService.update(producto);
    }

}
