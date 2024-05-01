package windows;

import Forms.Admin;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar{
    public static JDesktopPane desktopPane;
    public MainMenu(){
        desktopPane = new JDesktopPane();

        UIManager.put("MenuItem.selectionBackground", new Color(137, 109, 150));
        JMenuBar barOne = new JMenuBar();
        JMenu mainMenu = new JMenu("Inicio");
        JMenu secMenu = new JMenu("Herramientas");
        JMenu searchMenu = new JMenu("Buscar");

        ActionListener ctFca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Crear Factura");
            }
        };
        ActionListener outa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Salir");
            }
        };
        ActionListener logOa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cerrar sesion");
            }
        };

        ActionListener cliSr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Buscar Cliente");
            }
        };
        ActionListener pdSr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Buscar producto");
            }
        };

        JMenuItem createFac = new JMenuItem("Crear Factura");
        createFac.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        createFac.setBackground(new Color(46, 21, 59));
        createFac.setForeground(Color.white);
        createFac.addActionListener(ctFca);
        JMenuItem out = new JMenuItem("Salir");
        out.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        out.setBackground(new Color(46, 21, 59));
        out.setForeground(Color.white);
        out.addActionListener(outa);
        JMenuItem logO = new JMenuItem("Cerrar sesion");
        logO.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        logO.setBackground(new Color(46, 21, 59));
        logO.setForeground(Color.white);
        ;
        logO.addActionListener(logOa);

        mainMenu.add(createFac);
        mainMenu.add(out);
        mainMenu.add(logO);
        mainMenu.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        mainMenu.setOpaque(false);
        mainMenu.setPreferredSize(new Dimension(100, 30));

        JMenuItem admin = new JMenuItem("Administradores");
        admin.setBackground(new Color(46, 21, 59));
        admin.setForeground(Color.white);
        //JINTERNALFRAME DE ADMINISTRADORES
        // -----------------------------------------------------------------------------------
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desktopPane = new JDesktopPane();

            }
        });
  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JMenuItem sell = new JMenuItem("Vendedores");
        sell.setBackground(new Color(46, 21, 59));
        sell.setForeground(Color.white);
//        sell.addActionListener(sella);
        // JINTERNALFRAME DE VENDEDORES
//        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        sell.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JInternalFrame internalFrame = new JInternalFrame("Vendedores", true, true, true, true);
//                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//                internalFrame.setSize(new Dimension(screen.width - 800, screen.height - 100));
//                internalFrame.setResizable(true);
//                internalFrame.getContentPane().setBackground(new Color(46, 21, 59));
//                internalFrame.setLayout(null);
//
//
//                Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
//                Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
//                Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
//                Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
//                Color yell = new Color(255, 179, 2);
//                Color dk = new Color(46, 21, 59);
//
//                JLabel title = new JLabel("Vendedores del negocio");
//                title.setForeground(yell);
//                title.setFont(font20);
//                title.setBounds(30, 20, 400, 40);
//
//                JLabel nameA = new JLabel("Nombre:");
//                nameA.setForeground(yell);
//                nameA.setFont(font12);
//                nameA.setBounds(30, 90, 100, 30);
//
//                JLabel apeA = new JLabel("Apellido:");
//                apeA.setForeground(yell);
//                apeA.setFont(font12);
//                apeA.setBounds(30, 150, 100, 30);
//
//                JLabel cedA = new JLabel("Cedula:");
//                cedA.setForeground(yell);
//                cedA.setFont(font12);
//                cedA.setBounds(30, 200, 100, 30);
//
//                JTextField namTxt = new JTextField();
//                namTxt.setOpaque(false);
//                namTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                namTxt.setBounds(90, 90, 200, 30);
//                namTxt.setForeground(yell);
//                namTxt.setFont(font12);
//
//                JTextField apetxt = new JTextField();
//                apetxt.setOpaque(false);
//                apetxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                apetxt.setBounds(90, 150, 200, 30);
//                apetxt.setForeground(yell);
//                apetxt.setFont(font12);
//                JTextField cedtxt = new JTextField();
//                cedtxt.setOpaque(false);
//                cedtxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                cedtxt.setBounds(90, 200, 200, 30);
//                cedtxt.setForeground(yell);
//                cedtxt.setFont(font12);
//
//                JButton addBtt = new JButton("Agregar");
//                addBtt.setText("Agregar Vendedor");
//                addBtt.setOpaque(false);
//                addBtt.setFont(font14);
//                addBtt.setForeground(yell);
//                addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                addBtt.setBounds(300, 100, 200, 40);
//                JButton delBtt = new JButton("Eliminar");
//                delBtt.setText("Eliminar Vendedor");
//                delBtt.setOpaque(false);
//                delBtt.setFont(font14);
//                delBtt.setForeground(yell);
//                delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                delBtt.setBounds(300, 170, 200, 40);
//
//                DefaultTableModel model1 = new DefaultTableModel();
//                model1.addColumn("Nombre");
//                model1.addColumn("Apellido");
//                model1.addColumn("N. Cedula");
//                JTable table1 = new JTable(model1);
//                table1.getTableHeader().setBackground(dk);
//                table1.getTableHeader().setForeground(yell);
//                table1.getTableHeader().setFont(font14);
//                table1.setBackground(yell);
//                table1.setForeground(dk);
//                table1.setFont(font12);
//                table1.setSelectionBackground(new Color(141, 98, 220));
//
//                JScrollPane scrollPane = new JScrollPane(table1);
//                JPanel tablePanel = new JPanel();
//                tablePanel.setBounds(30, 300, 500, 700);
//                tablePanel.setBackground(yell);
//                tablePanel.add(scrollPane);
//
//                addBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String name = namTxt.getText();
//                        String lastN = apetxt.getText();
//                        String cd = cedtxt.getText();
//
//                        model1.addRow(new Object[]{name, lastN, cd});
//                    }
//                });
//                delBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        int num = table1.getSelectedRow();
//                        model1.removeRow(num);
//                    }
//                });
//
//                internalFrame.add(tablePanel);
//                internalFrame.add(title);
//                internalFrame.add(nameA);
//                internalFrame.add(namTxt);
//                internalFrame.add(apeA);
//                internalFrame.add(apetxt);
//                internalFrame.add(cedA);
//                internalFrame.add(cedtxt);
//                internalFrame.add(addBtt);
//                internalFrame.add(delBtt);
//                internalFrame.setVisible(true);
//                desktopPane.add(internalFrame);
//
//            }
//        });
        JMenuItem client = new JMenuItem("Clientes");
        client.setBackground(new Color(46, 21, 59));
        client.setForeground(Color.white);
//        client.addActionListener(clienta);
        // JINTERNAL FRAME DE CLIENTES
//        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        client.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JInternalFrame internalFrame = new JInternalFrame("Clientes", true, true, true, true);
//                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//                internalFrame.setSize(new Dimension(screen.width - 800, screen.height - 100));
//                internalFrame.setResizable(true);
//                internalFrame.getContentPane().setBackground(new Color(46, 21, 59));
//                internalFrame.setLayout(null);
//
//
//                Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
//                Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
//                Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
//                Font font20 = new Font("Outfit SemiBold", Font.BOLD, 20);
//                Color yell = new Color(255, 179, 2);
//                Color dk = new Color(46, 21, 59);
//
//                JLabel title = new JLabel("Clientes del negocio");
//                title.setForeground(yell);
//                title.setFont(font20);
//                title.setBounds(30, 20, 400, 40);
//
//                JLabel nameA = new JLabel("Nombre:");
//                nameA.setForeground(yell);
//                nameA.setFont(font12);
//                nameA.setBounds(30, 90, 100, 30);
//
//                JLabel apeA = new JLabel("Apellido:");
//                apeA.setForeground(yell);
//                apeA.setFont(font12);
//                apeA.setBounds(30, 150, 100, 30);
//
//                JLabel cedA = new JLabel("Cedula:");
//                cedA.setForeground(yell);
//                cedA.setFont(font12);
//                cedA.setBounds(30, 200, 100, 30);
//
//                JTextField namTxt = new JTextField();
//                namTxt.setOpaque(false);
//                namTxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                namTxt.setBounds(90, 90, 200, 30);
//                namTxt.setForeground(yell);
//                namTxt.setFont(font12);
//
//                JTextField apetxt = new JTextField();
//                apetxt.setOpaque(false);
//                apetxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                apetxt.setBounds(90, 150, 200, 30);
//                apetxt.setForeground(yell);
//                apetxt.setFont(font12);
//                JTextField cedtxt = new JTextField();
//                cedtxt.setOpaque(false);
//                cedtxt.setBorder(new MatteBorder(0, 0, 1, 0, yell));
//                cedtxt.setBounds(90, 200, 200, 30);
//                cedtxt.setForeground(yell);
//                cedtxt.setFont(font12);
//
//                JButton addBtt = new JButton("Agregar");
//                addBtt.setText("Agregar Cliente");
//                addBtt.setOpaque(false);
//                addBtt.setFont(font14);
//                addBtt.setForeground(yell);
//                addBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                addBtt.setBounds(300, 100, 200, 40);
//                JButton delBtt = new JButton("Eliminar");
//                delBtt.setText("Eliminar Cliente");
//                delBtt.setOpaque(false);
//                delBtt.setFont(font14);
//                delBtt.setForeground(yell);
//                delBtt.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                delBtt.setBounds(300, 170, 200, 40);
//
//                DefaultTableModel model1 = new DefaultTableModel();
//                model1.addColumn("Nombre");
//                model1.addColumn("Apellido");
//                model1.addColumn("N. Cedula");
//                JTable table1 = new JTable(model1);
//                table1.getTableHeader().setBackground(dk);
//                table1.getTableHeader().setForeground(yell);
//                table1.getTableHeader().setFont(font14);
//                table1.setBackground(yell);
//                table1.setForeground(dk);
//                table1.setFont(font12);
//                table1.setSelectionBackground(new Color(141, 98, 220));
//
//                JScrollPane scrollPane = new JScrollPane(table1);
//                JPanel tablePanel = new JPanel();
//                tablePanel.setBounds(30, 300, 500, 700);
//                tablePanel.setBackground(yell);
//                tablePanel.add(scrollPane);
//
//                addBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String name = namTxt.getText();
//                        String lastN = apetxt.getText();
//                        String cd = cedtxt.getText();
//
//                        model1.addRow(new Object[]{name, lastN, cd});
//                    }
//                });
//                delBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        int num = table1.getSelectedRow();
//                        model1.removeRow(num);
//                    }
//                });
//
//                internalFrame.add(tablePanel);
//                internalFrame.add(title);
//                internalFrame.add(nameA);
//                internalFrame.add(namTxt);
//                internalFrame.add(apeA);
//                internalFrame.add(apetxt);
//                internalFrame.add(cedA);
//                internalFrame.add(cedtxt);
//                internalFrame.add(addBtt);
//                internalFrame.add(delBtt);
//                internalFrame.setVisible(true);
//                desktopPane.add(internalFrame);
//            }
//        });
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JMenuItem prov = new JMenuItem("Productos");
        prov.setBackground(new Color(46, 21, 59));
        prov.setForeground(Color.white);
//        prov.addActionListener(prova);
        //JINTERNAL FRAME DE PRODUCTOS
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        prov.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JInternalFrame internalFrame = new JInternalFrame("Productos", true, true, true, true);
//                internalFrame.setTitle("Productos Melis");
//                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//                internalFrame.setSize(new Dimension(screen.width-800, screen.height-100));
//                internalFrame.setResizable(true);
//                internalFrame.getContentPane().setBackground(new Color(46, 21, 59));
//                internalFrame.setLayout(null);
//
//
//                Font font14 = new Font("Outfit SemiBold", Font.BOLD, 14);
//                Font font12 = new Font("Outfit SemiBold", Font.BOLD, 12);
//                Font font16 = new Font("Outfit SemiBold", Font.BOLD, 16);
//                Font font20= new Font("Outfit SemiBold", Font.BOLD, 20);
//                Color yell = new Color(255,179,2);
//                Color dk = new Color(46, 21, 59);
//
//                JLabel title = new JLabel("Productos en almacen");
//                title.setForeground(yell);
//                title.setFont(font20);
//                title.setBounds(30,20,400,40);
//
//                JLabel nameA = new JLabel("Descripcion:");
//                nameA.setForeground(yell);
//                nameA.setFont(font12);
//                nameA.setBounds(30,90,100,30);
//
//                JLabel apeA = new JLabel("Color:");
//                apeA.setForeground(yell);
//                apeA.setFont(font12);
//                apeA.setBounds(30,150,100,30);
//
//                JLabel cedA = new JLabel("Codigo:");
//                cedA.setForeground(yell);
//                cedA.setFont(font12);
//                cedA.setBounds(30,200,100,30);
//
//                JLabel catA = new JLabel("Categoria:");
//                catA.setForeground(yell);
//                catA.setFont(font12);
//                catA.setBounds(30,200,100,30);
//
//                JLabel sizeA = new JLabel("Talla:");
//                sizeA.setForeground(yell);
//                sizeA.setFont(font12);
//                sizeA.setBounds(30,200,100,30);
//
//                JTextField namTxt = new JTextField();
//                namTxt.setOpaque(false);
//                namTxt.setBorder(new MatteBorder(0,0,1,0,yell));
//                namTxt.setBounds(100,90, 200,30);
//                namTxt.setForeground(yell);
//                namTxt.setFont(font12);
//
//                JTextField apetxt = new JTextField();
//                apetxt.setOpaque(false);
//                apetxt.setBorder(new MatteBorder(0,0,1,0,yell));
//                apetxt.setBounds(100,150, 200,30);
//                apetxt.setForeground(yell);
//                apetxt.setFont(font12);
//
//                JTextField cedtxt = new JTextField();
//                cedtxt.setOpaque(false);
//                cedtxt.setBorder(new MatteBorder(0,0,1,0,yell));
//                cedtxt.setBounds(100,200, 200,30);
//                cedtxt.setForeground(yell);
//                cedtxt.setFont(font12);
//
//                JButton addBtt = new JButton("Agregar");
//                addBtt.setText("Agregar Producto");
//                addBtt.setOpaque(false);
//                addBtt.setFont(font14);
//                addBtt.setForeground(yell);
//                addBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                addBtt.setBounds(300,100,200,40);
//                JButton delBtt = new JButton("Eliminar");
//                delBtt.setText("Restar Producto");
//                delBtt.setOpaque(false);
//                delBtt.setFont(font14);
//                delBtt.setForeground(yell);
//                delBtt.setBorder(new MatteBorder(1,1,1,1,Color.WHITE));
////        addBtt.setPreferredSize(new Dimension(300,40));
//                delBtt.setBounds(300,170,200,40);
//
//                DefaultTableModel model1 = new DefaultTableModel();
//                model1.addColumn("Descripcion");
//                model1.addColumn("Color");
//                model1.addColumn("Codigo");
//                model1.addColumn("Talla");
//                JTable table1 = new JTable(model1);
//                table1.getTableHeader().setBackground(dk);
//                table1.getTableHeader().setForeground(yell);
//                table1.getTableHeader().setFont(font14);
//                table1.setBackground(yell);
//                table1.setForeground(dk);
//                table1.setFont(font12);
//                table1.setSelectionBackground(new Color(141, 98, 220));
//
//                JScrollPane scrollPane = new JScrollPane(table1);
//                JPanel tablePanel = new JPanel();
//                tablePanel.setBounds(30,300,500,700);
//                tablePanel.setBackground(yell);
//                tablePanel.add(scrollPane);
//
//                addBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        String name = namTxt.getText();
//                        String lastN = apetxt.getText();
//                        String cd = cedtxt.getText();
//
//                        model1.addRow(new Object[]{name,lastN,cd});
//                    }
//                });
//                delBtt.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        int num = table1.getSelectedRow();
//                        model1.removeRow(num);
//                    }
//                });
//
//                internalFrame.add(tablePanel);
//                internalFrame.add(title);
//                internalFrame.add(nameA);
//                internalFrame.add(namTxt);
//                internalFrame.add(apeA);
//                internalFrame.add(apetxt);
//                internalFrame.add(cedA);
//                internalFrame.add(cedtxt);
//                internalFrame.add(addBtt);
//                internalFrame.add(delBtt);
//                internalFrame.setVisible(true);
//                desktopPane.add(internalFrame);
//
//            }
//        });   // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        secMenu.add(admin);
        secMenu.add(sell);
        secMenu.add(client);
        secMenu.add(prov);
        secMenu.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        secMenu.setOpaque(false);
        secMenu.setPreferredSize(new Dimension(200, 30));

        JMenu search = new JMenu("Buscar...");

//     search.setForeground(Color.white);

        JMenuItem cSrc = new JMenuItem("Cliente");
        cSrc.setForeground(Color.white);
//        cSrc.addActionListener(cliSr);
        cSrc.setBackground(new Color(46, 21, 59));
        JMenuItem pdRrc = new JMenuItem("Producto");
        pdRrc.setBackground(new Color(46, 21, 59));
        pdRrc.setForeground(Color.white);
//        pdRrc.addActionListener(pdSr);

        search.add(cSrc);
        search.add(pdRrc);
        search.setPreferredSize(new Dimension(250, 30));

        searchMenu.add(search);
        searchMenu.setPreferredSize(new Dimension(300, 30));


        add(mainMenu);
        add(secMenu);
        add(searchMenu);
        setOpaque(false);
        setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        setForeground(Color.white);
        setPreferredSize(new Dimension(600, 30));

    }
    private void AgregarAVentana(JInternalFrame ventanaInterna){
        desktopPane.add(ventanaInterna);
        Dimension dskSize = desktopPane.getSize();
        Dimension frmSize = ventanaInterna.getSize();
        ventanaInterna.setLocation(0,0);
        ventanaInterna.setVisible(true);
    }
}
