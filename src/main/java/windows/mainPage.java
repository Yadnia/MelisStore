package windows;

import forms.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class mainPage extends JFrame {

    public static JDesktopPane desktopPane;


    public mainPage() {
        desktopPane = new JDesktopPane();

        //pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Melis Store");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(750,700));
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setBackground(new Color(46, 21, 59));
        setLayout(new BorderLayout());

        //titulo

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(65, 100, 600, 400);
        mainPanel.setBackground(new Color(137, 109, 150));
        mainPanel.setPreferredSize(new Dimension(600,100));

        // MENU
        desktopPane = new JDesktopPane();

        UIManager.put("MenuItem.selectionBackground", new Color(137, 109, 150));
        JMenuBar barOne = new JMenuBar();
        JMenu mainMenu = new JMenu("Inicio");
        JMenu secMenu = new JMenu("Herramientas");
        JMenu searchMenu = new JMenu("Ayuda");

        ActionListener ctFca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Hacer Factura?");
            }
        };
        ActionListener outa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        };
        ActionListener logOa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        };

        //agregar los menu item
        JMenuItem createFac = new JMenuItem("Crear Factura");
        createFac.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));
        createFac.setBackground(new Color(46, 21, 59));
        createFac.setForeground(Color.white);
        createFac.addActionListener(ctFca);

        //-----------------------------------------------------
        //InternalFrame de crear una factura
        createFac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desktopPane = new JDesktopPane();
                getContentPane().add(desktopPane, BorderLayout.CENTER);
                AgregarAVentana(Factura.getInstancia());
                setVisible(true);
            }
        });
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
            //agregar al primer meni
        mainMenu.add(createFac);
        mainMenu.add(out);
        mainMenu.add(logO);
        mainMenu.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        mainMenu.setOpaque(false);
        mainMenu.setPreferredSize(new Dimension(100, 30));

        //crear nuevos item
        JMenuItem admin = new JMenuItem("Administradores");
        admin.setBackground(new Color(46, 21, 59));
        admin.setForeground(Color.white);
        //JINTERNALFRAME DE ADMINISTRADORES
        // -----------------------------------------------------------------------------------
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desktopPane = new JDesktopPane();
                getContentPane().add(desktopPane, BorderLayout.CENTER);
                AgregarAVentana(Admin.getInstancia());
                setVisible(true);

            }
        });
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JMenuItem sell = new JMenuItem("Vendedores");
        sell.setBackground(new Color(46, 21, 59));
        sell.setForeground(Color.white);
        // JINTERNALFRAME DE VENDEDORES
       // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
sell.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);
        AgregarAVentana((Sell.getInstancia()));
        setVisible(true);
    }
});

        JMenuItem client = new JMenuItem("Clientes");
        client.setBackground(new Color(46, 21, 59));
        client.setForeground(Color.white);
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desktopPane = new JDesktopPane();
                getContentPane().add(desktopPane, BorderLayout.CENTER);
                AgregarAVentana((Client.getInstancia()));
                setVisible(true);
            }
        });
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JMenuItem prov = new JMenuItem("Productos");
        prov.setBackground(new Color(46, 21, 59));
        prov.setForeground(Color.white);

        prov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desktopPane = new JDesktopPane();
                getContentPane().add(desktopPane, BorderLayout.CENTER);
                AgregarAVentana(Product.getInstancia());
                setVisible(true);
            }
        });

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //agregar items al segundo menu
        secMenu.add(admin);
        secMenu.add(sell);
        secMenu.add(client);
        secMenu.add(prov);
        secMenu.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        secMenu.setOpaque(false);
        secMenu.setPreferredSize(new Dimension(200, 30));

        JMenu search = new JMenu("Acerca de...");
        JMenuItem cSrc = new JMenuItem("Acerca de");
        cSrc.setForeground(Color.white);
//        cSrc.addActionListener(cliSr);
        cSrc.setBackground(new Color(46, 21, 59));
        JMenuItem pdRrc = new JMenuItem("Ayuda");
        pdRrc.setBackground(new Color(46, 21, 59));
        pdRrc.setForeground(Color.white);

        //agregar al tercer menu
        search.add(cSrc);
        search.add(pdRrc);
        search.setPreferredSize(new Dimension(250, 30));

        searchMenu.add(search);
        searchMenu.setPreferredSize(new Dimension(300, 30));

            //agregar menus a la barra de menus
        barOne.add(mainMenu);
        barOne.add(secMenu);
        barOne.add(searchMenu);
        barOne.setOpaque(false);
        barOne.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
        barOne.setForeground(Color.white);
        barOne.setPreferredSize(new Dimension(600, 30));
        //crear la jtoolbar
        JToolBar bar = new JToolBar();
        URL addAd = mainPage.class.getResource("/admin.png");
        URL addSel = mainPage.class.getResource("/seller.png");
        URL addCL = mainPage.class.getResource("/cliente.png");
        URL addP = mainPage.class.getResource("/product.png");
        ImageIcon addAdb = new ImageIcon(addAd);
        ImageIcon addSellB = new ImageIcon(addSel);
        ImageIcon addClb = new ImageIcon(addCL);
        ImageIcon prodb = new ImageIcon(addP);
        //convirtiendo de imageicon a image para ajustar tama;o
        Image im1 = addAdb.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image im2 = addSellB.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image im3 = addClb.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Image im4 = prodb.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        //convertir a imageicon otra vez
        ImageIcon adminImg = new ImageIcon(im1);
        ImageIcon sellImg = new ImageIcon(im2);
        ImageIcon cliImg = new ImageIcon(im3);
        ImageIcon prodImg = new ImageIcon(im4);
        //agregar acciones
        mainPage.ToolbarAction adminT = new mainPage.ToolbarAction("Agregar Admin", adminImg, "Agregar Administrador", 'a');
        mainPage.ToolbarAction sellT = new mainPage.ToolbarAction("Agregar Vendedor", sellImg, "Agregar Vendedor", 's');
        mainPage.ToolbarAction clienT = new mainPage.ToolbarAction("Agregar Cliente", cliImg, "Agregar Cliente", 'b');
        mainPage.ToolbarAction prodT = new mainPage.ToolbarAction("Agregar Producto", prodImg,"Agregar Producto", 'p');

        bar.add(adminT);
        bar.add(sellT);
        bar.add(clienT);
        bar.add(prodT);
        bar.setPreferredSize(new Dimension(200, 30));
        bar.setBounds(100, 100, 200, 30);
        bar.setOpaque(false);
        mainPanel.add(barOne, BorderLayout.NORTH);
        mainPanel.add(bar, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.NORTH);

        setVisible(true);

    }
    private void AgregarAVentana(JInternalFrame ventanaInterna){
        desktopPane.add(ventanaInterna);
        Dimension dskSize = desktopPane.getSize();
        Dimension frmSize = ventanaInterna.getSize();
        ventanaInterna.setLocation(0,0);
        ventanaInterna.setVisible(true);
    }
    class ToolbarAction extends AbstractAction {

        public ToolbarAction(String text, Icon icon, String description, char acelerator) {
            super(text, icon);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(acelerator, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
            putValue(SHORT_DESCRIPTION, description);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                    String action = (String) getValue(NAME);
                    switch (action){
                        case "Agregar Admin" ->{
                            desktopPane = new JDesktopPane();
                            getContentPane().add(desktopPane,BorderLayout.CENTER);
                            AgregarAVentana(Admin.getInstancia());
                            setVisible(true);
                        }
                        case "Agregar Vendedor" ->{
                            desktopPane = new JDesktopPane();
                            getContentPane().add(desktopPane, BorderLayout.CENTER);
                            AgregarAVentana(Sell.getInstancia());
                            setVisible(true);
                        }
                        case "Agregar Cliente" ->{
                            desktopPane = new JDesktopPane();
                            getContentPane().add(desktopPane, BorderLayout.CENTER);
                            AgregarAVentana(Client.getInstancia());
                            setVisible(true);
                        }
                        case "Agregar Producto" ->{
                            desktopPane = new JDesktopPane();
                            getContentPane().add(desktopPane,BorderLayout.CENTER);
                            AgregarAVentana(Product.getInstancia());
                            setVisible(true);
                        }
                    }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
